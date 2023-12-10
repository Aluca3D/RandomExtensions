package net.rand.exten.block.custom.blocks.explosives;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.entity.explosives.ExplosionEntity;

public class ExplosiveCakeBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 8, 15);

    public ExplosiveCakeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (player.isSneaking()) {
            world.setBlockState(pos, Blocks.RED_CANDLE_CAKE.getDefaultState(), 11);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(Blocks.TNT));
            } else if (!player.getInventory().insertStack(new ItemStack(Blocks.TNT))) {
                player.dropItem(new ItemStack(Blocks.TNT), false);
            }

        } else {
            if (!world.isClient) {
                this.spawnExplosive(world, pos);
            }

            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
            Item item = itemStack.getItem();

            player.incrementStat(Stats.USED.getOrCreateStat(item));

        }
        return ActionResult.success(world.isClient);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world.isClient) {
            return;
        }
        this.spawnExplosive(world, pos);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }


    public void spawnExplosive(World world, BlockPos pos) {
        ExplosionEntity explosion = new ExplosionEntity(Entities_RaEx.EXPLOSION_ENTITY, world);
        explosion.setFuse(0);
        explosion.setPos(pos.getX(), pos.getY(), pos.getZ());
        world.spawnEntity(explosion);
    }
}