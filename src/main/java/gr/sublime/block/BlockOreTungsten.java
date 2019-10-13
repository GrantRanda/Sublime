package gr.sublime.block;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOreTungsten extends BlockOreBase {

    public BlockOreTungsten(String name) {
        super(name);

        setHarvestLevel("pickaxe", 3);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.TUNGSTEN_ORE);
    }
}
