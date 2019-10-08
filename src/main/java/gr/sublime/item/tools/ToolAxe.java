package gr.sublime.item.tools;

import gr.sublime.Main;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe {

    public ToolAxe(String name, ToolMaterial material) {
        super(material, 9.0f, -3.0f);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}
