package net.rand.exten.block.custom.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.item.Items_RaEx;

public class SoulOre extends Block {

    public SoulOre(AbstractBlock.Settings settings) {
        super(settings);
    }

    public void replaceBlock(World world, BlockPos pos) {
        BlockState state = Blocks.END_STONE.getDefaultState();
        world.setBlockState(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        boolean s = false;
        if (itemStack.isOf(Items.GLASS_BOTTLE)) {
            itemStack.decrement(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(Items_RaEx.SOUL));
            } else if (!player.getInventory().insertStack(new ItemStack(Items_RaEx.SOUL))) {
                player.dropItem(new ItemStack(Items_RaEx.SOUL), false);
            }
            s = true;

        }
        if (!world.isClient() && s) {
            this.replaceBlock(world, pos);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
