package net.rand.exten.entity.projectile;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.Items_RaEx;
import net.rand.exten.util.tools.Math_RaEx;

public class HolyHandGrenade extends ThrownItemEntity {
    public HolyHandGrenade(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public HolyHandGrenade(LivingEntity livingEntity, World world) {
        super(Entities_RaEx.HOLY_HAND_GRENADE, livingEntity, world);
    }

    public HolyHandGrenade(World world, double x, double y, double z) {
        super(Entities_RaEx.HOLY_HAND_GRENADE, x, y, z, world);
    }


    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return Items_RaEx.HOLY_HAND_GRENADE_ITEM;
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
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient()) {
            Math_RaEx m = new Math_RaEx();
            int r1 = m.randomInt(2);
            int r2 = m.randomInt(2);

            ServerWorld world = ((ServerWorld) this.getWorld());
            BlockPos positionN = this.getBlockPos().north(r1);
            BlockPos positionS = this.getBlockPos().south(r2);
            BlockPos positionW = this.getBlockPos().west(r1);
            BlockPos positionE = this.getBlockPos().east(r2);

            EntityType.LIGHTNING_BOLT.spawn(world, positionN, SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, positionS, SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, positionW, SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, positionE, SpawnReason.TRIGGERED);

            this.getWorld().sendEntityStatus(this, (byte) 3);

            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.getWorld().createExplosion(this, getX(), getY(), getZ(), 4, World.ExplosionSourceType.NONE);
            this.discard();
        }
    }
}
