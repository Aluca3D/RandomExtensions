package net.rand.exten.mixin.items;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useEmptyCanModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(Items_RaEx.EMPTY_SODA_CAN) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccours$getModels().getModelManager().getModel(new ModelIdentifier(RandomExtensions.MOD_ID, "empty_soda_can_3d", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useGreenCanModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(Items_RaEx.GREEN_SODA_CAN) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccours$getModels().getModelManager().getModel(new ModelIdentifier(RandomExtensions.MOD_ID, "green_soda_can_3d", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRedCanModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(Items_RaEx.RED_SODA_CAN) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccours$getModels().getModelManager().getModel(new ModelIdentifier(RandomExtensions.MOD_ID, "red_soda_can_3d", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useToyHammerModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ToolsAndArmors_RaEx.TOY_HAMMER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccours$getModels().getModelManager().getModel(new ModelIdentifier(RandomExtensions.MOD_ID, "toy_hammer_3d", "inventory"));
        }
        return value;
    }
}
