package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.block.custom.crops.CornCropBlock;
import net.rand.exten.block.custom.crops.TomatoCropBlock;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.item.custom.LootBag_RaEx;

import java.util.Optional;

public class ModelProvider_RaEx extends FabricModelProvider {
    public ModelProvider_RaEx(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool burnedWoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks_RaEx.BURNED_PLANKS);
        BlockStateModelGenerator.BlockTexturePool purpurWoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks_RaEx.PURPUR_PLANKS);
        BlockStateModelGenerator.BlockTexturePool cheesePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks_RaEx.CHEESE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.SOUL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.AQUAMARIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.AQUAMARIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.TOPAS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.TOPAS_ORE);

        // Cheese
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.CHEESE_STATION);
        cheesePool.stairs(Blocks_RaEx.CHEESE_STAIRS);
        cheesePool.slab(Blocks_RaEx.CHEESE_SLABS);
        cheesePool.wall(Blocks_RaEx.CHEESE_WALLS);

        // Trees
        /// PurPur Tree
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.PURPUR_LEAVES);
        blockStateModelGenerator.registerLog(Blocks_RaEx.PURPUR_LOG).log(Blocks_RaEx.PURPUR_LOG).wood(Blocks_RaEx.PURPUR_WOOD);
        blockStateModelGenerator.registerFlowerPotPlant(Blocks_RaEx.PURPUR_SAPLING, Blocks_RaEx.POTTED_PURPUR_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(Blocks_RaEx.STRIPPED_PURPUR_LOG).log(Blocks_RaEx.STRIPPED_PURPUR_LOG).wood(Blocks_RaEx.STRIPPED_PURPUR_WOOD);
        purpurWoodPool.fence(Blocks_RaEx.PURPUR_FENCE);
        purpurWoodPool.fenceGate(Blocks_RaEx.PURPUR_GATE);
        purpurWoodPool.stairs(Blocks_RaEx.PURPUR_STAIRS);
        purpurWoodPool.slab(Blocks_RaEx.PURPUR_SLABS);
        purpurWoodPool.button(Blocks_RaEx.PURPUR_BUTTON);
        purpurWoodPool.pressurePlate(Blocks_RaEx.PURPUR_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(Blocks_RaEx.PURPUR_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(Blocks_RaEx.PURPUR_TRAPDOOR);

        /// Burned Tree
        blockStateModelGenerator.registerLog(Blocks_RaEx.BURNED_LOG).log(Blocks_RaEx.BURNED_LOG).wood(Blocks_RaEx.BURNED_WOOD);
        blockStateModelGenerator.registerLog(Blocks_RaEx.STRIPPED_BURNED_LOG).log(Blocks_RaEx.STRIPPED_BURNED_LOG).wood(Blocks_RaEx.STRIPPED_BURNED_WOOD);
        burnedWoodPool.fence(Blocks_RaEx.BURNED_FENCE);
        burnedWoodPool.fenceGate(Blocks_RaEx.BURNED_GATE);
        burnedWoodPool.stairs(Blocks_RaEx.BURNED_STAIRS);
        burnedWoodPool.slab(Blocks_RaEx.BURNED_SLABS);
        burnedWoodPool.button(Blocks_RaEx.BURNED_BUTTON);
        burnedWoodPool.pressurePlate(Blocks_RaEx.BURNED_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(Blocks_RaEx.BURNED_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(Blocks_RaEx.BURNED_TRAPDOOR);
        blockStateModelGenerator.registerFlowerPotPlant(Blocks_RaEx.BURNED_TREE_SAPLING, Blocks_RaEx.POTTED_BURNED_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        // Misc
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.CHARCOAL_BLOCK);
        blockStateModelGenerator.registerCooker(Blocks_RaEx.GRINDER, TexturedModel.ORIENTABLE);

        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.MOSSY_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.ICE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.SAND_CRYSTAL);

        // Obsidian
        blockStateModelGenerator.registerGlassPane(Blocks_RaEx.OBSIDIAN_GLASS, Blocks_RaEx.OBSIDIAN_GLASS_PANE);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks_RaEx.TINTED_OBSIDIAN_GLASS);
        blockStateModelGenerator.registerDoor(Blocks_RaEx.OBSIDIAN_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(Blocks_RaEx.OBSIDIAN_TRAPDOOR);

        blockStateModelGenerator.registerFlowerPotPlant(Blocks_RaEx.NIGHT_SHADE, Blocks_RaEx.POTTED_NIGHT_SHADE, BlockStateModelGenerator.TintType.NOT_TINTED);

        /// Crops
        blockStateModelGenerator.registerCrop(CropBlocks_RaEx.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(CropBlocks_RaEx.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ToolsAndArmors_RaEx.LEAVE_STAFF, Models.HANDHELD);

        itemModelGenerator.register(ToolsAndArmors_RaEx.WOODEN_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.STONE_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.COPPER_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.IRON_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.GOLDEN_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.DIAMOND_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.NETHERITE_PAXEL, Models.HANDHELD);

        itemModelGenerator.register(ToolsAndArmors_RaEx.TOY_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(Items_RaEx.ESCAPE_POTION, Models.GENERATED);
        itemModelGenerator.register(ToolsAndArmors_RaEx.ESCAPE_ROPE, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.SMOKE_BOMB_ITEM, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.GLOW_BOMB_ITEM, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.NINE_V_BATTERY_ITEM, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.HOLY_HAND_GRENADE_ITEM, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.SOUL, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.PEBBLE, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.DUK_TAPE, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.ROOMBA_ITEM, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.EMPTY_SODA_CAN, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.RED_SODA_CAN, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.GREEN_SODA_CAN, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.BAMBOO_EXPLOSIVE, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.AQUAMARIN, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.RAW_AQUAMARIN, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.RUBY, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.TOPAS, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.RAW_TOPAS, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.STINKY_CHEESE, Models.GENERATED);
        itemModelGenerator.register(LootBag_RaEx.CHEESE_LOOT_BAG, Models.GENERATED);
        itemModelGenerator.register(LootBag_RaEx.MINE_LOOT_BAG, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.METAL_LUMP, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.TOOTH, Models.GENERATED);

        itemModelGenerator.register(Items_RaEx.SANDWICH, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.BUCKET_CHEESE, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.CHEESE, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.CORN, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.TOMATO, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.END_BARRY, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.RAW_PIZZA, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.PIZZA, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.DOUGH, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.FLOUR, Models.GENERATED);
        itemModelGenerator.register(Items_RaEx.POPCORN, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.SHULKER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.SHULKER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.SHULKER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.SHULKER_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.COPPER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.COPPER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.COPPER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.COPPER_BOOTS);
        itemModelGenerator.register(ToolsAndArmors_RaEx.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ToolsAndArmors_RaEx.COPPER_SWORD, Models.HANDHELD);

        itemModelGenerator.register(Items_RaEx.GEMS_UPGRADE_TEMPLATE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_RUBY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_RUBY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_RUBY_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_RUBY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_RUBY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_RUBY_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_TOPAS_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.D_TOPAS_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_TOPAS_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ToolsAndArmors_RaEx.N_TOPAS_BOOTS);


        itemModelGenerator.register(Items_RaEx.NIGHTMARE_TV_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
