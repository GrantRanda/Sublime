package gr.sublime.block;

import gr.sublime.Main;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockFenceBase extends BlockFence {

    public BlockFenceBase(Material material, String name) {
        super(material, MapColor.WOOD);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.WOOD);
    }
}
