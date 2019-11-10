package gr.sublime.world.gen.feature;

import gr.sublime.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenLilyPad extends WorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (rand.nextInt(4) == 0)
            for (int i = 0; i < 1; ++i) {
                int j = position.getX() + rand.nextInt(8) - rand.nextInt(8);
                int k = position.getY() + rand.nextInt(4) - rand.nextInt(4);
                int l = position.getZ() + rand.nextInt(8) - rand.nextInt(8);

                if (worldIn.isAirBlock(new BlockPos(j, k, l)) && ModBlocks.LOTUS.canPlaceBlockAt(worldIn, new BlockPos(j, k, l))) {
                    worldIn.setBlockState(new BlockPos(j, k, l), ModBlocks.LOTUS.getDefaultState(), 2);
                }
            }

        return true;
    }
}
