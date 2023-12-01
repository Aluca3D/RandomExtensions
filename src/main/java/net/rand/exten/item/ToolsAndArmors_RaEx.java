package net.rand.exten.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.ArmorItem_RaEx;
import net.rand.exten.item.custom.ArmorMaterials_RaEx;
import net.rand.exten.item.custom.ToolMaterial_RaEx;
import net.rand.exten.item.custom.legendary.EscapeRope;
import net.rand.exten.item.custom.legendary.LeaveStaff;
import net.rand.exten.item.custom.legendary.ToyHammer;
import net.rand.exten.item.custom.tools.*;

public class ToolsAndArmors_RaEx {
    /**Special*/
    public static final Item LEAVE_STAFF = registerItem("leave_staff",
            new LeaveStaff(new FabricItemSettings().maxCount(1).fireproof().maxDamage(240)));
    public static final Item TOY_HAMMER = registerItem("toy_hammer",
            new ToyHammer(ToolMaterials.WOOD,new FabricItemSettings().maxCount(1).maxDamage(960)));
    public static final Item ESCAPE_ROPE = registerItem("escape_rope",
            new EscapeRope(new FabricItemSettings().maxCount(1).fireproof().maxDamage(64)));

    /**Long Sword*/
    public static final Item WOODEN_LONGSWORD = registerItem("wooden_longsword",
            new LongSwordItem(ToolMaterials.WOOD,3, -2.4f,new FabricItemSettings()));
    public static final Item STONE_LONGSWORD = registerItem("stone_longsword",
            new LongSwordItem(ToolMaterials.STONE,3, -2.4f,new FabricItemSettings()));
    public static final Item COPPER_LONGSWORD = registerItem("copper_longsword",
            new LongSwordItem(ToolMaterial_RaEx.COPPER,3, -2.4f,new FabricItemSettings()));
    public static final Item IRON_LONGSWORD = registerItem("iron_longsword",
            new LongSwordItem(ToolMaterials.IRON,3, -2.4f,new FabricItemSettings()));
    public static final Item GOLDEN_LONGSWORD = registerItem("golden_longsword",
            new LongSwordItem(ToolMaterials.GOLD,3, -2.4f,new FabricItemSettings()));
    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword",
            new LongSwordItem(ToolMaterials.DIAMOND,3, -2.4f,new FabricItemSettings()));
    public static final Item NETHERITE_LONGSWORD = registerItem("netherite_longsword",
            new LongSwordItem(ToolMaterials.NETHERITE,3, -2.4f,new FabricItemSettings()));

    /**Paxel*/
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

    /**Copper*/
    public static final Item COPPER_AXE = registerItem("cooper_axe",
            new AxeItem(ToolMaterial_RaEx.COPPER, 5, -3f, new FabricItemSettings()));
    public static final Item COPPER_PICKAXE = registerItem("cooper_pickaxe",
            new PickaxeItem(ToolMaterial_RaEx.COPPER, 1, -2.8f, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("cooper_shovel",
            new ShovelItem(ToolMaterial_RaEx.COPPER, 1, -3f, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("cooper_hoe",
            new HoeItem(ToolMaterial_RaEx.COPPER, -2, -3f, new FabricItemSettings()));
    public static final Item COPPER_SWORD = registerItem("cooper_sword",
            new SwordItem(ToolMaterial_RaEx.COPPER, 3, -2.4f, new FabricItemSettings()));

    public static final Item COPPER_HELMET = registerItem("cooper_helmet",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("cooper_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("cooper_leggings",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("cooper_boots",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    /**Aquamarin Armor*/
    public static final Item D_AQUAMARIN_HELMET = registerItem("diamond_aquamarin_helmet",
            new ArmorItem_RaEx(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item D_AQUAMARIN_CHESTPLATE = registerItem("diamond_aquamarin_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item D_AQUAMARIN_LEGGINGS = registerItem("diamond_aquamarin_leggings",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item D_AQUAMARIN_BOOTS = registerItem("diamond_aquamarin_boots",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item N_AQUAMARIN_HELMET = registerItem("netherite_aquamarin_helmet",
            new ArmorItem_RaEx(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item N_AQUAMARIN_CHESTPLATE = registerItem("netherite_aquamarin_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item N_AQUAMARIN_LEGGINGS = registerItem("netherite_aquamarin_leggings",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item N_AQUAMARIN_BOOTS = registerItem("netherite_aquamarin_boots",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    /**Ruby Armor*/
    public static final Item D_RUBY_HELMET = registerItem("diamond_ruby_helmet",
            new ArmorItem_RaEx(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item D_RUBY_CHESTPLATE = registerItem("diamond_ruby_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item D_RUBY_LEGGINGS = registerItem("diamond_ruby_leggings",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item D_RUBY_BOOTS = registerItem("diamond_ruby_boots",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item N_RUBY_HELMET = registerItem("netherite_ruby_helmet",
            new ArmorItem_RaEx(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item N_RUBY_CHESTPLATE = registerItem("netherite_ruby_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item N_RUBY_LEGGINGS = registerItem("netherite_ruby_leggings",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item N_RUBY_BOOTS = registerItem("netherite_ruby_boots",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

     /**Topas Armor*/
    public static final Item D_TOPAS_HELMET = registerItem("diamond_topas_helmet",
            new ArmorItem_RaEx(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item D_TOPAS_CHESTPLATE = registerItem("diamond_topas_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item D_TOPAS_LEGGINGS = registerItem("diamond_topas_leggings",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item D_TOPAS_BOOTS = registerItem("diamond_topas_boots",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item N_TOPAS_HELMET = registerItem("netherite_topas_helmet",
            new ArmorItem_RaEx(ArmorMaterials_RaEx.NETHERITE_TOPAS, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item N_TOPAS_CHESTPLATE = registerItem("netherite_topas_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_TOPAS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item N_TOPAS_LEGGINGS = registerItem("netherite_topas_leggings",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_TOPAS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item N_TOPAS_BOOTS = registerItem("netherite_topas_boots",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_TOPAS, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Armor and Tools for " + RandomExtensions.MOD_ID);


    }
}

