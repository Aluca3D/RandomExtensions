package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.StepBlockRegistry;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.util.Tags_RaEx;

public class RecipeProvider_RaEx extends FabricRecipeProvider {

    public RecipeProvider_RaEx(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.ROOMBA_ITEM, 1)
                .pattern("BOB")
                .pattern("IHI")
                .pattern("IDI")
                .input('B', Items.BLACK_CONCRETE)
                .input('O', Items.OBSERVER)
                .input('H', Items_RaEx.SOUL)
                .input('I', Items.IRON_INGOT)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.BLACK_CONCRETE), conditionsFromItem(Items.BLACK_CONCRETE))
                .criterion(hasItem(Items.OBSERVER), conditionsFromItem(Items.OBSERVER))
                .criterion(hasItem(Items_RaEx.SOUL), conditionsFromItem(Items_RaEx.SOUL))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.ROOMBA_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks_RaEx.BARBED_WIRE, 3)
                .pattern("SSS")
                .pattern("AAA")
                .pattern("SSS")
                .input('A', Items.IRON_BARS)
                .input('S', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_BARS), conditionsFromItem(Items.IRON_BARS))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BARBED_WIRE)));

        // Gem Block
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items_RaEx.AQUAMARIN, RecipeCategory.DECORATIONS,
                Blocks_RaEx.AQUAMARIN_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHARCOAL, RecipeCategory.DECORATIONS,
                Blocks_RaEx.CHARCOAL_BLOCK);

        // Cheese
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items_RaEx.CHEESE, RecipeCategory.FOOD,
                Blocks_RaEx.CHEESE_BLOCK);

        offerFoodCookingRecipe(exporter, "milk", RecipeSerializer.SMOKING, SmokingRecipe::new, 150, Items.MILK_BUCKET, Items_RaEx.BUCKET_CHEESE, 0.2f);

        offerSingleOutputShapelessRecipe(exporter, Blocks_RaEx.CHEESE_BLOCK, Items_RaEx.BUCKET_CHEESE, "cheese_block_from_bucket_cheese");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.CHEESE_STATION, 1)
                .pattern("SAS")
                .pattern("ARA")
                .pattern("SAS")
                .input('A', Items.STONE)
                .input('S', Items_RaEx.CHEESE)
                .input('R', Blocks_RaEx.CHEESE_BLOCK)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(Items_RaEx.CHEESE), conditionsFromItem(Items_RaEx.CHEESE))
                .criterion(hasItem(Blocks_RaEx.CHEESE_BLOCK), conditionsFromItem(Blocks_RaEx.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.CHEESE_STATION)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.CHEESE_SLABS, Ingredient.ofItems(Blocks_RaEx.CHEESE_BLOCK))
                .criterion(hasItem(Blocks_RaEx.CHEESE_BLOCK), conditionsFromItem(Blocks_RaEx.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.CHEESE_SLABS)));
        createStairsRecipe(Blocks_RaEx.CHEESE_STAIRS, Ingredient.ofItems(Blocks_RaEx.CHEESE_BLOCK))
                .criterion(hasItem(Blocks_RaEx.CHEESE_BLOCK), conditionsFromItem(Blocks_RaEx.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.CHEESE_STAIRS)));
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.CHEESE_WALLS, Blocks_RaEx.CHEESE_BLOCK);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, StepBlockRegistry.CHEESE_STEP, Ingredient.ofItems(Blocks_RaEx.CHEESE_SLABS))
                .criterion(hasItem(Blocks_RaEx.CHEESE_SLABS), conditionsFromItem(Blocks_RaEx.CHEESE_SLABS))
                .offerTo(exporter, new Identifier(getRecipeName(StepBlockRegistry.CHEESE_STEP)));

        // Crystal
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.MOSSY_CRYSTAL, 5)
                .pattern("SAS")
                .pattern("ABA")
                .pattern("SAS")
                .input('B', Blocks_RaEx.MOSSY_CRYSTAL)
                .input('A', Items.MOSS_BLOCK)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(Blocks_RaEx.MOSSY_CRYSTAL), conditionsFromItem(Blocks_RaEx.MOSSY_CRYSTAL))
                .criterion(hasItem(Items.MOSS_BLOCK), conditionsFromItem(Items.MOSS_BLOCK))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.MOSSY_CRYSTAL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.ICE_CRYSTAL, 5)
                .pattern("SAS")
                .pattern("ABA")
                .pattern("SAS")
                .input('B', Blocks_RaEx.ICE_CRYSTAL)
                .input('A', Items.ICE)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(Blocks_RaEx.ICE_CRYSTAL), conditionsFromItem(Blocks_RaEx.ICE_CRYSTAL))
                .criterion(hasItem(Items.ICE), conditionsFromItem(Items.ICE))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.ICE_CRYSTAL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.SAND_CRYSTAL, 5)
                .pattern("SAS")
                .pattern("ABA")
                .pattern("SAS")
                .input('B', Blocks_RaEx.SAND_CRYSTAL)
                .input('A', Items.SAND)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(Blocks_RaEx.SAND_CRYSTAL), conditionsFromItem(Blocks_RaEx.SAND_CRYSTAL))
                .criterion(hasItem(Items.SAND), conditionsFromItem(Items.SAND))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.SAND_CRYSTAL)));

        // Burned Wood
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.BURNED_WOOD, 3)
                .input(Blocks_RaEx.BURNED_LOG, 4)
                .criterion(hasItem(Blocks_RaEx.BURNED_LOG), conditionsFromItem(Blocks_RaEx.BURNED_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_WOOD)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.STRIPPED_BURNED_WOOD, 3)
                .input(Blocks_RaEx.STRIPPED_BURNED_LOG, 4)
                .criterion(hasItem(Blocks_RaEx.STRIPPED_BURNED_LOG), conditionsFromItem(Blocks_RaEx.STRIPPED_BURNED_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.STRIPPED_BURNED_WOOD)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.BURNED_SLABS, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_SLABS)));
        createStairsRecipe(Blocks_RaEx.BURNED_STAIRS, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_STAIRS)));
        createDoorRecipe(Blocks_RaEx.BURNED_DOOR, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_DOOR)));
        createTrapdoorRecipe(Blocks_RaEx.BURNED_TRAPDOOR, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_TRAPDOOR)));
        createFenceRecipe(Blocks_RaEx.BURNED_FENCE, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_FENCE)));
        createFenceGateRecipe(Blocks_RaEx.BURNED_GATE, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_GATE)));
        createPressurePlateRecipe(RecipeCategory.REDSTONE, Blocks_RaEx.BURNED_PRESSURE_PLATE, Ingredient.ofItems(Blocks_RaEx.BURNED_PLANKS))
                .criterion(hasItem(Blocks_RaEx.BURNED_PLANKS), conditionsFromItem(Blocks_RaEx.BURNED_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.BURNED_PRESSURE_PLATE)));
        offerSingleOutputShapelessRecipe(exporter, Blocks_RaEx.BURNED_BUTTON, Blocks_RaEx.BURNED_PLANKS, "");

        // PurPur Wood
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.PURPUR_WOOD, 3)
                .input(Blocks_RaEx.PURPUR_LOG, 4)
                .criterion(hasItem(Blocks_RaEx.PURPUR_LOG), conditionsFromItem(Blocks_RaEx.PURPUR_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_WOOD)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.STRIPPED_PURPUR_WOOD, 3)
                .input(Blocks_RaEx.STRIPPED_PURPUR_LOG, 4)
                .criterion(hasItem(Blocks_RaEx.STRIPPED_PURPUR_LOG), conditionsFromItem(Blocks_RaEx.STRIPPED_PURPUR_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.STRIPPED_PURPUR_WOOD)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.PURPUR_SLABS, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_SLABS)));
        createStairsRecipe(Blocks_RaEx.PURPUR_STAIRS, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_STAIRS)));
        createDoorRecipe(Blocks_RaEx.PURPUR_DOOR, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_DOOR)));
        createTrapdoorRecipe(Blocks_RaEx.PURPUR_TRAPDOOR, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_TRAPDOOR)));
        createFenceRecipe(Blocks_RaEx.PURPUR_FENCE, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_FENCE)));
        createFenceGateRecipe(Blocks_RaEx.PURPUR_GATE, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_GATE)));
        createPressurePlateRecipe(RecipeCategory.REDSTONE, Blocks_RaEx.PURPUR_PRESSURE_PLATE, Ingredient.ofItems(Blocks_RaEx.PURPUR_PLANKS))
                .criterion(hasItem(Blocks_RaEx.PURPUR_PLANKS), conditionsFromItem(Blocks_RaEx.PURPUR_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.PURPUR_PRESSURE_PLATE)));
        offerSingleOutputShapelessRecipe(exporter, Blocks_RaEx.PURPUR_BUTTON, Blocks_RaEx.PURPUR_PLANKS, "");

        //Food
        offerFoodCookingRecipe(exporter, "smoking_dough", RecipeSerializer.SMOKING, SmokingRecipe::new, 150, Items_RaEx.DOUGH, Items.BREAD, 0.2f);
        offerFoodCookingRecipe(exporter, "dough", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200, Items_RaEx.DOUGH, Items.BREAD, 0.1f);
        offerFoodCookingRecipe(exporter, "campfire_dough", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 200, Items_RaEx.DOUGH, Items.BREAD, 0.1f);

        offerFoodCookingRecipe(exporter, "smoking_pizza", RecipeSerializer.SMOKING, SmokingRecipe::new, 150, Items_RaEx.RAW_PIZZA, Items_RaEx.PIZZA, 0.2f);
        offerFoodCookingRecipe(exporter, "pizza", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200, Items_RaEx.RAW_PIZZA, Items_RaEx.PIZZA, 0.1f);
        offerFoodCookingRecipe(exporter, "campfire_pizza", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 200, Items_RaEx.RAW_PIZZA, Items_RaEx.PIZZA, 0.1f);

        offerFoodCookingRecipe(exporter, "campfire_rotten_flesh", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 200, Items.ROTTEN_FLESH, Items.LEATHER, 0.1f);
        offerFoodCookingRecipe(exporter, "smoking_rotten_flesh", RecipeSerializer.SMOKING, SmokingRecipe::new, 200, Items.ROTTEN_FLESH, Items.LEATHER, 0.1f);

        offerFoodCookingRecipe(exporter, "smoking_popcorn", RecipeSerializer.SMOKING, SmokingRecipe::new, 200, Items_RaEx.CORN, Items_RaEx.POPCORN, 0.1f);
        offerFoodCookingRecipe(exporter, "popcorn", RecipeSerializer.SMELTING, SmeltingRecipe::new, 200, Items_RaEx.CORN, Items_RaEx.POPCORN, 0.1f);
        offerFoodCookingRecipe(exporter, "campfire_popcorn", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 200, Items_RaEx.CORN, Items_RaEx.POPCORN, 0.1f);

        // Paxel
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.WOODEN_PAXEL)
                .input(Items.WOODEN_AXE, 1)
                .input(Items.WOODEN_PICKAXE, 1)
                .input(Items.WOODEN_SHOVEL, 1)
                .criterion(hasItem(Items.WOODEN_AXE), conditionsFromItem(Items.WOODEN_AXE))
                .criterion(hasItem(Items.WOODEN_PICKAXE), conditionsFromItem(Items.WOODEN_PICKAXE))
                .criterion(hasItem(Items.WOODEN_SHOVEL), conditionsFromItem(Items.WOODEN_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.WOODEN_PAXEL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.STONE_PAXEL)
                .input(Items.STONE_AXE, 1)
                .input(Items.STONE_PICKAXE, 1)
                .input(Items.STONE_SHOVEL, 1)
                .criterion(hasItem(Items.STONE_AXE), conditionsFromItem(Items.STONE_AXE))
                .criterion(hasItem(Items.STONE_PICKAXE), conditionsFromItem(Items.STONE_PICKAXE))
                .criterion(hasItem(Items.STONE_SHOVEL), conditionsFromItem(Items.STONE_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.STONE_PAXEL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.COPPER_PAXEL)
                .input(ToolsAndArmors_RaEx.COPPER_AXE, 1)
                .input(ToolsAndArmors_RaEx.COPPER_PICKAXE, 1)
                .input(ToolsAndArmors_RaEx.COPPER_SHOVEL, 1)
                .criterion(hasItem(ToolsAndArmors_RaEx.COPPER_AXE), conditionsFromItem(ToolsAndArmors_RaEx.COPPER_AXE))
                .criterion(hasItem(ToolsAndArmors_RaEx.COPPER_PICKAXE), conditionsFromItem(ToolsAndArmors_RaEx.COPPER_PICKAXE))
                .criterion(hasItem(ToolsAndArmors_RaEx.COPPER_SHOVEL), conditionsFromItem(ToolsAndArmors_RaEx.COPPER_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_PAXEL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.IRON_PAXEL)
                .input(Items.IRON_AXE, 1)
                .input(Items.IRON_PICKAXE, 1)
                .input(Items.IRON_SHOVEL, 1)
                .criterion(hasItem(Items.IRON_AXE), conditionsFromItem(Items.IRON_AXE))
                .criterion(hasItem(Items.IRON_PICKAXE), conditionsFromItem(Items.IRON_PICKAXE))
                .criterion(hasItem(Items.IRON_SHOVEL), conditionsFromItem(Items.IRON_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.IRON_PAXEL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.GOLDEN_PAXEL)
                .input(Items.GOLDEN_AXE, 1)
                .input(Items.GOLDEN_PICKAXE, 1)
                .input(Items.GOLDEN_SHOVEL, 1)
                .criterion(hasItem(Items.GOLDEN_AXE), conditionsFromItem(Items.GOLDEN_AXE))
                .criterion(hasItem(Items.GOLDEN_PICKAXE), conditionsFromItem(Items.GOLDEN_PICKAXE))
                .criterion(hasItem(Items.GOLDEN_SHOVEL), conditionsFromItem(Items.GOLDEN_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.GOLDEN_PAXEL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.DIAMOND_PAXEL)
                .input(Items.DIAMOND_AXE, 1)
                .input(Items.DIAMOND_PICKAXE, 1)
                .input(Items.DIAMOND_SHOVEL, 1)
                .criterion(hasItem(Items.DIAMOND_AXE), conditionsFromItem(Items.DIAMOND_AXE))
                .criterion(hasItem(Items.DIAMOND_PICKAXE), conditionsFromItem(Items.DIAMOND_PICKAXE))
                .criterion(hasItem(Items.DIAMOND_SHOVEL), conditionsFromItem(Items.DIAMOND_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.DIAMOND_PAXEL)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.DIAMOND_PAXEL),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS, ToolsAndArmors_RaEx.NETHERITE_PAXEL)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.DIAMOND_PAXEL), conditionsFromItem(ToolsAndArmors_RaEx.DIAMOND_PAXEL))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.NETHERITE_PAXEL)));

        // Misc
        offerFoodCookingRecipe(exporter, "raw_ruby", RecipeSerializer.SMELTING, SmeltingRecipe::new, 150, Items_RaEx.RAW_RUBY, Items_RaEx.RUBY, 0.2f);
        offerFoodCookingRecipe(exporter, "raw_aquamarin", RecipeSerializer.SMELTING, SmeltingRecipe::new, 150, Items_RaEx.RAW_AQUAMARIN, Items_RaEx.AQUAMARIN, 0.2f);
        offerFoodCookingRecipe(exporter, "raw_topas", RecipeSerializer.SMELTING, SmeltingRecipe::new, 150, Items_RaEx.RAW_TOPAS, Items_RaEx.TOPAS, 0.2f);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks_RaEx.SWITCH, 4)
                .input(Items.SMOOTH_STONE)
                .input(Ingredient.fromTag(ItemTags.BUTTONS), 4)
                .criterion(hasItem(Items.SMOOTH_STONE), conditionsFromItem(Items.SMOOTH_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.SWITCH)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.CHEESE_OF_FLIGHT, 4)
                .input(Items_RaEx.CHEESE, 4)
                .input(Items.FEATHER,4)
                .input(Items.SHULKER_SHELL)
                .criterion(hasItem(Items_RaEx.CHEESE), conditionsFromItem(Items_RaEx.CHEESE))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.CHEESE_OF_FLIGHT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_DYE)
                .input(Blocks_RaEx.NIGHT_SHADE)
                .criterion(hasItem(Blocks_RaEx.NIGHT_SHADE), conditionsFromItem(Blocks_RaEx.NIGHT_SHADE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.PURPLE_DYE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.TOOTH, 4)
                .input(Items.BONE, 2)
                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.TOOTH)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BONE_MEAL)
                .input(Items_RaEx.TOOTH, 2)
                .criterion(hasItem(Items_RaEx.TOOTH), conditionsFromItem(Items_RaEx.TOOTH))
                .offerTo(exporter, new Identifier(getRecipeName(Items.BONE_MEAL)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COBBLESTONE, 1)
                .input(Items_RaEx.PEBBLE, 3)
                .criterion(hasItem(Items_RaEx.PEBBLE), conditionsFromItem(Items_RaEx.PEBBLE))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks.COBBLESTONE)).withPath("cobblestone_from_pebble"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.PEBBLE, 3)
                .input(Blocks.COBBLESTONE, 1)
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.PEBBLE)).withPath("pebble_from_cobblestone"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.GRINDER, 1)
                .pattern("RRR")
                .pattern("RSR")
                .pattern("RRR")
                .input('S', Items.GRINDSTONE)
                .input('R', Items.STONE)
                .criterion(hasItem(Items.GRINDSTONE), conditionsFromItem(Items.GRINDSTONE))
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.GRINDER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK, 1)
                .pattern("S")
                .pattern("C")
                .pattern("R")
                .input('C', Items.CAKE)
                .input('S', Items.RED_CANDLE)
                .input('R', Items.TNT)
                .criterion(hasItem(Items.CAKE), conditionsFromItem(Items.CAKE))
                .criterion(hasItem(Items.RED_CANDLE), conditionsFromItem(Items.RED_CANDLE))
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Items_RaEx.DOUGH, 1)
                .pattern("S")
                .pattern("R")
                .input('S', Items_RaEx.FLOUR)
                .input('R', Items.WATER_BUCKET)
                .criterion(hasItem(Items_RaEx.FLOUR), conditionsFromItem(Items_RaEx.FLOUR))
                .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.DOUGH)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items_RaEx.RAW_PIZZA, 4)
                .input(Items_RaEx.CHEESE, 1)
                .input(Items_RaEx.TOMATO, 1)
                .input(Items_RaEx.DOUGH, 1)
                .criterion(hasItem(Items_RaEx.CHEESE), conditionsFromItem(Items_RaEx.CHEESE))
                .criterion(hasItem(Items_RaEx.TOMATO), conditionsFromItem(Items_RaEx.TOMATO))
                .criterion(hasItem(Items_RaEx.DOUGH), conditionsFromItem(Items_RaEx.DOUGH))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.RAW_PIZZA)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items_RaEx.SANDWICH, 1)
                .input(Items_RaEx.CHEESE, 1)
                .input(Items_RaEx.CORN, 1)
                .input(Items_RaEx.TOMATO, 1)
                .input(Items.BREAD, 1)
                .criterion(hasItem(Items_RaEx.CHEESE), conditionsFromItem(Items_RaEx.CHEESE))
                .criterion(hasItem(Items_RaEx.CORN), conditionsFromItem(Items_RaEx.CORN))
                .criterion(hasItem(Items_RaEx.TOMATO), conditionsFromItem(Items_RaEx.TOMATO))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.SANDWICH)));

        /// Soda
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Items_RaEx.EMPTY_SODA_CAN, 1)
                .pattern(" S ")
                .pattern("S S")
                .pattern(" S ")
                .input('S', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.EMPTY_SODA_CAN)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items_RaEx.RED_SODA_CAN, 1)
                .input(Items.FERMENTED_SPIDER_EYE, 1)
                .input(Items.BLAZE_POWDER, 1)
                .input(Items_RaEx.EMPTY_SODA_CAN, 1)
                .criterion(hasItem(Items.FERMENTED_SPIDER_EYE), conditionsFromItem(Items.FERMENTED_SPIDER_EYE))
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .criterion(hasItem(Items_RaEx.EMPTY_SODA_CAN), conditionsFromItem(Items_RaEx.EMPTY_SODA_CAN))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.RED_SODA_CAN)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items_RaEx.GREEN_SODA_CAN, 1)
                .input(Items.SUGAR, 1)
                .input(Items.RABBIT_FOOT, 1)
                .input(Items_RaEx.EMPTY_SODA_CAN, 1)
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.RABBIT_FOOT), conditionsFromItem(Items.RABBIT_FOOT))
                .criterion(hasItem(Items_RaEx.EMPTY_SODA_CAN), conditionsFromItem(Items_RaEx.EMPTY_SODA_CAN))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.GREEN_SODA_CAN)));

        // Obsidian
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.OBSIDIAN_GLASS, 6)
                .pattern("SRS")
                .pattern("RRR")
                .pattern("SRS")
                .input('S', Items.OBSIDIAN)
                .input('R', Items.GLASS)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.OBSIDIAN_GLASS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.TINTED_OBSIDIAN_GLASS, 2)
                .pattern(" R ")
                .pattern("RSR")
                .pattern(" R ")
                .input('S', Blocks_RaEx.OBSIDIAN_GLASS)
                .input('R', Items.AMETHYST_SHARD)
                .criterion(hasItem(Blocks_RaEx.OBSIDIAN_GLASS), conditionsFromItem(Blocks_RaEx.OBSIDIAN_GLASS))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.TINTED_OBSIDIAN_GLASS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.OBSIDIAN_GLASS_PANE, 16)
                .pattern("SSS")
                .pattern("SSS")
                .input('S', Blocks_RaEx.OBSIDIAN_GLASS)
                .criterion(hasItem(Blocks_RaEx.OBSIDIAN_GLASS), conditionsFromItem(Blocks_RaEx.OBSIDIAN_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.OBSIDIAN_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.OBSIDIAN_TRAPDOOR, 2)
                .pattern("SES")
                .pattern("SES")
                .input('S', Items.OBSIDIAN)
                .input('E', Items.IRON_TRAPDOOR)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .criterion(hasItem(Items.IRON_TRAPDOOR), conditionsFromItem(Items.IRON_TRAPDOOR))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.OBSIDIAN_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks_RaEx.OBSIDIAN_DOOR, 3)
                .pattern("SES")
                .pattern("SES")
                .pattern("SES")
                .input('S', Items.OBSIDIAN)
                .input('E', Items.IRON_DOOR)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .criterion(hasItem(Items.IRON_DOOR), conditionsFromItem(Items.IRON_DOOR))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.OBSIDIAN_DOOR)));

        // Armor and Tools
        offerSmithingTemplateCopyingRecipe(exporter, Items_RaEx.GEMS_UPGRADE_TEMPLATE, Tags_RaEx.Items.GEMS);

        /// Tools
        //// Long Sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.WOODEN_LONGSWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ItemTags.PLANKS)
                .input('S', Items.WOODEN_SWORD)
                .criterion(hasItem(Items.WOODEN_SWORD), conditionsFromItem(Items.WOODEN_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.WOODEN_LONGSWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.STONE_LONGSWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ItemTags.STONE_TOOL_MATERIALS)
                .input('S', Items.STONE_SWORD)
                .criterion(hasItem(Items.STONE_SWORD), conditionsFromItem(Items.STONE_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.STONE_LONGSWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.COPPER_LONGSWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', Items.COPPER_INGOT)
                .input('S', ToolsAndArmors_RaEx.COPPER_SWORD)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(ToolsAndArmors_RaEx.COPPER_SWORD), conditionsFromItem(ToolsAndArmors_RaEx.COPPER_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_LONGSWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.GOLDEN_LONGSWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', Items.GOLD_INGOT)
                .input('S', Items.GOLDEN_SWORD)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.GOLDEN_SWORD), conditionsFromItem(Items.GOLDEN_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.GOLDEN_LONGSWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.IRON_LONGSWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', Items.IRON_INGOT)
                .input('S', Items.IRON_SWORD)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.IRON_LONGSWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.DIAMOND_LONGSWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', Items.DIAMOND)
                .input('S', Items.DIAMOND_SWORD)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.NETHERITE_LONGSWORD)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD), conditionsFromItem(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.NETHERITE_LONGSWORD)));

        //// Copper
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.COPPER_AXE, 1)
                .pattern("CC")
                .pattern("CS")
                .pattern(" S")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.COPPER_SHOVEL, 1)
                .pattern("C")
                .pattern("S")
                .pattern("S")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.COPPER_PICKAXE, 1)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ToolsAndArmors_RaEx.COPPER_HOE, 1)
                .pattern("CC")
                .pattern(" S")
                .pattern(" S")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_HOE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.COPPER_SWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_SWORD)));

        /// Armor
        //// Shulker
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.SHULKER_HELMET, 1)
                .input(Items.SHULKER_SHELL, 2)
                .input(Items.LEATHER_HELMET)
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .criterion(hasItem(Items.LEATHER_HELMET), conditionsFromItem(Items.LEATHER_HELMET))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.SHULKER_HELMET)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.SHULKER_CHESTPLATE, 1)
                .input(Items.SHULKER_SHELL, 2)
                .input(Items.LEATHER_CHESTPLATE)
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .criterion(hasItem(Items.LEATHER_CHESTPLATE), conditionsFromItem(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.SHULKER_CHESTPLATE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.SHULKER_LEGGINGS, 1)
                .input(Items.SHULKER_SHELL, 2)
                .input(Items.LEATHER_LEGGINGS)
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .criterion(hasItem(Items.LEATHER_LEGGINGS), conditionsFromItem(Items.LEATHER_LEGGINGS))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.SHULKER_LEGGINGS)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.SHULKER_BOOTS, 1)
                .input(Items.SHULKER_SHELL, 2)
                .input(Items.LEATHER_BOOTS)
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .criterion(hasItem(Items.LEATHER_BOOTS), conditionsFromItem(Items.LEATHER_BOOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.SHULKER_BOOTS)));


        //// Copper
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items_RaEx.COPPER_NUGGET, RecipeCategory.MISC,
                Items.COPPER_INGOT);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BREWING, Items_RaEx.METAL_LUMP, 2)
                .input(Items_RaEx.COPPER_NUGGET)
                .input(Items.IRON_NUGGET)
                .input(Items.GOLD_NUGGET)
                .criterion(hasItem(Items_RaEx.COPPER_NUGGET), conditionsFromItem(Items_RaEx.COPPER_NUGGET))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.METAL_LUMP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.COPPER_HELMET, 1)
                .pattern("CCC")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_HELMET)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.COPPER_CHESTPLATE, 1)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.COPPER_LEGGINGS, 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ToolsAndArmors_RaEx.COPPER_BOOTS, 1)
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.COPPER_BOOTS)));

        //// Grenades
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.SMOKE_BOMB_ITEM, 1)
                .pattern("CA")
                .pattern("CB")
                .input('C', Items.IRON_INGOT)
                .input('B', Items.BLACK_DYE)
                .input('A', Items.INK_SAC)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.SMOKE_BOMB_ITEM)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.GLOW_BOMB_ITEM, 1)
                .input(Items_RaEx.SMOKE_BOMB_ITEM, 1)
                .input(Items.GLOW_INK_SAC, 2)
                .criterion(hasItem(Items_RaEx.SMOKE_BOMB_ITEM), conditionsFromItem(Items_RaEx.SMOKE_BOMB_ITEM))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.GLOW_BOMB_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.NINE_V_BATTERY_ITEM, 1)
                .pattern("CA")
                .pattern("CB")
                .input('C', Items.COPPER_INGOT)
                .input('B', Items.IRON_NUGGET)
                .input('A', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.NINE_V_BATTERY_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.HOLY_HAND_GRENADE_ITEM, 1)
                .pattern("CCC")
                .pattern("CBC")
                .input('C', Items.GOLD_INGOT)
                .input('B', Items_RaEx.NINE_V_BATTERY_ITEM)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items_RaEx.NINE_V_BATTERY_ITEM), conditionsFromItem(Items_RaEx.NINE_V_BATTERY_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.HOLY_HAND_GRENADE_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks_RaEx.LAND_MINE, 3)
                .pattern("RRR")
                .pattern("RSR")
                .input('S', Items.TNT)
                .input('R', Items.COPPER_INGOT)
                .criterion(hasItem(Items.TNT), conditionsFromItem(Items.TNT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.LAND_MINE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks_RaEx.STRONG_LAND_MINE)
                .pattern("RRR")
                .pattern("RSR")
                .input('S', Blocks_RaEx.LAND_MINE)
                .input('R', Items.IRON_INGOT)
                .criterion(hasItem(Blocks_RaEx.LAND_MINE), conditionsFromItem(Blocks_RaEx.LAND_MINE))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks_RaEx.STRONG_LAND_MINE)));


        //// Aquamarin
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(Items_RaEx.AQUAMARIN),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
                .criterion(hasItem(Items_RaEx.AQUAMARIN), conditionsFromItem(Items_RaEx.AQUAMARIN))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(Items_RaEx.AQUAMARIN),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
                .criterion(hasItem(Items_RaEx.AQUAMARIN), conditionsFromItem(Items_RaEx.AQUAMARIN))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(Items_RaEx.AQUAMARIN),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
                .criterion(hasItem(Items_RaEx.AQUAMARIN), conditionsFromItem(Items_RaEx.AQUAMARIN))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(Items_RaEx.AQUAMARIN),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_BOOTS), conditionsFromItem(Items.DIAMOND_BOOTS))
                .criterion(hasItem(Items_RaEx.AQUAMARIN), conditionsFromItem(Items_RaEx.AQUAMARIN))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS)));


        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET), conditionsFromItem(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE), conditionsFromItem(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS), conditionsFromItem(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS), conditionsFromItem(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS)));


        //// Ruby
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(Items_RaEx.RUBY),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_RUBY_HELMET)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
                .criterion(hasItem(Items_RaEx.RUBY), conditionsFromItem(Items_RaEx.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_RUBY_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(Items_RaEx.RUBY),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
                .criterion(hasItem(Items_RaEx.RUBY), conditionsFromItem(Items_RaEx.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(Items_RaEx.RUBY),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_RUBY_LEGGINGS)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
                .criterion(hasItem(Items_RaEx.RUBY), conditionsFromItem(Items_RaEx.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(Items_RaEx.RUBY),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_RUBY_BOOTS)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_BOOTS), conditionsFromItem(Items.DIAMOND_BOOTS))
                .criterion(hasItem(Items_RaEx.RUBY), conditionsFromItem(Items_RaEx.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_RUBY_BOOTS)));


        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_RUBY_HELMET),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_RUBY_HELMET)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_RUBY_HELMET), conditionsFromItem(ToolsAndArmors_RaEx.D_RUBY_HELMET))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_RUBY_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE), conditionsFromItem(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_RUBY_LEGGINGS)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS), conditionsFromItem(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_RUBY_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_RUBY_BOOTS),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_RUBY_BOOTS)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_RUBY_BOOTS), conditionsFromItem(ToolsAndArmors_RaEx.D_RUBY_BOOTS))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_RUBY_BOOTS)));


        //// Topas
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(Items_RaEx.TOPAS),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_TOPAS_HELMET)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
                .criterion(hasItem(Items_RaEx.TOPAS), conditionsFromItem(Items_RaEx.TOPAS))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_TOPAS_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(Items_RaEx.TOPAS),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
                .criterion(hasItem(Items_RaEx.TOPAS), conditionsFromItem(Items_RaEx.TOPAS))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(Items_RaEx.TOPAS),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
                .criterion(hasItem(Items_RaEx.TOPAS), conditionsFromItem(Items_RaEx.TOPAS))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(Items_RaEx.TOPAS),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.D_TOPAS_BOOTS)
                .criterion(hasItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE), conditionsFromItem(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND_BOOTS), conditionsFromItem(Items.DIAMOND_BOOTS))
                .criterion(hasItem(Items_RaEx.TOPAS), conditionsFromItem(Items_RaEx.TOPAS))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.D_TOPAS_BOOTS)));


        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_TOPAS_HELMET),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_TOPAS_HELMET)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_TOPAS_HELMET), conditionsFromItem(ToolsAndArmors_RaEx.D_TOPAS_HELMET))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_TOPAS_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE), conditionsFromItem(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS), conditionsFromItem(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ToolsAndArmors_RaEx.D_TOPAS_BOOTS),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT, ToolsAndArmors_RaEx.N_TOPAS_BOOTS)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ToolsAndArmors_RaEx.D_TOPAS_BOOTS), conditionsFromItem(ToolsAndArmors_RaEx.D_TOPAS_BOOTS))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ToolsAndArmors_RaEx.N_TOPAS_BOOTS)));

        //Explosive Bamboo
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items_RaEx.BAMBOO_EXPLOSIVE, 1)
                .input(Items.GUNPOWDER, 2)
                .input(Items.BAMBOO, 1)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.BAMBOO_EXPLOSIVE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items_RaEx.BAMBOO_EXPLOSIVE_STRONG, 1)
                .input(Items_RaEx.BAMBOO_EXPLOSIVE, 2)
                .input(Items_RaEx.DUK_TAPE, 1)
                .criterion(hasItem(Items_RaEx.BAMBOO_EXPLOSIVE), conditionsFromItem(Items_RaEx.BAMBOO_EXPLOSIVE))
                .criterion(hasItem(Items_RaEx.DUK_TAPE), conditionsFromItem(Items_RaEx.DUK_TAPE))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items_RaEx.DUK_TAPE, 8)
                .input(Items.PAPER, 8)
                .input(Items.HONEY_BOTTLE, 1)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.HONEY_BOTTLE))
                .offerTo(exporter, new Identifier(getRecipeName(Items_RaEx.DUK_TAPE)));
    }
}
