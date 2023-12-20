package net.rand.exten.block.custom.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.rand.exten.util.DamageTypes_RaEx;
import org.jetbrains.annotations.Nullable;

public class BarbedWire extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    protected static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0, 0, 4, 16, 14, 12);
    protected static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0, 0, 4, 16, 14, 12);
    protected static final VoxelShape SHAPE_WEST = Block.createCuboidShape(4, 0, 0, 12, 14, 16);
    protected static final VoxelShape SHAPE_EAST = Block.createCuboidShape(4, 0, 0, 12, 14, 16);

    public BarbedWire(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }


        @Override
        public void onEntityCollision (BlockState state, World world, BlockPos pos, Entity entity){
            entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
            if (!entity.bypassesSteppingEffects()) {
                entity.damage(DamageTypes_RaEx.of(world, DamageTypes_RaEx.BARBED_WIRE_DAMAGE_TYPE), 1.0f);
            }

        }

        @Override
        @Nullable
        public BlockState getPlacementState (ItemPlacementContext ctx){
            BlockPos blockPos = ctx.getBlockPos();
            BlockState blockState = ctx.getWorld().getBlockState(blockPos);
            if (blockState.isOf(this)) {
                return blockState.with(WATERLOGGED, false).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
            }
            FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
            BlockState blockState2 = this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);

            return blockState2.with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        }

        @Override
        public FluidState getFluidState (BlockState state){
            if (state.get(WATERLOGGED).booleanValue()) {
                return Fluids.WATER.getStill(false);
            }
            return super.getFluidState(state);
        }

        @Override
        public boolean tryFillWithFluid (WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState){
            return Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
        }

        @Override
        public boolean canFillWithFluid (@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState
        state, Fluid fluid){
            return Waterloggable.super.canFillWithFluid(player, world, pos, state, fluid);
        }

        @Override
        public BlockState getStateForNeighborUpdate (BlockState state, Direction direction, BlockState
        neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos){
            if (state.get(WATERLOGGED).booleanValue()) {
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }

        @Override
        public boolean canPathfindThrough (BlockState state, BlockView world, BlockPos pos, NavigationType type){
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
