package net.rand.exten.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.Items_RaEx;

public class NineVBattery extends ThrownItemEntity {
    public NineVBattery(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public NineVBattery(LivingEntity livingEntity, World world) {
        super(Entities_RaEx.NINE_V_BATTERY, livingEntity, world);
    }

    public NineVBattery(World world, double x, double y, double z) {
        super(Entities_RaEx.NINE_V_BATTERY, x, y, z, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return Items_RaEx.NINE_V_BATTERY_ITEM;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            for (int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08, ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 1f);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient()) {

            ServerWorld world = ((ServerWorld) this.getWorld());
            BlockPos position = this.getBlockPos();

            EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);

            this.getWorld().sendEntityStatus(this, (byte) 3);

            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }
}
