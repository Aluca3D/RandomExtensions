package net.rand.exten.item.mains;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.materials.ToolMaterial_RaEx;
import net.rand.exten.item.custom.tools.LongSwordItem;

public class Weapons {
    /**
     * Long Sword
     */
    public static final Item WOODEN_LONGSWORD = registerItem("wooden_longsword",
            new LongSwordItem(ToolMaterials.WOOD, 4, -2.9f, -0.01f, new FabricItemSettings()));
    public static final Item STONE_LONGSWORD = registerItem("stone_longsword",
            new LongSwordItem(ToolMaterials.STONE, 4, -2.9f, -0.02f, new FabricItemSettings()));
    public static final Item COPPER_LONGSWORD = registerItem("copper_longsword",
            new LongSwordItem(ToolMaterial_RaEx.COPPER, 4, -3f, -0.01f, new FabricItemSettings()));
    public static final Item IRON_LONGSWORD = registerItem("iron_longsword",
            new LongSwordItem(ToolMaterials.IRON, 4, -2.9f, -0.02f, new FabricItemSettings()));
    public static final Item GOLDEN_LONGSWORD = registerItem("golden_longsword",
            new LongSwordItem(ToolMaterials.GOLD, 4, -2.6f, -0.01f, new FabricItemSettings()));
    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword",
            new LongSwordItem(ToolMaterials.DIAMOND, 4, -2.9f, -0.02f, new FabricItemSettings()));
    public static final Item NETHERITE_LONGSWORD = registerItem("netherite_longsword",
            new LongSwordItem(ToolMaterials.NETHERITE, 4, -2.8f, -0.02f, new FabricItemSettings()));
    /**
     * Copper
     */
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ToolMaterial_RaEx.COPPER, 3, -2.5f, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Weapons for " + RandomExtensions.MOD_ID);
    }
}
