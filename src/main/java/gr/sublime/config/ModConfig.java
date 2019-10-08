package gr.sublime.config;

import gr.sublime.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.ID)
@LangKey("sublime.config.title")
public class ModConfig {

    @Config.LangKey("sublime.config.cat.terrain")
    @Config.Comment("Terrain Configuration")
    public static TerrainCat terrainCat = new TerrainCat();

    public static class TerrainCat {
        @Config.Name("Mutated Grass Spread")
        @Config.Comment("Controls Mutated Grass spreading")
        public boolean mutatedGrassSpread = true;
    }

    @Mod.EventBusSubscriber(modid = Reference.ID)
    public static class EventHandler {

        @SubscribeEvent
        public static void onConfigChangedEvent(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Reference.ID)) {
                ConfigManager.sync(Reference.ID, net.minecraftforge.common.config.Config.Type.INSTANCE);
            }
        }
    }
}
