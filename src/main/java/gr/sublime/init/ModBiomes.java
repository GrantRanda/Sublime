package gr.sublime.init;

import gr.sublime.config.ModConfig;
import gr.sublime.util.Reference;
import gr.sublime.world.biome.BiomeBase;
import gr.sublime.world.biome.BiomeSublime;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.ID)
public class ModBiomes {
    public static final BiomeBase SUBLIME = new BiomeSublime(new Biome.BiomeProperties("Sublime")
            .setWaterColor(ModConfig.customWaterColor ? 0x59FF3E : 16777215)
            .setBaseHeight(-0.3f)
            .setHeightVariation(0.6f)
            .setTemperature(0.6f));

    public static void registerBiomes() {
        initBiome(SUBLIME, ModWorldGen.SUBLIME_NAME, BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);

        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));

        return biome;
    }
}