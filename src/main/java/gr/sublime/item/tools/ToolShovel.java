package gr.sublime.item.tools;

import gr.sublime.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ToolShovel extends ItemSpade {

    private Item repair;

    public ToolShovel(String name, ToolMaterial material, Item repair) {
        super(material);

        this.repair = repair;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == this.repair || super.getIsRepairable(toRepair, repair);
    }

}
