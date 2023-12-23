package net.rand.exten.block.custom.blocks.explosives;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.entity.Entities_RaEx;
import net.rand.exten.entity.explosives.ExplosionEntity;

public class LandMine extends StrongLandMine {
    public LandMine(Settings settings) {
        super(settings);
    }

    @Override
    public void spawnExplosive(World world, BlockPos pos, Entity entity) {
        ExplosionEntity explosion = new ExplosionEntity(Entities_RaEx.EXPLOSION_ENTITY, world);
        explosion.setExplosionRadius(2);
        explosion.setFuse(0);
        explosion.setPos((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5);
        world.spawnEntity(explosion);
    }
}
