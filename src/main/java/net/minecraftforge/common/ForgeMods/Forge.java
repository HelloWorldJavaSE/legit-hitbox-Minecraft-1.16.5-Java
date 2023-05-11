package net.minecraftforge.common.ForgeMods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Forge.MOD_ID)
public class Forge {

    // Directly reference a log4j logger.
    public static final String MOD_ID = "mods";
    private static final Logger LOGGER = LogManager.getLogger();

    public Forge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new Local());
    }
    }
