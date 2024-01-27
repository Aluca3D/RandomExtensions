/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.rand.exten.block.custom.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.rand.exten.sound.Sounds_RaEx;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.BiConsumer;

public class SwitchBlock extends WallMountedBlock implements Waterloggable {
    public static final MapCodec<SwitchBlock> CODEC = SwitchBlock.createCodec(SwitchBlock::new);
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected static final VoxelShape NORTH_WALL_SHAPE = Block.createCuboidShape(4, 5, 13.75, 12, 11, 16);
    protected static final VoxelShape SOUTH_WALL_SHAPE = Block.createCuboidShape(4, 5, 0, 12, 11, 2.25);
    protected static final VoxelShape WEST_WALL_SHAPE = Block.createCuboidShape(13.75, 5, 4, 16, 11, 12);
    protected static final VoxelShape EAST_WALL_SHAPE = Block.createCuboidShape(0, 5, 4, 2.25, 11, 12);

    protected static final VoxelShape FLOOR_Z_AXIS_SHAPE = Block.createCuboidShape(4, 0, 5, 12, 2.25, 11);
    protected static final VoxelShape FLOOR_X_AXIS_SHAPE = Block.createCuboidShape(5, 0, 4, 11, 2.25, 12);
    protected static final VoxelShape CEILING_Z_AXIS_SHAPE = Block.createCuboidShape(4, 13.75, 5, 12, 16, 11);
    protected static final VoxelShape CEILING_X_AXIS_SHAPE = Block.createCuboidShape(5, 13.75, 4, 11, 16, 12);

    public MapCodec<SwitchBlock> getCodec() {
        return CODEC;
    }

    public SwitchBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(POWERED, false).with(FACE, BlockFace.WALL));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACE)) {
            case FLOOR: {
                if (Objects.requireNonNull(state.get(FACING).getAxis()) == Direction.Axis.X) {
                    return FLOOR_X_AXIS_SHAPE;
                }
                return FLOOR_Z_AXIS_SHAPE;
            }
            case WALL: {
                return switch (state.get(FACING)) {
                    case EAST -> EAST_WALL_SHAPE;
                    case WEST -> WEST_WALL_SHAPE;
                    case SOUTH -> SOUTH_WALL_SHAPE;
                    default -> NORTH_WALL_SHAPE;
                };
            }
        }
        if (Objects.requireNonNull(state.get(FACING).getAxis()) == Direction.Axis.X) {
            return CEILING_X_AXIS_SHAPE;
        }
        return CEILING_Z_AXIS_SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            BlockState blockState = state.cycle(POWERED);
            if (blockState.get(POWERED)) {
                SwitchBlock.spawnParticles(blockState, world, pos, 1.0f);
            }
            return ActionResult.SUCCESS;
        }
        BlockState blockState = this.togglePower(state, world, pos);
        float f = blockState.get(POWERED) ? 0.6f : 0.5f;
        world.playSound(null, pos, Sounds_RaEx.ON_OFF, SoundCategory.BLOCKS, 0.3f, f);
        world.emitGameEvent(player, blockState.get(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
        return ActionResult.CONSUME;
    }

    @Override
    public void onExploded(BlockState state, World world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (explosion.getDestructionType() == Explosion.DestructionType.TRIGGER_BLOCK && !world.isClient()) {
            this.togglePower(state, world, pos);
        }
        super.onExploded(state, world, pos, explosion, stackMerger);
    }

    public BlockState togglePower(BlockState state, World world, BlockPos pos) {
        state = state.cycle(POWERED);
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
        this.updateNeighbors(state, world, pos);
        return state;
    }

    private static void spawnParticles(BlockState state, WorldAccess world, BlockPos pos, float alpha) {
        Direction direction = state.get(FACING).getOpposite();
        Direction direction2 = SwitchBlock.getDirection(state).getOpposite();
        double d = (double) pos.getX() + 0.5 + 0.1 * (double) direction.getOffsetX() + 0.2 * (double) direction2.getOffsetX();
        double e = (double) pos.getY() + 0.5 + 0.1 * (double) direction.getOffsetY() + 0.2 * (double) direction2.getOffsetY();
        double f = (double) pos.getZ() + 0.5 + 0.1 * (double) direction.getOffsetZ() + 0.2 * (double) direction2.getOffsetZ();
        world.addParticle(new DustParticleEffect(DustParticleEffect.RED, alpha), d, e, f, 0.0, 0.0, 0.0);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(POWERED) && random.nextFloat() < 0.25f) {
            SwitchBlock.spawnParticles(state, world, pos, 0.5f);
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (moved || state.isOf(newState.getBlock())) {
            return;
        }
        if (state.get(POWERED)) {
            this.updateNeighbors(state, world, pos);
        }
        super.onStateReplaced(state, world, pos, newState, false);
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWERED) ? 15 : 0;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (state.get(POWERED) && SwitchBlock.getDirection(state) == direction) {
            return 15;
        }
        return 0;
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    private void updateNeighbors(BlockState state, World world, BlockPos pos) {
        world.updateNeighborsAlways(pos, this);
        world.updateNeighborsAlways(pos.offset(SwitchBlock.getDirection(state).getOpposite()), this);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACE, FACING, POWERED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
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
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
