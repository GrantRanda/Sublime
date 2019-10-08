package gr.sublime.block;

import gr.sublime.Main;
import gr.sublime.config.ModConfig;
import gr.sublime.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BlockMutedGrass extends BlockGrass {

    public BlockMutedGrass(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
        setSoundType(SoundType.PLANT);
        setHardness(0.5f);
        setHarvestLevel("shovel", 0);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.LIGHT_BLUE;
    }


    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (!worldIn.isAreaLoaded(pos, 3)) return;
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getBlock().getLightOpacity(worldIn.getBlockState(pos.up()), worldIn, pos.up()) > 2)
                worldIn.setBlockState(pos, ModBlocks.MUTED_DIRT.getDefaultState());
            else
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    Block block = worldIn.getBlockState(blockpos.up()).getBlock();
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);

                    if ((iblockstate.getBlock() == Blocks.GRASS && ModConfig.terrainCat.mutatedGrassSpread || iblockstate.getBlock() == ModBlocks.MUTED_DIRT || iblockstate.getBlock() == Blocks.DIRT && iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && ModConfig.terrainCat.mutatedGrassSpread) && block.getLightOpacity(worldIn.getBlockState(blockpos.up()), worldIn, blockpos.up()) <= 2)
                        worldIn.setBlockState(blockpos, ModBlocks.MUTED_GRASS.getDefaultState());
                    else if (ModConfig.terrainCat.mutatedGrassSpread && iblockstate.getBlock() == Blocks.DIRT && iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && worldIn.isSideSolid(blockpos, EnumFacing.UP) && !worldIn.getBlockState(blockpos.up()).getMaterial().isLiquid())
                        worldIn.setBlockState(blockpos, ModBlocks.MUTED_DIRT.getDefaultState());
                }
        }
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        boolean hasWater = world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.south()).getMaterial() == Material.WATER;
        return plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Plains ||
                plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Beach && hasWater;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
        return ModBlocks.MUTED_DIRT.getItemDropped(state, par2Random, par3);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        BlockPos blockpos = pos.up();

        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    if (worldIn.isAirBlock(blockpos1))
                        if (rand.nextInt(8) == 0)
                            worldIn.getBiome(blockpos1).plantFlower(worldIn, rand, blockpos1);
                        else {
                            IBlockState iblockstate1 = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);

                            if (Blocks.TALLGRASS.canBlockStay(worldIn, blockpos1, iblockstate1))
                                worldIn.setBlockState(blockpos1, iblockstate1, 3);
                        }

                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

                if (worldIn.getBlockState(blockpos1.down()).getBlock() != ModBlocks.MUTED_GRASS || worldIn.getBlockState(blockpos1).isNormalCube())
                    break;

                ++j;
            }
        }
    }
}
