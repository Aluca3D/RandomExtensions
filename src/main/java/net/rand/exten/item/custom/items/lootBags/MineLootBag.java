package net.rand.exten.item.custom.items.lootBags;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.custom.items.LootBag;
import net.rand.exten.util.tools.RandomItemPicker;

public class MineLootBag extends LootBag {
    public MineLootBag(Settings settings, String text) {
        super(settings, text);
    }

    @Override
    public Item ItemList(PlayerEntity user, RandomItemPicker picker) {
        // Common: 12
        picker.addItemWithRarity(Items.COBBLESTONE, 12);
        picker.addItemWithRarity(Items.OAK_PLANKS, 12);
        picker.addItemWithRarity(Items.STICK, 12);
        // Uncommon: 6
        picker.addItemWithRarity(Items.COAL, 6);
        picker.addItemWithRarity(Items.TORCH, 6);
        // Rare: 3

        // Epic: 1
        picker.addItemWithRarity(Items_RaEx.ESCAPE_POTION, 1);

        return picker.pickRandomItem();
    }
}
