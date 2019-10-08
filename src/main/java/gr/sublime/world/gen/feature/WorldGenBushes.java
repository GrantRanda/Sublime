package gr.sublime.world.gen.feature;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBushes extends WorldGenerator {

    private IBlockState blockStateLeaves = ModBlocks.LEAVES_FALLEN.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public WorldGenBushes() {

    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 64; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos)
                    && (!worldIn.provider.isNether()
                    || blockpos.getY() < 255)
                    && (worldIn.getBlockState(position.down()).getBlock() == ModBlocks.MUTED_GRASS
                    || worldIn.getBlockState(position.down()).getBlock() == blockStateLeaves.getBlock())) {
                worldIn.setBlockState(position, blockStateLeaves, 2);
            }
        }

        return true;
    }
}
