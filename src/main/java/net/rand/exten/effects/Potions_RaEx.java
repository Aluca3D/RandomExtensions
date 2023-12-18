package net.rand.exten.effects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.effects.Effects_RaEx;

public class Potions_RaEx {
    public static final Potion LIGHTNING_ATTRACTION_POTION = registerPotion("lightning_attraction_potion",
            new Potion(new StatusEffectInstance(Effects_RaEx.LIGHTNING_ATTRACTION, 2400, 0)));

    public static final Potion EVOKERS_BITE_POTION = registerPotion("evokers_bite_potion",
            new Potion(new StatusEffectInstance(Effects_RaEx.EVOKERS_BITE, 600, 0)));
    
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(RandomExtensions.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        RandomExtensions.LOGGER.info("Registering Potions for " + RandomExtensions.MOD_ID);
    }
}
