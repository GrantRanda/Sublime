package gr.sublime.block;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockLeavesBloodlessElm extends BlockLeavesBase {

    public BlockLeavesBloodlessElm(String name) {
        super(name);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.SAPLING_BLOODLESS_ELM);
    }
}
