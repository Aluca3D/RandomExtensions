package net.rand.exten.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.util.Arm;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.Items_RaEx;

public class SmokeBomb extends ThrownItemEntity {
    public SmokeBomb(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public SmokeBomb(LivingEntity livingEntity, World world) {
        super(Entities_RaEx.SMOKE_BOMB_PROJECTILE, livingEntity, world);
    }

    public SmokeBomb(World world, double x, double y, double z) {
        super(Entities_RaEx.SMOKE_BOMB_PROJECTILE, x, y, z, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return Items_RaEx.SMOKE_BOMB;
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

            AreaEffectCloudEntity x = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
            x.setRadius(6f);
            x.setDuration(400); // time in ticks
            x.addEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 60, 1, false, false));
            x.addEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 1, false, false));
            x.setParticleType(ParticleTypes.SMOKE);
            this.getWorld().spawnEntity(x);

            this.getWorld().sendEntityStatus(this, (byte) 3);

            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }
}