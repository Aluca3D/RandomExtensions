package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider_RaEx extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider_RaEx(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


// Todo add Flower Item/Block Tag

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET, ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE,
                        ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS, ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS,

                        ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET, ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE,
                        ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS, ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS,

                        ToolsAndArmors_RaEx.D_RUBY_HELMET, ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE,
                        ToolsAndArmors_RaEx.D_RUBY_LEGGINGS, ToolsAndArmors_RaEx.D_RUBY_BOOTS,

                        ToolsAndArmors_RaEx.N_RUBY_HELMET, ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE,
                        ToolsAndArmors_RaEx.N_RUBY_LEGGINGS, ToolsAndArmors_RaEx.N_RUBY_BOOTS,

                        ToolsAndArmors_RaEx.D_TOPAS_HELMET, ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE,
                        ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS, ToolsAndArmors_RaEx.D_TOPAS_BOOTS,

                        ToolsAndArmors_RaEx.N_TOPAS_HELMET, ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE,
                        ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS, ToolsAndArmors_RaEx.N_TOPAS_BOOTS,

                        ToolsAndArmors_RaEx.COPPER_HELMET, ToolsAndArmors_RaEx.COPPER_CHESTPLATE,
                        ToolsAndArmors_RaEx.COPPER_LEGGINGS, ToolsAndArmors_RaEx.COPPER_BOOTS

                );

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(Blocks_RaEx.BURNED_LOG.asItem(), Blocks_RaEx.BURNED_WOOD.asItem(),
                        Blocks_RaEx.STRIPPED_BURNED_WOOD.asItem(), Blocks_RaEx.STRIPPED_BURNED_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(Blocks_RaEx.BURNED_LOG.asItem())
                .add(Blocks_RaEx.STRIPPED_BURNED_LOG.asItem())
                .add(Blocks_RaEx.BURNED_WOOD.asItem())
                .add(Blocks_RaEx.STRIPPED_BURNED_WOOD.asItem())

        ;

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(Blocks_RaEx.BURNED_PLANKS.asItem())

        ;

    }
}
