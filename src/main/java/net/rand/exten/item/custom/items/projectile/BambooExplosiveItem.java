package net.rand.exten.item.custom.items.projectile;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.rand.exten.entity.projectile.BambooExplosive;

import java.util.List;

public class BambooExplosiveItem extends Item {
    public BambooExplosiveItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.randexten.bamboo_explosive.tooltip"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 10);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_BAMBOO_BREAK, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            BambooExplosive bambooExplosiveProjectile = new BambooExplosive(user, world);
            bambooExplosiveProjectile.setItem(itemStack);
            bambooExplosiveProjectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2f, 1f);
            world.spawnEntity(bambooExplosiveProjectile);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}