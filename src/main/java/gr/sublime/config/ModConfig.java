package gr.sublime.config;

import gr.sublime.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.ID)
@LangKey("sublime.config.title")
public class ModConfig {

    @Config.LangKey("sublime.config.cat.world_generation")
    @Config.Comment("World Generation")
    public static WorldGenerationCat worldGenerationCat = new WorldGenerationCat();

    @Config.LangKey("sublime.config.cat.passive_mob_spawning")
    @Config.Comment("Passive Mob Spawning")
    public static PassiveMobSpawningCat passiveMobSpawningCat = new PassiveMobSpawningCat();

    @Config.LangKey("sublime.config.cat.hostile_mob_spawning")
    @Config.Comment("Hostile Mob Spawning")
    public static HostileMobSpawningCat hostileMobSpawningCat = new HostileMobSpawningCat();

    @Config.Name("Muted Grass Spread")
    @Config.Comment("Controls Muted Grass spreading")
    public static boolean mutedGrassSpread = true;

    @RequiresMcRestart
    @Config.Name("Custom Water Color")
    @Config.Comment("Controls Water color")
    public static boolean customWaterColor = true;

    @Config.Name("Tungsten Armor Effects")
    @Config.Comment("Controls Tungsten Armor potion effects")
    public static boolean tungstenArmorEffects = true;

    public static class WorldGenerationCat {
        @Config.Name("Ore Iridium")
        @Config.Comment("Controls Iridium Ore generation")
        public boolean oreGenIridium = true;

        @Config.Name("Ore Tungsten")
        @Config.Comment("Controls Tungsten Ore generation")
        public boolean oreGenTungsten = true;

        @Config.Name("Ore Niobium")
        @Config.Comment("Controls Niobium Ore generation")
        public boolean oreGenNiobium = true;

        @Config.Name("Tree Bloodless Elm")
        @Config.Comment("Controls Bloodless Elm Tree generation")
        public boolean treeGenBloodlessElm = true;

        @Config.Name("Tree Hanami")
        @Config.Comment("Controls Hanami Tree generation")
        public boolean treeGenHanami = true;

        @Config.Name("Tree Yedoensis")
        @Config.Comment("Controls Yedoensis Tree generation")
        public boolean treeGenYedoensis = true;

        @Config.Name("Fallen Leaves")
        @Config.Comment("Controls Fallen Leaves generation")
        public boolean genFallenLeaves = true;

        @Config.Name("Flower Astrantia")
        @Config.Comment("Controls Astrantia Flower generation")
        public boolean flowerGenAstrantia = true;

        @Config.Name("Flower Chrysanthemum")
        @Config.Comment("Controls Chrysanthemum Flower generation")
        public boolean flowerGenChrysanthemum = true;

        @Config.Name("Double Plant Eterisk")
        @Config.Comment("Controls Eterisk generation")
        public boolean doublePlantGenEterisk = true;

        @Config.Name("Calamagrostis")
        @Config.Comment("Controls Calamagrostis generation")
        public boolean genCalamagrostis = true;

        @Config.Name("Lotus")
        @Config.Comment("Controls Lotus generation")
        public boolean genLotus = true;

        @Config.Name("Tall Grass")
        @Config.Comment("Controls Tall Grass generation")
        public boolean genTallGrass = true;
    }

    public static class PassiveMobSpawningCat {
        @RequiresMcRestart
        @Config.Name("Sheep")
        @Config.Comment("Controls Sheep spawning")
        public boolean spawnSheep = true;

        @RequiresMcRestart
        @Config.Name("Cow")
        @Config.Comment("Controls Cow spawning")
        public boolean spawnCow = true;

        @RequiresMcRestart
        @Config.Name("Pig")
        @Config.Comment("Controls Pig spawning")
        public boolean spawnPig = true;

        @RequiresMcRestart
        @Config.Name("Horse")
        @Config.Comment("Controls Horse spawning")
        public boolean spawnHorse = true;

        @RequiresMcRestart
        @Config.Name("Donkey")
        @Config.Comment("Controls Donkey spawning")
        public boolean spawnDonkey = true;

        @RequiresMcRestart
        @Config.Name("Squid")
        @Config.Comment("Controls Squid spawning")
        public boolean spawnSquid = true;

        @RequiresMcRestart
        @Config.Name("Bat")
        @Config.Comment("Controls Bat spawning")
        public boolean spawnBat = true;
    }

    public static class HostileMobSpawningCat {
        @RequiresMcRestart
        @Config.Name("Spider")
        @Config.Comment("Controls Spider spawning")
        public boolean spawnSpider = true;

        @RequiresMcRestart
        @Config.Name("Zombie")
        @Config.Comment("Controls Zombie spawning")
        public boolean spawnZombie = true;

        @RequiresMcRestart
        @Config.Name("Zombie Villager")
        @Config.Comment("Controls Zombie Villager spawning")
        public boolean spawnZombieVillager = true;

        @RequiresMcRestart
        @Config.Name("Skeleton")
        @Config.Comment("Controls Skeleton spawning")
        public boolean spawnSkeleton = true;

        @RequiresMcRestart
        @Config.Name("Creeper")
        @Config.Comment("Controls Creeper spawning")
        public boolean spawnCreeper = true;

        @RequiresMcRestart
        @Config.Name("Slime")
        @Config.Comment("Controls Slime spawning")
        public boolean spawnSlime = true;

        @RequiresMcRestart
        @Config.Name("Enderman")
        @Config.Comment("Controls Enderman spawning")
        public boolean spawnEnderman = true;

        @RequiresMcRestart
        @Config.Name("Witch")
        @Config.Comment("Controls Witch spawning")
        public boolean spawnWitch = true;
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
