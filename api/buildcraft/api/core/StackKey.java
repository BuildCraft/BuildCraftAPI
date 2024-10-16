/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.core;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/** This class is used whenever stacks needs to be stored as keys. */
public final class StackKey {
    public final ItemStack stack;
    public final FluidStack fluidStack;

    public StackKey(FluidStack fluidStack) {
        this(null, fluidStack);
    }

    public StackKey(ItemStack stack) {
        this(stack, null);
    }

    public StackKey(ItemStack stack, FluidStack fluidStack) {
        this.stack = stack;
        this.fluidStack = fluidStack;
    }

    // public static StackKey stack(Item item, int amount, int damage)
    public static StackKey stack(Item item, int amount) {
//        return new StackKey(new ItemStack(item, amount, damage));
        return new StackKey(new ItemStack(item, amount));
    }

    // public static StackKey stack(Block block, int amount, int damage)
    public static StackKey stack(Block block, int amount) {
//        return new StackKey(new ItemStack(block, amount, damage));
        return new StackKey(new ItemStack(block, amount));
    }

    public static StackKey stack(Item item) {
//        return new StackKey(new ItemStack(item, 1, 0));
        return new StackKey(new ItemStack(item, 1));
    }

    public static StackKey stack(Block block) {
//        return new StackKey(new ItemStack(block, 1, 0));
        return new StackKey(new ItemStack(block, 1));
    }

    public static StackKey stack(ItemStack itemStack) {
        return new StackKey(itemStack);
    }

    public static StackKey fluid(Fluid fluid, int amount) {
        return new StackKey(new FluidStack(fluid, amount));
    }

    public static StackKey fluid(Fluid fluid) {
        return new StackKey(new FluidStack(fluid, 1000));
    }

    public static StackKey fluid(FluidStack fluidStack) {
        return new StackKey(fluidStack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != StackKey.class) {
            return false;
        }
        StackKey k = (StackKey) o;
        if ((stack == null ^ k.stack == null) || (fluidStack == null ^ k.fluidStack == null)) {
            return false;
        }
        if (stack != null) {
            if (
                    stack.getItem() != k.stack.getItem()
//                            || stack.getHasSubtypes()
                            && stack.getDamageValue() != k.stack.getDamageValue()
                            || !objectsEqual(stack.getTag(), k.stack.getTag())
            )
            {
                return false;
            }
        }
        if (fluidStack != null) {
            if (!fluidStack.isFluidEqual(k.fluidStack) || fluidStack.getAmount() != k.fluidStack.getAmount()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 7;
        if (stack != null) {
            result = 31 * result + stack.getItem().hashCode();
            result = 31 * result + stack.getDamageValue();
            result = 31 * result + objectHashCode(stack.getTag());
        }
        result = 31 * result + 7;
        if (fluidStack != null) {
//            result = 31 * result + fluidStack.getFluid().getName().hashCode();
            result = 31 * result + fluidStack.getFluid().getRegistryName().hashCode();
            result = 31 * result + fluidStack.getAmount();
            result = 31 * result + objectHashCode(fluidStack.getTag());
        }
        return result;
    }

    private boolean objectsEqual(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        } else if (o1 == null || o2 == null) {
            return false;
        } else {
            return o1.equals(o2);
        }
    }

    private int objectHashCode(Object o) {
        return o != null ? o.hashCode() : 0;
    }

    public StackKey copy() {
        return new StackKey(stack != null ? stack.copy() : null, fluidStack != null ? fluidStack.copy() : null);
    }
}
