package gr.sublime.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPlanksBase extends BlockBase {

    public BlockPlanksBase(String name) {
        super(Material.WOOD, name);

        setSoundType(SoundType.WOOD);
        setHardness(1.75f);
        setResistance(5.0f);
    }
}
