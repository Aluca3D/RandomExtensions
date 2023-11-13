package net.rand.exten.block.custom.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;

public class BlockEntity_RaEx {

    public static void registerBlockEntities() {
        RandomExtensions.LOGGER.info("Registering Block Entities for " + RandomExtensions.MOD_ID);
    }    public static final BlockEntityType<GrinderEntity> GRINDER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(RandomExtensions.MOD_ID, "grinder_be"),
                    FabricBlockEntityTypeBuilder.create(GrinderEntity::new,
                            Blocks_RaEx.GRINDER).build(null));


}