package gr.sublime.init;

import gr.sublime.Main;
import gr.sublime.block.BlockDirtBase;
import gr.sublime.block.BlockDoublePlantEterisk;
import gr.sublime.block.BlockFarmlandBase;
import gr.sublime.block.BlockFenceBase;
import gr.sublime.block.BlockFenceGateBase;
import gr.sublime.block.BlockFlowerBase;
import gr.sublime.block.BlockLeavesBloodlessElm;
import gr.sublime.block.BlockLeavesFallen;
import gr.sublime.block.BlockLeavesHanami;
import gr.sublime.block.BlockLilyBase;
import gr.sublime.block.BlockLogBase;
import gr.sublime.block.BlockMutedGrass;
import gr.sublime.block.BlockNiobiumChest;
import gr.sublime.block.BlockOreIridium;
import gr.sublime.block.BlockOreNiobium;
import gr.sublime.block.BlockOreTungsten;
import gr.sublime.block.BlockCalamagrostis;
import gr.sublime.block.BlockPlanksBase;
import gr.sublime.block.BlockSaplingBase;
import gr.sublime.block.BlockThatch;
import gr.sublime.item.ItemBlackLotus;
import gr.sublime.world.gen.feature.WorldGenTreeBloodlessElm;
import gr.sublime.world.gen.feature.WorldGenTreeHanami;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static BlockOreIridium IRIDIUM_ORE = new BlockOreIridium("iridium_ore");
    public static BlockOreNiobium NIOBIUM_ORE = new BlockOreNiobium("niobium_ore");
    public static BlockOreTungsten TUNGSTEN_ORE = new BlockOreTungsten("tungsten_ore");
    public static BlockNiobiumChest NIOBIUM_CHEST = new BlockNiobiumChest("niobium_chest");
    public static BlockLogBase LOG_BLOODLESS_ELM = new BlockLogBase("log_bloodless_elm");
    public static BlockLogBase LOG_HANAMI = new BlockLogBase("log_hanami");
    public static BlockPlanksBase PLANKS_BLOODLESS_ELM = new BlockPlanksBase("planks_bloodless_elm");
    public static BlockPlanksBase PLANKS_HANAMI = new BlockPlanksBase("planks_hanami");
    public static BlockLeavesBloodlessElm LEAVES_BLOODLESS_ELM = new BlockLeavesBloodlessElm("leaves_bloodless_elm");
    public static BlockLeavesFallen LEAVES_FALLEN = new BlockLeavesFallen("leaves_fallen");
    public static BlockLeavesHanami LEAVES_HANAMI = new BlockLeavesHanami("leaves_hanami");
    public static BlockSaplingBase SAPLING_BLOODLESS_ELM = new BlockSaplingBase("sapling_bloodless_elm", new WorldGenTreeBloodlessElm(false));
    public static BlockSaplingBase SAPLING_HANAMI = new BlockSaplingBase("sapling_hanami", new WorldGenTreeHanami(false));
    public static BlockDirtBase MUTED_DIRT = new BlockDirtBase("muted_dirt");
    public static BlockMutedGrass MUTED_GRASS = new BlockMutedGrass("muted_grass");
    public static BlockFarmlandBase MUTED_FARMLAND = new BlockFarmlandBase("muted_farmland", MUTED_DIRT);
    public static BlockFlowerBase FLOWER_ASTRANTIA = new BlockFlowerBase("flower_astrantia");
    public static BlockDoublePlantEterisk DOUBLE_PLANT_ETERISK = new BlockDoublePlantEterisk("double_plant_eterisk");
    public static BlockCalamagrostis CALAMAGROSTIS = new BlockCalamagrostis("calamagrostis");
    public static BlockLilyBase BLACK_LOTUS = new BlockLilyBase("black_lotus");
    public static BlockThatch THATCH = new BlockThatch("thatch");
    public static BlockFenceBase FENCE_BLOODLESS_ELM = new BlockFenceBase(Material.WOOD, "fence_bloodless_elm");
    public static BlockFenceBase FENCE_HANAMI = new BlockFenceBase(Material.WOOD, "fence_hanami");
    public static BlockFenceGateBase FENCE_GATE_BLOODLESS_ELM = new BlockFenceGateBase("fence_gate_bloodless_elm");
    public static BlockFenceGateBase FENCE_GATE_HANAMI = new BlockFenceGateBase("fence_gate_hanami");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                IRIDIUM_ORE,
                NIOBIUM_ORE,
                TUNGSTEN_ORE,
                NIOBIUM_CHEST,
                LOG_BLOODLESS_ELM,
                LOG_HANAMI,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                BLACK_LOTUS,
                THATCH,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        List<Item> items = toItemBlocks(
                IRIDIUM_ORE,
                NIOBIUM_ORE,
                TUNGSTEN_ORE,
                NIOBIUM_CHEST,
                LOG_BLOODLESS_ELM,
                LOG_HANAMI,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI
        );

        items.add(new ItemBlackLotus().setRegistryName(BLACK_LOTUS.getRegistryName()));
        items.add(
                new ItemBlock(THATCH) {
                    @Override
                    public int getItemBurnTime(ItemStack itemStack) {
                        return 300;
                    }
                }.setRegistryName(THATCH.getRegistryName())
        );

        for (Item item : items) {
            registry.register(item);
        }
    }

    public static void registerModels() {
        initModels(
                IRIDIUM_ORE,
                NIOBIUM_ORE,
                TUNGSTEN_ORE,
                NIOBIUM_CHEST,
                LOG_BLOODLESS_ELM,
                LOG_HANAMI,
                PLANKS_BLOODLESS_ELM,
                PLANKS_HANAMI,
                LEAVES_BLOODLESS_ELM,
                LEAVES_FALLEN,
                LEAVES_HANAMI,
                SAPLING_BLOODLESS_ELM,
                SAPLING_HANAMI,
                MUTED_DIRT,
                MUTED_GRASS,
                MUTED_FARMLAND,
                FLOWER_ASTRANTIA,
                DOUBLE_PLANT_ETERISK,
                CALAMAGROSTIS,
                BLACK_LOTUS,
                THATCH,
                FENCE_BLOODLESS_ELM,
                FENCE_HANAMI,
                FENCE_GATE_BLOODLESS_ELM,
                FENCE_GATE_HANAMI
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
