package net.rand.exten;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.entity.mobs.client.*;
import net.rand.exten.screen.GrinderScreen;
import net.rand.exten.screen.ScreenHandlers_RaEx;

public class Client_RaEx implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ScreenHandlers_RaEx.GRINDER_SCREEN_HANDLER, GrinderScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.OBSIDIAN_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.OBSIDIAN_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.TINTED_OBSIDIAN_GLASS, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.MOSSY_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.ICE_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.SAND_CRYSTAL, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.OBSIDIAN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.OBSIDIAN_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.BURNED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.BURNED_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.PURPUR_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.PURPUR_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.PURPUR_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.NIGHT_SHADE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.POTTED_NIGHT_SHADE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.PURPUR_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.POTTED_PURPUR_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.BARBED_WIRE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(CropBlocks_RaEx.END_BARRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CropBlocks_RaEx.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CropBlocks_RaEx.CORN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.BURNED_TREE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks_RaEx.POTTED_BURNED_TREE_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(Entities_RaEx.PEBBLE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Entities_RaEx.STINKY_CHEESE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Entities_RaEx.THROWN_BAMBOO_EXPLOSIVE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Entities_RaEx.THROWN_STRONG_BAMBOO_EXPLOSIVE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Entities_RaEx.SMOKE_BOMB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Entities_RaEx.NINE_V_BATTERY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Entities_RaEx.LEAF_BULLED, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(Entities_RaEx.NIGHTMARE_TV, NightmareTVRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers_RaEx.NIGHTMARETV, NightmareTVModel::getTexturedModelData);

        EntityRendererRegistry.register(Entities_RaEx.ROOMBA, RoombaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers_RaEx.ROOMBA, RoombaModel::getTexturedModelData);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), Blocks_RaEx.FAKE_LEAVES);


    }
}
