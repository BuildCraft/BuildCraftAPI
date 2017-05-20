package buildcraft.api.recipes;

import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface IRefineryRecipeManager {
    IHeatableRecipe createHeatingRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo, int ticks);

    default IHeatableRecipe addHeatableRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo, int ticks) {
        return getHeatableRegistry().addRecipe(createHeatingRecipe(in, out, heatFrom, heatTo, ticks));
    }

    ICoolableRecipe createCoolableRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo, int ticks);

    default ICoolableRecipe addCoolableRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo, int ticks) {
        return getCoolableRegistry().addRecipe(createCoolableRecipe(in, out, heatFrom, heatTo, ticks));
    }

    IDistillationRecipe createDistillationRecipe(FluidStack in, FluidStack outGas, FluidStack outLiquid, long powerRequired);

    default IDistillationRecipe addDistillationRecipe(FluidStack in, FluidStack outGas, FluidStack outLiquid, long powerRequired) {
        return getDistilationRegistry().addRecipe(createDistillationRecipe(in, outGas, outLiquid, powerRequired));
    }

    IRefineryRegistry<IHeatableRecipe> getHeatableRegistry();

    IRefineryRegistry<ICoolableRecipe> getCoolableRegistry();

    IRefineryRegistry<IDistillationRecipe> getDistilationRegistry();

    interface IRefineryRegistry<R extends IRefineryRecipe> {
        /** @return an unmodifiable collection containing all of the distillation recipes that satisfy the given
         *         predicate. All of the recipe objects are guaranteed to never be null. */
        Stream<R> getRecipes(Predicate<R> toReturn);

        /** @return an unmodifiable set containing all of the distillation recipes. */
        Collection<R> getAllRecipes();

        @Nullable
        R getRecipeForInput(@Nullable FluidStack fluid);

        Collection<R> removeRecipes(Predicate<R> toRemove);

        /** Adds the given recipe to the registry. Note that this will remove any existing recipes for the passed
         * recipe's {@link IRefineryRecipe#in()}
         * 
         * @param recipe The recipe to add.
         * @return The input recipe. */
        R addRecipe(R recipe);
    }

    interface IRefineryRecipe {
        FluidStack in();
    }

    interface IHeatExchangerRecipe extends IRefineryRecipe {
        int ticks();

        @Nullable
        FluidStack out();

        int heatFrom();

        int heatTo();
    }

    interface IHeatableRecipe extends IHeatExchangerRecipe {}

    interface ICoolableRecipe extends IHeatExchangerRecipe {}

    interface IDistillationRecipe extends IRefineryRecipe {
        long powerRequired();

        FluidStack outGas();

        FluidStack outLiquid();
    }
}
