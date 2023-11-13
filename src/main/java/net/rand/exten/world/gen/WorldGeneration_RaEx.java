package net.rand.exten.world.gen;

public class WorldGeneration_RaEx {
    public static void generateModWorldGeneration() {
        OreGeneration_RaEx.generateOres();
        FlowerGeneration_RaEx.generateFlowers();
        TreeGeneration_RaEx.generateTrees();
        MobGeneration_RaEx.addSpawns();
    }
}
