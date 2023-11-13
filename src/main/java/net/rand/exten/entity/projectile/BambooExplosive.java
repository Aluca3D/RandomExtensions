package net.rand.exten.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.item.Items_RaEx;

public class BambooExplosive extends ThrownItemEntity {

    public BambooExplosive(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BambooExplosive(LivingEntity livingEntity, World world) {
        super(Entities_RaEx.THROWN_BAMBOO_EXPLOSIVE_PROJECTILE, livingEntity, world);
    }

    public BambooExplosive(World world, double x, double y, double z) {
        super(Entities_RaEx.THROWN_BAMBOO_EXPLOSIVE_PROJECTILE, x, y, z, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return Items_RaEx.BAMBOO_EXPLOSIVE;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte) 3);

            this.getWorld().createExplosion(this, getX(), getY(), getZ(), 3, World.ExplosionSourceType.NONE);

            this.discard();
        }
    }
}
