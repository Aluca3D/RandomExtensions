package net.rand.exten.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.custom.crops.CornCropBlock;
import net.rand.exten.block.custom.crops.TomatoCropBlock;

public class CropBlocks_RaEx {

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(RandomExtensions.MOD_ID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));


    public static void registerRaExBlock() {
        RandomExtensions.LOGGER.info("Registers Crops for " + RandomExtensions.MOD_ID);
    }
}
