package gr.sublime.block;

import gr.sublime.Main;
import gr.sublime.init.ModBlocks;
import gr.sublime.init.ModItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDoorBase extends BlockDoor {

    public BlockDoorBase(Material material, String name) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        setHardness(3.0f);
        setSoundType(SoundType.WOOD);

        disableStats();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : getItem();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return getItem() != null ? new ItemStack(getItem()) : ItemStack.EMPTY;
    }

    private Item getItem() {
        if (this == ModBlocks.DOOR_BLOODLESS_ELM) {
            return ModItems.DOOR_BLOODLESS_ELM;
        }
        if (this == ModBlocks.DOOR_HANAMI) {
            return ModItems.DOOR_HANAMI;
        }
        if (this == ModBlocks.DOOR_YEDOENSIS) {
            return ModItems.DOOR_YEDOENSIS;
        }
        return null;
    }
}
