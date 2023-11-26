package net.rand.exten.item.custom.food;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;

public class EscapePotion extends Item {
    public EscapePotion(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);

        if (user.isOnGround() && world.getDimension().bedWorks()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 0.125f,1);

            if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            }

            if (!world.isClient) {
                if (user instanceof PlayerEntity PUser) {
                    BlockPos pos = user.getBlockPos();
                    teleportToSurface(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos), PUser);
                }
            }

            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            } else {
                if (user instanceof PlayerEntity playerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
                    ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                    stack.decrement(1);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
                return stack;
            }
        } else if (!world.isClient) {
            user.sendMessage(Text.literal("Teleporting did not work"));
        }
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    private void teleportToSurface(BlockPos pos, PlayerEntity user) {
        user.sendMessage(Text.literal("Teleported " + user.getName().getString() + " to Surface"));
        user.requestTeleport(user.getX(), pos.getY(), user.getZ());
    }
}
