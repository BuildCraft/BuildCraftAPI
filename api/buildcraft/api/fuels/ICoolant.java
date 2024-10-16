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

public interface ICoolant extends IRecipe<IInventory> {
    public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.ENERGY.getModId(), "coolant");

    public static final IRecipeType<ICoolant> TYPE = IRecipeType.register(TYPE_ID.toString());

    EnumCoolantType getCoolantType();

    FluidStack getFluid();

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
    default IRecipeType<?> getType() {
        return TYPE;
    }
}
