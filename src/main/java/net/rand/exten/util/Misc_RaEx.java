package net.rand.exten.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.rand.exten.block.Blocks_RaEx;
import net.rand.exten.entity.projectile.*;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.mixin.BrewingRecipeRegistryMixin;
import net.rand.exten.effects.Potions_RaEx;

public class Misc_RaEx {
    public static void registerMisc() {
        registerFuel();
        registerBehavior();
        registerStrippable();
        registerFlammable();
        registerPotionRecipes();
    }

    private static void registerFuel() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        // Burned Wood
        registry.add(Blocks_RaEx.BURNED_PLANKS, 450);
        registry.add(Blocks_RaEx.BURNED_STAIRS, 450);
        registry.add(Blocks_RaEx.BURNED_SLABS, 450);
        registry.add(Blocks_RaEx.BURNED_FENCE, 450);
        registry.add(Blocks_RaEx.BURNED_GATE, 450);
        registry.add(Blocks_RaEx.BURNED_BUTTON, 450);
        registry.add(Blocks_RaEx.BURNED_DOOR, 450);
        registry.add(Blocks_RaEx.BURNED_TRAPDOOR, 450);
        registry.add(Blocks_RaEx.BURNED_PRESSURE_PLATE, 450);
        registry.add(Blocks_RaEx.BURNED_LOG, 450);
        registry.add(Blocks_RaEx.STRIPPED_BURNED_LOG, 450);
        registry.add(Blocks_RaEx.BURNED_WOOD, 450);
        registry.add(Blocks_RaEx.STRIPPED_BURNED_WOOD, 450);
        registry.add(Blocks_RaEx.BURNED_TREE_SAPLING, 150);

        registry.add(Items_RaEx.SOUL, 22000);
        registry.add(Blocks_RaEx.CHARCOAL_BLOCK, 16000);
    }

    private static void registerBehavior() {
        // DispenserBlock
        DispenserBlock.registerBehavior(Items_RaEx.BAMBOO_EXPLOSIVE, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new BambooExplosive(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.BAMBOO_EXPLOSIVE_STRONG, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new StrongBambooExplosive(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.STINKY_CHEESE, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new StinkyCheese(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.PEBBLE, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new Pebble(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.SMOKE_BOMB_ITEM, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new SmokeBomb(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.GLOW_BOMB_ITEM, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new GlowBomb(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.NINE_V_BATTERY_ITEM, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new NineVBattery(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });
        DispenserBlock.registerBehavior(Items_RaEx.HOLY_HAND_GRENADE_ITEM, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new HolyHandGrenade(world, position.getX(), position.getY(), position.getZ()), (entity) -> {
                    entity.setItem(stack);
                });
            }
        });

        // CauldronBehavior
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items_RaEx.FLOUR, (state, world, pos, player, hand, stack) -> {
            if (!stack.isOf(Items_RaEx.FLOUR)) {
                return ActionResult.PASS;
            } else {
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(Items_RaEx.DOUGH, stack.getCount()).copyWithCount(1);
                    if (!player.getAbilities().creativeMode) {
                        stack.decrement(1);
                    }
                    if (stack.isEmpty()) {
                        player.setStackInHand(hand, itemStack);
                    } else if (player.getInventory().insertStack(itemStack)) {
                        player.playerScreenHandler.syncState();
                    } else {
                        player.dropItem(itemStack, false);
                    }

                    LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                }

                return ActionResult.success(world.isClient);
            }
        });
    }

    private static void registerFlammable() {
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_LOG, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.STRIPPED_BURNED_LOG, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_WOOD, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.STRIPPED_BURNED_WOOD, 10, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_PLANKS, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_TRAPDOOR, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_DOOR, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_GATE, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_FENCE, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_PRESSURE_PLATE, 5, 3);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.BURNED_BUTTON, 5, 3);

        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.CHARCOAL_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Blocks_RaEx.FAKE_LEAVES, 100, 100);
    }

    private static void registerStrippable() {
        StrippableBlockRegistry.register(Blocks_RaEx.BURNED_LOG, Blocks_RaEx.STRIPPED_BURNED_LOG);
        StrippableBlockRegistry.register(Blocks_RaEx.BURNED_WOOD, Blocks_RaEx.STRIPPED_BURNED_WOOD);

        StrippableBlockRegistry.register(Blocks_RaEx.PURPUR_LOG, Blocks_RaEx.STRIPPED_PURPUR_LOG);
        StrippableBlockRegistry.register(Blocks_RaEx.PURPUR_WOOD, Blocks_RaEx.STRIPPED_PURPUR_WOOD);
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items_RaEx.METAL_LUMP, Potions_RaEx.LIGHTNING_ATTRACTION_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items_RaEx.TOOTH, Potions_RaEx.EVOKERS_BITE_POTION);
    }
}
