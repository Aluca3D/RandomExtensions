package net.rand.exten.item.custom.wearable.accessories.head;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.rand.exten.item.custom.wearable.Hats;

public class UnicornHorn extends Hats {
    public UnicornHorn(Settings settings) {
        super(settings);
    }

    @Override
    public void SpecialAbility(PlayerEntity user, ItemStack stack, World world) {
        if (user.getEquippedStack(EquipmentSlot.HEAD).getItem() == this ) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING));
        }
    }
}
