package net.rand.exten.enchantment.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.random.Random;
import net.rand.exten.enchantment.Enchantments_RaEx;

import java.util.Map;

public class CurseOfSelfHarming extends Enchantment {
    public CurseOfSelfHarming(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.getItem() instanceof SwordItem) {
            return true;
        }

        if (stack.getItem() instanceof AxeItem) {
            return true;
        }
        return super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Random random = target.getEntityWorld().getRandom();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(Enchantments_RaEx.CURSE_OF_SELF_HARMING, (LivingEntity) target);

        if (CurseOfSelfHarming.shouldDamageAttacker(random)) {
            if (user != null) {
                user.damage(target.getDamageSources().thorns(target), CurseOfSelfHarming.getDamageAmount(random, 1));
                target.damage(user.getDamageSources().thorns(user), CurseOfSelfHarming.getDamageAmount(random, 2));
            }

            if (entry != null) {
                assert user != null;
                entry.getValue().damage(2, user, entity -> entity.sendEquipmentBreakStatus(entry.getKey()));
            }
        }
    }

    public static boolean shouldDamageAttacker(Random random) {
        return random.nextFloat() < 0.5;
    }

    public static int getDamageAmount(Random random, int i) {
        return (1 + random.nextInt(4)) * i;
    }
}
