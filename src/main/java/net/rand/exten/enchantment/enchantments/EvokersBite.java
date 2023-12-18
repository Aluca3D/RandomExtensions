package net.rand.exten.enchantment.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rand.exten.util.tools.Math_RaEx;

public class EvokersBite extends Enchantment {
    public EvokersBite(Enchantment.Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.getItem() instanceof SwordItem) {
            return true;
        }
        return super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient()) {
            World world = user.getWorld();
            Vec3d position = target.getPos();
            Math_RaEx math = new Math_RaEx();

            if (level == 1) {
                world.spawnEntity(new EvokerFangsEntity(world, position.getX(), position.getY(), position.getZ(), math.randomInt(180), 5, user));
            }
            if (level == 2) {
                world.spawnEntity(new EvokerFangsEntity(world, position.getX(), position.getY(), position.getZ(), math.randomInt(180), 2, user));
                world.spawnEntity(new EvokerFangsEntity(world, position.getX(), position.getY(), position.getZ(), math.randomInt(180), 3, user));
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
