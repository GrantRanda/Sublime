package gr.sublime.block;

import gr.sublime.Main;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public abstract class BlockSlabBase extends BlockSlab {

    public static final PropertyEnum<BlockSlabBase.Variant> VARIANT = PropertyEnum.create("variant", BlockSlabBase.Variant.class);

    public BlockSlabBase(String name) {
        super(Material.WOOD);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);

        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.WOOD);
        this.useNeighborBrightness = !this.isDouble();

        IBlockState iblockstate = this.blockState.getBaseState().withProperty(VARIANT, BlockSlabBase.Variant.DEFAULT);
        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }
        setDefaultState(iblockstate);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockSlabBase.Variant.DEFAULT);

        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.TOP : BlockSlab.EnumBlockHalf.BOTTOM);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, VARIANT) : new BlockStateContainer(this, VARIANT, HALF);
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return BlockSlabBase.Variant.DEFAULT;
    }

    public enum Variant implements IStringSerializable {
        DEFAULT;

        @Override
        public String getName() {
            return "default";
        }
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}
