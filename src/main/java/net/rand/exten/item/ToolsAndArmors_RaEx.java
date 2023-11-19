package net.rand.exten.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.ArmorItem_RaEx;
import net.rand.exten.item.custom.ArmorMaterials_RaEx;
import net.rand.exten.item.custom.tools.LeaveStaff;
import net.rand.exten.item.custom.tools.PaxelItem;
import net.rand.exten.item.custom.tools.ToyHammer;

public class ToolsAndArmors_RaEx {
    /**Special*/
    public static final Item LEAVE_STAFF = registerItem("leave_staff",
            new LeaveStaff(new FabricItemSettings().maxCount(1).fireproof().maxDamage(240)));
    public static final Item TOY_HAMMER = registerItem("toy_hammer",
            new ToyHammer(ToolMaterials.WOOD,new FabricItemSettings().maxCount(1).maxDamage(240)));

    /**Paxel*/
    public static final Item WOODEN_PAXEL = registerItem("wooden_paxel",
            new PaxelItem(ToolMaterials.WOOD, 0, 0f, new FabricItemSettings()));
    public static final Item STONE_PAXEL = registerItem("stone_paxel",
            new PaxelItem(ToolMaterials.STONE, 0, 0f, new FabricItemSettings()));
    public static final Item IRON_PAXEL = registerItem("iron_paxel",
            new PaxelItem(ToolMaterials.IRON, 0, 0f, new FabricItemSettings()));
    public static final Item GOLDEN_PAXEL = registerItem("golden_paxel",
            new PaxelItem(ToolMaterials.GOLD, 0, 0f, new FabricItemSettings()));
    public static final Item DIAMOND_PAXEL = registerItem("diamond_paxel",
            new PaxelItem(ToolMaterials.DIAMOND, 0, 0f, new FabricItemSettings()));
    public static final Item NETHERITE_PAXEL = registerItem("netherite_paxel",
            new PaxelItem(ToolMaterials.NETHERITE, 0, 0f, new FabricItemSettings().fireproof()));

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

