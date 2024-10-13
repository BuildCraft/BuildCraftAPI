/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.fuels;

import buildcraft.api.BCModules;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;

public interface ICoolant extends Recipe<Container> {
    public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.ENERGY.getModId(), "coolant");

    public static final RecipeType<ICoolant> TYPE = RecipeType.register(TYPE_ID.toString());

    EnumCoolantType getCoolantType();

    FluidStack getFluid();

    @Override
    default boolean matches(Container inv, Level world) {
        return false;
    }

    @Override
    default ItemStack assemble(Container inv) {
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
    default RecipeType<?> getType() {
        return TYPE;
    }
}
