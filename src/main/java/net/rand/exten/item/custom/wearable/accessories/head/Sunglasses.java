package net.rand.exten.item.custom.wearable.accessories.head;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.rand.exten.item.custom.wearable.Hats;

public class Sunglasses extends Hats {
    public Sunglasses(Settings settings) {
        super(settings);
    }

    @Override
    public void SpecialAbility(PlayerEntity user, ItemStack stack, World world) {

    }
}
