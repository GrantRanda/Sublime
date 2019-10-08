package gr.sublime.block;

import gr.sublime.Main;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.SoundType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.EnumPlantType;

public class BlockLilyBase extends BlockLilyPad {

    public BlockLilyBase(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        setHardness(0.0f);
        setSoundType(SoundType.PLANT);
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Water;
    }
}
