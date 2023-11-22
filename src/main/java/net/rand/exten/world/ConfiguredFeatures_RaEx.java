package net.rand.exten.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;

import java.util.List;

public class ConfiguredFeatures_RaEx {

    //Ores
    public static final RegistryKey<ConfiguredFeature<?, ?>> SOUL_ORE_KEY = registerKey("soul_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AQUARAMIN_ORE_KEY = registerKey("aquamarin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAS_ORE_KEY = registerKey("topas_ore");

    //Flowers
    public static final RegistryKey<ConfiguredFeature<?, ?>> NIGHT_SHADE_KEY = registerKey("night_shade");

    //Tree
    public static final RegistryKey<ConfiguredFeature<?, ?>> BURNED_TREE_KEY = registerKey("burned_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_BURNED_TREE_KEY = registerKey("large_burned_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> soulOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, Blocks_RaEx.SOUL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> aquamarinOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, Blocks_RaEx.AQUAMARIN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> rubyOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, Blocks_RaEx.RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> topasOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, Blocks_RaEx.TOPAS_ORE.getDefaultState()));

        //Ores
        register(context, SOUL_ORE_KEY, Feature.ORE, new OreFeatureConfig(soulOres, 4));
        register(context, AQUARAMIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(aquamarinOres, 5));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(rubyOres, 5));
        register(context, TOPAS_ORE_KEY, Feature.ORE, new OreFeatureConfig(topasOres, 5));

        //Flowers
        register(context, NIGHT_SHADE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 4, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks_RaEx.NIGHT_SHADE)))));

        //Tree
        register(context, BURNED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks_RaEx.BURNED_LOG),
                new ForkingTrunkPlacer(2, 3, 3),
                BlockStateProvider.of(Blocks.AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, LARGE_BURNED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks_RaEx.BURNED_LOG),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(Blocks.AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());

    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(RandomExtensions.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
