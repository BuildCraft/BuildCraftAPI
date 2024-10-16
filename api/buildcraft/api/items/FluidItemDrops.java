package buildcraft.api.items;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fml.RegistryObject;

public class FluidItemDrops {
    public static RegistryObject<? extends IItemFluidShard> item;

    public static void addFluidDrops(NonNullList<ItemStack> toDrop, FluidStack... fluids) {
        if (item != null) {
            for (FluidStack fluid : fluids) {
                item.get().addFluidDrops(toDrop, fluid);
            }
        }
    }

    public static void addFluidDrops(NonNullList<ItemStack> toDrop, IFluidTank... tanks) {
        if (item != null) {
            for (IFluidTank tank : tanks) {
                item.get().addFluidDrops(toDrop, tank.getFluid());
            }
        }
    }
}
