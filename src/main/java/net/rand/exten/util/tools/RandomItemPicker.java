package net.rand.exten.util.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomItemPicker {
    private final List<Item> items = new ArrayList<>();
    private final List<int[]> amountRanges = new ArrayList<int[]>();
    private final List<Integer> rarityValues = new ArrayList<>();
    private final Random random = new Random();

    public void addItemWithRarity(Item item, int rarity) {
        items.add(item);
        rarityValues.add(rarity);
        amountRanges.add(new int[]{1, 1});
    }

    public void addItemWithRarity(Item item, int rarity, int minAmount, int maxAmount) {
        items.add(item);
        rarityValues.add(rarity);
        amountRanges.add(new int[]{minAmount, maxAmount});
    }

    public Item pickRandom() {
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

    public ItemStack pickRandomItem() {
        Item item = pickRandom();
        int index = items.indexOf(item);
        int[] amountRange = amountRanges.get(index);
        int amount = random.nextInt(amountRange[1] - amountRange[0] + 1) + amountRange[0];
        return new ItemStack(item, amount);
    }
}
