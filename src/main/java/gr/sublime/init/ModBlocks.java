package gr.sublime.init;

import gr.sublime.Main;
import gr.sublime.block.BlockCalamagrostis;
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
import gr.sublime.block.BlockLeavesYedoensis;
import gr.sublime.block.BlockLilyBase;
import gr.sublime.block.BlockLogBase;
import gr.sublime.block.BlockMutedGrass;
import gr.sublime.block.BlockNiobiumChest;
import gr.sublime.block.BlockOreBase;
import gr.sublime.block.BlockOreIridium;
import gr.sublime.block.BlockOreNiobium;
import gr.sublime.block.BlockOreTungsten;
import gr.sublime.block.BlockPlanksBase;
import gr.sublime.block.BlockSaplingBase;
import gr.sublime.block.BlockSlabBase;
import gr.sublime.block.BlockSlabBloodlessElm;
import gr.sublime.block.BlockSlabHanami;
import gr.sublime.block.BlockSlabYedoensis;
import gr.sublime.block.BlockStairsBase;
import gr.sublime.block.BlockThatch;
import gr.sublime.block.BlockTungstenFurnace;
import gr.sublime.item.ItemLotus;
import gr.sublime.world.gen.feature.WorldGenTreeBloodlessElm;
import gr.sublime.world.gen.feature.WorldGenTreeHanami;
import gr.sublime.world.gen.feature.WorldGenTreeYedoensis;
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
    public static BlockLogBase LOG_YEDOENSIS = new BlockLogBase("log_yedoensis");
    public static BlockPlanksBase PLANKS_BLOODLESS_ELM = new BlockPlanksBase("planks_bloodless_elm");
    public static BlockPlanksBase PLANKS_HANAMI = new BlockPlanksBase("planks_hanami");
    public static BlockPlanksBase PLANKS_YEDOENSIS = new BlockPlanksBase("planks_yedoensis");
    public static BlockLeavesBloodlessElm LEAVES_BLOODLESS_ELM = new BlockLeavesBloodlessElm("leaves_bloodless_elm");
    public static BlockLeavesFallen LEAVES_FALLEN = new BlockLeavesFallen("leaves_fallen");
    public static BlockLeavesHanami LEAVES_HANAMI = new BlockLeavesHanami("leaves_hanami");
    public static BlockLeavesYedoensis LEAVES_YEDOENSIS = new BlockLeavesYedoensis("leaves_yedoensis");
    public static BlockSaplingBase SAPLING_BLOODLESS_ELM = new BlockSaplingBase("sapling_bloodless_elm", new WorldGenTreeBloodlessElm(false));
    public static BlockSaplingBase SAPLING_HANAMI = new BlockSaplingBase("sapling_hanami", new WorldGenTreeHanami(false));
    public static BlockSaplingBase SAPLING_YEDOENSIS = new BlockSaplingBase("sapling_yedoensis", new WorldGenTreeYedoensis(false));
    public static BlockDirtBase MUTED_DIRT = new BlockDirtBase("muted_dirt");
    public static BlockMutedGrass MUTED_GRASS = new BlockMutedGrass("muted_grass");
    public static BlockFarmlandBase MUTED_FARMLAND = new BlockFarmlandBase("muted_farmland", ModBlocks.MUTED_DIRT);
    public static BlockFlowerBase FLOWER_ASTRANTIA = new BlockFlowerBase("flower_astrantia");
    public static BlockFlowerBase FLOWER_CHYSANTHEMUM = new BlockFlowerBase("flower_chrysanthemum");
    public static BlockDoublePlantEterisk DOUBLE_PLANT_ETERISK = new BlockDoublePlantEterisk("double_plant_eterisk");
    public static BlockCalamagrostis CALAMAGROSTIS = new BlockCalamagrostis("calamagrostis");
    public static BlockLilyBase LOTUS = new BlockLilyBase("lotus");
    public static BlockThatch THATCH = new BlockThatch("thatch");
    public static BlockFenceBase FENCE_BLOODLESS_ELM = new BlockFenceBase(Material.WOOD, "fence_bloodless_elm");
    public static BlockFenceBase FENCE_HANAMI = new BlockFenceBase(Material.WOOD, "fence_hanami");
    public static BlockFenceBase FENCE_YEDOENSIS = new BlockFenceBase(Material.WOOD, "fence_yedoensis");
    public static BlockFenceGateBase FENCE_GATE_BLOODLESS_ELM = new BlockFenceGateBase("fence_gate_bloodless_elm");
    public static BlockFenceGateBase FENCE_GATE_HANAMI = new BlockFenceGateBase("fence_gate_hanami");
    public static BlockFenceGateBase FENCE_GATE_YEDOENSIS = new BlockFenceGateBase("fence_gate_yedoensis");
    public static BlockSlabBase DOUBLE_SLAB_BLOODLESS_ELM = new BlockSlabBloodlessElm.Double("double_slab_bloodless_elm");
    public static BlockSlabBase SLAB_BLOODLESS_ELM = new BlockSlabBloodlessElm.Half("slab_bloodless_elm");
    public static BlockSlabBase DOUBLE_SLAB_HANAMI = new BlockSlabHanami.Double("double_slab_hanami");
    public static BlockSlabBase SLAB_HANAMI = new BlockSlabHanami.Half("slab_hanami");
    public static BlockSlabBase DOUBLE_SLAB_YEDOENSIS = new BlockSlabYedoensis.Double("double_slab_yedoensis");
    public static BlockSlabBase SLAB_YEDOENSIS = new BlockSlabYedoensis.Half("slab_yedoensis");
    public static BlockStairsBase STAIRS_BLOODLESS_ELM = new BlockStairsBase(ModBlocks.PLANKS_BLOODLESS_ELM.getDefaultState(), "stairs_bloodless_elm");
    public static BlockStairsBase STAIRS_HANAMI = new BlockStairsBase(ModBlocks.PLANKS_HANAMI.getDefaultState(), "stairs_hanami");
    public static BlockStairsBase STAIRS_YEDOENSIS = new BlockStairsBase(ModBlocks.PLANKS_YEDOENSIS.getDefaultState(), "stairs_yedoensis");
    public static BlockDoorBase DOOR_BLOODLESS_ELM = new BlockDoorBase(Material.WOOD, "door_bloodless_elm");
    public static BlockDoorBase DOOR_HANAMI = new BlockDoorBase(Material.WOOD, "door_hanami");
    public static BlockDoorBase DOOR_YEDOENSIS = new BlockDoorBase(Material.WOOD, "door_yedoensis");

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
                LOG_YEDOENSIS,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                PLANKS_YEDOENSIS,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                LEAVES_YEDOENSIS,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                SAPLING_YEDOENSIS,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                FLOWER_CHYSANTHEMUM,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                LOTUS,
                THATCH,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_YEDOENSIS,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI,
                FENCE_GATE_YEDOENSIS,
                DOUBLE_SLAB_BLOODLESS_ELM,
                SLAB_BLOODLESS_ELM,
                DOUBLE_SLAB_HANAMI,
                SLAB_HANAMI,
                DOUBLE_SLAB_YEDOENSIS,
                SLAB_YEDOENSIS,
                STAIRS_BLOODLESS_ELM,
                STAIRS_HANAMI,
                STAIRS_YEDOENSIS,
                DOOR_BLOODLESS_ELM,
                DOOR_HANAMI,
                DOOR_YEDOENSIS
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
                LOG_YEDOENSIS,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                PLANKS_YEDOENSIS,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                LEAVES_YEDOENSIS,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                SAPLING_YEDOENSIS,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                FLOWER_CHYSANTHEMUM,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_YEDOENSIS,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI,
                FENCE_GATE_YEDOENSIS,
                STAIRS_BLOODLESS_ELM,
                STAIRS_HANAMI,
                STAIRS_YEDOENSIS
        );

        items.add(new ItemLotus().setRegistryName(ModBlocks.LOTUS.getRegistryName()));
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
        items.add(new ItemSlab(SLAB_YEDOENSIS, SLAB_YEDOENSIS, DOUBLE_SLAB_YEDOENSIS).setRegistryName(ModBlocks.SLAB_YEDOENSIS.getRegistryName()));

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
                LOG_YEDOENSIS,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                PLANKS_YEDOENSIS,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                LEAVES_YEDOENSIS,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                SAPLING_YEDOENSIS,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                FLOWER_CHYSANTHEMUM,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                LOTUS,
                THATCH,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_YEDOENSIS,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI,
                FENCE_GATE_YEDOENSIS,
                SLAB_BLOODLESS_ELM,
                SLAB_HANAMI,
                SLAB_YEDOENSIS,
                STAIRS_BLOODLESS_ELM,
                STAIRS_HANAMI,
                STAIRS_YEDOENSIS
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
