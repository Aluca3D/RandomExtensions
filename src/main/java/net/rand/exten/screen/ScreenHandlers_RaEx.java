package net.rand.exten.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;

public class ScreenHandlers_RaEx {


    public static final ScreenHandlerType<GrinderScreenHandler> GRINDER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(RandomExtensions.MOD_ID, "grinder_screen_handler"),
                    new ScreenHandlerType<>(GrinderScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    public static void registerScreenHandler() {
        RandomExtensions.LOGGER.info("Registering Screen Handlers for " + RandomExtensions.MOD_ID);
    }
}
