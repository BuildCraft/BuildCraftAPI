package buildcraft.api.recipes;

import buildcraft.api.BCModules;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Set;

public interface IAssemblyRecipe extends Comparable<IAssemblyRecipe>, IRecipe<IInventory> {
    public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.SILICON.getModId(), "assembly");

    public static final IRecipeType<IAssemblyRecipe> TYPE = IRecipeType.register(TYPE_ID.toString());

    /**
     * The outputs this recipe can generate with any of the given inputs
     *
     * @param inputs Current ingredients in the assembly table
     * @return A Set containing all possible outputs given the given inputs or an empty one if nothing can be assembled from the given inputs
     */
    public abstract Set<ItemStack> getOutputs(NonNullList<ItemStack> inputs);

    /** Used to determine all outputs from this recipe for recipe previews (guide book and/or JEI) */
    public abstract Set<ItemStack> getOutputPreviews();

    /**
     * Used to determine what items to use up for the given output
     *
     * @param output The output we want to know the inputs for, only ever called using stacks obtained from getOutputs or getOutputPreviews
     */
    public abstract Set<IngredientStack> getInputsFor(@Nonnull ItemStack output);

    /**
     * Used to determine how much MJ is required to asemble the given output item
     *
     * @param output The output we want to know the MJ cost for, only ever called using stacks obtained from getOutputs or getOutputPreviews
     */
    public abstract long getRequiredMicroJoulesFor(@Nonnull ItemStack output);

    @Override
    public default int compareTo(IAssemblyRecipe o) {
        return getId().toString().compareTo(o.getId().toString());
    }

    public abstract long getRequiredMicroJoules();

    public abstract Set<IngredientStack> getRequiredIngredientStacks();

    public abstract Set<ItemStack> getOutput();

    // IRecipe

    @Override
    public default boolean matches(IInventory inv, World world) {
        return false;
    }

    @Override
    public default boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public default boolean isSpecial() {
        return true;
    }

    @Override
    public default IRecipeType<IAssemblyRecipe> getType() {
        return TYPE;
    }
}
