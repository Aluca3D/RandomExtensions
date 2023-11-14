package net.rand.exten.item.custom.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.entity.projectile.SeedBullet;
import net.rand.exten.sound.Sounds_RaEx;

public class LeaveStaff extends Item {
    public LeaveStaff(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient) {
            if (entity instanceof PlayerEntity user && user.getOffHandStack().isOf(this)) {
                setBlockBelow(world, user);
            }
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isIn(ItemTags.LEAVES);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), Sounds_RaEx.MAGIC_SHOT, SoundCategory.NEUTRAL, 1F, 1.75F);
        user.getItemCooldownManager().set(this, 10);
        if (!world.isClient()) {
            SeedBullet seedBulled = new SeedBullet(user, world);
            seedBulled.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.75F, 0.25F);
            world.spawnEntity(seedBulled);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        }
        return TypedActionResult.success(itemStack, world.isClient());

    }

    private void setBlockBelow(World world, PlayerEntity user) {
        BlockPos posBelow = user.getBlockPos().down();
        BlockState blockStateBelow = user.getWorld().getBlockState(posBelow);
        Block below = blockStateBelow.getBlock();

        //Hand hand = Hand.OFF_HAND;
        //ItemStack itemStack = user.getStackInHand(hand);

        if (!user.isSneaking() && below.equals(Blocks.AIR)) {
            BlockState state = Blocks_RaEx.FAKE_LEAVES.getDefaultState();
            world.setBlockState(posBelow, state);
            }

        } else if (user.isSneaking() && below.equals(Blocks_RaEx.FAKE_LEAVES)) {
            BlockState state = Blocks.AIR.getDefaultState();
            world.setBlockState(posBelow, state);
        }

    }

}
