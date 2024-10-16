package buildcraft.api.schematics;

import buildcraft.api.core.InvalidInputDataException;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public interface ISchematicEntity {
    void init(SchematicEntityContext context);

    Vector3d getPos();

    @Nonnull
    default List<ItemStack> computeRequiredItems() {
        return Collections.emptyList();
    }

    @Nonnull
    default List<FluidStack> computeRequiredFluids() {
        return Collections.emptyList();
    }

    ISchematicEntity getRotated(Rotation rotation);

    Entity build(World world, BlockPos basePos);

    Entity buildWithoutChecks(World world, BlockPos basePos);

    CompoundNBT serializeNBT();

    /** @throws InvalidInputDataException If the input data wasn't correct or didn't make sense. */
    void deserializeNBT(CompoundNBT nbt) throws InvalidInputDataException;
}
