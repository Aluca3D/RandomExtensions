package net.rand.exten.item.mains;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.materials.ArmorMaterials_RaEx;
import net.rand.exten.item.custom.legendary.EscapeRope;
import net.rand.exten.item.custom.legendary.LeaveStaff;
import net.rand.exten.item.custom.legendary.ToyHammer;
import net.rand.exten.item.custom.wearable.armor.*;

public class Armors {
    /**
     * Shulker
     */
    public static final Item SHULKER_HELMET = registerItem("shulker_helmet",
            new ShulkerArmorItem(ArmorMaterials_RaEx.SHULKER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SHULKER_CHESTPLATE = registerItem("shulker_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.SHULKER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SHULKER_LEGGINGS = registerItem("shulker_leggings",
            new ArmorItem(ArmorMaterials_RaEx.SHULKER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SHULKER_BOOTS = registerItem("shulker_boots",
            new ArmorItem(ArmorMaterials_RaEx.SHULKER, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    /**
     * Copper
     */
    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new CopperArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(ArmorMaterials_RaEx.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    /**
     * Aquamarin Armor
     */
    public static final Item D_AQUAMARIN_HELMET = registerItem("diamond_aquamarin_helmet",
            new AquamarinArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item D_AQUAMARIN_CHESTPLATE = registerItem("diamond_aquamarin_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item D_AQUAMARIN_LEGGINGS = registerItem("diamond_aquamarin_leggings",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item D_AQUAMARIN_BOOTS = registerItem("diamond_aquamarin_boots",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item N_AQUAMARIN_HELMET = registerItem("netherite_aquamarin_helmet",
            new AquamarinArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item N_AQUAMARIN_CHESTPLATE = registerItem("netherite_aquamarin_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item N_AQUAMARIN_LEGGINGS = registerItem("netherite_aquamarin_leggings",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item N_AQUAMARIN_BOOTS = registerItem("netherite_aquamarin_boots",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    /**
     * Ruby Armor
     */
    public static final Item D_RUBY_HELMET = registerItem("diamond_ruby_helmet",
            new RubyArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item D_RUBY_CHESTPLATE = registerItem("diamond_ruby_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item D_RUBY_LEGGINGS = registerItem("diamond_ruby_leggings",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item D_RUBY_BOOTS = registerItem("diamond_ruby_boots",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item N_RUBY_HELMET = registerItem("netherite_ruby_helmet",
            new RubyArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item N_RUBY_CHESTPLATE = registerItem("netherite_ruby_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item N_RUBY_LEGGINGS = registerItem("netherite_ruby_leggings",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item N_RUBY_BOOTS = registerItem("netherite_ruby_boots",
            new ArmorItem(ArmorMaterials_RaEx.NETHERITE_RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    /**
     * Topas Armor
     */
    public static final Item D_TOPAS_HELMET = registerItem("diamond_topas_helmet",
            new TopasArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item D_TOPAS_CHESTPLATE = registerItem("diamond_topas_chestplate",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item D_TOPAS_LEGGINGS = registerItem("diamond_topas_leggings",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item D_TOPAS_BOOTS = registerItem("diamond_topas_boots",
            new ArmorItem(ArmorMaterials_RaEx.DIAMOND_TOPAS, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item N_TOPAS_HELMET = registerItem("netherite_topas_helmet",
            new TopasArmorItem(ArmorMaterials_RaEx.NETHERITE_TOPAS, ArmorItem.Type.HELMET, new FabricItemSettings()));
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
        RandomExtensions.LOGGER.info("Register Armors for " + RandomExtensions.MOD_ID);
    }
}
