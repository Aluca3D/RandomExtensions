package net.rand.exten.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.custom.food.Cheese;
import net.rand.exten.item.custom.food.FoodComponents_RaEx;
import net.rand.exten.item.custom.food.EscapePotion;
import net.rand.exten.item.custom.food.Soda;
import net.rand.exten.item.custom.items.projectile.*;

public class Items_RaEx {
    /**
     * Gems
     */
    public static final Item AQUAMARIN = registerItem("aquamarin",
            new Item(new FabricItemSettings()));
    public static final Item RAW_AQUAMARIN = registerItem("raw_aquamarin",
            new Item(new FabricItemSettings()));

    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby",
            new Item(new FabricItemSettings()));

    public static final Item TOPAS = registerItem("topas",
            new Item(new FabricItemSettings()));
    public static final Item RAW_TOPAS = registerItem("raw_topas",
            new Item(new FabricItemSettings()));

    /**
     * Souls
     */
    public static final Item SOUL = registerItem("soul",
            new Item(new FabricItemSettings()));

    /**
     * Crops
     */
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(CropBlocks_RaEx.TOMATO_CROP, new FabricItemSettings()));
    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(CropBlocks_RaEx.CORN_CROP, new FabricItemSettings()));

    public static final Item END_BARRY = registerItem("end_barry",
            new AliasedBlockItem(CropBlocks_RaEx.END_BARRY_BUSH, new FabricItemSettings().food(FoodComponents_RaEx.END_BARRY)));

    /**
     * Food
     */
    public static final Item SANDWICH = registerItem("sandwich",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.SANDWICH)));
    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.CORN)));
    public static final Item DOUGH = registerItem("dough",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.DOUGH)));
    public static final Item CHEESE = registerItem("cheese",
            new Cheese(new FabricItemSettings().food(FoodComponents_RaEx.CHEESE)));
    public static final Item BUCKET_CHEESE = registerItem("bucket_cheese",
            new Item(new FabricItemSettings().recipeRemainder(Items.BUCKET)));
    public static final Item STINKY_CHEESE = registerItem("stinky_cheese",
            new StinkyCheeseItem(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.TOMATO)));
    public static final Item PIZZA = registerItem("pizza",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.PIZZA)));
    public static final Item RAW_PIZZA = registerItem("raw_pizza",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.RAW_PIZZA)));
    public static final Item POPCORN = registerItem("popcorn",
            new Item(new FabricItemSettings().food(FoodComponents_RaEx.POPCORN)));

    /**
     * Potions
     */
    public static final Item ESCAPE_POTION = registerItem("escape_potion",
            new EscapePotion(new FabricItemSettings().maxDamage(16).rarity(Rarity.RARE)));

    /**
     * Soda
     */
    public static final Item EMPTY_SODA_CAN = registerItem("empty_soda_can",
            new Item(new FabricItemSettings().maxCount(16)));
    public static final Item GREEN_SODA_CAN = registerItem("green_soda_can",
            new Soda(new FabricItemSettings().food(FoodComponents_RaEx.SODA)
                    .maxCount(1),
                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 2),
                    new StatusEffectInstance(StatusEffects.SPEED, 1200)));
    public static final Item RED_SODA_CAN = registerItem("red_soda_can",
            new Soda(new FabricItemSettings().food(FoodComponents_RaEx.SODA)
                    .maxCount(1),
                    new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 2),
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 1200)));

    /**
     * Food Component
     */
    public static final Item FLOUR = registerItem("flour",
            new Item(new FabricItemSettings()));

    /**
     * Misc
     */
    public static final Item GEMS_UPGRADE_TEMPLATE = registerItem("gems_upgrade_template",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    public static final Item BAMBOO_EXPLOSIVE = registerItem("bamboo_explosive",
            new BambooExplosiveItem(new FabricItemSettings()));
    public static final Item BAMBOO_EXPLOSIVE_STRONG = registerItem("bamboo_explosive_strong",
            new StrongBambooExplosiveItem(new FabricItemSettings()));

    public static final Item PEBBLE = registerItem("pebble",
            new PebbleItem(new FabricItemSettings()));

    public static final Item DUK_TAPE = registerItem("duk_tape",
            new Item(new FabricItemSettings()));

    public static final Item SMOKE_BOMB = registerItem("smoke_bomb",
            new SmokeBombItem(new FabricItemSettings()));


    /**
     * Spawn Egg
     */
    public static final Item NIGHTMARE_TV_SPAWN_EGG = registerItem("nightmare_tv_spawn_egg",
            new SpawnEggItem(Entities_RaEx.NIGHTMARE_TV, 0x000000, 0xFFFFFF, new FabricItemSettings()));

    public static final Item ROOMBA_ITEM = registerItem("roomba_item",
            new SpawnEggItem(Entities_RaEx.ROOMBA, 0xFFFFFF, 0xFFFFFF, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Items for " + RandomExtensions.MOD_ID);

    }
}
