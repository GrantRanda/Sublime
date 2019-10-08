package gr.sublime.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockOreBase extends BlockBase {

    public BlockOreBase(String name) {
        super(Material.ROCK, name);

        setSoundType(SoundType.METAL);
        setHardness(3f);
        setResistance(5f);
        setHarvestLevel("pickaxe", 2);
    }
}
