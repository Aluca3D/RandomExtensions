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

import java.util.Optional;
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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

        AdvancementEntry foodRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.CHEESE),
                        Text.literal("Many new Foods"), Text.literal("there are new things, like CHEESE"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("consumed_item", ConsumeItemCriterion.Conditions.any())
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:sandwich"))
                        .addRecipe(new Identifier("randexten:bucket_cheese_from_milk"))
                        .addRecipe(new Identifier("randexten:raw_pizza"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/new_foods");

        AdvancementEntry drinkRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.EMPTY_SODA_CAN),
                        Text.literal("Lets Make some Drinks"), Text.literal("Burp"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:empty_soda_can"))
                        .addRecipe(new Identifier("randexten:red_soda_can"))
                        .addRecipe(new Identifier("randexten:green_soda_can"))
                        .setExperience(20)
                )
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/drinks/root_drinks");

        // Generates
        generateTreeAdvancement(consumer, mainRoot);
        generateGemsAdvancement(consumer, mainRoot);
        generateCrystalAdvancement(consumer, mainRoot);
        generateCooperAdvancement(consumer, mainRoot);
        generateExplosivesAdvancement(consumer, mainRoot);
        generateLegendaryAdvancement(consumer, mainRoot);
        generateFoodAdvancement(consumer, mainRoot, foodRoot);
        generateProjectileAdvancement(consumer, mainRoot);
        generateGrinderAdvancement(consumer, mainRoot);
        generateMiscAdvancement(consumer, mainRoot);

        generateRecipes(consumer);

        // Soda
        AdvancementEntry drinkAll = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.RED_SODA_CAN),
                        Text.literal("Dats a lot of drinks"), Text.literal("ENERGY!?!"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_drank_red", ConsumeItemCriterion.Conditions.item(Items_RaEx.RED_SODA_CAN))
                .criterion("has_drank_green", ConsumeItemCriterion.Conditions.item(Items_RaEx.GREEN_SODA_CAN))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(drinkRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/drinks/drink_all");

    }

    public void generateMiscAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry miscRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.CHARCOAL_BLOCK),
                        Text.literal("Miscellaneous stuff"), Text.literal(""),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_charcoal", InventoryChangedCriterion.Conditions.items(Items.CHARCOAL))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:roomba_item"))
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/misc_root");

        /// Misc
        AdvancementEntry soulOre = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.SOUL_ORE),
                        Text.literal("Soul"), Text.literal("their is no joke"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_soul", InventoryChangedCriterion.Conditions.items(Items_RaEx.SOUL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/soul_ore");

        AdvancementEntry metalLump = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.METAL_LUMP),
                        Text.literal("A Lump of Metal"), Text.literal("he, Lump"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_gold_nugget", InventoryChangedCriterion.Conditions.items(Items.GOLD_NUGGET))
                .criterion("has_iron_nugget", InventoryChangedCriterion.Conditions.items(Items.IRON_NUGGET))
                .criterion("has_copper_nugget", InventoryChangedCriterion.Conditions.items(Items_RaEx.COPPER_NUGGET))
                .rewards(AdvancementRewards.Builder.experience(20)
                        .addRecipe(new Identifier("randexten:metal_lump")))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/metal_lump");

        AdvancementEntry roomba = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.ROOMBA_ITEM),
                        Text.literal("Roomba"), Text.literal("Good Boy"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_roomba", InventoryChangedCriterion.Conditions.items(Items_RaEx.ROOMBA_ITEM))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/roomba");

        AdvancementEntry longSword = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.IRON_LONGSWORD),
                        Text.literal("They are LONG"), Text.literal("he Sword Long"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_sword", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.SWORD)))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:wooden_longsword"))
                        .addRecipe(new Identifier("randexten:stone_longsword"))
                        .addRecipe(new Identifier("randexten:iron_longsword"))
                        .addRecipe(new Identifier("randexten:golden_longsword"))
                        .addRecipe(new Identifier("randexten:diamond_longsword")))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/long_sword");

        // Obsidian
        AdvancementEntry obsidianStuff = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.OBSIDIAN_GLASS),
                        Text.literal("Stronger Glass"), Text.literal("its BOOM prof"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_obsidian", InventoryChangedCriterion.Conditions.items(Blocks.OBSIDIAN))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:obsidian_door"))
                        .addRecipe(new Identifier("randexten:obsidian_glass"))
                        .addRecipe(new Identifier("randexten:obsidian_glass_pane"))
                        .addRecipe(new Identifier("randexten:obsidian_trapdoor"))
                        .setExperience(20))
                .parent(miscRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/obsidian_stuff");


    }

    public void generateProjectileAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry projectileRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items.SNOWBALL),
                        Text.literal("Projectiles"), Text.literal("Lets Trow some thinks"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_projectile", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.PROJECTILE)))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/projectile/root_projectile");


        // Projectile
        AdvancementEntry pebble = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.PEBBLE),
                        Text.literal("Rock"), Text.literal("Throw at Friend"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_pebble", InventoryChangedCriterion.Conditions.items(Items_RaEx.PEBBLE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:bamboo_explosive"))
                        .setExperience(20)
                )
                .parent(projectileRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/projectile/pebble");

    }

    public void generateGrinderAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry grinderRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.GRINDER),
                        Text.literal("Grinder"), Text.literal("maybe we can build something with that?"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("get_grindstone", InventoryChangedCriterion.Conditions.items(Blocks.GRINDSTONE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:grinder"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/grinder/grinder_root");

        // Grinder
        AdvancementEntry grindAll = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.GRINDER),
                        Text.literal("Grind Everything"), Text.literal("Automation, Baby"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_recipe_cobblestone", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/cobblestone_grinder")))
                .criterion("has_recipe_gravel", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/gravel_grinder")))
                .criterion("has_recipe_sand", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/sand_grinder")))
                .criterion("has_recipe_flour", RecipeUnlockedCriterion.create(new Identifier("randexten:grinder/flour_grinder")))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(grinderRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/grinder/grind_all");

    }

    public void generateFoodAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot, AdvancementEntry foodRoot) {
        AdvancementEntry sandwich = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.SANDWICH),
                        Text.literal("Sandwich"), Text.literal("Mmmm, Sandwich"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_consumed_sandwich", ConsumeItemCriterion.Conditions.item(Items_RaEx.SANDWICH))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/sandwich");

        AdvancementEntry cheeseBucket = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.BUCKET_CHEESE),
                        Text.literal("This, is a (Cheese filed) Bucket"), Text.literal("Dear God"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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

        AdvancementEntry itsAllCheese = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.CHEESE_STAIRS),
                        Text.literal("Its all Cheese?"), Text.literal("Yes, yes it is"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
                        true, true, true))
                .criterion("has_cheese_stair", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.CHEESE_STAIRS))
                .criterion("has_cheese_slab", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.CHEESE_SLABS))
                .criterion("has_cheese_wall", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.CHEESE_WALLS))
                .criterion("has_cheese_step", InventoryChangedCriterion.Conditions.items(StepBlockRegistry.CHEESE_STEP))
                .rewards(AdvancementRewards.Builder.experience(200)
                        .addRecipe(new Identifier("randexten:roomba_item")))
                .parent(cheese)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/its_all_cheese");

        AdvancementEntry stinkyCheese = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.STINKY_CHEESE),
                        Text.literal("Eww, Stinky"), Text.literal("Lets trow it at People that we don't like"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_stinky_cheese", InventoryChangedCriterion.Conditions.items(Items_RaEx.STINKY_CHEESE))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(cheese)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/stinky_cheese");

        AdvancementEntry rawPizza = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.RAW_PIZZA),
                        Text.literal("Its Raw"), Text.literal("Needs to be backed"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_raw_pizza", InventoryChangedCriterion.Conditions.items(Items_RaEx.RAW_PIZZA))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/raw_pizza");

        AdvancementEntry stillRawPizza = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.RAW_PIZZA),
                        Text.literal("Still Raw"), Text.literal("Why?"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_raw_eaten_pizza", ConsumeItemCriterion.Conditions.item(Items_RaEx.RAW_PIZZA))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(rawPizza)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/still_raw_pizza");

        AdvancementEntry Pizza = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.PIZZA),
                        Text.literal("PIZZA"), Text.literal("Pizza Time"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_eaten_pizza", ConsumeItemCriterion.Conditions.item(Items_RaEx.PIZZA))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(rawPizza)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/pizza");

        AdvancementEntry flour = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.FLOUR),
                        Text.literal("Lets put it in the Grinder"), Text.literal("Hehe, white powder"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_flour", InventoryChangedCriterion.Conditions.items(Items_RaEx.FLOUR))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(foodRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/flour");

        AdvancementEntry dough = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.DOUGH),
                        Text.literal("A better way to make bread"), Text.literal("its Cauldron time"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_dough", InventoryChangedCriterion.Conditions.items(Items_RaEx.DOUGH))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:bread_from_campfire_dough"))
                        .addRecipe(new Identifier("randexten:bread_from_dough"))
                        .addRecipe(new Identifier("randexten:bread_from_smoking_dough"))
                        .setExperience(20)
                )
                .parent(flour)
                .build(consumer, RandomExtensions.MOD_ID + ":re/foods/dough");

    }

    public void generateGemsAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry gemRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.AQUAMARIN_ORE),
                        Text.literal("Gems"), Text.literal("we, are the..."),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_gem", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.GEMS)))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/root_gem");

        // Gems
        AdvancementEntry gemUpgrade = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.GEMS_UPGRADE_TEMPLATE),
                        Text.literal("Time for Upgrades"), Text.literal("Welcome to the Jungle"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, false))
                .criterion("has_gems_upgrade_template", InventoryChangedCriterion.Conditions.items(Items_RaEx.GEMS_UPGRADE_TEMPLATE))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(gemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/gem_upgrade");

        AdvancementEntry aquamarinRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.AQUAMARIN_BLOCK),
                        Text.literal("Its Aquamarin"), Text.literal("we, are the..."),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_aquamarin", InventoryChangedCriterion.Conditions.items(Items_RaEx.AQUAMARIN))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(gemUpgrade)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/aquamarin_root");

        AdvancementEntry aquamarinDArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.D_AQUAMARIN_HELMET),
                        Text.literal("Lets be Fish"), Text.literal("i cant swim"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_ruby", InventoryChangedCriterion.Conditions.items(Items_RaEx.RUBY))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(gemUpgrade)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/ruby_root");

        AdvancementEntry rubyDArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.D_RUBY_HELMET),
                        Text.literal("Battle time"), Text.literal("fight me"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_topas", InventoryChangedCriterion.Conditions.items(Items_RaEx.TOPAS))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(gemUpgrade)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/topas_root");

        AdvancementEntry topasDArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.D_TOPAS_HELMET),
                        Text.literal("Let go Mining"), Text.literal("Side to Side"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.CHALLENGE,
                        true, true, false))
                .criterion("has_topas_armor_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_HELMET))
                .criterion("has_topas_armor_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_CHESTPLATE))
                .criterion("has_topas_armor_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_LEGGINGS))
                .criterion("has_topas_armor_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.N_TOPAS_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(200))
                .parent(topasDArmor)
                .build(consumer, RandomExtensions.MOD_ID + ":re/gems/topas_n_armor");

    }

    public void generateCooperAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry copperRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.COPPER_PICKAXE),
                        Text.literal("Copper"), Text.literal("Rust Prof"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_copper_ingot", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:copper_axe"))
                        .addRecipe(new Identifier("randexten:copper_pickaxe"))
                        .addRecipe(new Identifier("randexten:copper_shovel"))
                        .addRecipe(new Identifier("randexten:copper_hoe"))
                        .addRecipe(new Identifier("randexten:copper_sword"))
                        .addRecipe(new Identifier("randexten:copper_helmet"))
                        .addRecipe(new Identifier("randexten:copper_chestplate"))
                        .addRecipe(new Identifier("randexten:copper_leggings"))
                        .addRecipe(new Identifier("randexten:copper_boots"))
                        .addRecipe(new Identifier("randexten:copper_paxel"))
                        .addRecipe(new Identifier("randexten:copper_longsword"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/copper/copper_root");

        // Copper
        AdvancementEntry copperArmor = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.COPPER_HELMET),
                        Text.literal("Copper Armor"), Text.literal("Dose not Rust, i *promise*"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_copper_helmet", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_HELMET))
                .criterion("has_copper_chestplate", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_CHESTPLATE))
                .criterion("has_copper_leggings", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_LEGGINGS))
                .criterion("has_copper_boots", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_BOOTS))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(copperRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/copper/copper_armor");

        AdvancementEntry copperTools = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.COPPER_AXE),
                        Text.literal("Tools of Copper"), Text.literal("Cant Rust"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_copper_axe", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_AXE))
                .criterion("has_copper_pickaxe", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_PICKAXE))
                .criterion("has_copper_shovel", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_SHOVEL))
                .criterion("has_copper_hoe", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_HOE))
                .criterion("has_copper_sword", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.COPPER_SWORD))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(copperRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/copper/copper_tools");
    }

    public void generateCrystalAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry crystalRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.MOSSY_CRYSTAL),
                        Text.literal("Crystals"), Text.literal("Alternative Medicine"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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

        // Crystal
        AdvancementEntry mossyCrystal = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.MOSSY_CRYSTAL),
                        Text.literal("Moss"), Text.literal("Green"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_mossy_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.MOSSY_CRYSTAL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(crystalRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/mossy_crystal");

        AdvancementEntry iceCrystal = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.ICE_CRYSTAL),
                        Text.literal("Cold"), Text.literal("Blue"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_ice_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.ICE_CRYSTAL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(crystalRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/ice_crystal");

        AdvancementEntry sandCrystal = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.SAND_CRYSTAL),
                        Text.literal("Sandy"), Text.literal("Yellow"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_sand_crystal", InventoryChangedCriterion.Conditions.items(Blocks_RaEx.SAND_CRYSTAL))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(crystalRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/sand_crystal");

    }

    public void generateLegendaryAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry legendaryItemRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.LEAVE_STAFF),
                        Text.literal("That's a Legendary"), Text.literal("Got one"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_a_legendary", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(Tags_RaEx.Items.LEGENDARY)))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/legendary_root");

        // Legendary
        AdvancementEntry leaveStaff = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.LEAVE_STAFF),
                        Text.literal("Do you like Tree jokes?"), Text.literal("Because they leaf me in tears"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_leave_staff", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.LEAVE_STAFF))
                .rewards(AdvancementRewards.Builder.experience(400))
                .parent(legendaryItemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/leave_staff");

        AdvancementEntry toyHammer = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.TOY_HAMMER),
                        Text.literal("Bonk"), Text.literal("Yeet"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_toy_hammer", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.TOY_HAMMER))
                .rewards(AdvancementRewards.Builder.experience(400))
                .parent(legendaryItemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/toy_hammer");

        AdvancementEntry escapeRope = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ToolsAndArmors_RaEx.ESCAPE_ROPE),
                        Text.literal("Lets get aut of here"), Text.literal("Escape!"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_escape_rope", InventoryChangedCriterion.Conditions.items(ToolsAndArmors_RaEx.ESCAPE_ROPE))
                .rewards(AdvancementRewards.Builder.experience(400))
                .parent(legendaryItemRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/legendary_item/escape_rope");

    }

    public void generateExplosivesAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry explosivesRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks.TNT),
                        Text.literal("BOOM"), Text.literal("Lets make some Bombs"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_gunpowder", InventoryChangedCriterion.Conditions.items(Items.GUNPOWDER))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:bamboo_explosive"))
                        .setExperience(20)
                )
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/root_explosives");

        /// Explosives
        AdvancementEntry bambooExplosive = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.BAMBOO_EXPLOSIVE),
                        Text.literal("Hehe, BamBOOM"), Text.literal("Bamboo goes BOOM"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_duk_tape", InventoryChangedCriterion.Conditions.items(Items_RaEx.DUK_TAPE))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(bambooExplosive)
                .build(consumer, RandomExtensions.MOD_ID + ":re/misc/duk_tape");

        AdvancementEntry strongBambooExplosive = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG),
                        Text.literal("Even bigger BOOM"), Text.literal("explosive_sound.mp4"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_strong_bamboo_explosive", InventoryChangedCriterion.Conditions.items(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(bambooExplosive)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/strong_bamboo_explosive");

        /// Fun with Explosives
        AdvancementEntry funWithExplosives = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.HOLY_HAND_GRENADE_ITEM),
                        Text.literal("Have Fun with ExPlOSiVeS"), Text.literal("Even more Boom Boom"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        true, true, true))
                .criterion("has_tnt", InventoryChangedCriterion.Conditions.items(Items.TNT))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:nine_v_battery"))
                        .addRecipe(new Identifier("randexten:holy_hand_grenade"))
                        .addRecipe(new Identifier("randexten:smoke_bomb"))
                        .addRecipe(new Identifier("randexten:glow_bomb"))
                        .addRecipe(new Identifier("randexten:land_mine"))
                        .addRecipe(new Identifier("randexten:strong_land_mine"))
                        .setExperience(20)
                )
                .parent(explosivesRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/fun_with_explosives");

        AdvancementEntry holyHandGrenade = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.HOLY_HAND_GRENADE_ITEM),
                        Text.literal("Big Boom"), Text.literal(""),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_holy_hand_grenade", InventoryChangedCriterion.Conditions.items(Items_RaEx.HOLY_HAND_GRENADE_ITEM))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(funWithExplosives)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/holy_hand_grenade");

        AdvancementEntry smokeBomb = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.SMOKE_BOMB_ITEM),
                        Text.literal("I cant see"), Text.literal("O-O"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_smoke_bomb", InventoryChangedCriterion.Conditions.items(Items_RaEx.SMOKE_BOMB_ITEM))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(funWithExplosives)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/smoke_bomb");

        AdvancementEntry nineVBattery = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Items_RaEx.NINE_V_BATTERY_ITEM),
                        Text.literal("Energising"), Text.literal("Lightning!!"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.GOAL,
                        true, true, true))
                .criterion("has_nine_v_battery", InventoryChangedCriterion.Conditions.items(Items_RaEx.NINE_V_BATTERY_ITEM))
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(funWithExplosives)
                .build(consumer, RandomExtensions.MOD_ID + ":re/explosives/nine_v_battery");

    }

    public void generateTreeAdvancement(Consumer<AdvancementEntry> consumer, AdvancementEntry mainRoot) {
        AdvancementEntry treeRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks.OAK_SAPLING),
                        Text.literal("New Trees"), Text.literal(""),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
                        false, false, true))
                .criterion("has_a_sapling", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(ItemTags.SAPLINGS)))
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(mainRoot)
                .build(consumer, RandomExtensions.MOD_ID + ":re/tree_advancements/burned_root");

        AdvancementEntry burnedRoot = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(Blocks_RaEx.BURNED_TREE_SAPLING),
                        Text.literal("In the Furnace with it"), Text.literal("Burn a Sapling"),
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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
                        Optional.of(new Identifier(RandomExtensions.MOD_ID, background)), AdvancementFrame.TASK,
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

    public void generateRecipes(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry switchRecipe = Advancement.Builder.create()
                .criterion("has_smooth_stone", InventoryChangedCriterion.Conditions.items(Blocks.SMOOTH_STONE))
                .rewards(AdvancementRewards.Builder.recipe(new Identifier("randexten:switch")))
                .build(consumer, RandomExtensions.MOD_ID + ":re/recipes/switch");
    }

}
