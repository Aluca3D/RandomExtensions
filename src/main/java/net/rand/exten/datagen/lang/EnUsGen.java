package net.rand.exten.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.block.StepBlockRegistry;
import net.rand.exten.effects.Effects_RaEx;
import net.rand.exten.enchantment.Enchantments_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.item.custom.LootBag_RaEx;

import java.nio.file.Path;

public class EnUsGen extends FabricLanguageProvider {
    public EnUsGen(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Todo add all
        /// Item
        translationBuilder.add(Items_RaEx.AQUAMARIN, "Aquamarin");
        translationBuilder.add(Items_RaEx.RAW_AQUAMARIN, "Raw Aquamarin");
        translationBuilder.add(Items_RaEx.RUBY, "Ruby");
        translationBuilder.add(Items_RaEx.RAW_RUBY, "Raw Ruby");
        translationBuilder.add(Items_RaEx.TOPAS, "Topas");
        translationBuilder.add(Items_RaEx.RAW_TOPAS, "Raw Topas");
        translationBuilder.add(Items_RaEx.TOOTH, "Tooth");
        translationBuilder.add(Items_RaEx.GEMS_UPGRADE_TEMPLATE, "Gems Upgrade Template");
        translationBuilder.add(ToolsAndArmors_RaEx.WOODEN_LONGSWORD, "Wooden Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.STONE_LONGSWORD, "Stone Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.IRON_LONGSWORD, "Iron Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_LONGSWORD, "Copper Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.GOLDEN_LONGSWORD, "Golden Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD, "Diamond Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.NETHERITE_LONGSWORD, "Netherite Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.WOODEN_PAXEL, "Wooden Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.STONE_PAXEL, "Stone Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.IRON_PAXEL, "Iron Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_PAXEL, "Copper Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.GOLDEN_PAXEL, "Golden Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.DIAMOND_PAXEL, "Diamond Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.NETHERITE_PAXEL, "Netherite Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_AXE, "Copper Axe");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_PICKAXE, "Copper Pickaxe");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_SHOVEL, "Copper Shovel");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_HOE, "Copper Hoe");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_SWORD, "Copper Sword");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_HELMET, "Copper Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_CHESTPLATE, "Copper Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_LEGGINGS, "Copper Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_BOOTS, "Copper Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_HELMET, "Shulker Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_CHESTPLATE, "Shulker Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_LEGGINGS, "Shulker Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_BOOTS, "Shulker Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET, "Aquamarin Diamond Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE, "Aquamarin Diamond Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS, "Aquamarin Diamond Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS, "Aquamarin Diamond Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET, "Aquamarin Netherite Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE, "Aquamarin Netherite Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS, "Aquamarin Netherite Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS, "Aquamarin Netherite Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_HELMET, "Ruby Diamond Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE, "Ruby Diamond Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS, "Ruby Diamond Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_BOOTS, "Ruby Diamond Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_HELMET, "Ruby Netherite Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE, "Ruby Netherite Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_LEGGINGS, "Ruby Netherite Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_BOOTS, "Ruby Netherite Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_HELMET, "Topas Diamond Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE, "Topas Diamond Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS, "Topas Diamond Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_BOOTS, "Topas Diamond Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_HELMET, "Topas Netherite Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE, "Topas Netherite Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS, "Topas Netherite Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_BOOTS, "Topas Netherite Boots");
        translationBuilder.add(Items_RaEx.SOUL, "Soul");
        translationBuilder.add(Items_RaEx.PEBBLE, "Pebble");

        translationBuilder.add(Items_RaEx.SMOKE_BOMB_ITEM, "Smoke Bomb");
        translationBuilder.add(Items_RaEx.GLOW_BOMB_ITEM, "Glow Bomb");
        translationBuilder.add(Items_RaEx.NINE_V_BATTERY_ITEM, "9v Battery");
        translationBuilder.add(Items_RaEx.HOLY_HAND_GRENADE_ITEM, "Holy Hand Grenade");
        translationBuilder.add(Items_RaEx.NIGHTMARE_TV_SPAWN_EGG, "NightmareTV Spawn Egg");
        translationBuilder.add(Items_RaEx.ROOMBA_ITEM, "Roomba");

        translationBuilder.add(Items_RaEx.SANDWICH, "Sandwich");
        translationBuilder.add(Items_RaEx.POPCORN, "Popcorn");
        translationBuilder.add(Items_RaEx.CORN, "Corn");
        translationBuilder.add(Items_RaEx.END_BARRY, "End Barry");
        translationBuilder.add(Items_RaEx.CORN_SEEDS, "Corn Seed");
        translationBuilder.add(Items_RaEx.TOMATO_SEEDS, "Tomato Seed");
        translationBuilder.add(Items_RaEx.TOMATO, "Tomato");
        translationBuilder.add(Items_RaEx.RAW_PIZZA, "Raw Pizza");
        translationBuilder.add(Items_RaEx.PIZZA, "Pizza");
        translationBuilder.add(Items_RaEx.DOUGH, "Dough");
        translationBuilder.add(Items_RaEx.FLOUR, "Flour");
        translationBuilder.add(Items_RaEx.STINKY_CHEESE, "Stinky Cheese");
        translationBuilder.add(Items_RaEx.CHEESE, "Cheese");
        translationBuilder.add(Items_RaEx.BUCKET_CHEESE, "Cheese Bucket");
        translationBuilder.add(Items_RaEx.ESCAPE_POTION, "Escape Potion");
        translationBuilder.add(Items_RaEx.DUK_TAPE, "Duk Tape");
        translationBuilder.add(ToolsAndArmors_RaEx.TOY_HAMMER, "Toy Hammer");
        translationBuilder.add(ToolsAndArmors_RaEx.ESCAPE_ROPE, "Escape Rope");
        translationBuilder.add(ToolsAndArmors_RaEx.LEAVE_STAFF, "Leave Staff");
        translationBuilder.add(Items_RaEx.METAL_LUMP, "Metal Lump");
        translationBuilder.add(Items_RaEx.COPPER_NUGGET, "Copper Nugget");
        translationBuilder.add(Items_RaEx.BAMBOO_EXPLOSIVE, "Bamboo Explosive");
        translationBuilder.add(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG, "Strong Bamboo Explosive");
        translationBuilder.add(Items_RaEx.EMPTY_SODA_CAN, "Empty Can");
        translationBuilder.add(Items_RaEx.GREEN_SODA_CAN, "Green Soda");
        translationBuilder.add(Items_RaEx.RED_SODA_CAN, "Red Soda");

        /// Loot Bag
        translationBuilder.add(LootBag_RaEx.EMPTY_LOOT_BAG, "Empty Loot Bag");
        translationBuilder.add(LootBag_RaEx.CHEESE_LOOT_BAG, "Cheese Loot Bag");
        translationBuilder.add(LootBag_RaEx.MINE_LOOT_BAG, "Mine Loot Bag");

        /// Block
        translationBuilder.add(Blocks_RaEx.AQUAMARIN_ORE, "Deepslate Aquamarin Ore");
        translationBuilder.add(Blocks_RaEx.AQUAMARIN_BLOCK, "Aquamarin Block");
        translationBuilder.add(Blocks_RaEx.TOPAS_ORE, "Deepslate Topas Ore");
        translationBuilder.add(Blocks_RaEx.TOPAS_BLOCK, "Topas Block");
        translationBuilder.add(Blocks_RaEx.RUBY_ORE, "Deepslate Ruby Ore");
        translationBuilder.add(Blocks_RaEx.RUBY_BLOCK, "Ruby Block");
        translationBuilder.add(Blocks_RaEx.SOUL_ORE, "Soul ore");
        translationBuilder.add(Blocks_RaEx.CHARCOAL_BLOCK, "Charcoal Block");
        translationBuilder.add(Blocks_RaEx.CHEESE_BLOCK, "Cheese Block");
        translationBuilder.add(Blocks_RaEx.CHEESE_SLABS, "Cheese Slab");
        translationBuilder.add(Blocks_RaEx.CHEESE_STAIRS, "Cheese Stair");
        translationBuilder.add(Blocks_RaEx.CHEESE_WALLS, "Cheese Wall");
        translationBuilder.add(Blocks_RaEx.CHEESE_STATION, "Cheese Station");
        translationBuilder.add(StepBlockRegistry.CHEESE_STEP, "Cheese Step");
        translationBuilder.add(Blocks_RaEx.BARBED_WIRE, "Barbed Wire");
        translationBuilder.add(Blocks_RaEx.LAND_MINE, "Land Mine");
        translationBuilder.add(Blocks_RaEx.STRONG_LAND_MINE, "Strong Land Mine");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_DOOR, "Obsidian Door");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_TRAPDOOR, "Obsidian Trapdoor");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_GLASS, "Obsidian Glass");
        translationBuilder.add(Blocks_RaEx.TINTED_OBSIDIAN_GLASS, "Tinted Obsidian Glass");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_GLASS_PANE, "Obsidian Glass Pane");
        translationBuilder.add(Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK, "Explosive Cake");
        translationBuilder.add(Blocks_RaEx.MOSSY_CRYSTAL, "Mossy Crystal");
        translationBuilder.add(Blocks_RaEx.ICE_CRYSTAL, "Icey Crystal");
        translationBuilder.add(Blocks_RaEx.SAND_CRYSTAL, "Sandy Crystal");
        translationBuilder.add(Blocks_RaEx.GRINDER, "Grinder");
        translationBuilder.add(Blocks_RaEx.NIGHT_SHADE, "Night Shade");
        translationBuilder.add(Blocks_RaEx.POTTED_NIGHT_SHADE, "Potted Night Shade");
        translationBuilder.add(Blocks_RaEx.PURPUR_WOOD, "PurPur Wood");
        translationBuilder.add(Blocks_RaEx.PURPUR_LOG, "PurPur Log");
        translationBuilder.add(Blocks_RaEx.STRIPPED_PURPUR_WOOD, "Stripped PurPur Wood");
        translationBuilder.add(Blocks_RaEx.STRIPPED_PURPUR_LOG, "Stripped PurPur Log");
        translationBuilder.add(Blocks_RaEx.PURPUR_PLANKS, "PurPur Planks");
        translationBuilder.add(Blocks_RaEx.PURPUR_STAIRS, "PurPur Stairs");
        translationBuilder.add(Blocks_RaEx.PURPUR_SLABS, "PurPur Slabs");
        translationBuilder.add(Blocks_RaEx.PURPUR_FENCE, "PurPur Fence");
        translationBuilder.add(Blocks_RaEx.PURPUR_GATE, "PurPur Gate");
        translationBuilder.add(Blocks_RaEx.PURPUR_DOOR, "PurPur Door");
        translationBuilder.add(Blocks_RaEx.PURPUR_TRAPDOOR, "PurPur Trapdoor");
        translationBuilder.add(Blocks_RaEx.PURPUR_BUTTON, "PurPur Button");
        translationBuilder.add(Blocks_RaEx.PURPUR_LEAVES, "PurPur Leaves");
        translationBuilder.add(Blocks_RaEx.PURPUR_PRESSURE_PLATE, "PurPur Pressure Plate");
        translationBuilder.add(Blocks_RaEx.PURPUR_SAPLING, "PurPur Tree Sapling");
        translationBuilder.add(Blocks_RaEx.POTTED_PURPUR_SAPLING, "PurPur Potted Tree Sapling");
        translationBuilder.add(Blocks_RaEx.BURNED_WOOD, "Burned Wood");
        translationBuilder.add(Blocks_RaEx.BURNED_LOG, "Burned Log");
        translationBuilder.add(Blocks_RaEx.STRIPPED_BURNED_WOOD, "Stripped Burned Wood");
        translationBuilder.add(Blocks_RaEx.STRIPPED_BURNED_LOG, "Stripped Burned Log");
        translationBuilder.add(Blocks_RaEx.BURNED_PLANKS, "Burned Planks");
        translationBuilder.add(Blocks_RaEx.BURNED_STAIRS, "Burned Stairs");
        translationBuilder.add(Blocks_RaEx.BURNED_SLABS, "Burned Slabs");
        translationBuilder.add(Blocks_RaEx.BURNED_FENCE, "Burned Fence");
        translationBuilder.add(Blocks_RaEx.BURNED_GATE, "Burned Gate");
        translationBuilder.add(Blocks_RaEx.BURNED_DOOR, "Burned Door");
        translationBuilder.add(Blocks_RaEx.BURNED_TRAPDOOR, "Burned Trapdoor");
        translationBuilder.add(Blocks_RaEx.BURNED_BUTTON, "Burned Button");
        translationBuilder.add(Blocks_RaEx.BURNED_PRESSURE_PLATE, "Burned Pressure Plate");
        translationBuilder.add(Blocks_RaEx.BURNED_TREE_SAPLING, "Burned Tree Sapling");
        translationBuilder.add(Blocks_RaEx.POTTED_BURNED_TREE_SAPLING, "Burned Potted Tree Sapling");
        translationBuilder.add(CropBlocks_RaEx.END_BARRY_BUSH, "End Barry Bush");
        translationBuilder.add(CropBlocks_RaEx.TOMATO_CROP, "Tomato Crop");
        translationBuilder.add(CropBlocks_RaEx.CORN_CROP, "Corn Crop");

        translationBuilder.add(Blocks_RaEx.SWITCH, "Switch");

        /// Effect
        translationBuilder.add(Effects_RaEx.EVOKERS_BITE, "Evoker's Bite");
        translationBuilder.add(Effects_RaEx.LIGHTNING_ATTRACTION, "Lightning Attraction");

        ///Enchantment
        translationBuilder.add(Enchantments_RaEx.CURSE_OF_EXPLODING, "Curse of Exploding");
        translationBuilder.add(Enchantments_RaEx.POISONED_BLADE, "Poisoned Blade");
        translationBuilder.add(Enchantments_RaEx.CURSE_OF_SELF_HARMING, "Curse of Self Harming");
        translationBuilder.add(Enchantments_RaEx.ESCAPER, "Escaper");
        translationBuilder.add(Enchantments_RaEx.EVOKERS_BITE, "Evoker's Bite");
        translationBuilder.add(Enchantments_RaEx.LIFE_STEAL, "Life Steal");
        translationBuilder.add(Enchantments_RaEx.FREEZING_BLADE, "Freezing Blade");

        ///Entity
        translationBuilder.add(Entities_RaEx.NIGHTMARE_TV, "NightmareTV");
        translationBuilder.add(Entities_RaEx.ROOMBA, "Roomba");

        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/randexten/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Existing lang", e);
        }
    }
}
