package gr.sublime.client;

import gr.sublime.init.ModItems;
import gr.sublime.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SublimeTab extends CreativeTabs {

    public SublimeTab() {
        super(Reference.ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.IRIDIUM);
    }
}
