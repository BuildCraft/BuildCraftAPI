package buildcraft.api.schematics;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;

public interface ISchematicBlock<S extends ISchematicBlock<S>> extends INBTSerializable<NBTTagCompound> {
    int BLOCK_LEVEL = 0;
    int FLUID_LEVEL = 1;

    void init(SchematicBlockContext context);

    int getLevel();

    boolean isAir();

    @Nonnull
    Set<BlockPos> getRequiredBlockOffsets();

    @Nonnull
    List<ItemStack> computeRequiredItems(SchematicBlockContext context);

    @Nonnull
    List<FluidStack> computeRequiredFluids(SchematicBlockContext context);

    S getRotated(Rotation rotation);

    boolean canBuild(World world, BlockPos blockPos);

    boolean build(World world, BlockPos blockPos);

    boolean buildWithoutChecks(World world, BlockPos blockPos);

    boolean isBuilt(World world, BlockPos blockPos);
}
