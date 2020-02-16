package gr.sublime.world.gen.structure;

import gr.sublime.Main;
import gr.sublime.init.ModBlocks;
import gr.sublime.tileentity.TileEntityNiobiumChest;
import gr.sublime.util.Reference;
import gr.sublime.world.storage.loot.SublimeLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class StructureGenerator extends WorldGenerator {

    private static final ResourceLocation[] SPAWNER_TYPES = new ResourceLocation[]{EntityList.getKey(EntitySkeleton.class), EntityList.getKey(EntityZombie.class)};

    private String name;
    private int variation;

    public StructureGenerator(String name, int variation) {
        this.name = name;
        this.variation = variation;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        WorldServer worldServer = (WorldServer) world;
        MinecraftServer minecraftServer = world.getMinecraftServer();
        TemplateManager templateManager = worldServer.getStructureTemplateManager();
        Template template = templateManager.get(minecraftServer, new ResourceLocation(Reference.ID, name));

        if (template == null) {
            Main.logger.error("Structure not found: " + name);
            return false;
        }

        if (canSpawnHere(template, worldServer, position)) {
            PlacementSettings placementSettings = new PlacementSettings()
                    .setMirror(Mirror.NONE)
                    .setRotation(Rotation.values()[rand.nextInt(3)])
                    .setIgnoreStructureBlock(false);

            template.addBlocksToWorld(world, position, placementSettings);

            Map<BlockPos, String> dataBlocks = template.getDataBlocks(position, placementSettings);
            for (Entry<BlockPos, String> entry : dataBlocks.entrySet()) {
                String data = entry.getValue();
                BlockPos pos = entry.getKey().down();

                if (data.equals("niobium_chest")) {
                    world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 3);

                    TileEntity tileEntity = world.getTileEntity(pos);
                    if (tileEntity instanceof TileEntityNiobiumChest) {
                        ((TileEntityNiobiumChest) tileEntity).setLootTable(LootTableList.CHESTS_VILLAGE_BLACKSMITH, rand.nextLong());
                    }
                }
                if (data.equals("chest")) {
                    if (name.equals("watchtower")) {
                        world.setBlockState(pos.up(), ModBlocks.SLAB_YEDOENSIS.getDefaultState().withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP), 3);
                    } else {
                        world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 3);
                    }

                    TileEntity tileEntity = world.getTileEntity(pos);
                    if (tileEntity instanceof TileEntityChest) {
                        ((TileEntityChest) tileEntity).setLootTable(LootTableList.CHESTS_IGLOO_CHEST, rand.nextLong());
                    }
                }
                if (data.equals("dropper")) {
                    world.setBlockState(pos.up(), ModBlocks.MUTED_DIRT.getDefaultState(), 3);

                    TileEntity tileEntity = world.getTileEntity(pos.up().up());
                    if (tileEntity instanceof TileEntityDropper) {
                        ((TileEntityDropper) tileEntity).setLootTable(SublimeLootTables.CHESTS_GAZEBO_DROPPER, rand.nextLong());
                    }
                }
                if (data.equals("spawner")) {
                    world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 3);
                }
            }
            return true;
        }
        return false;
    }

    public boolean isCornerValid(World world, BlockPos pos) {
        int groundY = getGroundHeight(world, pos.getX(), pos.getZ());
        return groundY > pos.getY() - variation && groundY < pos.getY() + variation;
    }

    public boolean canSpawnHere(Template template, World world, BlockPos pos) {
        return isCornerValid(world, pos)
                && isCornerValid(world, pos.add(template.getSize().getX(), 0, 0))
                && isCornerValid(world, pos.add(template.getSize().getX(), 0, template.getSize().getZ()))
                && isCornerValid(world, pos.add(0, 0, template.getSize().getZ()));
    }

    public int getGroundHeight(World world, int x, int z) {
        int y = world.getHeight();
        while (y-- > 0) {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            if (block == Blocks.WATER || block == Blocks.FLOWING_WATER) {
                y = -1;
            }
            if (block == ModBlocks.MUTED_GRASS || block == ModBlocks.MUTED_DIRT) {
                return y;
            }
        }
        return -1;
    }
}
