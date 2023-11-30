package net.rand.exten.block.custom.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BarbedWire extends Block {
    public BarbedWire(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
        if (!entity.bypassesSteppingEffects()) {
            entity.damage(world.getDamageSources().generic(), 1.0f);
        }
        
    }
}
