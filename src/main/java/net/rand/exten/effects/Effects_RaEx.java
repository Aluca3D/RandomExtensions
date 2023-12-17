package net.rand.exten.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.effects.effect.LightningAttraction;

public class Effects_RaEx {
    public static final StatusEffect LIGHTNING_ATTRACTION = registerStatusEffect("lightning_attraction",
            new LightningAttraction(StatusEffectCategory.NEUTRAL, 0xfff936));

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(RandomExtensions.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        RandomExtensions.LOGGER.info("Registering Effects for " + RandomExtensions.MOD_ID);
    }
}
