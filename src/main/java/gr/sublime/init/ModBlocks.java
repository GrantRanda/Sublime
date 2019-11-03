package gr.sublime.init;

import gr.sublime.Main;
import gr.sublime.block.BlockBase;
import gr.sublime.block.BlockDirtBase;
import gr.sublime.block.BlockDoorBase;
import gr.sublime.block.BlockDoublePlantEterisk;
import gr.sublime.block.BlockFarmlandBase;
import gr.sublime.block.BlockFenceBase;
import gr.sublime.block.BlockFenceGateBase;
import gr.sublime.block.BlockFlowerBase;
import gr.sublime.block.BlockLeavesBloodlessElm;
import gr.sublime.block.BlockLeavesFallen;
import gr.sublime.block.BlockLeavesHanami;
import gr.sublime.block.BlockLeavesMaidenhair;
import gr.sublime.block.BlockLilyBase;
import gr.sublime.block.BlockLogBase;
import gr.sublime.block.BlockMutedGrass;
import gr.sublime.block.BlockNiobiumChest;
import gr.sublime.block.BlockOreBase;
import gr.sublime.block.BlockTungstenFurnace;
import gr.sublime.block.BlockOreIridium;
import gr.sublime.block.BlockOreNiobium;
import gr.sublime.block.BlockOreTungsten;
import gr.sublime.block.BlockCalamagrostis;
import gr.sublime.block.BlockPlanksBase;
import gr.sublime.block.BlockSaplingBase;
import gr.sublime.block.BlockSlabBase;
import gr.sublime.block.BlockStairsBase;
import gr.sublime.block.BlockThatch;
import gr.sublime.item.ItemBlackLotus;
import gr.sublime.world.gen.feature.WorldGenTreeBloodlessElm;
import gr.sublime.world.gen.feature.WorldGenTreeHanami;
import gr.sublime.world.gen.feature.WorldGenTreeMaidenhair;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static BlockOreIridium IRIDIUM_ORE = new BlockOreIridium("iridium_ore");
    public static BlockOreNiobium NIOBIUM_ORE = new BlockOreNiobium("niobium_ore");
    public static BlockOreTungsten TUNGSTEN_ORE = new BlockOreTungsten("tungsten_ore");
    public static BlockOreBase IRIDIUM_BLOCK = new BlockOreBase("iridium_block");
    public static BlockOreBase NIOBIUM_BLOCK = new BlockOreBase("niobium_block");
    public static BlockOreBase TUNGSTEN_BLOCK = new BlockOreBase("tungsten_block");
    public static BlockNiobiumChest NIOBIUM_CHEST = new BlockNiobiumChest("niobium_chest");
    public static BlockTungstenFurnace TUNGSTEN_FURNACE = new BlockTungstenFurnace(false, "tungsten_furnace");
    public static BlockTungstenFurnace TUNGSTEN_FURNACE_LIT = new BlockTungstenFurnace(true, "tungsten_furnace_lit");
    public static BlockLogBase LOG_BLOODLESS_ELM = new BlockLogBase("log_bloodless_elm");
    public static BlockLogBase LOG_HANAMI = new BlockLogBase("log_hanami");
    public static BlockLogBase LOG_MAIDENHAIR = new BlockLogBase("log_maidenhair");
    public static BlockPlanksBase PLANKS_BLOODLESS_ELM = new BlockPlanksBase("planks_bloodless_elm");
    public static BlockPlanksBase PLANKS_HANAMI = new BlockPlanksBase("planks_hanami");
    public static BlockPlanksBase PLANKS_MAIDENHAIR = new BlockPlanksBase("planks_maidenhair");
    public static BlockLeavesBloodlessElm LEAVES_BLOODLESS_ELM = new BlockLeavesBloodlessElm("leaves_bloodless_elm");
    public static BlockLeavesFallen LEAVES_FALLEN = new BlockLeavesFallen("leaves_fallen");
    public static BlockLeavesHanami LEAVES_HANAMI = new BlockLeavesHanami("leaves_hanami");
    public static BlockLeavesMaidenhair LEAVES_MAIDENHAIR = new BlockLeavesMaidenhair("leaves_maidenhair");
    public static BlockSaplingBase SAPLING_BLOODLESS_ELM = new BlockSaplingBase("sapling_bloodless_elm", new WorldGenTreeBloodlessElm(false));
    public static BlockSaplingBase SAPLING_HANAMI = new BlockSaplingBase("sapling_hanami", new WorldGenTreeHanami(false));
    public static BlockSaplingBase SAPLING_MAIDENHAIR = new BlockSaplingBase("sapling_maidenhair", new WorldGenTreeMaidenhair(false));
    public static BlockDirtBase MUTED_DIRT = new BlockDirtBase("muted_dirt");
    public static BlockMutedGrass MUTED_GRASS = new BlockMutedGrass("muted_grass");
    public static BlockFarmlandBase MUTED_FARMLAND = new BlockFarmlandBase("muted_farmland", ModBlocks.MUTED_DIRT);
    public static BlockFlowerBase FLOWER_ASTRANTIA = new BlockFlowerBase("flower_astrantia");
    public static BlockFlowerBase FLOWER_CHYSANTHEMUM = new BlockFlowerBase("flower_chrysanthemum");
    public static BlockDoublePlantEterisk DOUBLE_PLANT_ETERISK = new BlockDoublePlantEterisk("double_plant_eterisk");
    public static BlockCalamagrostis CALAMAGROSTIS = new BlockCalamagrostis("calamagrostis");
    public static BlockLilyBase BLACK_LOTUS = new BlockLilyBase("black_lotus");
    public static BlockThatch THATCH = new BlockThatch("thatch");
    public static BlockFenceBase FENCE_BLOODLESS_ELM = new BlockFenceBase(Material.WOOD, "fence_bloodless_elm");
    public static BlockFenceBase FENCE_HANAMI = new BlockFenceBase(Material.WOOD, "fence_hanami");
    public static BlockFenceBase FENCE_MAIDENHAIR = new BlockFenceBase(Material.WOOD, "fence_maidenhair");
    public static BlockFenceGateBase FENCE_GATE_BLOODLESS_ELM = new BlockFenceGateBase("fence_gate_bloodless_elm");
    public static BlockFenceGateBase FENCE_GATE_HANAMI = new BlockFenceGateBase("fence_gate_hanami");
    public static BlockFenceGateBase FENCE_GATE_MAIDENHAIR = new BlockFenceGateBase("fence_gate_maidenhair");
    public static BlockSlabBase DOUBLE_SLAB_BLOODLESS_ELM = new BlockSlabBase.Double(Material.WOOD, ModBlocks.SLAB_BLOODLESS_ELM, "double_slab_bloodless_elm");
    public static BlockSlabBase SLAB_BLOODLESS_ELM = new BlockSlabBase.Half(Material.WOOD, ModBlocks.SLAB_BLOODLESS_ELM, "slab_bloodless_elm");
    public static BlockSlabBase DOUBLE_SLAB_HANAMI = new BlockSlabBase.Double(Material.WOOD, ModBlocks.SLAB_HANAMI, "double_slab_hanami");
    public static BlockSlabBase SLAB_HANAMI = new BlockSlabBase.Half(Material.WOOD, ModBlocks.SLAB_HANAMI, "slab_hanami");
    public static BlockSlabBase DOUBLE_SLAB_MAIDENHAIR = new BlockSlabBase.Double(Material.WOOD, ModBlocks.SLAB_MAIDENHAIR, "double_slab_maidenhair");
    public static BlockSlabBase SLAB_MAIDENHAIR = new BlockSlabBase.Half(Material.WOOD, ModBlocks.SLAB_MAIDENHAIR, "slab_maidenhair");
    public static BlockStairsBase STAIRS_BLOODLESS_ELM = new BlockStairsBase(ModBlocks.PLANKS_BLOODLESS_ELM.getDefaultState(), "stairs_bloodless_elm");
    public static BlockStairsBase STAIRS_HANAMI = new BlockStairsBase(ModBlocks.PLANKS_HANAMI.getDefaultState(), "stairs_hanami");
    public static BlockStairsBase STAIRS_MAIDENHAIR = new BlockStairsBase(ModBlocks.PLANKS_MAIDENHAIR.getDefaultState(), "stairs_maidenhair");
    public static BlockDoorBase DOOR_BLOODLESS_ELM = new BlockDoorBase(Material.WOOD, "door_bloodless_elm");
    public static BlockDoorBase DOOR_HANAMI = new BlockDoorBase(Material.WOOD, "door_hanami");
    public static BlockDoorBase DOOR_MAIDENHAIR = new BlockDoorBase(Material.WOOD, "door_maidenhair");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                IRIDIUM_ORE,
                NIOBIUM_ORE,
                TUNGSTEN_ORE,
                IRIDIUM_BLOCK,
                NIOBIUM_BLOCK,
                TUNGSTEN_BLOCK,
                NIOBIUM_CHEST,
                TUNGSTEN_FURNACE,
                TUNGSTEN_FURNACE_LIT,
                LOG_BLOODLESS_ELM,
                LOG_HANAMI,
                LOG_MAIDENHAIR,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                PLANKS_MAIDENHAIR,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                LEAVES_MAIDENHAIR,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                SAPLING_MAIDENHAIR,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                FLOWER_CHYSANTHEMUM,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                BLACK_LOTUS,
                THATCH,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_MAIDENHAIR,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI,
                FENCE_GATE_MAIDENHAIR,
                DOUBLE_SLAB_BLOODLESS_ELM,
                SLAB_BLOODLESS_ELM,
                DOUBLE_SLAB_HANAMI,
                SLAB_HANAMI,
                DOUBLE_SLAB_MAIDENHAIR,
                SLAB_MAIDENHAIR,
                STAIRS_BLOODLESS_ELM,
                STAIRS_HANAMI,
                STAIRS_MAIDENHAIR,
                DOOR_BLOODLESS_ELM,
                DOOR_HANAMI,
                DOOR_MAIDENHAIR
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        List<Item> items = toItemBlocks(
                IRIDIUM_ORE,
                NIOBIUM_ORE,
                TUNGSTEN_ORE,
                IRIDIUM_BLOCK,
                NIOBIUM_BLOCK,
                TUNGSTEN_BLOCK,
                NIOBIUM_CHEST,
                TUNGSTEN_FURNACE,
                TUNGSTEN_FURNACE_LIT,
                LOG_BLOODLESS_ELM,
                LOG_HANAMI,
                LOG_MAIDENHAIR,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                PLANKS_MAIDENHAIR,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                LEAVES_MAIDENHAIR,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                SAPLING_MAIDENHAIR,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                FLOWER_CHYSANTHEMUM,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_MAIDENHAIR,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI,
                FENCE_GATE_MAIDENHAIR,
                STAIRS_BLOODLESS_ELM,
                STAIRS_HANAMI,
                STAIRS_MAIDENHAIR
        );

        items.add(new ItemBlackLotus().setRegistryName(ModBlocks.BLACK_LOTUS.getRegistryName()));
        items.add(
                new ItemBlock(THATCH) {
                    @Override
                    public int getItemBurnTime(ItemStack itemStack) {
                        return 300;
                    }
                }.setRegistryName(ModBlocks.THATCH.getRegistryName())
        );
        items.add(new ItemSlab(SLAB_BLOODLESS_ELM, SLAB_BLOODLESS_ELM, DOUBLE_SLAB_BLOODLESS_ELM).setRegistryName(ModBlocks.SLAB_BLOODLESS_ELM.getRegistryName()));
        items.add(new ItemSlab(SLAB_HANAMI, SLAB_HANAMI, DOUBLE_SLAB_HANAMI).setRegistryName(ModBlocks.SLAB_HANAMI.getRegistryName()));
        items.add(new ItemSlab(SLAB_MAIDENHAIR, SLAB_MAIDENHAIR, DOUBLE_SLAB_MAIDENHAIR).setRegistryName(ModBlocks.SLAB_MAIDENHAIR.getRegistryName()));

        for (Item item : items) {
            registry.register(item);
        }
    }

    public static void registerModels() {
        initModels(
                IRIDIUM_ORE,
                NIOBIUM_ORE,
                TUNGSTEN_ORE,
                IRIDIUM_BLOCK,
                NIOBIUM_BLOCK,
                TUNGSTEN_BLOCK,
                NIOBIUM_CHEST,
                TUNGSTEN_FURNACE,
                TUNGSTEN_FURNACE_LIT,
                LOG_BLOODLESS_ELM,
                LOG_HANAMI,
                LOG_MAIDENHAIR,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                PLANKS_MAIDENHAIR,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                LEAVES_MAIDENHAIR,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                SAPLING_MAIDENHAIR,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                FLOWER_CHYSANTHEMUM,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                BLACK_LOTUS,
                THATCH,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_MAIDENHAIR,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI,
                FENCE_GATE_MAIDENHAIR,
                SLAB_BLOODLESS_ELM,
                SLAB_HANAMI,
                SLAB_MAIDENHAIR,
                STAIRS_BLOODLESS_ELM,
                STAIRS_HANAMI,
                STAIRS_MAIDENHAIR
        );
    }

    private static List<Item> toItemBlocks(Block... blocks) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < blocks.length; i++) {
            items.add(new ItemBlock(blocks[i]).setRegistryName(blocks[i].getRegistryName()));
        }
        return items;
    }

    private static void initModels(Block... blocks) {
        for (Block block : blocks) {
            Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }
}
