package net.rand.exten;

import net.fabricmc.api.ModInitializer;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.block.StepBlockRegistry;
import net.rand.exten.block.custom.blocks.entity.BlockEntity_RaEx;
import net.rand.exten.effects.Effects_RaEx;
import net.rand.exten.enchantment.Enchantments_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.AccessorieItems;
import net.rand.exten.item.ItemGroups_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.effects.Potions_RaEx;
import net.rand.exten.recipe.Recipes_RaEx;
import net.rand.exten.screen.ScreenHandlers_RaEx;
import net.rand.exten.sound.Sounds_RaEx;
import net.rand.exten.util.CustomTrades_RaEx;
import net.rand.exten.util.LootTableModifiers_RaEx;
import net.rand.exten.util.Misc_RaEx;
import net.rand.exten.villager.Villager_RaEx;
import net.rand.exten.world.gen.WorldGeneration_RaEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomExtensions implements ModInitializer {

    public static final String MOD_ID = "randexten";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemGroups_RaEx.registerItemGroups();
        Items_RaEx.registerRaExItems();
        AccessorieItems.registerRaExItems();
        Blocks_RaEx.registerRaExBlock();
        StepBlockRegistry.registerStepBlocks();
        BlockEntity_RaEx.registerBlockEntities();
        Recipes_RaEx.registerRecipes();
        Potions_RaEx.registerPotions();
        ScreenHandlers_RaEx.registerScreenHandler();
        CropBlocks_RaEx.registerRaExBlock();
        Enchantments_RaEx.registerEnchantments();
        ToolsAndArmors_RaEx.registerRaExItems();
        Sounds_RaEx.registerSounds();
        Entities_RaEx.registerModEntities();
        Entities_RaEx.registerEntityAttributes();
        Villager_RaEx.registerVillager();
        CustomTrades_RaEx.registerCustomTrades();
        LootTableModifiers_RaEx.modifyLootTables();
        Misc_RaEx.registerMisc();
        Effects_RaEx.registerEffects();
        WorldGeneration_RaEx.generateModWorldGeneration();
    }
}