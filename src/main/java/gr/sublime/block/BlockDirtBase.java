package gr.sublime.block;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BlockDirtBase extends BlockBase {

    public BlockDirtBase(String name) {
        super(Material.GROUND, name);
        setHardness(0.4f);
        setResistance(2.0f);
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        return ModBlocks.MUTED_GRASS.canSustainPlant(state, world, pos, direction, plantable);
    }
}
