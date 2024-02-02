package net.rand.exten.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.StepBlockRegistry;
import net.rand.exten.item.custom.LootBag_RaEx;

public class ItemGroups_RaEx {

    public static final ItemGroup RANDEXTEN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RandomExtensions.MOD_ID, "randexten_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.randexten_group"))
                    .icon(() -> new ItemStack(Items_RaEx.AQUAMARIN)).entries((displayContext, entries) -> {

                        /// Aquamarin
                        entries.add(Blocks_RaEx.AQUAMARIN_ORE);
                        entries.add(Items_RaEx.RAW_AQUAMARIN);
                        entries.add(Items_RaEx.AQUAMARIN);
                        entries.add(Blocks_RaEx.AQUAMARIN_BLOCK);

                        /// Ruby
                        entries.add(Blocks_RaEx.RUBY_ORE);
                        entries.add(Items_RaEx.RAW_RUBY);
                        entries.add(Items_RaEx.RUBY);
                        entries.add(Blocks_RaEx.RUBY_BLOCK);

                        /// Topas
                        entries.add(Blocks_RaEx.TOPAS_ORE);
                        entries.add(Items_RaEx.RAW_TOPAS);
                        entries.add(Items_RaEx.TOPAS);
                        entries.add(Blocks_RaEx.TOPAS_BLOCK);

                        // Tools
                        /// Special
                        entries.add(ToolsAndArmors_RaEx.LEAVE_STAFF);
                        entries.add(ToolsAndArmors_RaEx.TOY_HAMMER);
                        entries.add(Items_RaEx.ESCAPE_POTION);
                        entries.add(ToolsAndArmors_RaEx.ESCAPE_ROPE);

                        /// LongSword
                        entries.add(ToolsAndArmors_RaEx.WOODEN_LONGSWORD);
                        entries.add(ToolsAndArmors_RaEx.STONE_LONGSWORD);
                        entries.add(ToolsAndArmors_RaEx.COPPER_LONGSWORD);
                        entries.add(ToolsAndArmors_RaEx.IRON_LONGSWORD);
                        entries.add(ToolsAndArmors_RaEx.GOLDEN_LONGSWORD);
                        entries.add(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD);
                        entries.add(ToolsAndArmors_RaEx.NETHERITE_LONGSWORD);

                        /// Copper
                        entries.add(ToolsAndArmors_RaEx.COPPER_SHOVEL);
                        entries.add(ToolsAndArmors_RaEx.COPPER_PICKAXE);
                        entries.add(ToolsAndArmors_RaEx.COPPER_AXE);
                        entries.add(ToolsAndArmors_RaEx.COPPER_HOE);
                        entries.add(ToolsAndArmors_RaEx.COPPER_SWORD);

                        /// Paxel
                        entries.add(ToolsAndArmors_RaEx.WOODEN_PAXEL);
                        entries.add(ToolsAndArmors_RaEx.STONE_PAXEL);
                        entries.add(ToolsAndArmors_RaEx.COPPER_PAXEL);
                        entries.add(ToolsAndArmors_RaEx.IRON_PAXEL);
                        entries.add(ToolsAndArmors_RaEx.GOLDEN_PAXEL);
                        entries.add(ToolsAndArmors_RaEx.DIAMOND_PAXEL);
                        entries.add(ToolsAndArmors_RaEx.NETHERITE_PAXEL);

                        // Armor
                        /// Shulker
                        entries.add(ToolsAndArmors_RaEx.SHULKER_HELMET);
                        entries.add(ToolsAndArmors_RaEx.SHULKER_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.SHULKER_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.SHULKER_BOOTS);

                        /// Copper
                        entries.add(ToolsAndArmors_RaEx.COPPER_HELMET);
                        entries.add(ToolsAndArmors_RaEx.COPPER_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.COPPER_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.COPPER_BOOTS);

                        entries.add(Items_RaEx.GEMS_UPGRADE_TEMPLATE);

                        /// Aquamarin
                        entries.add(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET);
                        entries.add(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS);

                        entries.add(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET);
                        entries.add(ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS);

                        /// Ruby
                        entries.add(ToolsAndArmors_RaEx.D_RUBY_HELMET);
                        entries.add(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.D_RUBY_BOOTS);

                        entries.add(ToolsAndArmors_RaEx.N_RUBY_HELMET);
                        entries.add(ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.N_RUBY_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.N_RUBY_BOOTS);

                        /// Topas
                        entries.add(ToolsAndArmors_RaEx.D_TOPAS_HELMET);
                        entries.add(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.D_TOPAS_BOOTS);

                        entries.add(ToolsAndArmors_RaEx.N_TOPAS_HELMET);
                        entries.add(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE);
                        entries.add(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS);
                        entries.add(ToolsAndArmors_RaEx.N_TOPAS_BOOTS);

                        /// Souls
                        entries.add(Blocks_RaEx.SOUL_ORE);
                        entries.add(Items_RaEx.SOUL);

                        /// Cheese
                        entries.add(Items_RaEx.BUCKET_CHEESE);
                        entries.add(Items_RaEx.CHEESE);
                        entries.add(Items_RaEx.STINKY_CHEESE);
                        entries.add(Blocks_RaEx.CHEESE_BLOCK);
                        entries.add(Blocks_RaEx.CHEESE_STAIRS);
                        entries.add(Blocks_RaEx.CHEESE_SLABS);
                        entries.add(Blocks_RaEx.CHEESE_WALLS);
                        entries.add(Blocks_RaEx.CHEESE_STATION);

                        ///Loot Bag
                        entries.add(LootBag_RaEx.EMPTY_LOOT_BAG);
                        entries.add(LootBag_RaEx.CHEESE_LOOT_BAG);
                        entries.add(LootBag_RaEx.MINE_LOOT_BAG);
                        entries.add(LootBag_RaEx.HAT_LOOT_BAG);

                        /// Foods
                        entries.add(Items_RaEx.FLOUR);
                        entries.add(Items_RaEx.DOUGH);
                        entries.add(Items_RaEx.RAW_PIZZA);
                        entries.add(Items_RaEx.PIZZA);
                        entries.add(Items_RaEx.SANDWICH);
                        entries.add(Items_RaEx.POPCORN);

                        /// Crops
                        entries.add(Items_RaEx.END_BARRY);

                        entries.add(Items_RaEx.TOMATO_SEEDS);
                        entries.add(Items_RaEx.TOMATO);

                        entries.add(Items_RaEx.CORN_SEEDS);
                        entries.add(Items_RaEx.CORN);

                        /// Drinks
                        entries.add(Items_RaEx.EMPTY_SODA_CAN);
                        entries.add(Items_RaEx.GREEN_SODA_CAN);
                        entries.add(Items_RaEx.RED_SODA_CAN);

                        /// Flowers
                        entries.add(Blocks_RaEx.NIGHT_SHADE);

                        // Tree
                        entries.add(Blocks_RaEx.PURPUR_LOG);
                        entries.add(Blocks_RaEx.PURPUR_WOOD);
                        entries.add(Blocks_RaEx.PURPUR_LEAVES);
                        entries.add(Blocks_RaEx.STRIPPED_PURPUR_LOG);
                        entries.add(Blocks_RaEx.STRIPPED_PURPUR_WOOD);
                        entries.add(Blocks_RaEx.PURPUR_PLANKS);
                        entries.add(Blocks_RaEx.PURPUR_STAIRS);
                        entries.add(Blocks_RaEx.PURPUR_SLABS);
                        entries.add(Blocks_RaEx.PURPUR_FENCE);
                        entries.add(Blocks_RaEx.PURPUR_GATE);
                        entries.add(Blocks_RaEx.PURPUR_DOOR);
                        entries.add(Blocks_RaEx.PURPUR_TRAPDOOR);
                        entries.add(Blocks_RaEx.PURPUR_PRESSURE_PLATE);
                        entries.add(Blocks_RaEx.PURPUR_BUTTON);
                        entries.add(Blocks_RaEx.PURPUR_SAPLING);

                        /// Burned Tree
                        entries.add(Blocks_RaEx.BURNED_LOG);
                        entries.add(Blocks_RaEx.BURNED_WOOD);
                        entries.add(Blocks_RaEx.STRIPPED_BURNED_WOOD);
                        entries.add(Blocks_RaEx.STRIPPED_BURNED_LOG);
                        entries.add(Blocks_RaEx.BURNED_PLANKS);
                        entries.add(Blocks_RaEx.BURNED_STAIRS);
                        entries.add(Blocks_RaEx.BURNED_SLABS);
                        entries.add(Blocks_RaEx.BURNED_FENCE);
                        entries.add(Blocks_RaEx.BURNED_GATE);
                        entries.add(Blocks_RaEx.BURNED_DOOR);
                        entries.add(Blocks_RaEx.BURNED_TRAPDOOR);
                        entries.add(Blocks_RaEx.BURNED_PRESSURE_PLATE);
                        entries.add(Blocks_RaEx.BURNED_BUTTON);
                        entries.add(Blocks_RaEx.BURNED_TREE_SAPLING);

                        /// Misc
                        entries.add(Items_RaEx.DUK_TAPE);
                        entries.add(Items_RaEx.COPPER_NUGGET);
                        entries.add(Items_RaEx.METAL_LUMP);
                        entries.add(Items_RaEx.TOOTH);
                        entries.add(Blocks_RaEx.CHARCOAL_BLOCK);
                        entries.add(Items_RaEx.BAMBOO_EXPLOSIVE);
                        entries.add(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG);
                        entries.add(Blocks_RaEx.GRINDER);
                        entries.add(Items_RaEx.PEBBLE);
                        entries.add(Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK);
                        entries.add(Blocks_RaEx.BARBED_WIRE);

                        /// Head Wearable
                        entries.add(Items_RaEx.SUNGLASSES);
                        entries.add(Items_RaEx.TOP_HAT);
                        entries.add(Items_RaEx.TOP_TOP_HAT);
                        entries.add(Items_RaEx.TOP_TOP_TOP_HAT);

                        /// Funny Items and Blocks
                        entries.add(Items_RaEx.CHEESE_OF_FLIGHT);

                        /// Redstone
                        entries.add(Blocks_RaEx.SWITCH);

                        /// Explosives
                        entries.add(Blocks_RaEx.LAND_MINE);
                        entries.add(Blocks_RaEx.STRONG_LAND_MINE);
                        entries.add(Items_RaEx.SMOKE_BOMB_ITEM);
                        entries.add(Items_RaEx.GLOW_BOMB_ITEM);
                        entries.add(Items_RaEx.NINE_V_BATTERY_ITEM);
                        entries.add(Items_RaEx.HOLY_HAND_GRENADE_ITEM);

                        /// Crystal
                        entries.add(Blocks_RaEx.MOSSY_CRYSTAL);
                        entries.add(Blocks_RaEx.ICE_CRYSTAL);
                        entries.add(Blocks_RaEx.SAND_CRYSTAL);

                        /// Obsidian
                        entries.add(Blocks_RaEx.OBSIDIAN_GLASS);
                        entries.add(Blocks_RaEx.TINTED_OBSIDIAN_GLASS);
                        entries.add(Blocks_RaEx.OBSIDIAN_GLASS_PANE);
                        entries.add(Blocks_RaEx.OBSIDIAN_DOOR);
                        entries.add(Blocks_RaEx.OBSIDIAN_TRAPDOOR);

                        /// Spawn Egg
                        entries.add(Items_RaEx.ROOMBA_ITEM);
                        entries.add(Items_RaEx.NIGHTMARE_TV_SPAWN_EGG);

                        /// Step Blocks
                        entries.add(StepBlockRegistry.CHEESE_STEP);

                    }).build());

    public static void registerItemGroups() {
        RandomExtensions.LOGGER.info("Register Item Groups for" + RandomExtensions.MOD_ID);
    }
}
