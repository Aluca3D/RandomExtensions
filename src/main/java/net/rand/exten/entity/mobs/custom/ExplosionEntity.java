package net.rand.exten.entity.mobs.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class ExplosionEntity extends Entity {
    private static final TrackedData<Integer> FUSE = DataTracker.registerData(ExplosionEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> EXPLOSION_RADIUS = DataTracker.registerData(ExplosionEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public ExplosionEntity(EntityType<? extends ExplosionEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(FUSE, 0);
        this.dataTracker.startTracking(EXPLOSION_RADIUS, 4);
    }

    @Override
    protected Entity.MoveEffect getMoveEffect() {
        return Entity.MoveEffect.NONE;
    }

    @Override
    public boolean canHit() {
        return !this.isRemoved();
    }

    @Override
    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
        }
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98));
        if (this.isOnGround()) {
            this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
        }
        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.getWorld().isClient) {
                this.explode();
            }
        } else {
            this.updateWaterState();
            if (this.getWorld().isClient) {
                this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    private void explode() {
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), this.getExplosionRadius(), World.ExplosionSourceType.TNT);
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short) this.getFuse());
        nbt.putByte("ExplosionRadius", (byte) this.getExplosionRadius());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Fuse", NbtElement.NUMBER_TYPE)) {
            this.setFuse(nbt.getShort("Fuse"));
        }
        if (nbt.contains("ExplosionRadius", NbtElement.NUMBER_TYPE)) {
            this.setExplosionRadius(nbt.getByte("ExplosionRadius"));
        }
    }

    @Override
    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15f;
    }

    public void setFuse(int fuse) {
        this.dataTracker.set(FUSE, fuse);
    }

    public void setExplosionRadius(int radius) {
        this.dataTracker.set(EXPLOSION_RADIUS, radius);
    }

    public int getFuse() {
        return this.dataTracker.get(FUSE);
    }

    public int getExplosionRadius() {
        return this.dataTracker.get(EXPLOSION_RADIUS);
    }

}
