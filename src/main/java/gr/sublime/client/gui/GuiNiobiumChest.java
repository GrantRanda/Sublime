package gr.sublime.client.gui;

import gr.sublime.container.ContainerNiobiumChest;
import gr.sublime.tileentity.TileEntityNiobiumChest;
import gr.sublime.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiNiobiumChest extends GuiContainer {

    private static final int WIDTH = 176;
    private static final int HEIGHT = 220;
    private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.ID, "textures/gui/container/niobium_chest.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityNiobiumChest te;

    public GuiNiobiumChest(InventoryPlayer playerInventory, TileEntityNiobiumChest chestInventory, EntityPlayer player) {
        super(new ContainerNiobiumChest(playerInventory, chestInventory, player));
        this.playerInventory = playerInventory;
        this.te = chestInventory;

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 0);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 0);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
