package net.rand.exten.entity.mobs.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.entity.mobs.custom.RoombaEntity;

public class RoombaRenderer extends MobEntityRenderer<RoombaEntity, RoombaModel<RoombaEntity>> {
    private static final Identifier TEXTURE = new Identifier(RandomExtensions.MOD_ID, "textures/entity/roomba.png");

    public RoombaRenderer(EntityRendererFactory.Context context) {
        super(context, new RoombaModel<>(context.getPart(ModelLayers_RaEx.ROOMBA)), 0.6f);
    }

    @Override
    public void render(RoombaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(RoombaEntity entity) {
        return TEXTURE;
    }
}
