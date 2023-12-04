package net.rand.exten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.EnterBlockCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.block.StepBlockRegistry;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.item.ToolsAndArmors_RaEx;
import net.rand.exten.util.Tags_RaEx;

import java.util.function.Consumer;

public class AdvancementProvider_RaEx extends FabricAdvancementProvider {
    private final String background = "textures/block/cheese_block.png";
    public AdvancementProvider_RaEx(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {

        // Root
        AdvancementEntry mainRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.CHEESE_BLOCK),
                        Text.literal("Random Extensions"), Text.literal("Its filled with Random Stuff"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        false, false, false))
                .criterion("exist", EnterBlockCriterion.Conditions.block(Blocks.AIR))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:pebble_from_cobblestone"))
                        .addRecipe(new Identifier("randexten:cobblestone_from_pebble"))
                        .addRecipe(new Identifier("randexten:wooden_paxel"))
                        .addRecipe(new Identifier("randexten:stone_paxel"))
                        .addRecipe(new Identifier("randexten:iron_paxel"))
                        .addRecipe(new Identifier("randexten:golden_paxel"))
                        .addRecipe(new Identifier("randexten:diamond_paxel"))
                ).build(consumer, RandomExtensions.MOD_ID + ":re/randexten");

        generateTreeAdvancement(consumer, mainRoot);

        AdvancementEntry miscRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.CHARCOAL_BLOCK),
                        Text.literal("Miscellaneous stuff"), Text.literal(""),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_charcoal", RecipeUnlockedCriterion.create(new Identifier("minecraft:charcoal")))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:roomba_item"))
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/misc_root");

        AdvancementEntry foodRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.CHEESE),
                        Text.literal("Many new Foods"), Text.literal("there are new things, like CHEESE"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("consumed_item", ConsumeItemCriterion.Conditions.any())
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:sandwich"))
                        .addRecipe(new Identifier("randexten:bucket_cheese_from_milk"))
                        .addRecipe(new Identifier("randexten:raw_pizza"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/new_foods");

        AdvancementEntry copperRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.COPPER_PICKAXE),
                        Text.literal("Copper"), Text.literal("Rust Prof"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_copper_ingot", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:cooper_axe"))
                        .addRecipe(new Identifier("randexten:cooper_pickaxe"))
                        .addRecipe(new Identifier("randexten:cooper_shovel"))
                        .addRecipe(new Identifier("randexten:cooper_hoe"))
                        .addRecipe(new Identifier("randexten:cooper_sword"))
                        .addRecipe(new Identifier("randexten:cooper_helmet"))
                        .addRecipe(new Identifier("randexten:cooper_chestplate"))
                        .addRecipe(new Identifier("randexten:cooper_leggings"))
                        .addRecipe(new Identifier("randexten:cooper_boots"))
                        .addRecipe(new Identifier("randexten:copper_paxel"))
                        .addRecipe(new Identifier("randexten:copper_longsword"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/cooper/cooper_root");

        AdvancementEntry crystalRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.MOSSY_CRYSTAL),
                        Text.literal("Crystals"), Text.literal("Alternative Medicine"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_sand_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.SAND_CRYSTAL))
                .criterion("has_ice_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.ICE_CRYSTAL))
                .criterion("has_mossy_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.MOSSY_CRYSTAL))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:mossy_crystal"))
                        .addRecipe(new Identifier("randexten:ice_crystal"))
                        .addRecipe(new Identifier("randexten:sand_crystal"))
                        .setExperience(40)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/crystal_root");

        AdvancementEntry drinkRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.EMPTY_SODA_CAN),
                        Text.literal("Lets Make some Drinks"), Text.literal("Burp"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:empty_soda_can"))
                        .addRecipe(new Identifier("randexten:red_soda_can"))
                        .addRecipe(new Identifier("randexten:green_soda_can"))
                        .setExperience(20)
                )
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/drinks/root_drinks");

        AdvancementEntry projectileRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items.SNOWBALL),
                        Text.literal("Projectiles"), Text.literal("Lets Trow some thinks"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_projectile", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.PROJECTILE)))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/projectile/root_projectile");

        AdvancementEntry explosivesRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks.TNT),
                        Text.literal("BOOM"), Text.literal("Lets make some Bombs"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_gunpowder", InventoryChangedCriterion.Conditions.items(Items.GUNPOWDER))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:bamboo_explosive"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/root_explosives");

        AdvancementEntry gemRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.AQUAMARIN_ORE),
                        Text.literal("Gems"), Text.literal("we, are the..."),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_gem", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.GEMS)))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/root_gem");

        AdvancementEntry grinderRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.GRINDER),
                        Text.literal("Grinder"), Text.literal("maybe we can build something with that?"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("get_grindstone", InventoryChangedCriterion.Conditions.items(Blocks.GRINDSTONE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:grinder"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/grinder/grinder_root");

        AdvancementEntry legendaryItemRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.LEAVE_STAFF),
                        Text.literal("That's a Legendary"), Text.literal("Got one"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_a_legendary", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.LEGENDARY)))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/legendary_root");

        // Food
        AdvancementEntry sandwich = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.SANDWICH),
                        Text.literal("Sandwich"), Text.literal("Mmmm, Sandwich"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_consumed_sandwich", ConsumeItemCriterion.Conditions.item(Items_RaEx.SANDWICH))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/sandwich");

        AdvancementEntry cheeseBucket = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.BUCKET_CHEESE),
                        Text.literal("This, is a (Cheese filed) Bucket"), Text.literal("Dear God"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_cheese_bucket", InventoryChangedCriterion.Conditions.items((Items_RaEx.BUCKET_CHEESE)))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:cheese_block_from_bucket_cheese"))
                        .setExperience(20)
                )
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/cheese_bucket");

        AdvancementEntry cheese = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.CHEESE),
                        Text.literal("CHEESE"), Text.literal("Gromit, where are my crackers?"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_consumed_cheese", InventoryChangedCriterion.Conditions.items(Items_RaEx.CHEESE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:cheese_block"))
                        .addRecipe(new Identifier("randexten:cheese_slabs"))
                        .addRecipe(new Identifier("randexten:cheese_stairs"))
                        .addRecipe(new Identifier("randexten:cheese_walls"))
                        .addRecipe(new Identifier("randexten:cheese_step"))
                        .setExperience(20)
                )
                .parent(cheeseBucket)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/cheese");

        AdvancementEntry stinkyCheese = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.STINKY_CHEESE),
                        Text.literal("Eww, Stinky"), Text.literal("Lets trow it at People that we don't like"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_stinky_cheese", InventoryChangedCriterion.Conditions.items(Items_RaEx.STINKY_CHEESE))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(cheese)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/stinky_cheese");

        AdvancementEntry rawPizza = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.RAW_PIZZA),
                        Text.literal("Its Raw"), Text.literal("Needs to be backed"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_raw_pizza", InventoryChangedCriterion.Conditions.items(Items_RaEx.RAW_PIZZA))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/raw_pizza");

        AdvancementEntry stillRawPizza = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.RAW_PIZZA),
                        Text.literal("Still Raw"), Text.literal("Why?"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_raw_eaten_pizza", ConsumeItemCriterion.Conditions.item(Items_RaEx.RAW_PIZZA))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(rawPizza)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/still_raw_pizza");

        AdvancementEntry Pizza = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.PIZZA),
                        Text.literal("PIZZA"), Text.literal("Pizza Time"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_eaten_pizza", ConsumeItemCriterion.Conditions.item(Items_RaEx.PIZZA))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(rawPizza)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/pizza");

        AdvancementEntry flour = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.FLOUR),
                        Text.literal("Lets put it in the Grinder"), Text.literal("Hehe, white powder"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_flour", InventoryChangedCriterion.Conditions.items(Items_RaEx.FLOUR))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/flour");

        AdvancementEntry dough = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.DOUGH),
                        Text.literal("A better way to make bread"), Text.literal("its Cauldron time"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_dough", InventoryChangedCriterion.Conditions.items(Items_RaEx.DOUGH))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:bread_from_campfire_dough"))
                        .addRecipe(new Identifier("randexten:bread_from_dough"))
                        .addRecipe(new Identifier("randexten:bread_from_smoking_dough"))
                        .setExperience(20)
                )
                .parent(flour)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/dough");

        // Soda
        AdvancementEntry drinkAll = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.RED_SODA_CAN),
                        Text.literal("Dats a lot of drinks"), Text.literal("ENERGY!?!"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_drank_red", ConsumeItemCriterion.Conditions.item(Items_RaEx.RED_SODA_CAN))
                .criterion("has_drank_green", ConsumeItemCriterion.Conditions.item(Items_RaEx.GREEN_SODA_CAN))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(drinkRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/drinks/drink_all");

        // Grinder
        AdvancementEntry grindAll = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.GRINDER),
                        Text.literal("Grind Everything"), Text.literal("Automation, Baby"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_recipe_cobblestone", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/cobblestone_grinder")))
                .criterion("has_recipe_gravel", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/gravel_grinder")))
                .criterion("has_recipe_sand", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/sand_grinder")))
                .criterion("has_recipe_flour", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/flour_grinder")))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(grinderRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/grinder/grind_all");

        // Projectile
        AdvancementEntry pebble = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.PEBBLE),
                        Text.literal("Rock"), Text.literal("Throw at Friend"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_pebble", InventoryChangedCriterion.Conditions.items(Items_RaEx.PEBBLE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:bamboo_explosive"))
                        .setExperience(20)
                )
                .parent(projectileRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/projectile/pebble");

        /// Explosives
        AdvancementEntry bambooExplosive = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.BAMBOO_EXPLOSIVE),
                        Text.literal("Hehe, BamBOOM"), Text.literal("Bamboo goes BOOM"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_bamboo_explosive", InventoryChangedCriterion.Conditions.items(Items_RaEx.BAMBOO_EXPLOSIVE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:duk_tape"))
                        .addRecipe(new Identifier("randexten:bamboo_explosive_strong"))
                        .setExperience(20)
                )
                .parent(explosivesRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/bamboo_explosive");

        AdvancementEntry dukTape = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.DUK_TAPE),
                        Text.literal("Duck Tape OwO"), Text.literal("Duck.png"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_duk_tape", InventoryChangedCriterion.Conditions.items(Items_RaEx.DUK_TAPE))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(bambooExplosive)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/duk_tape");

        AdvancementEntry strongBambooExplosive = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG),
                        Text.literal("Even bigger BOOM"), Text.literal("explosive_sound.mp4"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_strong_bamboo_explosive", InventoryChangedCriterion.Conditions.items(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(bambooExplosive)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/strong_bamboo_explosive");

        // Obsidian
        AdvancementEntry obsidianStuff = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.OBSIDIAN_GLASS),
                        Text.literal("Stronger Glass"), Text.literal("its BOOM prof"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_obsidian", InventoryChangedCriterion.Conditions.items(Blocks.OBSIDIAN))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:obsidian_door"))
                        .addRecipe(new Identifier("randexten:obsidian_glass"))
                        .addRecipe(new Identifier("randexten:obsidian_glass_pane"))
                        .addRecipe(new Identifier("randexten:obsidian_trapdoor"))
                        .setExperience(20))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/obsidian_stuff");

        // Gems
        AdvancementEntry gemUpgrade = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Text.literal("Time for Upgrades"), Text.literal("Welcome to the Jungle"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_gems_upgrade_template", InventoryChangedCriterion.Conditions.items(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(gemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/gem_upgrade");

        AdvancementEntry aquamarinRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.AQUAMARIN_BLOCK),
                        Text.literal("Its Aquamarin"), Text.literal("we, are the..."),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_aquamarin", InventoryChangedCriterion.Conditions.items(Items_RaEx.AQUAMARIN))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(gemUpgrade)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/aquamarin_root");

        AdvancementEntry aquamarinDArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET),
                        Text.literal("Lets be Fish"), Text.literal("i cant swim"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_aquamarin_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET))
                .criterion("has_aquamarin_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_AQUAMARIN_CHESTPLATE))
                .criterion("has_aquamarin_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_AQUAMARIN_LEGGINGS))
                .criterion("has_aquamarin_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_AQUAMARIN_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(aquamarinRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/aquamarin_d_armor");

        AdvancementEntry aquamarinNArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET),
                        Text.literal("I can finally Breath"), Text.literal("Aqua-man"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_aquamarin_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_AQUAMARIN_HELMET))
                .criterion("has_aquamarin_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_AQUAMARIN_CHESTPLATE))
                .criterion("has_aquamarin_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_AQUAMARIN_LEGGINGS))
                .criterion("has_aquamarin_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_AQUAMARIN_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(aquamarinDArmor)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/aquamarin_n_armor");

        AdvancementEntry rubyRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.RUBY_BLOCK),
                        Text.literal("Ruby Time"), Text.literal("Retro"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_ruby", InventoryChangedCriterion.Conditions.items(Items_RaEx.RUBY))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(gemUpgrade)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/ruby_root");

        AdvancementEntry rubyDArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.D_RUBY_HELMET),
                        Text.literal("Battle time"), Text.literal("fight me"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_ruby_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_RUBY_HELMET))
                .criterion("has_ruby_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_RUBY_CHESTPLATE))
                .criterion("has_ruby_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_RUBY_LEGGINGS))
                .criterion("has_ruby_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_RUBY_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(rubyRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/ruby_d_armor");

        AdvancementEntry rubyNArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.N_RUBY_HELMET),
                        Text.literal("Speed"), Text.literal("Deja vu"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_ruby_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_RUBY_HELMET))
                .criterion("has_ruby_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_RUBY_CHESTPLATE))
                .criterion("has_ruby_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_RUBY_LEGGINGS))
                .criterion("has_ruby_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_RUBY_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(rubyDArmor)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/ruby_n_armor");

        AdvancementEntry topasRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.TOPAS_BLOCK),
                        Text.literal("Topas"), Text.literal("Topas"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_topas", InventoryChangedCriterion.Conditions.items(Items_RaEx.TOPAS))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(gemUpgrade)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/topas_root");

        AdvancementEntry topasDArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.D_TOPAS_HELMET),
                        Text.literal("Let go Mining"), Text.literal("Side to Side"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_topas_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_TOPAS_HELMET))
                .criterion("has_topas_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_TOPAS_CHESTPLATE))
                .criterion("has_topas_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_TOPAS_LEGGINGS))
                .criterion("has_topas_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.D_TOPAS_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(topasRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/topas_d_armor");

        AdvancementEntry topasNArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.N_TOPAS_HELMET),
                        Text.literal("Better Mining"), Text.literal("i still cant see"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_topas_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_HELMET))
                .criterion("has_topas_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE))
                .criterion("has_topas_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS))
                .criterion("has_topas_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(topasDArmor)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/topas_n_armor");

        /// Misc
        AdvancementEntry itsAllCheese = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.CHEESE_STAIRS),
                        Text.literal("Its all Cheese?"), Text.literal("Yes, yes it is"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_cheese_stair", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.CHEESE_STAIRS))
                .criterion("has_cheese_slab", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.CHEESE_SLABS))
                .criterion("has_cheese_wall", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.CHEESE_WALLS))
                .criterion("has_cheese_step", InventoryChangedCriterion.Conditions.items(StepBlockRegistry.CHEESE_STEP))
                .rewards(AdvancementRewards.Builder.experience(200)
                        .addRecipe(new Identifier("randexten:roomba_item")))
                .parent(cheese)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/its_all_cheese");

        AdvancementEntry soulOre = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.SOUL_ORE),
                        Text.literal("Soul"), Text.literal("their is no joke"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_soul", InventoryChangedCriterion.Conditions.items(Items_RaEx.SOUL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/soul_ore");

        AdvancementEntry roomba = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.ROOMBA_ITEM),
                        Text.literal("Roomba"), Text.literal("Good Boy"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_roomba", InventoryChangedCriterion.Conditions.items(Items_RaEx.ROOMBA_ITEM))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/roomba");

        AdvancementEntry longSword = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.IRON_LONGSWORD),
                        Text.literal("They are LONG"), Text.literal("he Sword Long"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_sword", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.SWORD)))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:wooden_longsword"))
                        .addRecipe(new Identifier("randexten:stone_longsword"))
                        .addRecipe(new Identifier("randexten:iron_longsword"))
                        .addRecipe(new Identifier("randexten:golden_longsword"))
                        .addRecipe(new Identifier("randexten:diamond_longsword")))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/long_sword");

        // Copper
        AdvancementEntry cooperArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.COPPER_HELMET),
                        Text.literal("Copper Armor"), Text.literal("Dose not Rust, i *promise*"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_copper_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_HELMET))
                .criterion("has_copper_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_CHESTPLATE))
                .criterion("has_copper_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_LEGGINGS))
                .criterion("has_copper_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(copperRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/cooper/cooper_armor");

        AdvancementEntry cooperTools = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.COPPER_AXE),
                        Text.literal("Tools of Copper"), Text.literal("Cant Rust"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_copper_axe", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_AXE))
                .criterion("has_copper_pickaxe", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_PICKAXE))
                .criterion("has_copper_shovel", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_SHOVEL))
                .criterion("has_copper_hoe", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_HOE))
                .criterion("has_copper_sword", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_SWORD))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(copperRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/cooper/cooper_tools");

        // Crystal
        AdvancementEntry mossyCrystal = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.MOSSY_CRYSTAL),
                        Text.literal("Moss"), Text.literal("Green"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_mossy_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.MOSSY_CRYSTAL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(crystalRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/mossy_crystal");
        AdvancementEntry iceCrystal = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.ICE_CRYSTAL),
                        Text.literal("Cold"), Text.literal("Blue"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_ice_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.ICE_CRYSTAL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(crystalRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/ice_crystal");
        AdvancementEntry sandCrystal = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.SAND_CRYSTAL),
                        Text.literal("Sandy"), Text.literal("Yellow"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_sand_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.SAND_CRYSTAL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(crystalRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/sand_crystal");

        // Legendary
        AdvancementEntry leaveStaff = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.LEAVE_STAFF),
                        Text.literal("Do you like Tree jokes?"), Text.literal("Because they leaf me in tears"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_leave_staff", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.LEAVE_STAFF))
                .rewards(AdvancementRewards.Builder.experience(400))
                .parent(legendaryItemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/leave_staff");

        AdvancementEntry toyHammer = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.TOY_HAMMER),
                        Text.literal("Bonk"), Text.literal("Yeet"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_toy_hammer", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.TOY_HAMMER))
                .rewards(AdvancementRewards.Builder.experience(400))
                .parent(legendaryItemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/toy_hammer");

        AdvancementEntry escapeRope = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.ESCAPE_ROPE),
                        Text.literal("Lets get aut of here"), Text.literal("Escape!"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_escape_rope", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.ESCAPE_ROPE))
                .rewards(AdvancementRewards.Builder.experience(400))
                .parent(legendaryItemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/escape_rope");

    }

    // Todo do this for all
    public void generateTreeAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {

        AdvancementEntry treeRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks.OAK_SAPLING),
                        Text.literal("New Trees"), Text.literal(""),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_sapling", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(ItemTags.SAPLINGS)))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/tree_advancements/burned_root");

        AdvancementEntry burnedRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.BURNED_TREE_SAPLING),
                        Text.literal("In the Furnace with it"), Text.literal("Burn a Sapling"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_furnace", InventoryChangedCriterion.Conditions.items(Items.FURNACE))
                .criterion("has_a_sapling", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(ItemTags.SAPLINGS)))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(treeRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/tree_advancements/burned_root");


        /// Tree
        // Burned Tree
        AdvancementEntry burnedTree = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.BURNED_LOG),
                        Text.literal("Its Burned"), Text.literal("Let it Burn"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_burned_sapling", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.BURNED_TREE_SAPLING))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:burned_button_from_burned_planks"))
                        .addRecipe(new Identifier("randexten:burned_door"))
                        .addRecipe(new Identifier("randexten:burned_gate"))
                        .addRecipe(new Identifier("randexten:burned_trapdoor"))
                        .addRecipe(new Identifier("randexten:burned_pressure_plate"))
                        .addRecipe(new Identifier("randexten:burned_fence"))
                        .addRecipe(new Identifier("randexten:burned_slabs"))
                        .addRecipe(new Identifier("randexten:burned_stairs"))
                        .setExperience(20)
                )
                .parent(burnedRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/tree_advancements/burned_tree");

        // PurPur Tree
        AdvancementEntry purpurTree = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.PURPUR_LOG),
                        Text.literal("PurPur"), Text.literal("ColOR"),
                        new Identifier(RandomExtensions.MOD_ID, background), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_purpur_log", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.PURPUR_LOG))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:purpur_button_from_purpur_planks"))
                        .addRecipe(new Identifier("randexten:purpur_door"))
                        .addRecipe(new Identifier("randexten:purpur_gate"))
                        .addRecipe(new Identifier("randexten:purpur_trapdoor"))
                        .addRecipe(new Identifier("randexten:purpur_pressure_plate"))
                        .addRecipe(new Identifier("randexten:purpur_fence"))
                        .addRecipe(new Identifier("randexten:purpur_slabs"))
                        .addRecipe(new Identifier("randexten:purpur_stairs"))
                        .setExperience(20)
                )
                .parent(treeRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/tree_advancements/purpur_tree");

    }
}
