package net.rand.exten.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.rand.exten.item.ItemGroups_RaEx;
import net.rand.exten.item.Items_RaEx;

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
        /// Block
        /// Effect
        ///Enchantment
        ///Entity

        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/randexten/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Existing lang", e);
        }
    }
}
