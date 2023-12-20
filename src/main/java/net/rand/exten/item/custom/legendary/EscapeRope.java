package net.rand.exten.item.custom.legendary;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class EscapeRope extends Item {
    public EscapeRope(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.ENDER_PEARL);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.isOnGround() && world.getDimension().bedWorks() && !world.isSkyVisible(user.getBlockPos())) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.NEUTRAL, 0.125f,1); //ToDo new Sound

            if (!world.isClient) {
                BlockPos pos = user.getBlockPos();
                teleportToSurface(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos), user);
            }

            if (!user.getAbilities().creativeMode) {
                user.getItemCooldownManager().set(this, 350);
                itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
            }
            return TypedActionResult.success(itemStack, world.isClient());
        } else if (!world.isClient) {
            user.sendMessage(Text.literal("Teleporting did not work"));  //Todo change to Translatable to use in lang
        }
        return TypedActionResult.fail(itemStack);
    }

    private void teleportToSurface(BlockPos pos, PlayerEntity user) {
        user.sendMessage(Text.literal("Teleported " + user.getName().getString() + " to Surface"));  //Todo change to Translatable to use in lang
        user.requestTeleport(user.getX(), pos.getY(), user.getZ());
    }

}
