package net.rand.exten.item.custom.food;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.rand.exten.item.Items_RaEx;

public class Soda extends Item {
    private final StatusEffectInstance statusEffect;
    private final StatusEffectInstance statusEffect2;

    public Soda(Settings settings, StatusEffectInstance statusEffect, StatusEffectInstance statusEffect2) {
        super(settings);
        this.statusEffect = statusEffect;
        this.statusEffect2 = statusEffect2;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {

            user.addStatusEffect(statusEffect);
            user.addStatusEffect(statusEffect2);
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items_RaEx.EMPTY_SODA_CAN);
        } else {
            if (user instanceof PlayerEntity playerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(Items_RaEx.EMPTY_SODA_CAN);
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }

            return stack;
        }
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
}
