package net.rand.exten.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.rand.exten.effects.Effects_RaEx;
import net.rand.exten.enchantment.Enchantments_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.ItemGroups_RaEx;
import net.rand.exten.item.Items_RaEx;
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

        /// Loot Bag
        translationBuilder.add(LootBag_RaEx.CHEESE_LOOT_BAG, "Cheese Loot Bag");
        translationBuilder.add(LootBag_RaEx.MINE_LOOT_BAG, "Mine Loot Bag");

        /// Block

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
