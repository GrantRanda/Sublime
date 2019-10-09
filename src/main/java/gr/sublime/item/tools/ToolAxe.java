package gr.sublime.item.tools;

import gr.sublime.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ToolAxe extends ItemAxe {

    private Item repair;

    public ToolAxe(String name, ToolMaterial material, Item repair) {
        super(material, 9.0f, -3.0f);

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
