package net.rand.exten.item.mains;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.materials.ToolMaterial_RaEx;
import net.rand.exten.item.custom.tools.PaxelItem;

public class Tools {
    /**
     * Paxel
     */
    public static final Item WOODEN_PAXEL = registerItem("wooden_paxel",
            new PaxelItem(ToolMaterials.WOOD, 4, -3f, new FabricItemSettings()));
    public static final Item STONE_PAXEL = registerItem("stone_paxel",
            new PaxelItem(ToolMaterials.STONE, 6, -3f, new FabricItemSettings()));
    public static final Item IRON_PAXEL = registerItem("iron_paxel",
            new PaxelItem(ToolMaterials.IRON, 6, -3f, new FabricItemSettings()));
    public static final Item COPPER_PAXEL = registerItem("copper_paxel",
            new PaxelItem(ToolMaterial_RaEx.COPPER, 6, -3f, new FabricItemSettings()));
    public static final Item GOLDEN_PAXEL = registerItem("golden_paxel",
            new PaxelItem(ToolMaterials.GOLD, 4, -3f, new FabricItemSettings()));
    public static final Item DIAMOND_PAXEL = registerItem("diamond_paxel",
            new PaxelItem(ToolMaterials.DIAMOND, 6, -3f, new FabricItemSettings()));
    public static final Item NETHERITE_PAXEL = registerItem("netherite_paxel",
            new PaxelItem(ToolMaterials.NETHERITE, 7, -3f, new FabricItemSettings().fireproof()));

    /**
     * Copper
     */
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ToolMaterial_RaEx.COPPER, 5, -3f, new FabricItemSettings()));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ToolMaterial_RaEx.COPPER, 1, -2.8f, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ToolMaterial_RaEx.COPPER, 1, -3f, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ToolMaterial_RaEx.COPPER, -2, -3f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Tools for " + RandomExtensions.MOD_ID);
    }
}
