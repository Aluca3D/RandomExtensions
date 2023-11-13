package net.rand.exten.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.enchantment.enchantments.*;

public class Enchantments_RaEx {

    public static final Enchantment POISONED_BLADE = register("poisoned_blade",
            new PoisonedBlade(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));


    public static final Enchantment CURSE_OF_SELF_HARMING = register("curse_of_self_harming",
            new CurseOfSelfHarming(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static final Enchantment ESCAPER = register("escaper",
            new Escaper(Enchantment.Rarity.RARE,
                    EnchantmentTarget.ARMOR_LEGS, EquipmentSlot.LEGS));

    public static final Enchantment LIFE_STEAL = register("life_steal",
            new LifeSteal(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static final Enchantment FREEZING_BLADE = register("freezing_blade",
            new FreezingBlade(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static final Enchantment EVOKERS_BITE = register("evokers_bite",
            new EvokersBite(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(RandomExtensions.MOD_ID, name), enchantment);
    }

    public static void registerEnchantments() {
        RandomExtensions.LOGGER.info("Registering Enchantments for " + RandomExtensions.MOD_ID);
    }
}
