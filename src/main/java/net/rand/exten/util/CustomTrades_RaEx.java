package net.rand.exten.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.villager.Villager_RaEx;

public class CustomTrades_RaEx {
    public static void registerCustomTrades() {
        /// Cheese Maker
        TradeOfferHelper.registerVillagerOffers(Villager_RaEx.CHEESE_MAKER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(Items_RaEx.CHEESE, 1),
                            6, 2, 0.075f));
                });
        TradeOfferHelper.registerVillagerOffers(Villager_RaEx.CHEESE_MAKER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 9),
                            new ItemStack(Blocks_RaEx.CHEESE_BLOCK, 1),
                            3, 4, 0.075f));
                });
        TradeOfferHelper.registerVillagerOffers(Villager_RaEx.CHEESE_MAKER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items_RaEx.CHEESE, 1),
                            new ItemStack(Items.EMERALD, 1),
                            5, 3, 0.075f));
                });
        TradeOfferHelper.registerVillagerOffers(Villager_RaEx.CHEESE_MAKER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Blocks_RaEx.CHEESE_BLOCK, 1),
                            new ItemStack(Items.EMERALD, 6),
                            5, 3, 0.075f));
                });
        TradeOfferHelper.registerVillagerOffers(Villager_RaEx.CHEESE_MAKER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(Items_RaEx.CHEESE_LOOT_BAG, 1),
                            5, 6, 0.075f));
                });
        TradeOfferHelper.registerVillagerOffers(Villager_RaEx.CHEESE_MAKER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 14),
                            new ItemStack(Items_RaEx.STINKY_CHEESE, 1),
                            10, 8, 0.075f));
                });
    }
}
