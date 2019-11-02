package gr.sublime.world.gen.feature;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class WorldGenTreeHanami extends WorldGenTreeBase {

    public WorldGenTreeHanami(boolean parShouldNotify) {
        super(parShouldNotify);

        setMinTreeHeight(14);
        setBlockStateLeaves(ModBlocks.LEAVES_HANAMI.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)));
        setBlockStateWood(ModBlocks.LOG_HANAMI.getDefaultState());
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos) {
        int minHeight = parRandom.nextInt(3) + minTreeHeight;

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight()) {
            if (!isSuitableLocation(parWorld, parBlockPos, minHeight)) {
                return false;
            } else {
                IBlockState state = parWorld.getBlockState(parBlockPos.down());

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1) {
                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
                    generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
                    generateTrunk(parWorld, parBlockPos, minHeight);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    protected void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom) {
        for (int foliageY = parBlockPos.getY() - 3 + height; foliageY <= parBlockPos.getY() + height; ++foliageY) {
            int foliageLayer = foliageY - (parBlockPos.getY() + height); // b1

            int foliageLayerRadius1 = 1 - foliageLayer / 2; // b2
            int foliageLayerRadius2 = 1 - foliageLayer / 4;
            int foliageLayerRadius3 = 1 - foliageLayer / 4;

            generateFoliageLayer(parWorld, parBlockPos, foliageLayerRadius1, foliageLayer, foliageY, 0, parRandom);
            generateFoliageLayer(parWorld, parBlockPos, foliageLayerRadius2, foliageLayer, foliageY, 0, parRandom);

            if (foliageY < parBlockPos.getY() - 3 + height + 2) {
                generateFoliageLayer(parWorld, parBlockPos, foliageLayerRadius3, foliageLayer, foliageY, -0.15 * height, parRandom);
            }
        }
    }

    private void generateFoliageLayer(World worldIn, BlockPos pos, int radius, int foliageLayer, int foliageY, double foliageYOffset, Random random) {

        for (int foliageX = pos.getX() - radius; foliageX <= pos.getX() + radius; ++foliageX) {
            int foliageRelativeX = foliageX - pos.getX(); // b3

            for (int foliageZ = pos.getZ() - radius; foliageZ <= pos.getZ() + radius; ++foliageZ) {
                int foliageRelativeZ = foliageZ - pos.getZ();

                // Fill in layer with some randomness
                if (Math.abs(foliageRelativeX) != radius || Math.abs(foliageRelativeZ) != radius || random.nextInt(2) != 0 && foliageLayer != 0) {
                    BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                    IBlockState state = worldIn.getBlockState(blockPos);

                    if (state.getBlock().isAir(state, worldIn, blockPos) || state.getBlock().isLeaves(state, worldIn, blockPos)) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(0, foliageYOffset, 0), blockStateLeaves);
                    }
                }
            }
        }
    }
}
