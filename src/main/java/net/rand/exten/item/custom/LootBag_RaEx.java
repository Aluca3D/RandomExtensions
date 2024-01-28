package net.rand.exten.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;

import java.util.Arrays;

public class LootBag_RaEx {

    public static final Item EMPTY_LOOT_BAG = registerItem("empty_loot_bag",
            new Item(new FabricItemSettings()));

    public static final Item CHEESE_LOOT_BAG = registerItem("cheese_loot_bag",
            new LootBag(new FabricItemSettings(), "item.randexten.cheese_loot_bag.tooltip", Arrays.asList(
                    Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE,
                    Blocks_RaEx.CHEESE_BLOCK.asItem(),
                    Items_RaEx.STINKY_CHEESE, Items_RaEx.STINKY_CHEESE
            ).toArray(new Item[0])));

    //todo: add to underground structure loot (Mineshaft,...)
    public static final Item MINE_LOOT_BAG = registerItem("mine_loot_bag",
            new LootBag(new FabricItemSettings(), "item.randexten.mine_loot_bag.tooltip", Arrays.asList(
                    Items.COBBLESTONE, Items.COBBLESTONE, Items.COBBLESTONE, Items.COBBLESTONE,
                    Items.STICK, Items.STICK, Items.STICK, Items.STICK,
                    Items.TORCH, Items.TORCH, Items.TORCH, Items.TORCH,
                    Items.COAL, Items.COAL, Items.COAL, Items.COAL,
                    Items.OAK_PLANKS, Items.OAK_PLANKS, Items.OAK_PLANKS, Items.OAK_PLANKS,
                    Items_RaEx.ESCAPE_POTION
            ).toArray(new Item[0])));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Loot Bags for " + RandomExtensions.MOD_ID);

    }
}
