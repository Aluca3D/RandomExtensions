package net.rand.exten.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LootBag_RaEx {

    /**LootBags*/
    public static final Item CHEESE_LOOT_BAG = registerItem("cheese_loot_bag",
            new LootBag(new FabricItemSettings(), "item.randexten.cheese_loot_bag.tooltip") {
                @Override
                protected void ItemList(PlayerEntity user, Random rItem) {
                    //Todo weight (wen possible)
                    List<Item> givenList = Arrays.asList(
                            Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Blocks_RaEx.CHEESE_BLOCK.asItem(),
                            Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.CHEESE, Items_RaEx.STINKY_CHEESE, Items_RaEx.STINKY_CHEESE
                    );
                    Item randomItem = givenList.get(rItem.nextInt(givenList.size()));

                    user.dropItem(randomItem);
                }
            });
    public static final Item MINE_LOOT_BAG = registerItem("mine_loot_bag",
            new LootBag(new FabricItemSettings(), "item.randexten.mine_loot_bag.tooltip") {
                @Override
                protected void ItemList(PlayerEntity user, Random rItem) {
                    List<Item> givenList = Arrays.asList(
                            Items.COBBLESTONE, Items.STICK, Items.TORCH, Items.COBBLESTONE, Items.COAL,
                            Items.OAK_PLANKS, Items_RaEx.ESCAPE_POTION, Items_RaEx.ESCAPE_POTION
                    );

                    Item randomItem = givenList.get(rItem.nextInt(givenList.size()));

                    user.dropItem(randomItem);
                }
            });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Loot Bags for " + RandomExtensions.MOD_ID);

    }
}
