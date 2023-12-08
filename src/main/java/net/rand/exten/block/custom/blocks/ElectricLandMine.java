package net.rand.exten.block.custom.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElectricLandMine extends LandMine{
    public ElectricLandMine(Settings settings) {
        super(settings);
    }

    @Override
    public void spawnExplosive(World world, BlockPos pos, Entity entity) {
        super.spawnExplosive(world, pos, entity);

        ServerWorld serverWorld = ((ServerWorld) entity.getWorld());
        BlockPos position = entity.getBlockPos();

        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
    }
}
