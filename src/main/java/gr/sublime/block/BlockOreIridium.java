package gr.sublime.block;

import gr.sublime.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOreIridium extends BlockOreBase {

    public BlockOreIridium(String name) {
        super(name);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.IRIDIUM;
    }
}
