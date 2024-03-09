package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.AccessorieItems;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.util.Tags_RaEx;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider_RaEx extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider_RaEx(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

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
                        ToolsAndArmors_RaEx.COPPER_LEGGINGS, ToolsAndArmors_RaEx.COPPER_BOOTS,

                        ToolsAndArmors_RaEx.SHULKER_HELMET, ToolsAndArmors_RaEx.SHULKER_CHESTPLATE,
                        ToolsAndArmors_RaEx.SHULKER_LEGGINGS, ToolsAndArmors_RaEx.SHULKER_BOOTS

                );

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(Blocks_RaEx.BURNED_LOG.asItem(), Blocks_RaEx.BURNED_WOOD.asItem(),
                        Blocks_RaEx.STRIPPED_BURNED_WOOD.asItem(), Blocks_RaEx.STRIPPED_BURNED_LOG.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(Blocks_RaEx.BURNED_LOG.asItem())
                .add(Blocks_RaEx.STRIPPED_BURNED_LOG.asItem())
                .add(Blocks_RaEx.BURNED_WOOD.asItem())
                .add(Blocks_RaEx.STRIPPED_BURNED_WOOD.asItem())
                .add(Blocks_RaEx.PURPUR_LOG.asItem())
                .add(Blocks_RaEx.STRIPPED_PURPUR_LOG.asItem())
                .add(Blocks_RaEx.PURPUR_WOOD.asItem())
                .add(Blocks_RaEx.STRIPPED_PURPUR_WOOD.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(Blocks_RaEx.BURNED_PLANKS.asItem())
                .add(Blocks_RaEx.PURPUR_PLANKS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(Blocks_RaEx.NIGHT_SHADE.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(Blocks_RaEx.NIGHT_SHADE.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(Blocks_RaEx.BURNED_TREE_SAPLING.asItem())
                .add(Blocks_RaEx.PURPUR_SAPLING.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(Blocks_RaEx.BURNED_FENCE.asItem())
                .add(Blocks_RaEx.PURPUR_FENCE.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(Blocks_RaEx.BURNED_GATE.asItem())
                .add(Blocks_RaEx.PURPUR_GATE.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(Blocks_RaEx.CHEESE_WALLS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.BUTTONS)
                .add(Blocks_RaEx.BURNED_BUTTON.asItem())
                .add(Blocks_RaEx.PURPUR_BUTTON.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(Blocks_RaEx.BURNED_PRESSURE_PLATE.asItem())
                .add(Blocks_RaEx.PURPUR_PRESSURE_PLATE.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(Blocks_RaEx.BURNED_STAIRS.asItem())
                .add(Blocks_RaEx.PURPUR_STAIRS.asItem())
                .add(Blocks_RaEx.CHEESE_STAIRS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(Blocks_RaEx.BURNED_SLABS.asItem())
                .add(Blocks_RaEx.PURPUR_SLABS.asItem())
                .add(Blocks_RaEx.CHEESE_SLABS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.DOORS)
                .add(Blocks_RaEx.OBSIDIAN_DOOR.asItem())
                .add(Blocks_RaEx.BURNED_DOOR.asItem())
                .add(Blocks_RaEx.PURPUR_DOOR.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.TRAPDOORS)
                .add(Blocks_RaEx.OBSIDIAN_TRAPDOOR.asItem())
                .add(Blocks_RaEx.BURNED_TRAPDOOR.asItem())
                .add(Blocks_RaEx.PURPUR_TRAPDOOR.asItem())
        ;

        getOrCreateTagBuilder(Tags_RaEx.Items.GEMS)
                .add(Items_RaEx.AQUAMARIN)
                .add(Items_RaEx.RUBY)
                .add(Items_RaEx.TOPAS)
        ;

        getOrCreateTagBuilder(Tags_RaEx.Items.LEGENDARY)
                .add(ToolsAndArmors_RaEx.TOY_HAMMER)
                .add(ToolsAndArmors_RaEx.LEAVE_STAFF)
                .add(ToolsAndArmors_RaEx.ESCAPE_ROPE)
        ;

        getOrCreateTagBuilder(Tags_RaEx.Items.SWORD)
                .add(Items.WOODEN_SWORD)
                .add(Items.STONE_SWORD)
                .add(ToolsAndArmors_RaEx.COPPER_SWORD)
                .add(Items.IRON_SWORD)
                .add(Items.GOLDEN_SWORD)
                .add(Items.DIAMOND_SWORD)
                .add(Items.NETHERITE_SWORD)

                .add(ToolsAndArmors_RaEx.WOODEN_LONGSWORD)
                .add(ToolsAndArmors_RaEx.STONE_LONGSWORD)
                .add(ToolsAndArmors_RaEx.COPPER_LONGSWORD)
                .add(ToolsAndArmors_RaEx.IRON_LONGSWORD)
                .add(ToolsAndArmors_RaEx.GOLDEN_LONGSWORD)
                .add(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD)
                .add(ToolsAndArmors_RaEx.NETHERITE_LONGSWORD)
        ;

        getOrCreateTagBuilder(Tags_RaEx.Items.PROJECTILE)
                .add(Items_RaEx.PEBBLE)
                .add(Items_RaEx.STINKY_CHEESE)
                .add(Items_RaEx.BAMBOO_EXPLOSIVE)
                .add(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG)

                .add(Items.SNOWBALL)
        ;

        getOrCreateTagBuilder(Tags_RaEx.Items.COMMON_HAT)
                .add(AccessorieItems.SUNGLASSES)
                .add(AccessorieItems.TOP_HAT)
                .add(AccessorieItems.BOATER)
                .add(AccessorieItems.STRAW_HAT)
        ;
        getOrCreateTagBuilder(Tags_RaEx.Items.UNCOMMON_HAT)
                .add(AccessorieItems.TOP_TOP_HAT)
                .add(AccessorieItems.DEVIL_HORNS)
                .add(AccessorieItems.HEADPHONES)
        ;
        getOrCreateTagBuilder(Tags_RaEx.Items.RARE_HAT)
                .add(AccessorieItems.TOP_TOP_TOP_HAT)
                .add(AccessorieItems.RAINBOW_SUNGLASSES)
                .add(AccessorieItems.NIGHTMARE_TV_HEAD)
        ;
        getOrCreateTagBuilder(Tags_RaEx.Items.EPIC_HAT)
                .add(AccessorieItems.UNICORN_HORN)
                .add(AccessorieItems.PIRAT_STRAW_HAT)
        ;

    }
}
