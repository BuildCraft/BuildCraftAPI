package buildcraft.api.recipes;

import buildcraft.api.BCModules;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface IRefineryRecipeManager {
    // IHeatableRecipe createHeatingRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo);
    IHeatableRecipe createHeatingRecipe(ResourceLocation id, FluidStack in, FluidStack out, int heatFrom, int heatTo);

    // default IHeatableRecipe addHeatableRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo)
    default IHeatableRecipe addUnregisteredHeatableRecipe(ResourceLocation id, FluidStack in, FluidStack out, int heatFrom, int heatTo) {
//        return getHeatableRegistry().addRecipe(createHeatingRecipe(in, out, heatFrom, heatTo));
        return getHeatableRegistry().addUnregisteredRecipe(createHeatingRecipe(id, in, out, heatFrom, heatTo));
    }

    // ICoolableRecipe createCoolableRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo);
    ICoolableRecipe createCoolableRecipe(ResourceLocation id, FluidStack in, FluidStack out, int heatFrom, int heatTo);

    // default ICoolableRecipe addCoolableRecipe(FluidStack in, FluidStack out, int heatFrom, int heatTo)
    default ICoolableRecipe addUnregisteredCoolableRecipe(ResourceLocation id, FluidStack in, FluidStack out, int heatFrom, int heatTo) {
//        return getCoolableRegistry().addRecipe(createCoolableRecipe(in, out, heatFrom, heatTo));
        return getCoolableRegistry().addUnregisteredRecipe(createCoolableRecipe(id, in, out, heatFrom, heatTo));
    }

    // IDistillationRecipe createDistillationRecipe(FluidStack in, FluidStack outGas, FluidStack outLiquid, long powerRequired);
    IDistillationRecipe createDistillationRecipe(ResourceLocation id, FluidStack in, FluidStack outGas, FluidStack outLiquid, long powerRequired);

    // default IDistillationRecipe addDistillationRecipe(FluidStack in, FluidStack outGas, FluidStack outLiquid, long powerRequired)
    default IDistillationRecipe addUnregisteredDistillationRecipe(ResourceLocation id, FluidStack in, FluidStack outGas, FluidStack outLiquid, long powerRequired) {
//        return getDistillationRegistry().addRecipe(createDistillationRecipe(in, outGas, outLiquid, powerRequired));
        return getDistillationRegistry().addUnregisteredRecipe(createDistillationRecipe(id, in, outGas, outLiquid, powerRequired));
    }

    IRefineryRegistry<IHeatableRecipe> getHeatableRegistry();

    IRefineryRegistry<ICoolableRecipe> getCoolableRegistry();

    IRefineryRegistry<IDistillationRecipe> getDistillationRegistry();

    interface IRefineryRegistry<R extends IRefineryRecipe> {
        /** @return an unmodifiable collection containing all of the distillation recipes that satisfy the given
         *         predicate. All of the recipe objects are guaranteed to never be null. */
//        Stream<R> getRecipes(Predicate<R> toReturn);
        Stream<R> getRecipes(World world, Predicate<R> toReturn);

        /** @return an unmodifiable set containing all of the distillation recipes. */
//        Collection<R> getAllRecipes();
        Collection<R> getAllRecipes(World world);

        @Nullable
//        R getRecipeForInput(@Nullable FluidStack fluid);
        R getRecipeForInput(World world, @Nullable FluidStack fluid);

        // Collection<R> removeRecipes(Predicate<R> toRemove);
        Collection<R> removeUnregisteredRecipes(Predicate<R> toRemove);

        /** Adds the given recipe to the registry. Note that this will remove any existing recipes for the passed
         * recipe's {@link IRefineryRecipe#in()}
         *
         * @param recipe The recipe to add.
         * @return The input recipe. */
//        R addRecipe(R recipe);
        R addUnregisteredRecipe(R recipe);

//        // Calen
//        IRecipeType<R> getRecipeType;
    }

    // interface IRefineryRecipe
    interface IRefineryRecipe extends IRecipe<IInventory> {
        FluidStack in();
    }

    interface IHeatExchangerRecipe extends IRefineryRecipe {
        @Nullable
        FluidStack out();

        int heatFrom();

        int heatTo();
    }

    interface IHeatableRecipe extends IHeatExchangerRecipe {
        public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.FACTORY.getModId(), "heat_exchange/heatable");

        public static final IRecipeType<IHeatableRecipe> TYPE = IRecipeType.register(TYPE_ID.toString());


        @Override
        default IRecipeType<IHeatableRecipe> getType() {
            return TYPE;
        }
    }

    interface ICoolableRecipe extends IHeatExchangerRecipe {
        public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.FACTORY.getModId(), "heat_exchange/coolable");

        public static final IRecipeType<ICoolableRecipe> TYPE = IRecipeType.register(TYPE_ID.toString());

        @Override
        default IRecipeType<ICoolableRecipe> getType() {
            return TYPE;
        }
    }

    interface IDistillationRecipe extends IRefineryRecipe {
        public static final ResourceLocation TYPE_ID = new ResourceLocation(BCModules.FACTORY.getModId(), "distillation");

        public static final IRecipeType<IDistillationRecipe> TYPE = IRecipeType.register(TYPE_ID.toString());

        long powerRequired();

        FluidStack outGas();

        FluidStack outLiquid();

        @Override
        default IRecipeType<IDistillationRecipe> getType() {
            return TYPE;
        }
    }
}
