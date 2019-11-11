package gr.sublime.world.biome;

import gr.sublime.block.BlockDoublePlantBase;
import gr.sublime.config.ModConfig;
import gr.sublime.init.ModBlocks;
import gr.sublime.world.gen.feature.WorldGenTreeBloodlessElm;
import gr.sublime.world.gen.feature.WorldGenTreeHanami;
import gr.sublime.world.gen.feature.WorldGenTreeYedoensis;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeSublime extends BiomeBase {

    private WorldGenTreeBloodlessElm worldGenTreeBloodlessElm = new WorldGenTreeBloodlessElm(false);
    private WorldGenTreeHanami worldGenTreeHanami = new WorldGenTreeHanami(false);
    private WorldGenTreeYedoensis worldGenTreeYedoensis = new WorldGenTreeYedoensis(false);

    public BiomeSublime(BiomeProperties properties) {
        super(properties);

        topBlock = ModBlocks.MUTED_GRASS.getDefaultState();
        fillerBlock = ModBlocks.MUTED_DIRT.getDefaultState();
    }

    @Override
    public BiomeDecoratorBase createBiomeDecorator() {
        return new BiomeDecoratorSublime();
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random par1Random) {
        if (ModConfig.worldGenerationCat.treeGenHanami && par1Random.nextInt(2) == 0) {
            return worldGenTreeHanami;
        }
        if (ModConfig.worldGenerationCat.treeGenYedoensis && par1Random.nextInt(8) == 0) {
            return worldGenTreeYedoensis;
        }
        if (ModConfig.worldGenerationCat.treeGenBloodlessElm) {
            return worldGenTreeBloodlessElm;
        }
        return null;
    }

    @Override
    public BlockBush pickRandomFlowerModded(Random rand, BlockPos pos) {
        if (ModConfig.worldGenerationCat.flowerGenAstrantia && rand.nextInt(2) > 0) {
            return ModBlocks.FLOWER_ASTRANTIA;
        }
        if (ModConfig.worldGenerationCat.flowerGenChrysanthemum) {
            return ModBlocks.FLOWER_CHYSANTHEMUM;
        }
        return null;
    }

    @Override
    public BlockDoublePlantBase pickRandomDoublePlantModded(Random rand, BlockPos pos) {
        if (ModConfig.worldGenerationCat.doublePlantGenEterisk) {
            return ModBlocks.DOUBLE_PLANT_ETERISK;
        }
        return null;
    }

    @Override
    protected void addFlowers() {
        flowers.clear();
        addFlower(ModBlocks.FLOWER_ASTRANTIA.getDefaultState(), 20);
        addFlower(ModBlocks.FLOWER_CHYSANTHEMUM.getDefaultState(), 20);
    }

    @Override
    protected void setSpawnables() {
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
        if (ModConfig.passiveMobSpawningCat.spawnSheep) spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 11, 2, 4));
        if (ModConfig.passiveMobSpawningCat.spawnCow) spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 9, 2, 4));
        if (ModConfig.passiveMobSpawningCat.spawnPig) spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 2, 4));
        if (ModConfig.passiveMobSpawningCat.spawnHorse) spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 6, 2, 6));
        if (ModConfig.passiveMobSpawningCat.spawnDonkey) spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDonkey.class, 3, 1, 3));
        if (ModConfig.hostileMobSpawningCat.spawnSpider) spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySpider.class, 100, 4, 4));
        if (ModConfig.hostileMobSpawningCat.spawnZombie) spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 95, 4, 4));
        if (ModConfig.hostileMobSpawningCat.spawnZombieVillager) spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 5, 1, 1));
        if (ModConfig.hostileMobSpawningCat.spawnSkeleton) spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        if (ModConfig.hostileMobSpawningCat.spawnCreeper) spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        if (ModConfig.hostileMobSpawningCat.spawnSlime) spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySlime.class, 100, 4, 4));
        if (ModConfig.hostileMobSpawningCat.spawnEnderman) spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        if (ModConfig.hostileMobSpawningCat.spawnWitch) spawnableMonsterList.add(new Biome.SpawnListEntry(EntityWitch.class, 5, 1, 1));
        if (ModConfig.passiveMobSpawningCat.spawnSquid) spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
        if (ModConfig.passiveMobSpawningCat.spawnBat) spawnableCaveCreatureList.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x635D5F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xD9CAD3;
    }
}
