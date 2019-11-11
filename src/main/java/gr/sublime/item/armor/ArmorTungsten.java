package gr.sublime.item.armor;

import gr.sublime.config.ModConfig;
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
        if (ModConfig.tungstenArmorEffects
                && player.inventory.armorInventory.get(0).getItem().equals(ModItems.TUNGSTEN_BOOTS)
                && player.inventory.armorInventory.get(1).getItem().equals(ModItems.TUNGSTEN_LEGGINGS)
                && player.inventory.armorInventory.get(2).getItem().equals(ModItems.TUNGSTEN_CHESTPLATE)
                && player.inventory.armorInventory.get(3).getItem().equals(ModItems.TUNGSTEN_HELMET)) {

            player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 2, 0, false, false));
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 2, 0, false, false));
        }
    }
}
