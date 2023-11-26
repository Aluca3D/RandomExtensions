package net.rand.exten.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;

import java.util.List;

public class PlacedFeatures_RaEx {

    /**Ores*/
    public static final RegistryKey<PlacedFeature> SOUL_ORE_PLACED_KEY = registerKey("soul_ore_placed");
    public static final RegistryKey<PlacedFeature> AQUARAMIN_ORE_PLACED_KEY = registerKey("aquamarin_ore_placed");
    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> TOPAS_ORE_PLACED_KEY = registerKey("topas_ore_placed");

    /**Flowers*/
    public static final RegistryKey<PlacedFeature> NIGHT_SHADE_PLACED_KEY = registerKey("night_shade_placed");

    /**Bushes*/
    public static final RegistryKey<PlacedFeature> END_BARRY_PLACED_KEY = registerKey("end_barry_placed");

    /**Tree*/
    public static final RegistryKey<PlacedFeature> PURPUR_TREE_PLACED_KEY = registerKey("purpur_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //Ores
        register(context, SOUL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.SOUL_ORE_KEY),
                OrePlacement_RaEx.modifiersWithCount(6, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-70), YOffset.fixed(10))));

        register(context, AQUARAMIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.AQUARAMIN_ORE_KEY),
                OrePlacement_RaEx.modifiersWithCount(5, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-70), YOffset.fixed(10))));

        register(context, RUBY_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.RUBY_ORE_KEY),
                OrePlacement_RaEx.modifiersWithCount(5, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-70), YOffset.fixed(10))));

        register(context, TOPAS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.TOPAS_ORE_KEY),
                OrePlacement_RaEx.modifiersWithCount(5, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-70), YOffset.fixed(10))));

        //Flowers
        register(context, NIGHT_SHADE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.NIGHT_SHADE_KEY),
                RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Bushes
        register(context, END_BARRY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.END_BARRY_KEY),
                RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Tree
        register(context, PURPUR_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures_RaEx.PURPUR_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.025f, 1), Blocks_RaEx.PURPUR_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(RandomExtensions.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
