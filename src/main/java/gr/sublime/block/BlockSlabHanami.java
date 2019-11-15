package gr.sublime.block;

import gr.sublime.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public abstract class BlockSlabHanami extends BlockSlabBase {

    public BlockSlabHanami(String name) {
        super(name);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.SLAB_HANAMI);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(ModBlocks.SLAB_HANAMI, 1);
    }

    public static class Double extends BlockSlabHanami {

        public Double(String name) {
            super(name);
        }

        @Override
        public boolean isDouble() {
            return true;
        }
    }

    public static class Half extends BlockSlabHanami {

        public Half(String name) {
            super(name);
        }

        @Override
        public boolean isDouble() {
            return false;
        }
    }
}
