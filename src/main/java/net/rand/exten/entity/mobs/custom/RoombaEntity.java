package net.rand.exten.entity.mobs.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.rand.exten.sound.Sounds_RaEx;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class RoombaEntity extends TameableEntity {
    static final Predicate<ItemEntity> PICKABLE_DROP_FILTER = item -> !item.cannotPickup() && item.isAlive();

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState sitAnimationState = new AnimationState();


    public RoombaEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(2, new PickupItemGoal());
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1.0, 10.0f, 2.0f, false));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1));
    }

    public static DefaultAttributeContainer.Builder createRoombaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                ;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(isInSittingPose()) {
            sitAnimationState.startIfNotRunning(this.age);
        } else {
            sitAnimationState.stop();
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setSitting(nbt.getBoolean("Sitting"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Sitting", this.isSitting());
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {

        if(hand == Hand.MAIN_HAND) {
            if (!this.isTamed()) {
                if (!this.getWorld().isClient()) {
                    this.playSound(Sounds_RaEx.ON_OFF, 1, 1);
                    super.setOwner(player);
                    this.navigation.recalculatePath();
                    this.setTarget(null);
                    this.getWorld().sendEntityStatus(this, (byte) 7);
                    setSitting(false);
                    setInSittingPose(false);
                }
                return ActionResult.SUCCESS;
            } else if (this.isTamed() && this.isOwner(player)) {
                boolean sitting = !isSitting();
                setSitting(sitting);
                setInSittingPose(sitting);
                this.playSound(Sounds_RaEx.ON_OFF, 1, 1);
                return ActionResult.SUCCESS;
            }
        }
        return super.interactMob(player, hand);
    }

    @Override
    public boolean canEquip(ItemStack stack) {
        EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(stack);
        if (!this.getEquippedStack(equipmentSlot).isEmpty()) {
            return false;
        }
        return equipmentSlot == EquipmentSlot.MAINHAND && super.canEquip(stack);
    }

    @Override
    public boolean canPickupItem(ItemStack stack) {
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.MAINHAND);
        return itemStack.isEmpty();
    }

    private void dropItem(ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), stack);
        this.getWorld().spawnEntity(itemEntity);
    }

    @Override
    protected void loot(ItemEntity item) {
        ItemStack itemStack = item.getStack();
        if (this.canPickupItem(itemStack)) {
            int i = itemStack.getCount();
            if (i > 1) {
                this.dropItem(itemStack.split(i - 1));
            }
            this.triggerItemPickedUpByEntityCriteria(item);
            this.equipStack(EquipmentSlot.MAINHAND, itemStack.split(1));
            this.updateDropChances(EquipmentSlot.MAINHAND);
            this.sendPickup(item, itemStack.getCount());
            item.discard();
        }
    }

    @Override
    protected void drop(DamageSource source) {
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.MAINHAND);
        if (!itemStack.isEmpty()) {
            this.dropStack(itemStack);
            this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        }
        super.drop(source);
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20.0);
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.3);
            this.setHealth(20.0f);
            this.setMovementSpeed(0.3f);
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20.0);
            this.setHealth(20.0f);
        } else {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(1.0);
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(0.0);
        }
    }

    boolean wantsToPickupItem() {
        return !this.isSleeping() && !this.isSitting();
    }

        @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
    }
    @Override
    public boolean canBreatheInWater() {
        return false;
    }

    @Nullable
    @Override
    public LivingEntity getOwner() {
        return super.getOwner();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return Sounds_RaEx.ROOMBA_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return Sounds_RaEx.ROOMBA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GENERIC_DEATH;
    }

    class PickupItemGoal extends Goal {
        public PickupItemGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            if (!RoombaEntity.this.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty()) {
                return false;
            }
            if (RoombaEntity.this.getTarget() != null || RoombaEntity.this.getAttacker() != null) {
                return false;
            }
            if (!RoombaEntity.this.wantsToPickupItem()) {
                return false;
            }
            if (RoombaEntity.this.getRandom().nextInt(RoombaEntity.PickupItemGoal.toGoalTicks(10)) != 0) {
                return false;
            }
            List<ItemEntity> list = RoombaEntity.this.getWorld().getEntitiesByClass(ItemEntity.class, RoombaEntity.this.getBoundingBox().expand(8.0, 8.0, 8.0), PICKABLE_DROP_FILTER);
            return !list.isEmpty() && RoombaEntity.this.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty();
        }

        @Override
        public void tick() {
            List<ItemEntity> list = RoombaEntity.this.getWorld().getEntitiesByClass(ItemEntity.class, RoombaEntity.this.getBoundingBox().expand(8.0, 8.0, 8.0), PICKABLE_DROP_FILTER);
            ItemStack itemStack = RoombaEntity.this.getEquippedStack(EquipmentSlot.MAINHAND);
            if (itemStack.isEmpty() && !list.isEmpty()) {
                RoombaEntity.this.getNavigation().startMovingTo(list.get(0), 1.2f);
            }
        }

        @Override
        public void start() {
            List<ItemEntity> list = RoombaEntity.this.getWorld().getEntitiesByClass(ItemEntity.class, RoombaEntity.this.getBoundingBox().expand(8.0, 8.0, 8.0), PICKABLE_DROP_FILTER);
            if (!list.isEmpty()) {
                RoombaEntity.this.getNavigation().startMovingTo(list.get(0), 1.2f);
            }
        }
    }
}
