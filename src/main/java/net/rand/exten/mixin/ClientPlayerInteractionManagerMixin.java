package net.rand.exten.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.rand.exten.item.custom.tools.LongSwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {

    @Inject(method="getReachDistance", at=@At("HEAD"), cancellable = true)
    public void getReachDistance(CallbackInfoReturnable<Float> cir) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getMainHandStack().getItem() instanceof LongSwordItem) {
            cir.setReturnValue(6f);
        }
    }
}