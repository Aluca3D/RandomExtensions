package net.rand.exten.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.CropBlocks_RaEx;
import net.rand.exten.block.StepBlockRegistry;
import net.rand.exten.effects.Effects_RaEx;
import net.rand.exten.enchantment.Enchantments_RaEx;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.item.custom.LootBag_RaEx;

import java.nio.file.Path;

public class DeGen extends FabricLanguageProvider {
    public DeGen(FabricDataOutput dataOutput) {
        super(dataOutput, "de_de");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Todo add all
        /// Item
        translationBuilder.add(Items_RaEx.AQUAMARIN, "Aquamarin");
        translationBuilder.add(Items_RaEx.RAW_AQUAMARIN, "Rohaquamarin");
        translationBuilder.add(Items_RaEx.RUBY, "Rubin");
        translationBuilder.add(Items_RaEx.RAW_RUBY, "Rohrubin");
        translationBuilder.add(Items_RaEx.TOPAS, "Topas");
        translationBuilder.add(Items_RaEx.RAW_TOPAS, "Rohtopas");
        translationBuilder.add(Items_RaEx.TOOTH, "Zahn");
        translationBuilder.add(Items_RaEx.GEMS_UPGRADE_TEMPLATE, "Edelsteine Upgrade Vorlage");
        translationBuilder.add(ToolsAndArmors_RaEx.WOODEN_LONGSWORD, "Holzlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.STONE_LONGSWORD, "Steinlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.IRON_LONGSWORD, "Eisenlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_LONGSWORD, "Kupferlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.GOLDEN_LONGSWORD, "Goldenlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.DIAMOND_LONGSWORD, "Diamantlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.NETHERITE_LONGSWORD, "Netheritlangschwert ");
        translationBuilder.add(ToolsAndArmors_RaEx.WOODEN_PAXEL, "Holz Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.STONE_PAXEL, "Stein Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.IRON_PAXEL, "Eisen Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_PAXEL, "Kupfer Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.GOLDEN_PAXEL, "Golden Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.DIAMOND_PAXEL, "Diamant Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.NETHERITE_PAXEL, "Netherit Paxel");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_AXE, "Kupferaxt");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_PICKAXE, "Kupferspitzhacke");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_SHOVEL, "Kupferschaufel");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_HOE, "Kupferhacke");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_SWORD, "Kupferschwert");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_HELMET, "Kupferhelm");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_CHESTPLATE, "Kupferharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_LEGGINGS, "Kupferbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.COPPER_BOOTS, "Kupferstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_HELMET, "Shulkerhelm");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_CHESTPLATE, "Shulkerharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_LEGGINGS, "Shulkerbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.SHULKER_BOOTS, "Shulkerstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET, "Aquamarin Diamanthelm");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE, "Aquamarin Diamantharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS, "Aquamarin Diamantbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS, "Aquamarin Diamantstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET, "Aquamarin Netherithelm");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE, "Aquamarin Netheritharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS, "Aquamarin Netheritbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS, "Aquamarin Netheritstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_HELMET, "Rubin Diamanthelm");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE, "Rubin Diamantharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS, "Rubin Diamantbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.D_RUBY_BOOTS, "Rubin Diamantstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_HELMET, "Rubin Netherithelm");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE, "Rubin Netheritharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_LEGGINGS, "Rubin Netheritbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.N_RUBY_BOOTS, "Rubin Netheritstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_HELMET, "Topas Diamanthelm");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE, "Topas Diamant harnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS, "Topas Diamantbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.D_TOPAS_BOOTS, "Topas Diamantstiefel");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_HELMET, "Topas Netherithelm");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE, "Topas Netheritharnisch");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS, "Topas Netheritbeinschutz");
        translationBuilder.add(ToolsAndArmors_RaEx.N_TOPAS_BOOTS, "Topas Netheritstiefel");
        translationBuilder.add(Items_RaEx.SOUL, "Seele");
        translationBuilder.add(Items_RaEx.PEBBLE, "Kieselstein");

        translationBuilder.add(Items_RaEx.SMOKE_BOMB_ITEM, "Rauchbombe");
        translationBuilder.add(Items_RaEx.GLOW_BOMB_ITEM, "Glühbombe");
        translationBuilder.add(Items_RaEx.NINE_V_BATTERY_ITEM, "9-V-Batterie");
        translationBuilder.add(Items_RaEx.HOLY_HAND_GRENADE_ITEM, "Heilige Handgranate");
        translationBuilder.add(Items_RaEx.NIGHTMARE_TV_SPAWN_EGG, "NightmareTV Spawn Egg");
        translationBuilder.add(Items_RaEx.ROOMBA_ITEM, "Roomba");

        translationBuilder.add(Items_RaEx.SANDWICH, "Sandwich");
        translationBuilder.add(Items_RaEx.POPCORN, "Popcorn");
        translationBuilder.add(Items_RaEx.CORN, "Mais");
        translationBuilder.add(Items_RaEx.END_BARRY, "End Beere");
        translationBuilder.add(Items_RaEx.CORN_SEEDS, "Mais Samen");
        translationBuilder.add(Items_RaEx.TOMATO_SEEDS, "Tomate Samen");
        translationBuilder.add(Items_RaEx.TOMATO, "Tomate");
        translationBuilder.add(Items_RaEx.RAW_PIZZA, "Rohe Pizza");
        translationBuilder.add(Items_RaEx.PIZZA, "Pizza");
        translationBuilder.add(Items_RaEx.DOUGH, "Teig");
        translationBuilder.add(Items_RaEx.FLOUR, "Mehl");
        translationBuilder.add(Items_RaEx.STINKY_CHEESE, "Stinkender Käse");
        translationBuilder.add(Items_RaEx.CHEESE, "Käse");
        translationBuilder.add(Items_RaEx.BUCKET_CHEESE, "Käse Eimer");
        translationBuilder.add(Items_RaEx.ESCAPE_POTION, "Trank der Flucht");
        translationBuilder.add(Items_RaEx.DUK_TAPE, "Duk Tape");
        translationBuilder.add(ToolsAndArmors_RaEx.TOY_HAMMER, "Spielzeughammer");
        translationBuilder.add(ToolsAndArmors_RaEx.ESCAPE_ROPE, "Rettungsseil");
        translationBuilder.add(ToolsAndArmors_RaEx.LEAVE_STAFF, "Blatt Stab");
        translationBuilder.add(Items_RaEx.METAL_LUMP, "Metallklumpen");
        translationBuilder.add(Items_RaEx.COPPER_NUGGET, "Kupferklumpen");
        translationBuilder.add(Items_RaEx.BAMBOO_EXPLOSIVE, "Bambussprengstoff");
        translationBuilder.add(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG, "Starker Bambussprengstoff");
        translationBuilder.add(Items_RaEx.EMPTY_SODA_CAN, "Leere Dose");
        translationBuilder.add(Items_RaEx.GREEN_SODA_CAN, "Grüne Limonade");
        translationBuilder.add(Items_RaEx.RED_SODA_CAN, "Rote Limonade");

        /// Loot Bag
        translationBuilder.add(LootBag_RaEx.EMPTY_LOOT_BAG, "Lehre Beutetasche");
        translationBuilder.add(LootBag_RaEx.CHEESE_LOOT_BAG, "Käse Beutetasche");
        translationBuilder.add(LootBag_RaEx.MINE_LOOT_BAG, "Minen Beutetasche");

        /// Block
        translationBuilder.add(Blocks_RaEx.AQUAMARIN_ORE, "Tiefenschiefer Aquamarinertz");
        translationBuilder.add(Blocks_RaEx.AQUAMARIN_BLOCK, "Aquamarinblock");
        translationBuilder.add(Blocks_RaEx.TOPAS_ORE, "Tiefenschiefer Topasertz");
        translationBuilder.add(Blocks_RaEx.TOPAS_BLOCK, "Topasblock");
        translationBuilder.add(Blocks_RaEx.RUBY_ORE, "Tiefenschiefer Rubinertz");
        translationBuilder.add(Blocks_RaEx.RUBY_BLOCK, "Rubinblock");
        translationBuilder.add(Blocks_RaEx.SOUL_ORE, "Seelenertz");
        translationBuilder.add(Blocks_RaEx.CHARCOAL_BLOCK, "Holzkohleblock");
        translationBuilder.add(Blocks_RaEx.CHEESE_BLOCK, "Käseblock");
        translationBuilder.add(Blocks_RaEx.CHEESE_SLABS, "Käsestufe");
        translationBuilder.add(Blocks_RaEx.CHEESE_STAIRS, "Käsetreppe");
        translationBuilder.add(Blocks_RaEx.CHEESE_WALLS, "Käsemauer");
        translationBuilder.add(Blocks_RaEx.CHEESE_STATION, "Käse Station");
        translationBuilder.add(StepBlockRegistry.CHEESE_STEP, "Käse Schritt");
        translationBuilder.add(Blocks_RaEx.BARBED_WIRE, "Stacheldraht");
        translationBuilder.add(Blocks_RaEx.LAND_MINE, "Landmine");
        translationBuilder.add(Blocks_RaEx.STRONG_LAND_MINE, "Starke Landmine");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_DOOR, "Obsidiantür");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_TRAPDOOR, "Obsidianfalltür");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_GLASS, "Obsidianglas");
        translationBuilder.add(Blocks_RaEx.TINTED_OBSIDIAN_GLASS, "Getöntes Obsidianglas");
        translationBuilder.add(Blocks_RaEx.OBSIDIAN_GLASS_PANE, "Obsidianglasscheibe");
        translationBuilder.add(Blocks_RaEx.EXPLOSIVE_CAKE_BLOCK, "Explosiver Kuchen");
        translationBuilder.add(Blocks_RaEx.MOSSY_CRYSTAL, "Moosiger Kristall");
        translationBuilder.add(Blocks_RaEx.ICE_CRYSTAL, "Eisig Kristall");
        translationBuilder.add(Blocks_RaEx.SAND_CRYSTAL, "Sandig Kristall");
        translationBuilder.add(Blocks_RaEx.GRINDER, "Mühle");
        translationBuilder.add(Blocks_RaEx.NIGHT_SHADE, "Nachtschatten");
        translationBuilder.add(Blocks_RaEx.POTTED_NIGHT_SHADE, "Nachtschatten im Topf");
        translationBuilder.add(Blocks_RaEx.PURPUR_WOOD, "Purpurholz");
        translationBuilder.add(Blocks_RaEx.PURPUR_LOG, "Purpurbaumstamm");
        translationBuilder.add(Blocks_RaEx.STRIPPED_PURPUR_WOOD, "Entrindetes Purpurholz");
        translationBuilder.add(Blocks_RaEx.STRIPPED_PURPUR_LOG, "Entrindetes Purpurbaumstamm");
        translationBuilder.add(Blocks_RaEx.PURPUR_PLANKS, "Purpurholzbretter");
        translationBuilder.add(Blocks_RaEx.PURPUR_STAIRS, "Purpurtreppe");
        translationBuilder.add(Blocks_RaEx.PURPUR_SLABS, "Purpurstufe");
        translationBuilder.add(Blocks_RaEx.PURPUR_FENCE, "Purpurzaun");
        translationBuilder.add(Blocks_RaEx.PURPUR_GATE, "Purpurzauntor");
        translationBuilder.add(Blocks_RaEx.PURPUR_DOOR, "Purpurtür");
        translationBuilder.add(Blocks_RaEx.PURPUR_TRAPDOOR, "Purpurfalltür");
        translationBuilder.add(Blocks_RaEx.PURPUR_BUTTON, "Purpurknopf");
        translationBuilder.add(Blocks_RaEx.PURPUR_LEAVES, "Purpurblätter");
        translationBuilder.add(Blocks_RaEx.PURPUR_PRESSURE_PLATE, "Purpurdruckplatte");
        translationBuilder.add(Blocks_RaEx.PURPUR_SAPLING, "Purpur Baumsetzling");
        translationBuilder.add(Blocks_RaEx.POTTED_PURPUR_SAPLING, "Purpur Baumsetzling im Topf");
        translationBuilder.add(Blocks_RaEx.BURNED_WOOD, "Verbranntesholz");
        translationBuilder.add(Blocks_RaEx.BURNED_LOG, "Verbrannterbaumstamm");
        translationBuilder.add(Blocks_RaEx.STRIPPED_BURNED_WOOD, "Entrindetes Verbranntesholz");
        translationBuilder.add(Blocks_RaEx.STRIPPED_BURNED_LOG, "Entrindetes Verbrannterbaumstamm");
        translationBuilder.add(Blocks_RaEx.BURNED_PLANKS, "Verbrannterholzbretter");
        translationBuilder.add(Blocks_RaEx.BURNED_STAIRS, "Verbranntetreppe");
        translationBuilder.add(Blocks_RaEx.BURNED_SLABS, "Verbranntestufe");
        translationBuilder.add(Blocks_RaEx.BURNED_FENCE, "Verbranntezaun");
        translationBuilder.add(Blocks_RaEx.BURNED_GATE, "Verbranntezauntor");
        translationBuilder.add(Blocks_RaEx.BURNED_DOOR, "Verbranntetür");
        translationBuilder.add(Blocks_RaEx.BURNED_TRAPDOOR, "Verbranntefalltür");
        translationBuilder.add(Blocks_RaEx.BURNED_BUTTON, "Verbrannteknopf");
        translationBuilder.add(Blocks_RaEx.BURNED_PRESSURE_PLATE, "Verbranntedruckplatte");
        translationBuilder.add(Blocks_RaEx.BURNED_TREE_SAPLING, "Verbrannter Setzling");
        translationBuilder.add(Blocks_RaEx.POTTED_BURNED_TREE_SAPLING, "Verbrannter Setzling im Topf");
        translationBuilder.add(CropBlocks_RaEx.END_BARRY_BUSH, "End Beeren Busch");
        translationBuilder.add(CropBlocks_RaEx.TOMATO_CROP, "Tomaten Pflanze");
        translationBuilder.add(CropBlocks_RaEx.CORN_CROP, "Mais Pflanze");

        translationBuilder.add(Blocks_RaEx.SWITCH, "Schalter");

        /// Effect
        translationBuilder.add(Effects_RaEx.EVOKERS_BITE, "Evoker's Biss");
        translationBuilder.add(Effects_RaEx.LIGHTNING_ATTRACTION, "Blitzattraktion");

        ///Enchantment
        translationBuilder.add(Enchantments_RaEx.CURSE_OF_EXPLODING, "Fluch des Explodierens");
        translationBuilder.add(Enchantments_RaEx.POISONED_BLADE, "Vergiftete Klinge");
        translationBuilder.add(Enchantments_RaEx.CURSE_OF_SELF_HARMING, "Fluch der Selbstverletzung");
        translationBuilder.add(Enchantments_RaEx.ESCAPER, "Flüchtling");
        translationBuilder.add(Enchantments_RaEx.EVOKERS_BITE, "Evoker's Biss");
        translationBuilder.add(Enchantments_RaEx.LIFE_STEAL, "Lebensraub");
        translationBuilder.add(Enchantments_RaEx.FREEZING_BLADE, "Gefrierklinge");

        ///Entity
        translationBuilder.add(Entities_RaEx.NIGHTMARE_TV, "NightmareTV");
        translationBuilder.add(Entities_RaEx.ROOMBA, "Roomba");

        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/randexten/lang/de_de.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Existing lang", e);
        }
    }
}
