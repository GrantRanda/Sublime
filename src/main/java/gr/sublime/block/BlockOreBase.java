package gr.sublime.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockOreBase extends BlockBase {

    public BlockOreBase(String name) {
        super(Material.ROCK, name);

        setSoundType(SoundType.STONE);
        setHardness(3.0f);
        setResistance(5.0f);
        setHarvestLevel("pickaxe", 2);
    }
}
