package gr.sublime.item.armor;

import gr.sublime.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorTungsten extends ArmorBase {

    public ArmorTungsten(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, ModItems.ARMOR_TUNGSTEN, renderIndexIn, equipmentSlotIn, ModItems.TUNGSTEN_INGOT);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 2, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 2, 0, false, false));
    }
}
