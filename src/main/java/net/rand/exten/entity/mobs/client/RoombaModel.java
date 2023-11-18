package net.rand.exten.entity.mobs.client;

import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.rand.exten.entity.mobs.animation.RoombaAnimation;
import net.rand.exten.entity.mobs.custom.RoombaEntity;

public class RoombaModel<T extends RoombaEntity> extends SinglePartEntityModel<T> {
	private final ModelPart roomba;
	private final ModelPart head;
	private final ModelPart eye;
	private final ModelPart eye2;
	public RoombaModel(ModelPart root) {
		this.roomba = root.getChild("roomba");
		this.head = roomba.getChild("body").getChild("torso").getChild("head");
		this.eye = roomba.getChild("body").getChild("torso").getChild("head").getChild("eye");
		this.eye2 = roomba.getChild("body").getChild("torso").getChild("head").getChild("eye2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData roomba = modelPartData.addChild("roomba", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = roomba.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -3.0F, -9.0F, 14.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 2.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, -6.0F));

		ModelPartData eye = head.addChild("eye", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 0.0F, 0.5F));

		ModelPartData cube_r1 = eye.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData eye2 = head.addChild("eye2", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, 0.0F, 0.5F));

		ModelPartData cube_r2 = eye2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData wheel = body.addChild("wheel", ModelPartBuilder.create().uv(1, 5).mirrored().cuboid(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-5.0F, -1.5F, -1.5F));

		ModelPartData wheel2 = body.addChild("wheel2", ModelPartBuilder.create().uv(1, 5).cuboid(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -1.5F, -1.5F));

		ModelPartData wheel3 = body.addChild("wheel3", ModelPartBuilder.create().uv(0, 18).cuboid(-5.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 4.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(RoombaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		if (entity.isTamed()) {
			setHeadAngles(netHeadYaw, headPitch);
			this.animateMovement(RoombaAnimation.ROOMBA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
			this.updateAnimation(entity.idleAnimationState, RoombaAnimation.ROOMBA_IDLE, ageInTicks, 1f);
			this.updateAnimation(entity.sitAnimationState, RoombaAnimation.ROOMBA_SIT, ageInTicks, 1f);
		} else {
			this.updateAnimation(entity.idleAnimationState, RoombaAnimation.ROOMBA_UN_TAMED, ageInTicks, 1f);
		}
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 35.0f);

		this.eye.yaw = headYaw * 0.017453292f;
		this.eye.pitch = headPitch * 0.017453292f;

		this.eye2.yaw = headYaw * 0.017453292f;
		this.eye2.pitch = headPitch * 0.017453292f;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		roomba.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

		@Override
		public ModelPart getPart() {
			return roomba;
		}
}