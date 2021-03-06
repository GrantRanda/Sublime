package gr.sublime.init;

import gr.sublime.world.gen.feature.WorldGenOres;
import gr.sublime.world.gen.structure.WorldGenStructures;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGen {

    public static final String SUBLIME_NAME = "sublime";

    public static void registerWorldGenerators() {
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenStructures(), 0);
    }
}
