package net.rand.exten.block.custom.crops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.util.DamageTypes_RaEx;

public class EndBarryBlock extends SweetBerryBushBlock {
    public EndBarryBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.END_STONE);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(Items_RaEx.END_BARRY);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getType() == EntityType.FOX || entity.getType() == EntityType.BEE) {
            return;
        }
        entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
        if (!(world.isClient || state.get(AGE) <= 0 || entity.lastRenderX == entity.getX() && entity.lastRenderZ == entity.getZ())) {
            double d = Math.abs(entity.getX() - entity.lastRenderX);
            double e = Math.abs(entity.getZ() - entity.lastRenderZ);
            if (d >= (double)0.003f || e >= (double)0.003f) {
                entity.damage(DamageTypes_RaEx.of(world, DamageTypes_RaEx.END_BARY_BUSH_DAMAGE_TYPE), 1.0f);
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean bl;
        int i = state.get(AGE);
        bl = i == 3;
        if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }
        if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            SweetBerryBushBlock.dropStack(world, pos, new ItemStack(Items_RaEx.END_BARRY, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            BlockState blockState = state.with(AGE, 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
