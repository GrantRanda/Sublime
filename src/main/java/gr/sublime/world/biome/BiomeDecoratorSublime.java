package gr.sublime.world.biome;

import gr.sublime.block.BlockDoublePlantBase;
import gr.sublime.config.ModConfig;
import gr.sublime.world.gen.feature.WorldGenBushes;
import gr.sublime.world.gen.feature.WorldGenDoublePlants;
import gr.sublime.world.gen.feature.WorldGenFlowers;
import gr.sublime.world.gen.feature.WorldGenLilyPad;
import gr.sublime.world.gen.feature.WorldGenCalamagrostis;
import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BiomeDecoratorSublime extends BiomeDecoratorBase {

    private int calamagrostisPerChunk = 20;
    private int lilyPadsPerChunk = 1;
    private int bushesPerChunk = 0;
    private int doublePlantsPerChunk = 2;

    protected WorldGenCalamagrostis calamagrostisGen = new WorldGenCalamagrostis();
    protected WorldGenLilyPad lilyPadGen = new WorldGenLilyPad();
    protected WorldGenDoublePlants doublePlantGen = new WorldGenDoublePlants();
    protected WorldGenFlowers flowerGen = new WorldGenFlowers();
    protected WorldGenBushes bushGen = new WorldGenBushes();

    public BiomeDecoratorSublime() {
        super();

        treesPerChunk = 1;
    }

    @Override
    protected void genDecorations(Biome biomeIn, World worldIn, Random random) {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, chunkPos));

        generateOres(worldIn, random);

        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.SAND, sandGen, sandPatchesPerChunk);
        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.CLAY, clayGen, clayPerChunk);
        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2, gravelGen, gravelPatchesPerChunk);
        generate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2, gravelGen, gravelPatchesPerChunk);
        generateTrees(worldIn, biomeIn, random, chunkPos);

        if (ModConfig.worldGenerationCat.genFallenLeaves) {
            generateBushes(worldIn, biomeIn, random, chunkPos);
        }

        generateFlowers(worldIn, (BiomeBase) biomeIn, random, chunkPos);
        generateDoublePlants(worldIn, (BiomeBase) biomeIn, random, chunkPos);

        if (ModConfig.worldGenerationCat.genCalamagrostis) {
            generateCalamagrostis(worldIn, (BiomeBase) biomeIn, random, chunkPos);
        }

        if (ModConfig.worldGenerationCat.genLotus) {
            generateLilyPads(worldIn, (BiomeBase) biomeIn, random, chunkPos);
        }

        if (ModConfig.worldGenerationCat.genTallGrass) {
            generateGrass(worldIn, biomeIn, random, chunkPos);
        }

        if (generateFalls) {
            generateFalls(worldIn, random, chunkPos);
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldIn, random, chunkPos));
    }

    /**
     * Generates variable leaf clusters.
     *
     * @param worldIn
     * @param biomeIn
     * @param random
     * @param chunkPos
     */
    private void generateBushes(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos) {
        int bushesToGen = bushesPerChunk;

        if (random.nextFloat() < 0.3f) {
            ++bushesToGen;
        }

        for (int numBushesGenerated = 0; numBushesGenerated < bushesToGen; ++numBushesGenerated) {
            int bushX = random.nextInt(16) + 8;
            int bushZ = random.nextInt(16) + 8;
            bushGen.setDecorationDefaults();
            BlockPos blockpos = worldIn.getHeight(chunkPos.add(bushX, 0, bushZ));

            // Initial leaf
            bushGen.generate(worldIn, random, blockpos);

            // Positive coordinate variations
            bushGen.generate(worldIn, random, blockpos.add(random.nextInt(1) + 1, 0, 0));
            bushGen.generate(worldIn, random, blockpos.add(0, random.nextInt(1) + 1, 0));
            bushGen.generate(worldIn, random, blockpos.add(0, 0, random.nextInt(1) + 1));
            bushGen.generate(worldIn, random, blockpos.add(random.nextInt(1) + 1, 0, random.nextInt(1) + 1));
            bushGen.generate(worldIn, random, blockpos.add(random.nextInt(1) + 1, random.nextInt(1), 0));
            bushGen.generate(worldIn, random, blockpos.add(0, random.nextInt(1) + 1, random.nextInt(1) + 1));

            // Negative coordinate variations
            bushGen.generate(worldIn, random, blockpos.add(random.nextInt(1) - 1, 0, 0));
            bushGen.generate(worldIn, random, blockpos.add(0, 0, random.nextInt(1) - 1));
            bushGen.generate(worldIn, random, blockpos.add(random.nextInt(1) - 1, 0, random.nextInt(1) - 1));
            bushGen.generate(worldIn, random, blockpos.add(random.nextInt(1) - 1, random.nextInt(1), 0));
            bushGen.generate(worldIn, random, blockpos.add(0, random.nextInt(1) + 1, random.nextInt(1) - 1));
        }
    }

    protected void generateCalamagrostis(World worldIn, BiomeBase biomeIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.REED)) {
            for (int k4 = 0; k4 < calamagrostisPerChunk; ++k4) {
                int i9 = random.nextInt(16) + 8;
                int l12 = random.nextInt(16) + 8;
                int i16 = worldIn.getHeight(this.chunkPos.add(i9, 0, l12)).getY() * 2;

                if (i16 > 0) {
                    int l18 = random.nextInt(i16);
                    calamagrostisGen.generate(worldIn, random, this.chunkPos.add(i9, l18, l12));
                }
            }

            for (int l4 = 0; l4 < 10; ++l4) {
                int j9 = random.nextInt(16) + 8;
                int i13 = random.nextInt(16) + 8;
                int j16 = worldIn.getHeight(this.chunkPos.add(j9, 0, i13)).getY() * 2;

                if (j16 > 0) {
                    int i19 = random.nextInt(j16);
                    calamagrostisGen.generate(worldIn, random, this.chunkPos.add(j9, i19, i13));
                }
            }
        }
    }

    protected void generateLilyPads(World worldIn, BiomeBase biomeIn, Random random, BlockPos chunkPos) {
        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LILYPAD))
            for (int k3 = 0; k3 < lilyPadsPerChunk; ++k3) {
                int l7 = random.nextInt(16) + 8;
                int k11 = random.nextInt(16) + 8;
                int i15 = worldIn.getHeight(this.chunkPos.add(l7, 0, k11)).getY() * 2;

                if (i15 > 0) {
                    int j18 = random.nextInt(i15);
                    BlockPos blockpos4;
                    BlockPos blockpos7;

                    for (blockpos4 = this.chunkPos.add(l7, j18, k11); blockpos4.getY() > 0; blockpos4 = blockpos7) {
                        blockpos7 = blockpos4.down();

                        if (!worldIn.isAirBlock(blockpos7)) {
                            break;
                        }
                    }

                    lilyPadGen.generate(worldIn, random, blockpos4);
                }
            }
    }

    protected void generateDoublePlants(World worldIn, BiomeBase biomeIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
            for (int doublePlantsGenerated = 0; doublePlantsGenerated < doublePlantsPerChunk; ++doublePlantsGenerated) {
                int flowerX = random.nextInt(16) + 8;
                int flowerZ = random.nextInt(16) + 8;
                int yRange = worldIn.getHeight(chunkPos.add(flowerX, 0, flowerZ)).getY() + 32;

                BlockDoublePlantBase plant = biomeIn.pickRandomDoublePlantModded(random, chunkPos);

                if (plant != null) {
                    doublePlantGen.setPlant(plant);

                    if (yRange > 0) {
                        int flowerY = random.nextInt(yRange);
                        BlockPos flowerBlockPos = chunkPos.add(flowerX, flowerY, flowerZ);
                        doublePlantGen.generate(worldIn, random, flowerBlockPos);
                    }
                }
            }
    }

    protected void generateFlowers(World worldIn, BiomeBase biomeIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
            for (int numFlowersGenerated = 0; numFlowersGenerated < flowersPerChunk; ++numFlowersGenerated) {
                int flowerX = random.nextInt(16) + 8;
                int flowerZ = random.nextInt(16) + 8;
                int yRange = worldIn.getHeight(chunkPos.add(flowerX, 0, flowerZ)).getY() + 32;

                BlockBush flower = biomeIn.pickRandomFlowerModded(random, chunkPos);

                if (flower != null) {
                    flowerGen.setFlower(flower);

                    if (yRange > 0) {
                        int flowerY = random.nextInt(yRange);
                        BlockPos flowerBlockPos = chunkPos.add(flowerX, flowerY, flowerZ);
                        flowerGen.generate(worldIn, random, flowerBlockPos);
                    }
                }
            }
    }
}
