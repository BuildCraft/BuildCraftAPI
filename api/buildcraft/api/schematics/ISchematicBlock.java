package buildcraft.api.schematics;

import buildcraft.api.core.IFakeWorld;
import buildcraft.api.core.InvalidInputDataException;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface ISchematicBlock {
    void init(SchematicBlockContext context);

    default boolean isAir() {
        return false;
    }

    @Nonnull
    default Set<BlockPos> getRequiredBlockOffsets() {
        return Collections.emptySet();
    }

    @Nonnull
    default List<ItemStack> computeRequiredItems() {
        return Collections.emptyList();
    }

    @Nonnull
    default List<FluidStack> computeRequiredFluids() {
        return Collections.emptyList();
    }

    ISchematicBlock getRotated(Rotation rotation);

    boolean canBuild(World world, BlockPos blockPos);

    default boolean isReadyToBuild(World world, BlockPos blockPos) {
        return true;
    }

    boolean build(World world, BlockPos blockPos);

    // boolean buildWithoutChecks(World world, BlockPos blockPos);
    boolean buildWithoutChecks(IFakeWorld world, BlockPos blockPos);

    boolean isBuilt(World world, BlockPos blockPos);

    CompoundNBT serializeNBT();

    /** @throws InvalidInputDataException If the input data wasn't correct or didn't make sense. */
    void deserializeNBT(CompoundNBT nbt) throws InvalidInputDataException;
}
