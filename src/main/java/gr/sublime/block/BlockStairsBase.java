package gr.sublime.block;

import gr.sublime.Main;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockStairsBase extends BlockStairs {

    public BlockStairsBase(IBlockState modelState, String name) {
        super(modelState);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        this.useNeighborBrightness = true;
    }
}
