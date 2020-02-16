package gr.sublime.proxy;

import gr.sublime.block.BlockLeavesBase;
import gr.sublime.client.animation.RenderNiobiumChest;
import gr.sublime.init.ModBlockColors;
import gr.sublime.tileentity.TileEntityNiobiumChest;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNiobiumChest.class, new RenderNiobiumChest());
    }

    @Override
    public void init() {
        ModBlockColors.registerBlockColors();
    }

    @Override
    public void setGraphicsLevel(BlockLeavesBase block, boolean fancyEnabled) {
        block.setGraphicsLevel(fancyEnabled);
    }
}
