/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */
package buildcraft.api.fuels;

import net.minecraftforge.fluids.FluidStack;

/**
 * This was named ICoolant in 1.12.2.
 * In 1.18.2, we differ coolants as {@link EnumCoolantType#FLUID} AND {@link EnumCoolantType#SOLID}.,
 * {@link IFluidCoolant} and {@link ISolidCoolant} both extends {@link ICoolant}.
 */
public interface IFluidCoolant extends ICoolant {
    boolean matchesFluid(FluidStack fluid);

    /** @param fluid
     * @param heat
     * @return 0 if the input fluid provides no cooling, or a value greater than 0 if it does. */
    float getDegreesCoolingPerMB(FluidStack fluid, float heat);

    /** @return The degrees-of-cooling-per-mb value of the recipe, ignoring whether a correct input is present. */
    float getDegreesCoolingPerMB();
}
