package net.rand.exten.util.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomItemPicker {
    private final List<Item> items = new ArrayList<>();
    private final List<Integer> rarityValues = new ArrayList<>();
    private final Random random = new Random();

    public void addItemWithRarity(Item item, int rarity) {
        items.add(item);
        rarityValues.add(rarity);
    }

    public Item pickRandomItem() {
        int totalRarity = 0;
        for (int rarity : rarityValues) {
            totalRarity += rarity;
        }

        int ri = random.nextInt(totalRarity) + 1;
        int cumulativeRarity = 0;
        for (int i = 0; i < items.size(); i++) {
            cumulativeRarity += rarityValues.get(i);
            if (ri <= cumulativeRarity) {
                return items.get(i);
            }
        }

        return Items.AIR;
    }
}
