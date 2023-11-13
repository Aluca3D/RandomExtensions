package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;

public class RecipeProvider_RaEx extends FabricRecipeProvider {

    public RecipeProvider_RaEx(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Gem Block
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items_RaEx.AQUAMARIN, RecipeCategory.DECORATIONS,
                Blocks_RaEx.AQUAMARIN_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.CHARCOAL, RecipeCategory.DECORATIONS,
                Blocks_RaEx.CHARCOAL_BLOCK);

        // Cheese
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items_RaEx.CHEESE, RecipeCategory.FOOD,
                Blocks_RaEx.CHEESE_BLOCK);

        offerFoodCookingRecipe(exporter, "milk", RecipeSerializer.SMOKING, 150, Items.MILK_BUCKET , Items_RaEx.BUCKET_CHEESE, 0.2f);

        offerSingleOutputShapelessRecipe(exporter,Blocks_RaEx.CHEESE_BLOCK, Items_RaEx.BUCKET_CHEESE, "cheese_block_from_bucket_cheese");

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

        // Burned Wood
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


        //Food
        offerFoodCookingRecipe(exporter, "smoking_dough", RecipeSerializer.SMOKING, 150, Items_RaEx.DOUGH, Items.BREAD, 0.2f);
        offerFoodCookingRecipe(exporter, "dough", RecipeSerializer.SMELTING, 200, Items_RaEx.DOUGH, Items.BREAD, 0.1f);
        offerFoodCookingRecipe(exporter, "campfire_dough", RecipeSerializer.CAMPFIRE_COOKING, 200, Items_RaEx.DOUGH, Items.BREAD, 0.1f);

        offerFoodCookingRecipe(exporter, "smoking_pizza", RecipeSerializer.SMOKING, 150, Items_RaEx.RAW_PIZZA, Items_RaEx.PIZZA, 0.2f);
        offerFoodCookingRecipe(exporter, "pizza", RecipeSerializer.SMELTING, 200, Items_RaEx.RAW_PIZZA, Items_RaEx.PIZZA, 0.1f);
        offerFoodCookingRecipe(exporter, "campfire_pizza", RecipeSerializer.CAMPFIRE_COOKING, 200, Items_RaEx.RAW_PIZZA, Items_RaEx.PIZZA, 0.1f);

        offerFoodCookingRecipe(exporter, "campfire_rotten_flesh", RecipeSerializer.CAMPFIRE_COOKING, 200, Items.ROTTEN_FLESH, Items.LEATHER, 0.1f);
        offerFoodCookingRecipe(exporter, "smoking_rotten_flesh", RecipeSerializer.SMOKING, 200, Items.ROTTEN_FLESH, Items.LEATHER, 0.1f);

        offerFoodCookingRecipe(exporter, "smoking_popcorn", RecipeSerializer.SMOKING, 200, Items_RaEx.CORN, Items_RaEx.POPCORN, 0.1f);
        offerFoodCookingRecipe(exporter, "popcorn", RecipeSerializer.SMELTING, 200, Items_RaEx.CORN, Items_RaEx.POPCORN, 0.1f);
        offerFoodCookingRecipe(exporter, "campfire_popcorn", RecipeSerializer.CAMPFIRE_COOKING, 200, Items_RaEx.CORN, Items_RaEx.POPCORN, 0.1f);

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
        offerSmithingTemplateCopyingRecipe(exporter, Items_RaEx.GEMS_UPGRADE_TEMPLATE, Items_RaEx.AQUAMARIN);

        /// Armor
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
