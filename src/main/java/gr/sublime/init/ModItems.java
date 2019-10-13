package gr.sublime.init;

import gr.sublime.Main;
import gr.sublime.item.ItemBase;
import gr.sublime.item.ItemDoorBase;
import gr.sublime.item.armor.ArmorBase;
import gr.sublime.item.armor.ArmorTungsten;
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
import net.minecraft.item.ItemDoor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    // Armor materials
    public static final ItemArmor.ArmorMaterial ARMOR_IRIDIUM = EnumHelper.addArmorMaterial("armor_iridium", Reference.ID + ":iridium", 30, new int[]{3, 5, 6, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5f);
    public static final ItemArmor.ArmorMaterial ARMOR_TUNGSTEN = EnumHelper.addArmorMaterial("armor_tungsten", Reference.ID + ":tungsten", 25, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0f);

    // Tool materials
    public static final Item.ToolMaterial TOOL_IRIDIUM = EnumHelper.addToolMaterial("tool_iridium", 3, 1360, 13.0f, 3.5f, 18);
    public static final Item.ToolMaterial TOOL_TUNGSTEN = EnumHelper.addToolMaterial("tool_tungsten", 2, 912, 9.0f, 3.0f, 16);

    // Misc
    public static final ItemBase IRIDIUM = new ItemBase("iridium");
    public static final ItemBase IRIDIUM_ROD = new ItemBase("iridium_rod");
    public static final ItemBase NIOBIUM_INGOT = new ItemBase("niobium_ingot");
    public static final ItemBase TUNGSTEN_INGOT = new ItemBase("tungsten_ingot");
    public static final ItemBase TUNGSTEN_ROD = new ItemBase("tungsten_rod");
    public static final ItemDoorBase DOOR_BLOODLESS_ELM = new ItemDoorBase(ModBlocks.DOOR_BLOODLESS_ELM, "door_bloodless_elm");
    public static final ItemDoorBase DOOR_HANAMI = new ItemDoorBase(ModBlocks.DOOR_HANAMI, "door_hanami");

    // Armor
    public static final ArmorBase IRIDIUM_HELMET = new ArmorBase("iridium_helmet", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.HEAD, IRIDIUM);
    public static final ArmorBase IRIDIUM_CHESTPLATE = new ArmorBase("iridium_chestplate", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.CHEST, IRIDIUM);
    public static final ArmorBase IRIDIUM_LEGGINGS = new ArmorBase("iridium_leggings", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.LEGS, IRIDIUM);
    public static final ArmorBase IRIDIUM_BOOTS = new ArmorBase("iridium_boots", ARMOR_IRIDIUM, 5, EntityEquipmentSlot.FEET, IRIDIUM);
    public static final ArmorTungsten TUNGSTEN_HELMET = new ArmorTungsten("tungsten_helmet", 5, EntityEquipmentSlot.HEAD);
    public static final ArmorTungsten TUNGSTEN_CHESTPLATE = new ArmorTungsten("tungsten_chestplate", 5, EntityEquipmentSlot.CHEST);
    public static final ArmorTungsten TUNGSTEN_LEGGINGS = new ArmorTungsten("tungsten_leggings", 5, EntityEquipmentSlot.LEGS);
    public static final ArmorTungsten TUNGSTEN_BOOTS = new ArmorTungsten("tungsten_boots", 5, EntityEquipmentSlot.FEET);

    // Tools
    public static final ToolPickaxe IRIDIUM_PICKAXE = new ToolPickaxe("iridium_pickaxe", TOOL_IRIDIUM, IRIDIUM);
    public static final ToolAxe IRIDIUM_AXE = new ToolAxe("iridium_axe", TOOL_IRIDIUM, IRIDIUM);
    public static final ToolShovel IRIDIUM_SHOVEL = new ToolShovel("iridium_shovel", TOOL_IRIDIUM, IRIDIUM);
    public static final ToolHoe IRIDIUM_HOE = new ToolHoe("iridium_hoe", TOOL_IRIDIUM, IRIDIUM);
    public static final ToolSword IRIDIUM_SWORD = new ToolSword("iridium_sword", TOOL_IRIDIUM, IRIDIUM);
    public static final ToolPickaxe TUNGSTEN_PICKAXE = new ToolPickaxe("tungsten_pickaxe", TOOL_TUNGSTEN, TUNGSTEN_INGOT);
    public static final ToolAxe TUNGSTEN_AXE = new ToolAxe("tungsten_axe", TOOL_TUNGSTEN, TUNGSTEN_INGOT);
    public static final ToolShovel TUNGSTEN_SHOVEL = new ToolShovel("tungsten_shovel", TOOL_TUNGSTEN, TUNGSTEN_INGOT);
    public static final ToolHoe TUNGSTEN_HOE = new ToolHoe("tungsten_hoe", TOOL_TUNGSTEN, TUNGSTEN_INGOT);
    public static final ToolSword TUNGSTEN_SWORD = new ToolSword("tungsten_sword", TOOL_TUNGSTEN, TUNGSTEN_INGOT);

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
                TUNGSTEN_INGOT,
                TUNGSTEN_ROD,
                TUNGSTEN_PICKAXE,
                TUNGSTEN_AXE,
                TUNGSTEN_SHOVEL,
                TUNGSTEN_HOE,
                TUNGSTEN_SWORD,
                TUNGSTEN_HELMET,
                TUNGSTEN_CHESTPLATE,
                TUNGSTEN_LEGGINGS,
                TUNGSTEN_BOOTS,
                NIOBIUM_INGOT,
                DOOR_BLOODLESS_ELM,
                DOOR_HANAMI
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
                TUNGSTEN_INGOT,
                TUNGSTEN_ROD,
                TUNGSTEN_PICKAXE,
                TUNGSTEN_AXE,
                TUNGSTEN_SHOVEL,
                TUNGSTEN_HOE,
                TUNGSTEN_SWORD,
                TUNGSTEN_HELMET,
                TUNGSTEN_CHESTPLATE,
                TUNGSTEN_LEGGINGS,
                TUNGSTEN_BOOTS,
                NIOBIUM_INGOT,
                DOOR_BLOODLESS_ELM,
                DOOR_HANAMI
        );
    }

    private static void initModels(Item... items) {
        for (Item item : items) {
            Main.proxy.registerItemRenderer(item, 0, "inventory");
        }
    }
}
