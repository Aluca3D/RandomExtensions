package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.item.Item;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;
import net.rand.exten.util.tools.RandomItemPicker;

public class HatLootBag extends LootBag {
    public HatLootBag(Settings settings, String text) {
        super(settings, text);
    }

    @Override
    public Item ItemList(RandomItemPicker picker) {
        // Common: 12
        picker.addItemWithRarity(Items_RaEx.SUNGLASSES, 12);
        picker.addItemWithRarity(Items_RaEx.TOP_HAT.asItem(), 12);
        // Uncommon: 6
        picker.addItemWithRarity(Items_RaEx.TOP_TOP_HAT, 6);
        // Rare: 3
        picker.addItemWithRarity(Items_RaEx.TOP_TOP_TOP_HAT, 3);
        // Epic: 1

        return picker.pickRandomItem();
    }
}
