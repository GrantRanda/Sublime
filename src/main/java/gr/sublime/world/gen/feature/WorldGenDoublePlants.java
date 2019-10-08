package gr.sublime.world.gen.feature;

import gr.sublime.block.BlockDoublePlantBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenDoublePlants extends WorldGenerator {

    private BlockDoublePlantBase plant;

    public void setPlant(BlockDoublePlantBase plant) {
        this.plant = plant;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        boolean flag = false;

        for (int i = 0; i < 32; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 254) && plant.canPlaceBlockAt(worldIn, blockpos)) {
                plant.placeAt(worldIn, blockpos, plant.getType(worldIn, blockpos, plant.getDefaultState()), 2);
                flag = true;
            }
        }

        return flag;
    }
}
