package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.item.ItemStack;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;
import net.rand.exten.util.tools.RandomItemPicker;

public class CheeseLootBag extends LootBag {
    public CheeseLootBag(Settings settings, String text) {
        super(settings, text);
    }

    @Override
    public ItemStack ItemList(RandomItemPicker picker) {
        // Common: 12
        picker.addItemWithRarity(Items_RaEx.CHEESE, 12, 1, 3);
        // Uncommon: 6
        picker.addItemWithRarity(Blocks_RaEx.CHEESE_BLOCK.asItem(), 6);
        // Rare: 3
        picker.addItemWithRarity(Items_RaEx.STINKY_CHEESE, 3, 1, 2);
        picker.addItemWithRarity(Items_RaEx.CHEESE_OF_FLIGHT, 3, 1, 2);
        // Epic: 1

        return picker.pickRandomItem();
    }
}
