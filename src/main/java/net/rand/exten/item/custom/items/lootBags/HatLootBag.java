package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.item.ItemStack;
import net.rand.exten.item.AccessorieItems;
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
        picker.addItemWithRarity(AccessorieItems.SUNGLASSES, 12);
        picker.addItemWithRarity(AccessorieItems.TOP_HAT, 12);
        picker.addItemWithRarity(AccessorieItems.BOATER, 12);
        picker.addItemWithRarity(AccessorieItems.STRAW_HAT, 12);
        // Uncommon: 6
        picker.addItemWithRarity(AccessorieItems.DEVIL_HORNS, 6);
        picker.addItemWithRarity(AccessorieItems.HEADPHONES, 6);
        // Rare: 3
        picker.addItemWithRarity(AccessorieItems.RAINBOW_SUNGLASSES, 3);

        // Epic: 1
        picker.addItemWithRarity(AccessorieItems.UNICORN_HORN, 1);

        return picker.pickRandomItem();
    }
}
