package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.item.ItemStack;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;
import net.rand.exten.util.tools.RandomItemPicker;

public class HatLootBag extends LootBag {
    public HatLootBag(Settings settings, String text) {
        super(settings, text);
    }

    @Override
    public ItemStack ItemList(RandomItemPicker picker) {
        // Common: 12
        picker.addItemWithRarity(Items_RaEx.SUNGLASSES, 12);
        picker.addItemWithRarity(Items_RaEx.TOP_HAT, 12);
        picker.addItemWithRarity(Items_RaEx.BOATER, 12);
        // Uncommon: 6
        picker.addItemWithRarity(Items_RaEx.DEVIL_HORNS, 6);
        // Rare: 3
        picker.addItemWithRarity(Items_RaEx.RAINBOW_SUNGLASSES, 3);

        // Epic: 1
        picker.addItemWithRarity(Items_RaEx.UNICORN_HORN, 1);

        return picker.pickRandomItem();
    }
}
