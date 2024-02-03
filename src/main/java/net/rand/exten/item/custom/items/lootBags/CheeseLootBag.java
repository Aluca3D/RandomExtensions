package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;
import net.rand.exten.util.tools.RandomItemPicker;

public class CheeseLootBag extends LootBag {
    public CheeseLootBag(Settings settings, String text) {
        super(settings, text);
    }

    @Override
    public Item ItemList(PlayerEntity user, RandomItemPicker picker) {
        // Common: 12
        picker.addItemWithRarity(Items_RaEx.CHEESE, 12);
        // Uncommon: 6
        picker.addItemWithRarity(Blocks_RaEx.CHEESE_BLOCK.asItem(), 6);
        // Rare: 3
        picker.addItemWithRarity(Items_RaEx.STINKY_CHEESE, 3);
        // Epic: 1

        return picker.pickRandomItem();
    }
}
