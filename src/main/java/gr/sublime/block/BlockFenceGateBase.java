package gr.sublime.block;

import gr.sublime.Main;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;

public class BlockFenceGateBase extends BlockFenceGate {

    public BlockFenceGateBase(String name) {
        super(EnumType.OAK);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.WOOD);
    }
}
