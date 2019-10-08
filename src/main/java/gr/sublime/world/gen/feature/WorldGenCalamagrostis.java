package gr.sublime.world.gen.feature;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenCalamagrostis extends WorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 20; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));

            if (worldIn.isAirBlock(blockpos)) {
                BlockPos blockpos1 = blockpos.down();

                if (worldIn.getBlockState(blockpos1.west()).getMaterial() == Material.WATER || worldIn.getBlockState(blockpos1.east()).getMaterial() == Material.WATER || worldIn.getBlockState(blockpos1.north()).getMaterial() == Material.WATER || worldIn.getBlockState(blockpos1.south()).getMaterial() == Material.WATER) {
                    int j = 2 + rand.nextInt(rand.nextInt(3) + 1);

                    for (int k = 0; k < j; ++k) {
                        if (ModBlocks.CALAMAGROSTIS.canBlockStay(worldIn, blockpos)) {
                            worldIn.setBlockState(blockpos.up(k), ModBlocks.CALAMAGROSTIS.getDefaultState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }
}
