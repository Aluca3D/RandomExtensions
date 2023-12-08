package net.rand.exten.block.custom.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;
import net.rand.exten.block.custom.Properties_RaEx;
import net.rand.exten.sound.Sounds_RaEx;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class LandMine extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty IS_ON = Properties_RaEx.IS_ON;

    public LandMine(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(IS_ON, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, IS_ON);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean b = state.get(IS_ON);
        if (player.isSneaking() && b) {
            this.setOff(state, world, pos);
        } else {
            this.setOn(state, world, pos);
        }
        world.playSound(player, pos, Sounds_RaEx.ON_OFF, SoundCategory.BLOCKS);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        boolean b = state.get(IS_ON);
        if (!world.isClient && b) {
            this.spawnExplosive(world, pos, entity);
            this.replaceBlock(world, pos);
        }
    }

    public void setOn(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(IS_ON, true), Block.NOTIFY_ALL);
        this.updateNeighbors(world, pos);
    }

    public void setOff(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(IS_ON, false), Block.NOTIFY_ALL);
        this.updateNeighbors(world, pos);
    }

    public void spawnExplosive(World world, BlockPos pos, Entity entity) {
        TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
        tntEntity.setInvisible(true);
        tntEntity.setNoGravity(true);
        tntEntity.setFuse(0);
        tntEntity.setPos(pos.getX(), pos.getY(), pos.getZ());
        world.spawnEntity(tntEntity);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world.isClient) {
            return;
        }
        spawnExplosive(world, pos, explosion.getEntity());
    }

    public void replaceBlock(World world, BlockPos pos) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
    }

    private void updateNeighbors(World world, BlockPos pos) {
        world.updateNeighborsAlways(pos, this);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Stream.of(
                Block.createCuboidShape(3, 0, 3, 13, 2, 13),
                Block.createCuboidShape(2.5, 0.001, 2.5, 5, 2.501, 5),
                Block.createCuboidShape(2.5, 0.001, 11, 5, 2.501, 13.5),
                Block.createCuboidShape(11, 0.001, 11, 13.5, 2.501, 13.5),
                Block.createCuboidShape(11, 0.001, 2.5, 13.5, 2.501, 5)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
    }

    @Override
    public boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return Waterloggable.super.canFillWithFluid(player, world, pos, state, fluid);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED).booleanValue()) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        switch (type) {
            case LAND, AIR: {
                return false;
            }
            case WATER: {
                return world.getFluidState(pos).isIn(FluidTags.WATER);
            }
        }
        return false;
    }
}
