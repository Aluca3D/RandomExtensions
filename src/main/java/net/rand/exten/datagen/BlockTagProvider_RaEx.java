package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.util.Tags_RaEx;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider_RaEx extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider_RaEx(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(Tags_RaEx.Blocks.PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Blocks_RaEx.AQUAMARIN_BLOCK)
                .add(Blocks_RaEx.AQUAMARIN_ORE)
                .add(Blocks_RaEx.RUBY_BLOCK)
                .add(Blocks_RaEx.RUBY_ORE)
                .add(Blocks_RaEx.TOPAS_BLOCK)
                .add(Blocks_RaEx.TOPAS_ORE)
                .add(Blocks_RaEx.SOUL_ORE)
                .add(Blocks_RaEx.OBSIDIAN_GLASS)
                .add(Blocks_RaEx.OBSIDIAN_GLASS_PANE)
                .add(Blocks_RaEx.TINTED_OBSIDIAN_GLASS)
                .add(Blocks_RaEx.OBSIDIAN_DOOR)
                .add(Blocks_RaEx.OBSIDIAN_TRAPDOOR)
                .add(Blocks_RaEx.CHARCOAL_BLOCK)
                .add(Blocks_RaEx.GRINDER)
                .add(Blocks_RaEx.CHEESE_BLOCK)
                .add(Blocks_RaEx.MOSSY_CRYSTAL)
                .add(Blocks_RaEx.ICE_CRYSTAL)
                .add(Blocks_RaEx.SAND_CRYSTAL)
                .add(Blocks_RaEx.LAND_MINE)
                .add(Blocks_RaEx.BARBED_WIRE)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(Blocks_RaEx.BURNED_LOG)
                .add(Blocks_RaEx.STRIPPED_BURNED_LOG)
                .add(Blocks_RaEx.BURNED_WOOD)
                .add(Blocks_RaEx.STRIPPED_BURNED_WOOD)
                .add(Blocks_RaEx.BURNED_FENCE)
                .add(Blocks_RaEx.BURNED_GATE)
                .add(Blocks_RaEx.BURNED_BUTTON)
                .add(Blocks_RaEx.BURNED_PRESSURE_PLATE)
                .add(Blocks_RaEx.BURNED_SLABS)
                .add(Blocks_RaEx.BURNED_PLANKS)
                .add(Blocks_RaEx.BURNED_STAIRS)
                .add(Blocks_RaEx.BURNED_DOOR)
                .add(Blocks_RaEx.BURNED_TRAPDOOR)

                .add(Blocks_RaEx.PURPUR_LOG)
                .add(Blocks_RaEx.STRIPPED_PURPUR_LOG)
                .add(Blocks_RaEx.PURPUR_WOOD)
                .add(Blocks_RaEx.STRIPPED_PURPUR_WOOD)
                .add(Blocks_RaEx.PURPUR_FENCE)
                .add(Blocks_RaEx.PURPUR_GATE)
                .add(Blocks_RaEx.PURPUR_BUTTON)
                .add(Blocks_RaEx.PURPUR_PRESSURE_PLATE)
                .add(Blocks_RaEx.PURPUR_SLABS)
                .add(Blocks_RaEx.PURPUR_PLANKS)
                .add(Blocks_RaEx.PURPUR_STAIRS)
                .add(Blocks_RaEx.PURPUR_DOOR)
                .add(Blocks_RaEx.PURPUR_TRAPDOOR)
        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)

        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)

        ;

        getOrCreateTagBuilder(BlockTags.CROPS)
                .add(CropBlocks_RaEx.CORN_CROP)
                .add(CropBlocks_RaEx.TOMATO_CROP)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks_RaEx.OBSIDIAN_DOOR)
                .add(Blocks_RaEx.OBSIDIAN_TRAPDOOR)
                .add(Blocks_RaEx.OBSIDIAN_GLASS)
                .add(Blocks_RaEx.OBSIDIAN_GLASS_PANE)
                .add(Blocks_RaEx.TINTED_OBSIDIAN_GLASS)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks_RaEx.AQUAMARIN_ORE)
                .add(Blocks_RaEx.SOUL_ORE)
                .add(Blocks_RaEx.RUBY_BLOCK)
                .add(Blocks_RaEx.RUBY_ORE)
                .add(Blocks_RaEx.TOPAS_BLOCK)
                .add(Blocks_RaEx.TOPAS_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks_RaEx.AQUAMARIN_BLOCK)
                .add(Blocks_RaEx.BARBED_WIRE)
        ;


        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(Blocks_RaEx.BURNED_FENCE)
                .add(Blocks_RaEx.PURPUR_FENCE)
        ;

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(Blocks_RaEx.BURNED_GATE)
                .add(Blocks_RaEx.PURPUR_GATE)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(Blocks_RaEx.CHEESE_WALLS)
        ;

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(Blocks_RaEx.BURNED_BUTTON)
                .add(Blocks_RaEx.PURPUR_BUTTON)
        ;

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(Blocks_RaEx.BURNED_PRESSURE_PLATE)
                .add(Blocks_RaEx.PURPUR_PRESSURE_PLATE)
        ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(Blocks_RaEx.BURNED_STAIRS)
                .add(Blocks_RaEx.PURPUR_STAIRS)
                .add(Blocks_RaEx.CHEESE_STAIRS)
        ;

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(Blocks_RaEx.BURNED_SLABS)
                .add(Blocks_RaEx.PURPUR_SLABS)
                .add(Blocks_RaEx.CHEESE_SLABS)
        ;

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(Blocks_RaEx.OBSIDIAN_DOOR)
                .add(Blocks_RaEx.BURNED_DOOR)
                .add(Blocks_RaEx.PURPUR_DOOR)
        ;

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(Blocks_RaEx.OBSIDIAN_TRAPDOOR)
                .add(Blocks_RaEx.BURNED_TRAPDOOR)
                .add(Blocks_RaEx.PURPUR_TRAPDOOR)
        ;

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(Blocks_RaEx.BURNED_LOG, Blocks_RaEx.STRIPPED_BURNED_LOG, Blocks_RaEx.BURNED_WOOD, Blocks_RaEx.STRIPPED_BURNED_WOOD)
        ;

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(Blocks_RaEx.PURPUR_LOG)
                .add(Blocks_RaEx.STRIPPED_BURNED_LOG)
                .add(Blocks_RaEx.BURNED_LOG)
                .add(Blocks_RaEx.STRIPPED_BURNED_LOG)

                .add(Blocks_RaEx.PURPUR_WOOD)
                .add(Blocks_RaEx.STRIPPED_BURNED_WOOD)
                .add(Blocks_RaEx.BURNED_WOOD)
                .add(Blocks_RaEx.STRIPPED_BURNED_WOOD)
        ;


        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(Blocks_RaEx.BURNED_PLANKS)
                .add(Blocks_RaEx.PURPUR_PLANKS)
        ;

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(Blocks_RaEx.PURPUR_LEAVES)

        ;

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(Blocks_RaEx.NIGHT_SHADE)

        ;

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(Blocks_RaEx.NIGHT_SHADE)

        ;

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(Blocks_RaEx.POTTED_NIGHT_SHADE)

        ;

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(Blocks_RaEx.BURNED_TREE_SAPLING)
                .add(Blocks_RaEx.PURPUR_SAPLING)
        ;

        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
                .add(Blocks_RaEx.BURNED_TREE_SAPLING)
                .add(Blocks_RaEx.PURPUR_SAPLING)
                .add(Blocks_RaEx.NIGHT_SHADE)
                .add(Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK)
                .add(Blocks_RaEx.CHEESE_BLOCK)
                .add(Blocks_RaEx.CHEESE_STATION)
        ;

    }
}
