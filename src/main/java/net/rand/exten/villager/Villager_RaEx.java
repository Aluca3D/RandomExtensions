package net.rand.exten.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.rand.exten.RandomExtensions;
import net.rand.exten.block.Blocks_RaEx;

public class Villager_RaEx {
    public static final RegistryKey<PointOfInterestType> CHEESE_POI_KEY = poiKey("cheesepoi");
    public static final PointOfInterestType CHEESE_POI = registerPoi("cheesepoi", Blocks_RaEx.CHEESE_STATION);

    public static final VillagerProfession CHEESE_MAKER = registerProfession("cheese_maker", CHEESE_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(RandomExtensions.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(RandomExtensions.MOD_ID, name), 1,1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(RandomExtensions.MOD_ID, name));
    }

    public static void registerVillager() {
        RandomExtensions.LOGGER.info("Registering Villagers " + RandomExtensions.MOD_ID);
    }
}
