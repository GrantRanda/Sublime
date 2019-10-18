package gr.sublime.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {

    public static void init() {

        // Ore Dictionary
        // --Blocks
        OreDictionary.registerOre("oreIridium", ModBlocks.IRIDIUM_ORE);
        OreDictionary.registerOre("oreNiobium", ModBlocks.NIOBIUM_ORE);
        OreDictionary.registerOre("oreNiobium", ModBlocks.TUNGSTEN_ORE);
        OreDictionary.registerOre("blockIridium", ModBlocks.IRIDIUM_BLOCK);
        OreDictionary.registerOre("blockNiobium", ModBlocks.NIOBIUM_BLOCK);
        OreDictionary.registerOre("blockTungsten", ModBlocks.TUNGSTEN_BLOCK);
        OreDictionary.registerOre("logWood", ModBlocks.LOG_BLOODLESS_ELM);
        OreDictionary.registerOre("logWood", ModBlocks.LOG_HANAMI);
        OreDictionary.registerOre("plankWood", ModBlocks.PLANKS_BLOODLESS_ELM);
        OreDictionary.registerOre("plankWood", ModBlocks.PLANKS_HANAMI);
        OreDictionary.registerOre("treeLeaves", ModBlocks.LEAVES_BLOODLESS_ELM);
        OreDictionary.registerOre("treeLeaves", ModBlocks.LEAVES_FALLEN);
        OreDictionary.registerOre("treeLeaves", ModBlocks.LEAVES_HANAMI);

        // --Items
        OreDictionary.registerOre("gemIridium", ModItems.IRIDIUM);
        OreDictionary.registerOre("ingotNiobium", ModItems.NIOBIUM_INGOT);
        OreDictionary.registerOre("ingotNiobium", ModItems.TUNGSTEN_INGOT);
        OreDictionary.registerOre("treeSapling", ModBlocks.SAPLING_BLOODLESS_ELM);
        OreDictionary.registerOre("treeSapling", ModBlocks.SAPLING_HANAMI);

        // Smelting
        GameRegistry.addSmelting(ModBlocks.NIOBIUM_ORE, new ItemStack(ModItems.NIOBIUM_INGOT), 1.0f);
        GameRegistry.addSmelting(ModBlocks.TUNGSTEN_ORE, new ItemStack(ModItems.TUNGSTEN_INGOT), 1.0f);
    }
}
