package net.rand.exten.block.custom.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.rand.exten.recipe.GrinderRecipe;
import net.rand.exten.screen.GrinderScreenHandler;

public class GrinderEntity extends AbstractFurnaceBlockEntity {
    public GrinderEntity(BlockPos pos, BlockState state) {
        super(BlockEntity_RaEx.GRINDER_BE, pos, state, GrinderRecipe.Type.GRINDER);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("block.randexten.grinder");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GrinderScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 2;
    }
}