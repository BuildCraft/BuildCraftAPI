/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */
package buildcraft.api.fuels;

import buildcraft.api.BCModules;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;

//public interface IFuel
public interface IFuel extends Recipe<Container> {
    public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.ENERGY.getModId(), "fuel");

    public static final RecipeType<IFuel> TYPE = RecipeType.simple(TYPE_ID);

    /** @return The input fluid. The {@link FluidStack#getAmount()} is ignored. */
    FluidStack getFluid();

    /** @return The number of ticks that a single bucket (1000mb) of this fuel will burn for. */
    int getTotalBurningTime();

    /** @return The amount (in micro mj) of power that this fuel will give off in 1 tick. */
    long getPowerPerCycle();

    @Override
    default boolean matches(Container inv, Level world) {
        return false;
    }

    @Override
    default ItemStack assemble(Container inv, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    default boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    default ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    default boolean isSpecial() {
        return true;
    }

    @Override
    default RecipeType<IFuel> getType() {
        return TYPE;
    }
}
