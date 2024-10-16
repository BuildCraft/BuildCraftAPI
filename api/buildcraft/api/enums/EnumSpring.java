package buildcraft.api.enums;

import buildcraft.api.blocks.ISpring;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;
import java.util.function.Supplier;

public enum EnumSpring implements IStringSerializable {
    WATER(5, -1, Blocks.WATER.defaultBlockState()),
    OIL(6000, 8, null); // Set in BuildCraftEnergy

    public static final EnumSpring[] VALUES = values();

    public final int tickRate, chance;
    public BlockState liquidBlock;
    public boolean canGen = true;
    // public Supplier<TileEntity> tileConstructor;
    public Supplier<TileEntity> tileConstructor;

    private final String lowerCaseName = name().toLowerCase(Locale.ROOT);

    EnumSpring(int tickRate, int chance, BlockState liquidBlock) {
        this.tickRate = tickRate;
        this.chance = chance;
        this.liquidBlock = liquidBlock;
    }

    public static EnumSpring fromState(BlockState state) {
//        return state.getValue(BuildCraftProperties.SPRING_TYPE);
        if (state.getBlock() instanceof ISpring) {
            ISpring spring = (ISpring) state.getBlock();
            return spring.getType();
        } else {
            return null;
        }
    }

    @Override
    public String getSerializedName() {
        return lowerCaseName;
    }
}
