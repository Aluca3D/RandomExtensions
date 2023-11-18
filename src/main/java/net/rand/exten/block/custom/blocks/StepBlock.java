package net.rand.exten.block.custom.blocks;

import net.minecraft.block.*;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.rand.exten.block.custom.Properties_RaEx;
import org.jetbrains.annotations.Nullable;

public class StepBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty TOP_OR_BOTTOM = Properties_RaEx.TOP_OR_BOTTOM;

    //ToDo Maybe add Corners (like Stairs)

    protected static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0, 0, 8, 16, 8, 16);
    protected static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0, 0, 0, 16, 8, 8);
    protected static final VoxelShape SHAPE_WEST = Block.createCuboidShape(8, 0, 0, 16, 8, 16);
    protected static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 0, 0, 8, 8, 16);

    protected static final VoxelShape TOP_SHAPE_NORTH = Block.createCuboidShape(0, 8, 8, 16, 16, 16);
    protected static final VoxelShape TOP_SHAPE_SOUTH = Block.createCuboidShape(0, 8, 0, 16, 16, 8);
    protected static final VoxelShape TOP_SHAPE_WEST = Block.createCuboidShape(8, 8, 0, 16, 16, 16);
    protected static final VoxelShape TOP_SHAPE_EAST = Block.createCuboidShape(0, 8, 0, 8, 16, 16);

    public StepBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(TOP_OR_BOTTOM, true));
    }
    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, TOP_OR_BOTTOM);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        Boolean b = state.get(TOP_OR_BOTTOM);
        if (b) {
            switch (dir) {
                case NORTH:{
                    return SHAPE_NORTH;
                }
                case SOUTH:{
                    return SHAPE_SOUTH;
                }
                case EAST:{
                    return SHAPE_EAST;
                }
                case WEST:{
                    return SHAPE_WEST;
                }
            }
        } else {
            switch (dir) {
                case NORTH:{
                    return TOP_SHAPE_NORTH;
                }
                case SOUTH:{
                    return TOP_SHAPE_SOUTH;
                }
                case EAST:{
                    return TOP_SHAPE_EAST;
                }
                case WEST:{
                    return TOP_SHAPE_WEST;
                }
            }
        }

        return null;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = ctx.getWorld().getBlockState(blockPos);
        if (blockState.isOf(this)) {
            return blockState.with(WATERLOGGED, false).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        }
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockState2 = this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        Direction direction = ctx.getSide();
        if (direction == Direction.DOWN || direction != Direction.UP && ctx.getHitPos().y - (double)blockPos.getY() > 0.5) {
            return blockState2.with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(TOP_OR_BOTTOM, false);
        }
        return blockState2.with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
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
