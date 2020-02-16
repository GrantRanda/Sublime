package gr.sublime.proxy;

import gr.sublime.block.BlockLeavesBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class CommonProxy {

    public void preInit() {
    }

    public void init() {
    }

    public void postInit() {
    }

    public void setGraphicsLevel(BlockLeavesBase block, boolean fancyEnabled) {
    }

    public void registerItemRenderer(Item item, int meta, String id) {

        // Set item model
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(item.getRegistryName(), id));
    }
}
