package net.rand.exten.world.gen.tree;

import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.rand.exten.world.ConfiguredFeatures_RaEx;
import org.jetbrains.annotations.Nullable;

public class PurPurTreeGenerator extends LargeTreeSaplingGenerator {

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ConfiguredFeatures_RaEx.PURPUR_TREE_KEY;
    }

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return ConfiguredFeatures_RaEx.LARGE_PURPUR_TREE_KEY;
    }
}
