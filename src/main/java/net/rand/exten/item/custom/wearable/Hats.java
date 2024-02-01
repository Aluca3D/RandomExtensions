package net.rand.exten.item.custom.wearable;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public abstract class Hats extends Item implements Equipment {
    public static final DispenserBehavior DISPENSER_BEHAVIOR = new ItemDispenserBehavior() {
        @Override
        protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
            return Hats.dispenseArmor(pointer, stack) ? stack : super.dispenseSilently(pointer, stack);
        }
    };

    public static boolean dispenseArmor(BlockPointer pointer, ItemStack armor) {
        BlockPos blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
        List<Entity> list = pointer.world().getEntitiesByClass(Entity.class, new Box(blockPos), EntityPredicates.EXCEPT_SPECTATOR.and(new EntityPredicates.Equipable(armor)));
        if (list.isEmpty()) {
            return false;
        }
        LivingEntity livingEntity = (LivingEntity) list.get(0);
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(armor);
        ItemStack itemStack = armor.split(1);
        livingEntity.equipStack(equipmentSlot, itemStack);
        if (livingEntity instanceof MobEntity) {
            ((MobEntity) livingEntity).setEquipmentDropChance(equipmentSlot, 2.0f);
            ((MobEntity) livingEntity).setPersistent();
        }
        return true;
    }

    public Hats(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, DISPENSER_BEHAVIOR);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player && wearsHat(player)) {
                SpecialAbility(player, stack, world);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public abstract void SpecialAbility(PlayerEntity user, ItemStack stack, World world);

    private boolean wearsHat(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        return !helmet.isEmpty();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return this.equipAndSwap(this, world, user, hand);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}
