package buildcraft.api.recipes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import buildcraft.api.core.BuildCraftAPI;
import com.google.common.collect.ImmutableSet;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

/** Provides an immutable assembly recipe */
public final class AssemblyRecipe implements Comparable<AssemblyRecipe> {
    public final @Nonnull ResourceLocation name;
    public final long requiredMicroJoules;
    public final @Nonnull ImmutableSet<StackDefinition> requiredStacks;
    public final @Nonnull ItemStack output;
    /**
     * Additional tag used to restore network-transmitted recipe to same state.<br>
     * You need to register own {@link IAssemblyRecipeProvider} using {@link IAssemblyRecipeRegistry#addRecipeProvider(IAssemblyRecipeProvider)}
     * to handle this and declare {@link IAssemblyRecipeProvider#getRecipe(ResourceLocation, NBTTagCompound)} method
     */
    public final @Nullable NBTTagCompound recipeTag;

    public AssemblyRecipe(@Nonnull ResourceLocation name, long requiredMicroJoules, @Nonnull ImmutableSet<StackDefinition> requiredStacks, @Nonnull ItemStack output, @Nullable NBTTagCompound recipeTag) {
        this.name = name;
        this.requiredMicroJoules = requiredMicroJoules;
        this.requiredStacks = requiredStacks;
        this.output = output;
        this.recipeTag = recipeTag;
    }

    public AssemblyRecipe(@Nonnull String name, long requiredMicroJoules, @Nonnull ImmutableSet<StackDefinition> requiredStacks, @Nonnull ItemStack output, @Nullable NBTTagCompound recipeTag) {
        this(BuildCraftAPI.nameToResourceLocation(name), requiredMicroJoules, requiredStacks, output, recipeTag);
    }

    public AssemblyRecipe(@Nonnull ResourceLocation name, long requiredMicroJoules, @Nonnull ImmutableSet<StackDefinition> requiredStacks, @Nonnull ItemStack output) {
        this(name, requiredMicroJoules, requiredStacks, output, null);
    }

    public AssemblyRecipe(@Nonnull String name, long requiredMicroJoules, @Nonnull ImmutableSet<StackDefinition> requiredStacks, @Nonnull ItemStack output) {
        this(name, requiredMicroJoules, requiredStacks, output, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssemblyRecipe that = (AssemblyRecipe) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(AssemblyRecipe o) {
        return name.toString().compareTo(o.name.toString());
    }
}
