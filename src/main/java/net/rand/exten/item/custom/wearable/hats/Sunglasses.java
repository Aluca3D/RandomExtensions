package net.rand.exten.item.custom.wearable.hats;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.rand.exten.item.custom.wearable.Hats;

public class Sunglasses extends Hats {
    public Sunglasses(Settings settings) {
        super(settings);
    }

    @Override
    public void SpecialAbility(PlayerEntity user, ItemStack stack, World world) {
        if (world.isDay()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 1, false, false));

        }
    }
}
