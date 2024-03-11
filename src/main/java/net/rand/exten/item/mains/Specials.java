package net.rand.exten.item.mains;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rand.exten.RandomExtensions;
import net.rand.exten.item.custom.legendary.EscapeRope;
import net.rand.exten.item.custom.legendary.LeaveStaff;
import net.rand.exten.item.custom.legendary.ToyHammer;

public class Specials {
    /**
     * Special
     */
    public static final Item LEAVE_STAFF = registerItem("leave_staff",
            new LeaveStaff(new FabricItemSettings().maxCount(1).fireproof().maxDamage(240).rarity(Rarity.EPIC)));
    public static final Item TOY_HAMMER = registerItem("toy_hammer",
            new ToyHammer(ToolMaterials.WOOD, new FabricItemSettings().maxCount(1).maxDamage(960).rarity(Rarity.EPIC)));
    public static final Item ESCAPE_ROPE = registerItem("escape_rope",
            new EscapeRope(new FabricItemSettings().maxCount(1).fireproof().maxDamage(64).rarity(Rarity.EPIC)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomExtensions.MOD_ID, name), item);
    }

    public static void registerRaExItems() {
        RandomExtensions.LOGGER.info("Register Special Weapons, Tools and Armors for " + RandomExtensions.MOD_ID);
    }
}
