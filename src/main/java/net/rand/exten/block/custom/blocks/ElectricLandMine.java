package net.rand.exten.block.custom.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.entity.mobs.custom.ExplosionEntity;

public class ElectricLandMine extends LandMine{
    public ElectricLandMine(Settings settings) {
        super(settings);
    }

    @Override
    public void spawnExplosive(World world, BlockPos pos, Entity entity) {
        ExplosionEntity explosion = new ExplosionEntity(Entities_RaEx.EXPLOSION_ENTITY, world);
        explosion.setExplosionRadius(2);
        explosion.setFuse(0);
        explosion.setPos(pos.getX(), pos.getY(), pos.getZ());
        world.spawnEntity(explosion);

        ServerWorld serverWorld = ((ServerWorld) entity.getWorld());
        BlockPos position = entity.getBlockPos();

        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
    }
}
