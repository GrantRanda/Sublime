package gr.sublime;

import gr.sublime.client.SublimeTab;
import gr.sublime.client.animation.RenderNiobiumChest;
import gr.sublime.client.gui.GuiHandler;
import gr.sublime.init.ModBiomes;
import gr.sublime.init.ModBlockColors;
import gr.sublime.init.ModBlocks;
import gr.sublime.init.ModItems;
import gr.sublime.init.ModRecipes;
import gr.sublime.init.ModTileEntities;
import gr.sublime.init.ModWorldGen;
import gr.sublime.proxy.CommonProxy;
import gr.sublime.tileentity.TileEntityNiobiumChest;
import gr.sublime.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.ID,
        name = Reference.NAME,
        version = Reference.VERSION,
        useMetadata = true
)
public class Main {

    public static final SublimeTab creativeTab = new SublimeTab();

    @SidedProxy(clientSide = "gr.sublime.proxy.ClientProxy",
            serverSide = "gr.sublime.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Main instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.log(Level.INFO, Reference.NAME + " is loading!");

        ConfigManager.sync(Reference.ID, Config.Type.INSTANCE);

        ModBiomes.registerBiomes();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        ModWorldGen.registerWorldGenerators();
        ModBlockColors.registerBlockColors();
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
            ModTileEntities.register();

            ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNiobiumChest.class, new RenderNiobiumChest());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }
}
