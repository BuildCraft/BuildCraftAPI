/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.fuels;

import buildcraft.api.BCModules;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

//public interface IFuel
public interface IFuel extends IRecipe<IInventory> {
    public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.ENERGY.getModId(), "fuel");

    public static final IRecipeType<IFuel> TYPE = IRecipeType.register(TYPE_ID.toString());

    /** @return The input fluid. The {@link FluidStack#getAmount()} is ignored. */
    FluidStack getFluid();

    /** @return The number of ticks that a single bucket (1000mb) of this fuel will burn for. */
    int getTotalBurningTime();

    /** @return The amount (in micro mj) of power that this fuel will give off in 1 tick. */
    long getPowerPerCycle();

    @Override
    default boolean matches(IInventory inv, World world) {
        return false;
    }

    @Override
    default ItemStack assemble(IInventory inv) {
        return ItemStack.EMPTY;
    }

    @Override
    default boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    default ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    default boolean isSpecial() {
        return true;
    }

    @Override
    default IRecipeType<IFuel> getType() {
        return TYPE;
    }
}
