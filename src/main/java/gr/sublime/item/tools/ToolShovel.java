package gr.sublime.item.tools;

import gr.sublime.Main;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade {

    public ToolShovel(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}
