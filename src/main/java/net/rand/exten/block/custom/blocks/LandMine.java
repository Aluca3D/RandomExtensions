package net.rand.exten.block.custom.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LandMine extends Block {
    public LandMine(Settings settings) {
        super(settings);
    }

    //Todo Model and more

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {

        if (!world.isClient) {
            this.replaceBlock(world, pos);
            TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
            tntEntity.setInvisible(true);
            tntEntity.setNoGravity(true);
            tntEntity.setFuse(0);
            tntEntity.setPos(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(tntEntity);
        }

        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }


    public void replaceBlock(World world, BlockPos pos) {
        BlockState state = Blocks.AIR.getDefaultState();
        world.setBlockState(pos, state);
    }
}
