package gr.sublime.world.biome;

import com.google.common.base.Predicate;
import gr.sublime.init.ModBlocks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BiomeDecoratorBase extends BiomeDecorator {

    Predicate<IBlockState> replaceablePredicate = new SublimePredicate();

    private int dirtSize = 33;
    private int gravelSize = 33;
    private int graniteSize = 33;
    private int dioriteSize = 33;
    private int andesiteSize = 33;
    private int coalSize = 17;
    private int ironSize = 9;
    private int goldSize = 9;
    private int redstoneSize = 9;
    private int diamondSize = 8;
    private int lapisSize = 8;

    private int dirtCount = 10;
    private int gravelCount = 8;
    private int dioriteCount = 10;
    private int graniteCount = 0;//10;
    private int andesiteCount = 10;
    private int coalCount = 20;
    private int ironCount = 20;
    private int goldCount = 2;
    private int redstoneCount = 8;
    private int diamondCount = 1;
    private int lapisCount = 1;

    private int lapisCenterHeight = 6;
    private int lapisSpread = 16;

    private int oreGenMinHeight = 0;

    private int dirtMaxHeight = 255;
    private int gravelMaxHeight = 255;
    private int dioriteMaxHeight = 80;
    private int graniteMaxHeight = 80;
    private int andesiteMaxHeight = 80;
    private int coalMaxHeight = 126;
    private int ironMaxHeight = 64;
    private int goldMaxHeight = 32;
    private int redstoneMaxHeight = 16;
    private int diamondMaxHeight = 16;

    public BiomeDecoratorBase() {
        super();

        dirtGen = new WorldGenMinable(ModBlocks.MUTED_DIRT.getDefaultState(), dirtSize, replaceablePredicate);

        gravelOreGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), gravelSize, replaceablePredicate);
        graniteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), graniteSize, replaceablePredicate);
        dioriteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), dioriteSize, replaceablePredicate);
        andesiteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), andesiteSize, replaceablePredicate);
        coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), coalSize, replaceablePredicate);
        ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), ironSize, replaceablePredicate);
        goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), goldSize, replaceablePredicate);
        redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), redstoneSize, replaceablePredicate);
        diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), diamondSize, replaceablePredicate);
        lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), lapisSize, replaceablePredicate);
    }

    /**
     * This is the function where ore generation and things like flowers are generated.
     *
     * @param worldIn the world in
     * @param random  the random
     * @param biome   the biome
     * @param pos     the pos
     */
    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if (decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            chunkPos = pos;
            genDecorations(biome, worldIn, random);
            decorating = false;
        }
    }

    /**
     * This is where things like trees are generated.
     *
     * @param biomeIn the biome in
     * @param worldIn the world in
     * @param random  the random
     */
    @Override
    protected void genDecorations(Biome biomeIn, World worldIn, Random random) {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, chunkPos));

        generateOres(worldIn, random);

        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.SAND, sandGen, sandPatchesPerChunk);
        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.CLAY, clayGen, clayPerChunk);
        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2, gravelGen, gravelPatchesPerChunk);
        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2, gravelGen, gravelPatchesPerChunk);
        generateTrees(worldIn, biomeIn, random, chunkPos);
        generateGrass(worldIn, biomeIn, random, chunkPos);

        if (generateFalls) {
            generateFalls(worldIn, random, chunkPos);
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldIn, random, chunkPos));
    }

    protected void generateTrees(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos) {
        int treesToGen = treesPerChunk;

        if (random.nextFloat() < extraTreeChance) {
            ++treesToGen;
        }

        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.TREE))
            for (int numTreesGenerated = 0; numTreesGenerated < treesToGen; ++numTreesGenerated) {
                int treeX = random.nextInt(16) + 8;
                int treeZ = random.nextInt(16) + 8;
                WorldGenAbstractTree treeGen = biomeIn.getRandomTreeFeature(random);

                if (treeGen != null) {
                    treeGen.setDecorationDefaults();
                    BlockPos blockpos = worldIn.getHeight(chunkPos.add(treeX, 0, treeZ));

                    if (treeGen.generate(worldIn, random, blockpos)) {
                        treeGen.generateSaplings(worldIn, random, blockpos);
                    }
                }
            }
    }

    protected void generateGrass(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.GRASS))
            for (int numGrassPerChunk = 0; numGrassPerChunk < grassPerChunk; ++numGrassPerChunk) {
                int grassX = random.nextInt(16) + 8;
                int grassZ = random.nextInt(16) + 8;
                int yRange = worldIn.getHeight(chunkPos.add(grassX, 0, grassZ)).getY() * 2;

                if (yRange > 0) {
                    int grassY = random.nextInt(yRange);
                    biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random, chunkPos.add(grassX, grassY, grassZ));
                }
            }
    }

    protected void generateFalls(World worldIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER))
            for (int k5 = 0; k5 < 50; ++k5) {
                int i10 = random.nextInt(16) + 8;
                int l13 = random.nextInt(16) + 8;
                int i17 = random.nextInt(248) + 8;

                if (i17 > 0) {
                    int k19 = random.nextInt(i17);
                    BlockPos blockpos6 = chunkPos.add(i10, k19, l13);
                    (new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(worldIn, random, blockpos6);
                }
            }

        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA))
            for (int l5 = 0; l5 < 20; ++l5) {
                int j10 = random.nextInt(16) + 8;
                int i14 = random.nextInt(16) + 8;
                int j17 = random.nextInt(random.nextInt(random.nextInt(240) + 8) + 8);
                BlockPos blockpos3 = chunkPos.add(j10, j17, i14);
                (new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(worldIn, random, blockpos3);
            }
    }

    protected void generate(World worldIn, Random random, BlockPos chunkPos, DecorateBiomeEvent.Decorate.EventType eventType, WorldGenerator generator, int countPerChunk) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, eventType)) {
            for (int count = 0; count < countPerChunk; ++count) {
                int randX = random.nextInt(16) + 8;
                int randZ = random.nextInt(16) + 8;
                generator.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(chunkPos.add(randX, 0, randZ)));
            }
        }
    }

    @Override
    protected void generateOres(World worldIn, Random random) {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, random, chunkPos));
        if (TerrainGen.generateOre(worldIn, random, dirtGen, chunkPos, OreGenEvent.GenerateMinable.EventType.DIRT))
            genStandardOre1(worldIn, random, dirtCount, dirtGen, oreGenMinHeight, dirtMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, gravelOreGen, chunkPos, OreGenEvent.GenerateMinable.EventType.GRAVEL))
            genStandardOre1(worldIn, random, gravelCount, gravelOreGen, oreGenMinHeight, gravelMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, dioriteGen, chunkPos, OreGenEvent.GenerateMinable.EventType.DIORITE))
            genStandardOre1(worldIn, random, dioriteCount, dioriteGen, oreGenMinHeight, dioriteMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, graniteGen, chunkPos, OreGenEvent.GenerateMinable.EventType.GRANITE))
            genStandardOre1(worldIn, random, graniteCount, graniteGen, oreGenMinHeight, graniteMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, andesiteGen, chunkPos, OreGenEvent.GenerateMinable.EventType.ANDESITE))
            genStandardOre1(worldIn, random, andesiteCount, andesiteGen, oreGenMinHeight, andesiteMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, coalGen, chunkPos, OreGenEvent.GenerateMinable.EventType.COAL))
            genStandardOre1(worldIn, random, coalCount, coalGen, oreGenMinHeight, coalMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, ironGen, chunkPos, OreGenEvent.GenerateMinable.EventType.IRON))
            genStandardOre1(worldIn, random, ironCount, ironGen, oreGenMinHeight, ironMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, goldGen, chunkPos, OreGenEvent.GenerateMinable.EventType.GOLD))
            genStandardOre1(worldIn, random, goldCount, goldGen, oreGenMinHeight, goldMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, redstoneGen, chunkPos, OreGenEvent.GenerateMinable.EventType.REDSTONE))
            genStandardOre1(worldIn, random, redstoneCount, redstoneGen, oreGenMinHeight, redstoneMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, diamondGen, chunkPos, OreGenEvent.GenerateMinable.EventType.DIAMOND))
            genStandardOre1(worldIn, random, diamondCount, diamondGen, oreGenMinHeight, diamondMaxHeight);
        if (TerrainGen.generateOre(worldIn, random, lapisGen, chunkPos, OreGenEvent.GenerateMinable.EventType.LAPIS))
            genStandardOre2(worldIn, random, lapisCount, lapisGen, lapisCenterHeight, lapisSpread);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, random, chunkPos));
    }

    static class SublimePredicate implements Predicate<IBlockState> {
        private SublimePredicate() {
        }

        @Override
        public boolean apply(IBlockState parBlockState) {
            if (parBlockState != null && parBlockState.getBlock() == Blocks.STONE) {
                return true;
            } else {
                return false;
            }
        }
    }
}
