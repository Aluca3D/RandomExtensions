package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.block.custom.crops.CornCropBlock;
import net.rand.exten.block.custom.crops.TomatoCropBlock;
import net.rand.exten.item.Items_RaEx;

public class LootTableProvider_RaEx extends FabricBlockLootTableProvider {
    public LootTableProvider_RaEx(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // Gems
        addDrop(Blocks_RaEx.AQUAMARIN_BLOCK);
        addDrop(Blocks_RaEx.RUBY_BLOCK);
        addDrop(Blocks_RaEx.TOPAS_BLOCK);
        addDrop(Blocks_RaEx.AQUAMARIN_ORE, oreDrops(Blocks_RaEx.AQUAMARIN_ORE, Items_RaEx.RAW_AQUAMARIN));
        addDrop(Blocks_RaEx.RUBY_ORE, oreDrops(Blocks_RaEx.RUBY_ORE, Items_RaEx.RAW_RUBY));
        addDrop(Blocks_RaEx.TOPAS_ORE, oreDrops(Blocks_RaEx.TOPAS_ORE, Items_RaEx.RAW_TOPAS));

        // Wood
        addDrop(Blocks_RaEx.BURNED_PLANKS);
        addDrop(Blocks_RaEx.BURNED_LOG);
        addDrop(Blocks_RaEx.STRIPPED_BURNED_LOG);
        addDrop(Blocks_RaEx.BURNED_WOOD);
        addDrop(Blocks_RaEx.STRIPPED_BURNED_WOOD);
        addDrop(Blocks_RaEx.BURNED_TRAPDOOR);
        addDrop(Blocks_RaEx.BURNED_DOOR, doorDrops(Blocks_RaEx.BURNED_DOOR));
        addDrop(Blocks_RaEx.BURNED_GATE);
        addDrop(Blocks_RaEx.BURNED_FENCE);
        addDrop(Blocks_RaEx.BURNED_SLABS, slabDrops(Blocks_RaEx.BURNED_SLABS));
        addDrop(Blocks_RaEx.BURNED_BUTTON);
        addDrop(Blocks_RaEx.BURNED_PRESSURE_PLATE);
        addDrop(Blocks_RaEx.BURNED_STAIRS);
        addDrop(Blocks_RaEx.BURNED_TREE_SAPLING);

        // Obsidian
        addDrop(Blocks_RaEx.OBSIDIAN_GLASS);
        addDrop(Blocks_RaEx.OBSIDIAN_GLASS_PANE);
        addDrop(Blocks_RaEx.TINTED_OBSIDIAN_GLASS);
        addDrop(Blocks_RaEx.OBSIDIAN_DOOR, doorDrops(Blocks_RaEx.OBSIDIAN_DOOR));
        addDrop(Blocks_RaEx.OBSIDIAN_TRAPDOOR);

        // Cheese
        addDrop(Blocks_RaEx.CHEESE_BLOCK);
        addDrop(Blocks_RaEx.CHEESE_STATION);
        addDrop(Blocks_RaEx.CHEESE_SLABS, slabDrops(Blocks_RaEx.CHEESE_SLABS));
        addDrop(Blocks_RaEx.CHEESE_STAIRS);
        addDrop(Blocks_RaEx.CHEESE_WALLS);

        // Misc
        addDrop(Blocks_RaEx.CHARCOAL_BLOCK);
        addDrop(Blocks_RaEx.SOUL_ORE);
        addDrop(Blocks_RaEx.GRINDER);

        // Crystal
        addDrop(Blocks_RaEx.MOSSY_CRYSTAL);
        addDrop(Blocks_RaEx.ICE_CRYSTAL);
        addDrop(Blocks_RaEx.SAND_CRYSTAL);

        addDrop(Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK);

        // Flower
        addDrop(Blocks_RaEx.NIGHT_SHADE);
        addPottedPlantDrops(Blocks_RaEx.POTTED_NIGHT_SHADE);

        /// Crops
        // Builders
        BlockStatePropertyLootCondition.Builder tomatoBuilder = BlockStatePropertyLootCondition.builder(CropBlocks_RaEx.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5));

        BlockStatePropertyLootCondition.Builder cornBuilder = BlockStatePropertyLootCondition.builder(CropBlocks_RaEx.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE, 8));

        // Tomato
        addDrop(CropBlocks_RaEx.TOMATO_CROP, cropDrops(CropBlocks_RaEx.TOMATO_CROP, Items_RaEx.TOMATO, Items_RaEx.TOMATO_SEEDS, tomatoBuilder)
                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3)));
        // Corn
        addDrop(CropBlocks_RaEx.CORN_CROP, cropDrops(CropBlocks_RaEx.CORN_CROP, Items_RaEx.CORN, Items_RaEx.CORN_SEEDS, cornBuilder)
                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3)));
    }

    //public LootTable.Builder ExampleDrop(Block drop, Item item) {
    //    return dropsWithSilkTouch(drop,
    //            this.applyExplosionDecay(drop, ItemEntry.builder(item).
    //                    apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F)))
    //                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    //}
}
