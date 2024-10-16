package buildcraft.api.items;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;

public interface IItemFluidShard {
    void addFluidDrops(NonNullList<ItemStack> toDrop, @Nullable FluidStack fluid);
}
