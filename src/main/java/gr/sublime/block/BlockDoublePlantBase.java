package gr.sublime.block;

import gr.sublime.Main;
import gr.sublime.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockDoublePlantBase extends BlockBush implements IGrowable, IShearable {

    public static final PropertyEnum<EnumPlantType> VARIANT = PropertyEnum.<BlockDoublePlantBase.EnumPlantType>create("variant", BlockDoublePlantBase.EnumPlantType.class);
    public static final PropertyEnum<EnumBlockHalf> HALF = PropertyEnum.<BlockDoublePlantBase.EnumBlockHalf>create("half", BlockDoublePlantBase.EnumBlockHalf.class);
    public static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;

    public BlockDoublePlantBase(String name) {
        super(Material.VINE);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumPlantType.ETERISK).withProperty(HALF, BlockDoublePlantBase.EnumBlockHalf.LOWER).withProperty(FACING, EnumFacing.NORTH));
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return FULL_BLOCK_AABB;
    }

    public BlockDoublePlantBase.EnumPlantType getType(IBlockAccess blockAccess, BlockPos pos, IBlockState state) {
        if (state.getBlock() == this) {
            state = state.getActualState(blockAccess, pos);
            return (BlockDoublePlantBase.EnumPlantType) state.getValue(VARIANT);
        } else {
            return EnumPlantType.ETERISK;
        }
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn, pos) && worldIn.isAirBlock(pos.up());
    }

    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() != this) {
            return true;
        } else {
            BlockDoublePlantBase.EnumPlantType blockdoubleplantbase$enumplanttype = (BlockDoublePlantBase.EnumPlantType) iblockstate.getActualState(worldIn, pos).getValue(VARIANT);
            return blockdoubleplantbase$enumplanttype == EnumPlantType.ETERISK;
        }
    }

    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!this.canBlockStay(worldIn, pos, state)) {
            boolean flag = state.getValue(HALF) == BlockDoublePlantBase.EnumBlockHalf.UPPER;
            BlockPos blockpos = flag ? pos : pos.up();
            BlockPos blockpos1 = flag ? pos.down() : pos;
            Block block = (Block) (flag ? this : worldIn.getBlockState(blockpos).getBlock());
            Block block1 = (Block) (flag ? worldIn.getBlockState(blockpos1).getBlock() : this);

            if (!flag) this.dropBlockAsItem(worldIn, pos, state, 0); //Forge move above the setting to air.

            if (block == this) {
                worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
            }

            if (block1 == this) {
                worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
            }
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getBlock() != this)
            return super.canBlockStay(worldIn, pos, state); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        if (state.getValue(HALF) == BlockDoublePlantBase.EnumBlockHalf.UPPER) {
            return worldIn.getBlockState(pos.down()).getBlock() == this;
        } else {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());
            return iblockstate.getBlock() == this && super.canBlockStay(worldIn, pos, iblockstate);
        }
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (state.getValue(HALF) == BlockDoublePlantBase.EnumBlockHalf.UPPER) {
            return Items.AIR;
        } else {
            BlockDoublePlantBase.EnumPlantType blockdoubleplantbase$enumplanttype = (BlockDoublePlantBase.EnumPlantType) state.getValue(VARIANT);

            return super.getItemDropped(state, rand, fortune);
        }
    }

    public int damageDropped(IBlockState state) {
        return state.getValue(HALF) != BlockDoublePlantBase.EnumBlockHalf.UPPER && state.getValue(VARIANT) != EnumPlantType.ETERISK ? ((BlockDoublePlantBase.EnumPlantType) state.getValue(VARIANT)).getMeta() : 0;
    }

    public void placeAt(World worldIn, BlockPos lowerPos, BlockDoublePlantBase.EnumPlantType variant, int flags) {
        worldIn.setBlockState(lowerPos, this.getDefaultState().withProperty(HALF, BlockDoublePlantBase.EnumBlockHalf.LOWER).withProperty(VARIANT, variant), flags);
        worldIn.setBlockState(lowerPos.up(), this.getDefaultState().withProperty(HALF, BlockDoublePlantBase.EnumBlockHalf.UPPER), flags);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, BlockDoublePlantBase.EnumBlockHalf.UPPER), 2);
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (state.getValue(HALF) == BlockDoublePlantBase.EnumBlockHalf.UPPER) {
            if (worldIn.getBlockState(pos.down()).getBlock() == this) {
                if (player.capabilities.isCreativeMode) {
                    worldIn.setBlockToAir(pos.down());
                } else {
                    IBlockState iblockstate = worldIn.getBlockState(pos.down());
                    BlockDoublePlantBase.EnumPlantType blockdoubleplantbase$enumplanttype = (BlockDoublePlantBase.EnumPlantType) iblockstate.getValue(VARIANT);

                    if (blockdoubleplantbase$enumplanttype != EnumPlantType.ETERISK) {
                        worldIn.destroyBlock(pos.down(), true);
                    } else if (worldIn.isRemote) {
                        worldIn.setBlockToAir(pos.down());
                    } else if (!player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().getItem() == Items.SHEARS) {
                        this.onHarvest(worldIn, pos, iblockstate, player);
                        worldIn.setBlockToAir(pos.down());
                    } else {
                        worldIn.destroyBlock(pos.down(), true);
                    }
                }
            }
        } else if (worldIn.getBlockState(pos.up()).getBlock() == this) {
            worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 2);
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    private boolean onHarvest(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        BlockDoublePlantBase.EnumPlantType blockdoubleplantbase$enumplanttype = (BlockDoublePlantBase.EnumPlantType) state.getValue(VARIANT);

        if (blockdoubleplantbase$enumplanttype != EnumPlantType.ETERISK) {
            return false;
        } else {
            player.addStat(StatList.getBlockStats(this));
            return true;
        }
    }

    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (BlockDoublePlantBase.EnumPlantType blockdoubleplantbase$enumplanttype : BlockDoublePlantBase.EnumPlantType.values()) {
            items.add(new ItemStack(this, 1, blockdoubleplantbase$enumplanttype.getMeta()));
        }
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this, 1, this.getType(worldIn, pos, state).getMeta());
    }

    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        spawnAsEntity(worldIn, pos, new ItemStack(this, 1, this.getType(worldIn, pos, state).getMeta()));
    }

    public IBlockState getStateFromMeta(int meta) {
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockDoublePlantBase.EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, BlockDoublePlantBase.EnumBlockHalf.LOWER).withProperty(VARIANT, BlockDoublePlantBase.EnumPlantType.byMetadata(meta & 7));
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        if (state.getValue(HALF) == BlockDoublePlantBase.EnumBlockHalf.UPPER) {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());

            if (iblockstate.getBlock() == this) {
                state = state.withProperty(VARIANT, iblockstate.getValue(VARIANT));
            }
        }

        return state;
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(HALF) == BlockDoublePlantBase.EnumBlockHalf.UPPER ? 8 | ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() : ((BlockDoublePlantBase.EnumPlantType) state.getValue(VARIANT)).getMeta();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{HALF, VARIANT, FACING});
    }

    public Block.EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XZ;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public java.util.List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        BlockDoublePlantBase.EnumPlantType type = (BlockDoublePlantBase.EnumPlantType) world.getBlockState(pos).getValue(VARIANT);
        if (type == EnumPlantType.ETERISK)
            ret.add(new ItemStack(ModBlocks.DOUBLE_PLANT_ETERISK, 2, EnumPlantType.ETERISK.getMeta()));
        return ret;
    }

    public static enum EnumBlockHalf implements IStringSerializable {
        UPPER,
        LOWER;

        public String toString() {
            return this.getName();
        }

        public String getName() {
            return this == UPPER ? "upper" : "lower";
        }
    }

    public static enum EnumPlantType implements IStringSerializable {
        ETERISK(0, "eterisk");

        private static final BlockDoublePlantBase.EnumPlantType[] META_LOOKUP = new BlockDoublePlantBase.EnumPlantType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumPlantType(int meta, String name) {
            this(meta, name, name);
        }

        private EnumPlantType(int meta, String name, String unlocalizedName) {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMeta() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public static BlockDoublePlantBase.EnumPlantType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName() {
            return this.name;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

        static {
            for (BlockDoublePlantBase.EnumPlantType blockdoubleplantbase$enumplanttype : values()) {
                META_LOOKUP[blockdoubleplantbase$enumplanttype.getMeta()] = blockdoubleplantbase$enumplanttype;
            }
        }
    }
}
