package gr.sublime.world.gen.structure;

import gr.sublime.config.ModConfig;
import gr.sublime.init.ModBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenStructures implements IWorldGenerator {

    private StructureGenerator structureHut1;
    private StructureGenerator structureWatchtower;
    private StructureGenerator structureGazebo;

    public WorldGenStructures() {
        structureHut1 = new StructureGenerator("hut_1", 3);
        structureWatchtower = new StructureGenerator("watchtower", 2);
        structureGazebo = new StructureGenerator("gazebo", 2);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (ModConfig.worldGenerationCat.genStructures
                && world.getWorldInfo().isMapFeaturesEnabled()
                && world.getWorldType() != WorldType.FLAT) {

            int blockX = chunkX * 16 + 12;
            int blockZ = chunkZ * 16 + 12;

            switch (world.provider.getDimension()) {
                case 0:
                    generateStructure(structureWatchtower, world, blockX, blockZ, 25, random);
                    generateStructure(structureGazebo, world, blockX, blockZ, 25, random);
                    generateStructure(structureHut1, world, blockX, blockZ, 25, random);
                case -1:
                case 1:
                    break;
            }
        }
    }

    private void generateStructure(StructureGenerator structure, World world, int blockX, int blockZ, int chance, Random random) {
        BlockPos pos = new BlockPos(blockX, structure.getGroundHeight(world, blockX, blockZ) + 1, blockZ);

        if (world.provider.getBiomeForCoords(pos) == ModBiomes.SUBLIME
                && random.nextInt(chance) == 0) {

            structure.generate(world, random, pos);
        }
    }
}
