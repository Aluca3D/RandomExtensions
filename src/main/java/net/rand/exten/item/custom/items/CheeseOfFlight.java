package net.rand.exten.item.custom.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CheeseOfFlight extends Item {
    public CheeseOfFlight(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            if (!user.getAbilities().creativeMode) {
                user.getStackInHand(hand).decrement(1);
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 60, false, true, false));
        }
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }
        if (!user.isSneaking()) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 60, false, true, false), user);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
