package gr.sublime.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockThatch extends BlockBase {

    public BlockThatch(String name) {
        super(Material.PLANTS, name);

        setSoundType(SoundType.PLANT);
        setHardness(0.8f);
    }
}
