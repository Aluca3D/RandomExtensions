package net.rand.exten.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;

public class Recipes_RaEx {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(RandomExtensions.MOD_ID, "grinder"),
                GrinderRecipe.Serializer.GRINDER);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(RandomExtensions.MOD_ID, "grinder"),
                GrinderRecipe.Type.GRINDER);
    }
}