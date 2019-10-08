package gr.sublime.tileentity;

import gr.sublime.container.ContainerNiobiumChest;
import gr.sublime.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityNiobiumChest extends TileEntityLockableLoot implements ITickable {

    private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(54, ItemStack.EMPTY);
    public int numPlayersUsing;
    public int ticksSinceSync;
    public float lidAngle;
    public float prevLidAngle;

    @Override
    public int getSizeInventory() {
        return 54;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : chestContents) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return hasCustomName() ? customName : "container.niobium_chest";
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        chestContents = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);

        if (!checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, chestContents);
        }
        if (compound.hasKey("CustomName", 8)) {
            customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if (!checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, chestContents);
        }
        if (compound.hasKey("CustomName", 8)) {
            compound.setString("CustomName", customName);
        }

        return compound;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerNiobiumChest(playerInventory, this, playerIn);
    }

    @Override
    public String getGuiID() {
        return Reference.ID + ":niobium_chest";
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    public void update() {
        if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + pos.getX() + pos.getY() + pos.getZ()) % 200 == 0) {
            this.numPlayersUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double) ((float) pos.getX() - 5.0F), (double) ((float) pos.getY() - 5.0F), (double) ((float) pos.getZ() - 5.0F), (double) ((float) (pos.getX() + 1) + 5.0F), (double) ((float) (pos.getY() + 1) + 5.0F), (double) ((float) (pos.getZ() + 1) + 5.0F)))) {
                if (entityplayer.openContainer instanceof ContainerNiobiumChest) {
                    if (((ContainerNiobiumChest) entityplayer.openContainer).getChestInventory() == this) {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }

        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            double d1 = (double) pos.getX() + 0.5D;
            double d2 = (double) pos.getZ() + 0.5D;
            this.world.playSound((EntityPlayer) null, d1, (double) pos.getY() + 0.5D, d2, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float f2 = this.lidAngle;

            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            } else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < 0.5F && f2 >= 0.5F) {
                double d3 = (double) pos.getX() + 0.5D;
                double d0 = (double) pos.getZ() + 0.5D;
                this.world.playSound((EntityPlayer) null, d3, (double) pos.getY() + 0.5D, d0, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
        ++numPlayersUsing;
        world.addBlockEvent(pos, getBlockType(), 1, numPlayersUsing);
        world.notifyNeighborsOfStateChange(pos, getBlockType(), false);
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        --numPlayersUsing;
        world.addBlockEvent(pos, getBlockType(), 1, numPlayersUsing);
        world.notifyNeighborsOfStateChange(pos, getBlockType(), false);
    }
}
