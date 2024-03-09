package net.rand.exten.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.wearable.accessories.head.*;

public class AccessorieItems {
    /**
     * Head Wearable
     */
    // Todo: add Witch/Mage Hat(witch_hat), Horns, Cat Ears

    // Common
    public static final Item SUNGLASSES = registerItem("sunglasses",
            new Sunglasses(new FabricItemSettings().maxCount(1)));
    public static final Item TOP_HAT = registerItem("top_hat",
            new TopHat(new FabricItemSettings().maxCount(1)));
    public static final Item BOATER = registerItem("boater",
            new Boater(new FabricItemSettings().maxCount(1)));
    public static final Item STRAW_HAT = registerItem("straw_hat",
            new StrawHat(new FabricItemSettings().maxCount(1))); //Todo +Model

    // Uncommon
    public static final Item TOP_TOP_HAT = registerItem("top_top_hat",
            new TopTopHat(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item DEVIL_HORNS = registerItem("devil_horns",
            new DevilHorns(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item HEADPHONES = registerItem("headphones",
            new Headphones(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON))); //Todo +Model

    // Rare
    public static final Item TOP_TOP_TOP_HAT = registerItem("top_top_top_hat",
            new TopTopTopHat(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item RAINBOW_SUNGLASSES = registerItem("rainbow_sunglasses",
            new RainbowSunglasses(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item NIGHTMARE_TV_HEAD = registerItem("nightmare_tv_head",
            new NightmareTvHead(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE))); //Todo +Model +MobDrop

    //Epic
    public static final Item UNICORN_HORN = registerItem("unicorn_horn",
            new UnicornHorn(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item PIRAT_STRAW_HAT = registerItem("pirat_straw_hat",
            new PiratStrawHat(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC))); //Todo +Model +Recipe


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Accessories for " + RandomExtensions.MOD_ID);
    }
}
