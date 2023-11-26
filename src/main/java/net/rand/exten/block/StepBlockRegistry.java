package net.rand.exten.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.custom.blocks.StepBlock;

public class StepBlockRegistry{

    public static final Block CHEESE_STEP = registerBlock("cheese_step",
            new StepBlock(FabricBlockSettings.copyOf(Blocks_RaEx.CHEESE_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerStepBlocks() {
        RandomExtensions.LOGGER.info("Registers Step Blocks for " + RandomExtensions.MOD_ID);
    }
}
