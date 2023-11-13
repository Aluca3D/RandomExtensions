package net.rand.exten.entity.mobs.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.rand.exten.entity.mobs.animation.NightmareTVAnimation;
import net.rand.exten.entity.mobs.custom.NightmareTVEntity;

public class NightmareTVModel<T extends NightmareTVEntity> extends SinglePartEntityModel<T> {
    private final ModelPart nightmare;
    private final ModelPart head;

    public NightmareTVModel(ModelPart root) {
        this.nightmare = root.getChild("nightmare");
        this.head = nightmare.getChild("body").getChild("torso").getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData nightmare = modelPartData.addChild("nightmare", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = nightmare.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData hip = torso.addChild("hip", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.7337F, 0.9989F));

        ModelPartData cube_r1 = hip.addChild("cube_r1", ModelPartBuilder.create().uv(0, 17).cuboid(-4.25F, -1.5F, -1.75F, 8.5F, 3.0F, 3.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.7663F, -0.4989F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r2 = hip.addChild("cube_r2", ModelPartBuilder.create().uv(31, 18).cuboid(-2.5F, -2.0F, -1.25F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2663F, 0.2511F, -0.1309F, 0.0F, 0.0F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -10.0F, -4.3F, 10.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(34, 4).cuboid(-5.0F, -10.0F, -5.3F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(34, 6).cuboid(-5.0F, -1.0F, -5.3F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 1.05F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(34, 2).cuboid(-4.0F, -0.5F, 0.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -5.0F, -5.3F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(34, 0).cuboid(-4.0F, -5.0F, 0.75F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, -6.05F, 0.0F, 0.0F, 1.5708F));

        ModelPartData eye = head.addChild("eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 28.0F, -1.05F));

        ModelPartData eye_ball = eye.addChild("eye_ball", ModelPartBuilder.create().uv(34, 12).cuboid(-2.0F, -1.4265F, 0.0F, 4.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -33.0735F, -3.5F));

        ModelPartData pupil = eye_ball.addChild("pupil", ModelPartBuilder.create().uv(27, 6).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0735F, -0.25F));

        ModelPartData eyebrow = eye.addChild("eyebrow", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData eyebrow_1 = eyebrow.addChild("eyebrow_1", ModelPartBuilder.create(), ModelTransform.pivot(-1.7808F, -36.0058F, -4.5F));

        ModelPartData cube_r5 = eyebrow_1.addChild("cube_r5", ModelPartBuilder.create().uv(27, 3).cuboid(-5.0F, -1.5F, -0.5F, 4.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.7808F, 1.5058F, 0.5F, 0.0F, 0.0F, 0.1745F));

        ModelPartData eyebrow_2 = eyebrow.addChild("eyebrow_2", ModelPartBuilder.create(), ModelTransform.pivot(1.7808F, -36.0058F, -4.5F));

        ModelPartData cube_r6 = eyebrow_2.addChild("cube_r6", ModelPartBuilder.create().uv(27, 3).mirrored().cuboid(1.0F, -1.5F, -0.5F, 4.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.7808F, 1.5058F, 0.5F, 0.0F, 0.0F, -0.1745F));

        ModelPartData eyelit = eye.addChild("eyelit", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -35.0F, -3.25F));

        ModelPartData eyelit_1 = eyelit.addChild("eyelit_1", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 2.0F, 0.45F));

        ModelPartData cube_r7 = eyelit_1.addChild("cube_r7", ModelPartBuilder.create().uv(34, 8).cuboid(-4.0F, -4.0F, -0.1F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.0F, 0.1F, 0.0F, 0.0F, 1.5708F));

        ModelPartData eyelit_2 = eyelit.addChild("eyelit_2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 2.0F, 0.45F));

        ModelPartData cube_r8 = eyelit_2.addChild("cube_r8", ModelPartBuilder.create().uv(34, 8).mirrored().cuboid(-4.0F, 0.0F, -0.1F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, 0.0F, 0.1F, 0.0F, 0.0F, 1.5708F));

        ModelPartData antenna = head.addChild("antenna", ModelPartBuilder.create().uv(48, 10).cuboid(-1.25F, -39.0F, -3.0F, 2.5F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 28.0F, -0.05F));

        ModelPartData antenna1 = antenna.addChild("antenna1", ModelPartBuilder.create(), ModelTransform.pivot(0.3605F, -38.854F, -1.9564F));

        ModelPartData cube_r9 = antenna1.addChild("cube_r9", ModelPartBuilder.create().uv(44, 12).mirrored().cuboid(0.0F, -4.5F, -0.5F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.3895F, -2.646F, -0.0436F, 0.0F, -0.0873F, 0.2618F));

        ModelPartData antenna2 = antenna.addChild("antenna2", ModelPartBuilder.create(), ModelTransform.pivot(-0.1017F, -38.8881F, -1.9564F));

        ModelPartData cube_r10 = antenna2.addChild("cube_r10", ModelPartBuilder.create().uv(44, 12).cuboid(-1.0F, -2.5F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.6483F, -2.6119F, -0.0436F, 0.0F, 0.0873F, -0.2618F));

        ModelPartData teeth = head.addChild("teeth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 28.0F, -0.05F));

        ModelPartData up = teeth.addChild("up", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData tooth_7 = up.addChild("tooth_7", ModelPartBuilder.create().uv(31, 5).cuboid(-4.65F, -30.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.75F, -7.0F, 0.0F));

        ModelPartData tooth_8 = up.addChild("tooth_8", ModelPartBuilder.create().uv(31, 5).cuboid(-3.65F, -29.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData tooth_9 = up.addChild("tooth_9", ModelPartBuilder.create().uv(31, 5).mirrored().cuboid(2.65F, -29.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData tooth_10 = up.addChild("tooth_10", ModelPartBuilder.create().uv(31, 5).cuboid(-4.4F, -30.0F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -7.0F, 0.0F));

        ModelPartData tooth_11 = up.addChild("tooth_11", ModelPartBuilder.create().uv(31, 5).cuboid(-3.65F, -30.25F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -7.0F, 0.0F));

        ModelPartData tooth_12 = up.addChild("tooth_12", ModelPartBuilder.create().uv(31, 5).cuboid(-4.65F, -30.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -7.0F, 0.0F));

        ModelPartData gum_1 = up.addChild("gum_1", ModelPartBuilder.create().uv(0, 24).cuboid(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -37.0F, -5.02F));

        ModelPartData down = teeth.addChild("down", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData tooth_1 = down.addChild("tooth_1", ModelPartBuilder.create().uv(31, 5).cuboid(-3.65F, -30.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData tooth_2 = down.addChild("tooth_2", ModelPartBuilder.create().uv(31, 5).mirrored().cuboid(2.65F, -30.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData tooth_3 = down.addChild("tooth_3", ModelPartBuilder.create().uv(31, 5).cuboid(-4.4F, -30.75F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

        ModelPartData tooth_4 = down.addChild("tooth_4", ModelPartBuilder.create().uv(31, 5).cuboid(-3.65F, -30.75F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, 0.0F));

        ModelPartData tooth_5 = down.addChild("tooth_5", ModelPartBuilder.create().uv(31, 5).cuboid(-4.65F, -30.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, 0.0F, 0.0F));

        ModelPartData tooth_6 = down.addChild("tooth_6", ModelPartBuilder.create().uv(31, 5).cuboid(-4.65F, -30.5F, -5.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.75F, 0.0F, 0.0F));

        ModelPartData gum_2 = down.addChild("gum_2", ModelPartBuilder.create().uv(0, 24).cuboid(-4.0F, -1.75F, 0.0F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -28.25F, -5.02F));

        ModelPartData left_leg = body.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.of(-3.0F, -24.5F, -0.5F, 0.0F, 0.1309F, 0.0F));

        ModelPartData left_higer_leg = left_leg.addChild("left_higer_leg", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 24.5F, 3.5F));

        ModelPartData cube_r11 = left_higer_leg.addChild("cube_r11", ModelPartBuilder.create().uv(23, 22).cuboid(-1.25F, -11.0F, -1.05F, 2.5F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-4.95F, -13.25F, -4.75F, -0.1745F, 0.0F, 0.0F));

        ModelPartData left_lower_leg = left_leg.addChild("left_lower_leg", ModelPartBuilder.create(), ModelTransform.pivot(0.1F, 12.8321F, -0.296F));

        ModelPartData cube_r12 = left_lower_leg.addChild("cube_r12", ModelPartBuilder.create().uv(48, 13).cuboid(-0.9F, -5.0F, -3.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 3.6679F, 1.796F, 0.1745F, 0.0F, 0.0F));

        ModelPartData left_foot = left_lower_leg.addChild("left_foot", ModelPartBuilder.create().uv(24, 17).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.1F, 11.1679F, 0.296F));

        ModelPartData left_toe_1 = left_foot.addChild("left_toe_1", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 0.5F, 3.5F));

        ModelPartData cube_r13 = left_toe_1.addChild("cube_r13", ModelPartBuilder.create().uv(27, 0).cuboid(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-6.5F, -0.5F, -4.0F, 0.0F, 0.2182F, -0.0873F));

        ModelPartData left_toe_2 = left_foot.addChild("left_toe_2", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 0.5F, 3.5F));

        ModelPartData cube_r14 = left_toe_2.addChild("cube_r14", ModelPartBuilder.create().uv(27, 0).cuboid(-0.6F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.5F, -0.5F, -5.5F, 0.0873F, 0.0F, -0.0436F));

        ModelPartData left_toe_3 = left_foot.addChild("left_toe_3", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 0.5F, 3.5F));

        ModelPartData cube_r15 = left_toe_3.addChild("cube_r15", ModelPartBuilder.create().uv(27, 0).cuboid(-0.5F, -0.3051F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.4303F, -0.6949F, -5.5F, 0.0873F, 0.0F, 0.0436F));

        ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.of(3.0F, -24.5F, -0.5F, 0.0F, -0.1309F, 0.0F));

        ModelPartData right_higer_leg = right_leg.addChild("right_higer_leg", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 24.5F, 3.5F));

        ModelPartData cube_r16 = right_higer_leg.addChild("cube_r16", ModelPartBuilder.create().uv(23, 22).mirrored().cuboid(-1.25F, -11.0F, -1.05F, 2.5F, 12.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.95F, -13.25F, -4.75F, -0.1745F, 0.0F, 0.0F));

        ModelPartData right_lower_leg = right_leg.addChild("right_lower_leg", ModelPartBuilder.create(), ModelTransform.pivot(-0.1F, 13.0446F, 0.1047F));

        ModelPartData cube_r17 = right_lower_leg.addChild("cube_r17", ModelPartBuilder.create().uv(48, 13).mirrored().cuboid(-1.1F, -5.2125F, -3.4007F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 3.6679F, 1.796F, 0.1745F, 0.0F, 0.0F));

        ModelPartData right_foot = right_lower_leg.addChild("right_foot", ModelPartBuilder.create().uv(24, 17).mirrored().cuboid(-1.0F, 0.5F, -3.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.1F, 9.9554F, 1.8953F));

        ModelPartData right_toe_1 = right_foot.addChild("right_toe_1", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 0.5F, 3.5F));

        ModelPartData cube_r18 = right_toe_1.addChild("cube_r18", ModelPartBuilder.create().uv(27, 0).mirrored().cuboid(-0.5F, -0.7125F, -1.4007F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(6.5F, 0.7125F, -5.5993F, 0.0F, -0.2182F, 0.0873F));

        ModelPartData right__toe_2 = right_foot.addChild("right__toe_2", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 0.5F, 3.5F));

        ModelPartData cube_r19 = right__toe_2.addChild("cube_r19", ModelPartBuilder.create().uv(27, 0).mirrored().cuboid(-0.4F, -0.7125F, -1.4007F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.5F, 0.7125F, -7.0993F, 0.0873F, 0.0F, 0.0436F));

        ModelPartData right__toe_3 = right_foot.addChild("right__toe_3", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 0.5F, 3.5F));

        ModelPartData cube_r20 = right__toe_3.addChild("cube_r20", ModelPartBuilder.create().uv(27, 0).mirrored().cuboid(-0.4303F, -0.5176F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.4303F, 0.5176F, -7.0993F, 0.0873F, 0.0F, -0.0436F));
        return TexturedModelData.of(modelData, 60, 40);
    }

    @Override
    public void setAngles(NightmareTVEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(NightmareTVAnimation.NIGHTMARE_TV_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, NightmareTVAnimation.NIGHTMARE_TV_IDLE, ageInTicks, 0.5f);

        this.updateAnimation(entity.attackingAnimationState, NightmareTVAnimation.NIGHTMARE_TV_ATTACK, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
        headPitch = MathHelper.clamp(headPitch, -25.0f, 35.0f);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        nightmare.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return nightmare;
    }
}