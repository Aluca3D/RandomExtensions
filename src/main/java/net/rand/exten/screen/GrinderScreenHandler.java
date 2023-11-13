package net.rand.exten.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.rand.exten.block.custom.blocks.entity.GrinderEntity;
import net.rand.exten.recipe.GrinderRecipe;

public class GrinderScreenHandler extends AbstractFurnaceScreenHandler {
    //Todo new RecipeBookCategory or GRINDER or Remove RecipeBook
    public GrinderScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ScreenHandlers_RaEx.GRINDER_SCREEN_HANDLER, GrinderRecipe.Type.GRINDER, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }

    public GrinderScreenHandler(int syncId, PlayerInventory playerInventory, GrinderEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(ScreenHandlers_RaEx.GRINDER_SCREEN_HANDLER, GrinderRecipe.Type.GRINDER, RecipeBookCategory.FURNACE, syncId, playerInventory, blockEntity, propertyDelegate);
    }

    @Override
    protected boolean isFuel(ItemStack itemStack) {
        return true;
    }
}
