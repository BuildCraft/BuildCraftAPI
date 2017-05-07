package buildcraft.api.schematics;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

public interface ISchematicEntity<S extends ISchematicEntity<S>> extends INBTSerializable<NBTTagCompound> {
    void init(SchematicEntityContext context);

    Vec3d getPos();

    @Nonnull
    List<ItemStack> getRequiredItems();

    @Nonnull
    List<FluidStack> getRequiredFluids();

    S getRotated(Rotation rotation);

    void computeRequired(SchematicEntityContext context);

    Entity build(World world, BlockPos basePos);

    Entity buildWithoutChecks(World world, BlockPos basePos);
}
