package net.rand.exten.item.custom.items;

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
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LootBag extends Item {
    private final String text;
    private final Item[] items;

    public LootBag(Settings settings, String text, Item[] items) {
        super(settings);
        this.text = text;
        this.items = items;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        ItemList(user); //Spawn Loot Item

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        user.getItemCooldownManager().set(this, 5);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BUNDLE_DROP_CONTENTS,
                SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(text));
    }

    public void ItemList(PlayerEntity user) {
        Random r = new Random();
        List<Item> givenList = Arrays.stream(items).toList(); //get Items list
        Item randomItem = givenList.get(r.nextInt(givenList.size())); //select random Item
        user.dropItem(randomItem); //drop Item
    }
}
