package gr.sublime.client.gui;

import gr.sublime.container.ContainerNiobiumChest;
import gr.sublime.tileentity.TileEntityNiobiumChest;
import gr.sublime.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == Reference.GUI_NIOBIUM_CHEST)
            return new ContainerNiobiumChest(player.inventory, (TileEntityNiobiumChest) world.getTileEntity(new BlockPos(x, y, z)), player);

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == Reference.GUI_NIOBIUM_CHEST)
            return new GuiNiobiumChest(player.inventory, (TileEntityNiobiumChest) world.getTileEntity(new BlockPos(x, y, z)), player);

        return null;
    }
}
