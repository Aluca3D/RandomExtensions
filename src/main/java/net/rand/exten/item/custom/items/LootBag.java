package net.rand.exten.item.custom.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.rand.exten.util.tools.RandomItemPicker;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class LootBag extends Item {
    private final String toolTip;

    public LootBag(Settings settings, String toolTip) {
        super(settings);
        this.toolTip = toolTip;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        RandomItemPicker picker = new RandomItemPicker();
        ItemStack itemStack = user.getStackInHand(hand);

        user.dropStack(ItemList(picker)); //drop/Spawn Loot Item

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BUNDLE_DROP_CONTENTS,
                SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
            user.getItemCooldownManager().set(this, 5);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    public abstract ItemStack ItemList(RandomItemPicker picker);

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(toolTip));
    }
}
