package net.rand.exten;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.rand.exten.datagen.*;
import net.rand.exten.world.ConfiguredFeatures_RaEx;
import net.rand.exten.world.PlacedFeatures_RaEx;
import net.rand.exten.world.gen.biome.Biomes_RaEx;

public class DataGenerator_RaEx implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(RecipeProvider_RaEx::new);
        pack.addProvider(ModelProvider_RaEx::new);
        pack.addProvider(BlockTagProvider_RaEx::new);
        pack.addProvider(ItemTagProvider_RaEx::new);
        pack.addProvider(LootTableProvider_RaEx::new);
        pack.addProvider(WorldGenerator_RaEx::new);
        pack.addProvider(PoiTagProvider_RaEx::new);
        pack.addProvider(AdvancementProvider_RaEx::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures_RaEx::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures_RaEx::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, Biomes_RaEx::bootstrap);
    }

}
