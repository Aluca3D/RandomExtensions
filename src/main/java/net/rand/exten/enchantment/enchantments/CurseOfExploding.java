package net.rand.exten.enchantment.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;

public class CurseOfExploding extends Enchantment {
    public CurseOfExploding(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.getHealth() <= 8) {
            if (!user.getWorld().isClient) {

                TntEntity tntEntity = new TntEntity(EntityType.TNT, user.getWorld());
                tntEntity.setInvisible(true);
                tntEntity.setNoGravity(true);
                tntEntity.setFuse(0);
                tntEntity.setPos(user.getX(), user.getY(), user.getZ());

                user.getWorld().spawnEntity(tntEntity);

            }

        }
    }
}
