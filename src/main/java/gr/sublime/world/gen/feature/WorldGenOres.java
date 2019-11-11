package gr.sublime.world.gen.feature;

import gr.sublime.config.ModConfig;
import gr.sublime.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOres implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) { // Overworld
            BlockPos pos = new BlockPos(chunkX * 16, 63, chunkZ * 16);
            String currentBiome = world.getBiomeForCoordsBody(pos).getBiomeName();

            if (currentBiome.startsWith("Sublime")) {

                if (ModConfig.worldGenerationCat.oreGenIridium) {
                    generateOre(ModBlocks.IRIDIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 5, 16, 1 + random.nextInt(4), 6);
                }
                if (ModConfig.worldGenerationCat.oreGenTungsten) {
                    generateOre(ModBlocks.TUNGSTEN_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 8, 32, 3 + random.nextInt(3), 7);
                }
                if (ModConfig.worldGenerationCat.oreGenNiobium) {
                    generateOre(ModBlocks.NIOBIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 9);
                }
            }
        }
    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }
}
