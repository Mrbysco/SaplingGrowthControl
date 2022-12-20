package com.lothrazar.growthcontrols;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.growthcontrols.config.ConfigHandler;
import com.lothrazar.growthcontrols.item.ItemGrow;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ModGrowthCtrl.MODID)
public class ModGrowthCtrl {

  public static final String MODID = "growthcontrols";
  public static ConfigHandler CONFIG;
  public static final Logger LOGGER = LogManager.getLogger();

  public ModGrowthCtrl() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    RegistryEvents.ITEMS.register(eventBus);

    MinecraftForge.EVENT_BUS.register(new GrowEvents());
    CONFIG = new ConfigHandler(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
    //TODO: remake whole thing with biome tags
  }

  public static class RegistryEvents {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModGrowthCtrl.MODID);
    public static final RegistryObject<Item> GROWTH_DETECTOR = ITEMS.register("growth_detector", () -> new ItemGrow(new Item.Properties()));
  }
}
