package net.rand.exten.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.effects.Effects_RaEx;
import net.rand.exten.enchantment.Enchantments_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.ItemGroups_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.item.custom.LootBag_RaEx;

import java.nio.file.Path;

public class EnUsGen extends FabricLanguageProvider {
    public EnUsGen(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Todo add all
        /// Item Group
        translationBuilder.add(ItemGroups_RaEx.RANDEXTEN_GROUP.getDisplayName().getString(), "Random Extensions");

        /// Item
        translationBuilder.add(Items_RaEx.AQUAMARIN, "Aquamarin");
        translationBuilder.add(Items_RaEx.RAW_AQUAMARIN, "Raw Aquamarin");
        translationBuilder.add(Items_RaEx.RUBY, "Ruby");
        translationBuilder.add(Items_RaEx.RAW_RUBY, "Raw Ruby");
        translationBuilder.add(Items_RaEx.TOPAS, "Topas");
        translationBuilder.add(Items_RaEx.RAW_TOPAS, "Raw Topas");
        translationBuilder.add(Items_RaEx.TOOTH, "Tooth");
        translationBuilder.add(Items_RaEx.GEMS_UPGRADE_TEMPLATE, "Gems Upgrade Template");
        translationBuilder.add(ToolsAndArmors_RaEx.WOODEN_LONGSWORD, "Wooden Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.STONE_LONGSWORD, "Stone Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.IRON_LONGSWORD, "Iron Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.GOLDEN_LONGSWORD, "Golden Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD, "Diamond Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.NETHERITE_LONGSWORD, "Netherite Longsword");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET, "Aquamarin Diamond Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE, "Aquamarin Diamond Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS, "Aquamarin Diamond Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS, "Aquamarin Diamond Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET, "Aquamarin Netherite Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE, "Aquamarin Netherite Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS, "Aquamarin Netherite Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS, "Aquamarin Netherite Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_HELMET, "Ruby Diamond Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE, "Ruby Diamond Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS, "Ruby Diamond Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_BOOTS, "Ruby Diamond Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_HELMET, "Ruby Netherite Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE, "Ruby Netherite Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_LEGGINGS, "Ruby Netherite Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_BOOTS, "Ruby Netherite Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_HELMET, "Topas Diamond Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE, "Topas Diamond Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS, "Topas Diamond Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_BOOTS, "Topas Diamond Boots");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_HELMET, "Topas Netherite Helmet");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE, "Topas Netherite Chestplate");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS, "Topas Netherite Leggings");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_BOOTS, "Topas Netherite Boots");
        translationBuilder.add(Items_RaEx.SOUL, "Soul");

        /// Loot Bag
        translationBuilder.add(LootBag_RaEx.CHEESE_LOOT_BAG, "Cheese Loot Bag");
        translationBuilder.add(LootBag_RaEx.MINE_LOOT_BAG, "Mine Loot Bag");

        /// Block
        translationBuilder.add(Blocks_RaEx.AQUAMARIN_ORE, "Deepslate Aquamarin Ore");
        translationBuilder.add(Blocks_RaEx.AQUAMARIN_BLOCK, "Aquamarin Block");
        translationBuilder.add(Blocks_RaEx.TOPAS_ORE, "Deepslate Topas Ore");
        translationBuilder.add(Blocks_RaEx.TOPAS_BLOCK, "Topas Block");
        translationBuilder.add(Blocks_RaEx.RUBY_ORE, "Deepslate Ruby Ore");
        translationBuilder.add(Blocks_RaEx.RUBY_BLOCK, "Ruby Block");
        translationBuilder.add(Blocks_RaEx.SOUL_ORE, "Soul ore");

        /// Effect
        translationBuilder.add(Effects_RaEx.EVOKERS_BITE, "Evokers Bite");
        translationBuilder.add(Effects_RaEx.LIGHTNING_ATTRACTION, "Lightning Attraction");

        ///Enchantment
        translationBuilder.add(Enchantments_RaEx.CURSE_OF_EXPLODING, "Curse of Exploding");
        translationBuilder.add(Enchantments_RaEx.POISONED_BLADE, "Poisoned Blade");
        translationBuilder.add(Enchantments_RaEx.CURSE_OF_SELF_HARMING, "Curse of Self Harming");
        translationBuilder.add(Enchantments_RaEx.ESCAPER, "Escaper");
        translationBuilder.add(Enchantments_RaEx.EVOKERS_BITE, "Evoker's Bite");
        translationBuilder.add(Enchantments_RaEx.LIFE_STEAL, "Life Steal");
        translationBuilder.add(Enchantments_RaEx.FREEZING_BLADE, "Freezing Blade");

        ///Entity
        translationBuilder.add(Entities_RaEx.NIGHTMARE_TV, "NightmareTV");
        translationBuilder.add(Entities_RaEx.ROOMBA, "Roomba");

        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/randexten/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Existing lang", e);
        }
    }
}
