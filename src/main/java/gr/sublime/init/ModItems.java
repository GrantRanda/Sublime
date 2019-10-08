package gr.sublime.init;

import gr.sublime.Main;
import gr.sublime.item.ItemBase;
import gr.sublime.item.armor.ArmorBase;
import gr.sublime.item.tools.ToolAxe;
import gr.sublime.item.tools.ToolHoe;
import gr.sublime.item.tools.ToolPickaxe;
import gr.sublime.item.tools.ToolShovel;
import gr.sublime.item.tools.ToolSword;
import gr.sublime.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    // Armor materials
    public static final ItemArmor.ArmorMaterial ARMOR_IRIDIUM = EnumHelper.addArmorMaterial("armor_iridium", Reference.ID + ":iridium", 35, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5f);

    // Tool materials
    public static final Item.ToolMaterial TOOL_IRIDIUM = EnumHelper.addToolMaterial("tool_iridium", 3, 1360, 13.0f, 3.5f, 18);

    // Misc
    public static final ItemBase IRIDIUM = new ItemBase("iridium");
    public static final ItemBase IRIDIUM_ROD = new ItemBase("iridium_rod");
    public static final ItemBase NIOBIUM_INGOT = new ItemBase("niobium_ingot");
    public static final ItemBase TUNGSTEN_INGOT = new ItemBase("tungsten_ingot");

    // Armor
    public static final ArmorBase IRIDIUM_HELMET = new ArmorBase("iridium_helmet", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.HEAD);
    public static final ArmorBase IRIDIUM_CHESTPLATE = new ArmorBase("iridium_chestplate", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.CHEST);
    public static final ArmorBase IRIDIUM_LEGGINGS = new ArmorBase("iridium_leggings", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.LEGS);
    public static final ArmorBase IRIDIUM_BOOTS = new ArmorBase("iridium_boots", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.FEET);

    // Tools
    public static final ToolPickaxe IRIDIUM_PICKAXE = new ToolPickaxe("iridium_pickaxe", TOOL_IRIDIUM);
    public static final ToolAxe IRIDIUM_AXE = new ToolAxe("iridium_axe", TOOL_IRIDIUM);
    public static final ToolShovel IRIDIUM_SHOVEL = new ToolShovel("iridium_shovel", TOOL_IRIDIUM);
    public static final ToolHoe IRIDIUM_HOE = new ToolHoe("iridium_hoe", TOOL_IRIDIUM);
    public static final ToolSword IRIDIUM_SWORD = new ToolSword("iridium_sword", TOOL_IRIDIUM);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                IRIDIUM,
                IRIDIUM_ROD,
                IRIDIUM_PICKAXE,
                IRIDIUM_AXE,
                IRIDIUM_SHOVEL,
                IRIDIUM_HOE,
                IRIDIUM_SWORD,
                IRIDIUM_HELMET,
                IRIDIUM_CHESTPLATE,
                IRIDIUM_LEGGINGS,
                IRIDIUM_BOOTS,
                NIOBIUM_INGOT,
                TUNGSTEN_INGOT
        );
    }

    public static void registerModels() {
        initModels(
                IRIDIUM,
                IRIDIUM_ROD,
                IRIDIUM_PICKAXE,
                IRIDIUM_AXE,
                IRIDIUM_SHOVEL,
                IRIDIUM_HOE,
                IRIDIUM_SWORD,
                IRIDIUM_HELMET,
                IRIDIUM_CHESTPLATE,
                IRIDIUM_LEGGINGS,
                IRIDIUM_BOOTS,
                NIOBIUM_INGOT,
                TUNGSTEN_INGOT
        );
    }

    private static void initModels(Item... items) {
        for (Item item : items) {
            Main.proxy.registerItemRenderer(item, 0, "inventory");
        }
    }
}
