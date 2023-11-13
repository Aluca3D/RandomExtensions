package net.rand.exten.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.rand.exten.block.Blocks_RaEx;

public class GrinderRecipe extends AbstractCookingRecipe {
    public GrinderRecipe(String group, CookingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(Type.GRINDER, group, category, ingredient, result, experience, cookingTime);
    }

    public ItemStack createIcon() {
        return new ItemStack(Blocks_RaEx.GRINDER);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.GRINDER;
    }

    public static class Type implements RecipeType<GrinderRecipe> {
        public static final Type GRINDER = new Type();
    }

    public static class Serializer {
        public static final RecipeSerializer<GrinderRecipe> GRINDER = new CookingRecipeSerializer<>(GrinderRecipe::new, 100);
    }

}
