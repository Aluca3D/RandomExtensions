package net.rand.exten.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;

public class Sounds_RaEx {

    public static final SoundEvent ROOMBA_AMBIENT = registerSoundEvent("roomba_ambient");
    public static final SoundEvent ROOMBA_HURT = registerSoundEvent("roomba_hurt");

    public static final SoundEvent NIGHTMARE_TV_AMBIENT = registerSoundEvent("nightmare_tv_ambient");
    public static final SoundEvent NIGHTMARE_TV_HURT = registerSoundEvent("nightmare_tv_hurt");

    public static final SoundEvent BOING = registerSoundEvent("boing");
    public static final SoundEvent ON_OFF = registerSoundEvent("on_off");
    public static final SoundEvent MAGIC_SHOT = registerSoundEvent("magic_shot");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(RandomExtensions.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        RandomExtensions.LOGGER.info("Registering Sounds for " + RandomExtensions.MOD_ID);
    }
}
