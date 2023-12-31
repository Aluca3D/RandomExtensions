package net.rand.exten.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;
import net.rand.exten.entity.explosives.ExplosionEntity;
import net.rand.exten.entity.mobs.custom.NightmareTVEntity;
import net.rand.exten.entity.mobs.custom.RoombaEntity;
import net.rand.exten.entity.projectile.*;

public class Entities_RaEx {

    /**Mobs*/
    public static final EntityType<NightmareTVEntity> NIGHTMARE_TV = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "nightmare_tv"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, NightmareTVEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 2f)).build());

    public static final EntityType<RoombaEntity> ROOMBA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "roomba"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, RoombaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.85f, 0.4f)).build());
    /**Projectiles*/
    public static final EntityType<BambooExplosive> THROWN_BAMBOO_EXPLOSIVE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "thrown_bamboo_explosive_projectile"),
            FabricEntityTypeBuilder.<BambooExplosive>create(SpawnGroup.MISC, BambooExplosive::new)
                    .dimensions(EntityDimensions.fixed(0.125f, 0.125f)).build());
    public static final EntityType<StrongBambooExplosive> THROWN_STRONG_BAMBOO_EXPLOSIVE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "thrown_strong_bamboo_explosive_projectile"),
            FabricEntityTypeBuilder.<StrongBambooExplosive>create(SpawnGroup.MISC, StrongBambooExplosive::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<StinkyCheese> STINKY_CHEESE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "stinky_cheese_projectile"),
            FabricEntityTypeBuilder.<StinkyCheese>create(SpawnGroup.MISC, StinkyCheese::new)
                    .dimensions(EntityDimensions.fixed(0.125f, 0.125f)).build());

    public static final EntityType<Pebble> PEBBLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "pebble_projectile"),
            FabricEntityTypeBuilder.<Pebble>create(SpawnGroup.MISC, Pebble::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<LeafBulled> LEAF_BULLED = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "leaf_bulled"),
            FabricEntityTypeBuilder.<LeafBulled>create(SpawnGroup.MISC, LeafBulled::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<SmokeBomb> SMOKE_BOMB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "smoke_bomb_projectile"),
            FabricEntityTypeBuilder.<SmokeBomb>create(SpawnGroup.MISC, SmokeBomb::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<GlowBomb> GLOW_BOMB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "glow_bomb_projectile"),
            FabricEntityTypeBuilder.<GlowBomb>create(SpawnGroup.MISC, GlowBomb::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<NineVBattery> NINE_V_BATTERY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "nine_v_battery_projectile"),
            FabricEntityTypeBuilder.<NineVBattery>create(SpawnGroup.MISC, NineVBattery::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<HolyHandGrenade> HOLY_HAND_GRENADE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "holy_hand_grenade_projectile"),
            FabricEntityTypeBuilder.<HolyHandGrenade>create(SpawnGroup.MISC, HolyHandGrenade::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
    /**Explosives*/
    public static final EntityType<ExplosionEntity> EXPLOSION_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RandomExtensions.MOD_ID, "explosion_entity"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ExplosionEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.2f)).build());

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(Entities_RaEx.NIGHTMARE_TV, NightmareTVEntity.createNightmareTVAttributes());
        FabricDefaultAttributeRegistry.register(Entities_RaEx.ROOMBA, RoombaEntity.createRoombaAttributes());
    }

    public static void registerModEntities() {
        RandomExtensions.LOGGER.info("Registering Entities for " + RandomExtensions.MOD_ID);
    }
}
