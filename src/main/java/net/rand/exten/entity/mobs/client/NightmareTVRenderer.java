package net.rand.exten.entity.mobs.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.entity.mobs.custom.NightmareTVEntity;

public class NightmareTVRenderer extends MobEntityRenderer<NightmareTVEntity, NightmareTVModel<NightmareTVEntity>> {
    private static final Identifier TEXTURE = new Identifier(RandomExtensions.MOD_ID, "textures/entity/nightmare_tv.png");

    public NightmareTVRenderer(EntityRendererFactory.Context context) {
        super(context, new NightmareTVModel<>(context.getPart(ModelLayers_RaEx.NIGHTMARETV)), 0.6f);
    }

    @Override
    public Identifier getTexture(NightmareTVEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(NightmareTVEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        matrixStack.scale(0.75f, 0.75f, 0.75f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
