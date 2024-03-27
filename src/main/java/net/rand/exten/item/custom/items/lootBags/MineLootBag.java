package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;
import net.rand.exten.util.tools.RandomItemPicker;

public class MineLootBag extends LootBag {
    public MineLootBag(Settings settings, String text) {
        super(settings, text);
    }

    @Override
    public ItemStack ItemList(RandomItemPicker picker) {
        // Common: 12
        picker.addItemWithRarity(Items.COBBLESTONE, 12, 1, 4);
        picker.addItemWithRarity(Items.OAK_PLANKS, 12, 1, 4);
        picker.addItemWithRarity(Items.STICK, 12, 1, 6);

        // Uncommon: 6
        picker.addItemWithRarity(Items.COAL, 6, 1, 2);
        picker.addItemWithRarity(Items.TORCH, 6, 1, 5);
        picker.addItemWithRarity(Items.GOLD_INGOT, 6, 1, 3);

        // Rare: 3
        picker.addItemWithRarity(Items.STONE_PICKAXE, 3);
        picker.addItemWithRarity(Items.IRON_INGOT, 3, 1, 2);

        // Epic: 1
        picker.addItemWithRarity(Items_RaEx.ESCAPE_POTION, 1);
        picker.addItemWithRarity(Items.DIAMOND, 1, 1, 3);

        return picker.pickRandomItem();
    }
}
