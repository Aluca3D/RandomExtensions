package net.rand.exten.world.gen.tree;

import net.minecraft.block.SaplingGenerator;
import net.rand.exten.world.ConfiguredFeatures_RaEx;

import java.util.Optional;

public class SaplingGenerator_RaEx {
    public static final SaplingGenerator PURPUR_TREE =
            new SaplingGenerator("purpur", 0.5f, Optional.of(ConfiguredFeatures_RaEx.LARGE_PURPUR_TREE_KEY),
                    Optional.empty(),
                    Optional.of(ConfiguredFeatures_RaEx.PURPUR_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

    public static final SaplingGenerator BURNED_TREE =
            new SaplingGenerator("purpur", 0.5f, Optional.of(ConfiguredFeatures_RaEx.LARGE_BURNED_TREE_KEY),
                    Optional.empty(),
                    Optional.of(ConfiguredFeatures_RaEx.BURNED_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
