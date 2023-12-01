package net.rand.exten.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.custom.blocks.*;
import net.rand.exten.block.custom.blocks.tree.PurPurTreeBlock;
import net.rand.exten.world.gen.tree.BurnedTreeSaplingGenerator;
import net.rand.exten.world.gen.tree.PurPurTreeGenerator;

public class Blocks_RaEx {
    /**
     * Gems
     */
    public static final Block AQUAMARIN_ORE = registerBlock("aquamarin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(2, 7)));
    public static final Block AQUAMARIN_BLOCK = registerBlock("aquamarin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(2, 7)));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));

    public static final Block TOPAS_ORE = registerBlock("topas_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(2, 7)));
    public static final Block TOPAS_BLOCK = registerBlock("topas_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));

    /**
     * Souls
     */
    public static final Block SOUL_ORE = registerBlock("soul_ore",
            new SoulOre(FabricBlockSettings.copyOf(Blocks.COAL_ORE)));

    /**
     * Flowers
     */
    public static final Block NIGHT_SHADE = registerBlock("night_shade",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 30,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block POTTED_NIGHT_SHADE = Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, "potted_night_shade"),
            new FlowerPotBlock(NIGHT_SHADE, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    /**
     * Misc
     */
    public static final Block CHARCOAL_BLOCK = registerBlock("charcoal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK)));

    public static final Block EXPLOSIVE_CAKE_BLOCK = registerBlock("explosive_cake_block",
            new ExplosiveCakeBlock(FabricBlockSettings.copyOf(Blocks.TNT)));
    public static final Block LAND_MINE = registerBlock("land_mine",
            new LandMine(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block GRINDER = registerBlock("grinder",
            new Grinder(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block BARBED_WIRE = registerBlock("barbed_wire",
            new BarbedWire(FabricBlockSettings.copyOf(Blocks.COBWEB)));

    public static final Block FAKE_LEAVES = registerBlockWithoutItem("fake_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).breakInstantly().dropsNothing()) {
                @Override
                public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
                    if (entity.bypassesLandingEffects()) {
                        super.onLandedUpon(world, state, pos, entity, fallDistance);
                    } else {
                        entity.handleFallDamage(fallDistance, 0.0f, world.getDamageSources().fall());
                    }
                }
            });

    /**
     * Crystal
     */
    public static final Block MOSSY_CRYSTAL = registerBlock("mossy_crystal",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque().allowsSpawning(Blocks::never).
                    solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block ICE_CRYSTAL = registerBlock("ice_crystal",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks_RaEx.MOSSY_CRYSTAL).slipperiness(0.98f)));
    public static final Block SAND_CRYSTAL = registerBlock("sand_crystal",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks_RaEx.MOSSY_CRYSTAL)));

    /**
     * Cheese
     */
    public static final Block CHEESE_BLOCK = registerBlock("cheese_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block CHEESE_STAIRS = registerBlock("cheese_stairs",
            new StairsBlock(Blocks_RaEx.CHEESE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks_RaEx.CHEESE_BLOCK)));
    public static final Block CHEESE_SLABS = registerBlock("cheese_slabs",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks_RaEx.CHEESE_BLOCK)));
    public static final Block CHEESE_WALLS = registerBlock("cheese_walls",
            new WallBlock(FabricBlockSettings.copyOf(Blocks_RaEx.CHEESE_BLOCK)));
    public static final Block CHEESE_STATION = registerBlock("cheese_station",
            new Block(FabricBlockSettings.copyOf(Blocks_RaEx.CHEESE_BLOCK)));

    /**
     * Obsidian
     */
    public static final Block OBSIDIAN_GLASS = registerBlock("obsidian_glass",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
                    .nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never)
                    .suffocates(Blocks::never).blockVision(Blocks::never)));

    public static final Block TINTED_OBSIDIAN_GLASS = registerBlock("tinted_obsidian_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
                    .nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never)
                    .suffocates(Blocks::never).blockVision(Blocks::never)));

    public static final Block OBSIDIAN_GLASS_PANE = registerBlock("obsidian_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
                    .nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never)
                    .suffocates(Blocks::never).blockVision(Blocks::never)));

    public static final Block OBSIDIAN_DOOR = registerBlock("obsidian_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).nonOpaque(), BlockSetType.IRON));

    public static final Block OBSIDIAN_TRAPDOOR = registerBlock("obsidian_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).nonOpaque(), BlockSetType.IRON));

    /**
     * Burned Tree
     */
    public static final Block BURNED_WOOD = registerBlock("burned_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block BURNED_LOG = registerBlock("burned_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_WOOD)));
    public static final Block STRIPPED_BURNED_WOOD = registerBlock("stripped_burned_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_BURNED_LOG = registerBlock("stripped_burned_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks_RaEx.STRIPPED_BURNED_WOOD)));
    public static final Block BURNED_PLANKS = registerBlock("burned_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block BURNED_STAIRS = registerBlock("burned_stairs",
            new StairsBlock(Blocks_RaEx.BURNED_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS)));
    public static final Block BURNED_SLABS = registerBlock("burned_slabs",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS)));
    public static final Block BURNED_FENCE = registerBlock("burned_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS)));
    public static final Block BURNED_GATE = registerBlock("burned_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS), WoodType.OAK));
    public static final Block BURNED_DOOR = registerBlock("burned_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block BURNED_TRAPDOOR = registerBlock("burned_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block BURNED_BUTTON = registerBlock("burned_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS), BlockSetType.OAK, 20, true));
    public static final Block BURNED_PRESSURE_PLATE = registerBlock("burned_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks_RaEx.BURNED_PLANKS), BlockSetType.OAK));

    public static final Block BURNED_TREE_SAPLING = registerBlock("burned_tree_sapling",
            new SaplingBlock(new BurnedTreeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block POTTED_BURNED_TREE_SAPLING = Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, "potted_burned_tree_sapling"),
            new FlowerPotBlock(BURNED_TREE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).nonOpaque()));

    /**
     * PurPur Tree
     */
    public static final Block PURPUR_LOG = registerBlock("purpur_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block PURPUR_WOOD = registerBlock("purpur_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_LOG)));
    public static final Block STRIPPED_PURPUR_WOOD = registerBlock("stripped_purpur_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_PURPUR_LOG = registerBlock("stripped_purpur_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks_RaEx.STRIPPED_PURPUR_WOOD)));
    public static final Block PURPUR_PLANKS = registerBlock("purpur_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PURPUR_STAIRS = registerBlock("purpur_stairs",
            new StairsBlock(Blocks_RaEx.PURPUR_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS)));
    public static final Block PURPUR_SLABS = registerBlock("purpur_slabs",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS)));
    public static final Block PURPUR_FENCE = registerBlock("purpur_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS)));
    public static final Block PURPUR_GATE = registerBlock("purpur_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS), WoodType.OAK));
    public static final Block PURPUR_DOOR = registerBlock("purpur_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block PURPUR_TRAPDOOR = registerBlock("purpur_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block PURPUR_BUTTON = registerBlock("purpur_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS), BlockSetType.OAK, 60, true));
    public static final Block PURPUR_PRESSURE_PLATE = registerBlock("purpur_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks_RaEx.PURPUR_PLANKS), BlockSetType.OAK));
    public static final Block PURPUR_LEAVES = registerBlock("purpur_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

    public static final Block PURPUR_SAPLING = registerBlock("purpur_sapling",
            new PurPurTreeBlock(new PurPurTreeGenerator(), FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM)));
    public static final Block POTTED_PURPUR_SAPLING = Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, "potted_purpur_sapling"),
            new FlowerPotBlock(PURPUR_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_BROWN_MUSHROOM).nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerRaExBlock() {
        RandomExtensions.LOGGER.info("Registers Blocks for " + RandomExtensions.MOD_ID);
    }
}
