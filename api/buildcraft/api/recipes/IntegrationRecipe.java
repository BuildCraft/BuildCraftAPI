package buildcraft.api.recipes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import buildcraft.api.core.BuildCraftAPI;
import com.google.common.collect.ImmutableList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public final class IntegrationRecipe {
    public final @Nonnull ResourceLocation name;
    public final long requiredMicroJoules;
    public final @Nonnull StackDefinition target;
    public final @Nonnull ImmutableList<StackDefinition> toIntegrate;
    public final @Nonnull ItemStack output;
    /**
     * Additional tag used to restore network-transmitted recipe to same state
     * You need to register own {@link IIntegrationRecipeProvider} using {@link IIntegrationRecipeRegistry#addRecipeProvider(IIntegrationRecipeProvider)}
     * to handle this and declare {@link IIntegrationRecipeProvider#getRecipe(ResourceLocation, NBTTagCompound)} method
     */
    public final @Nullable NBTTagCompound recipeTag;

    public IntegrationRecipe(@Nonnull ResourceLocation name, long requiredMicroJoules, @Nonnull StackDefinition target, @Nonnull ImmutableList<StackDefinition> toIntegrate, @Nonnull ItemStack output, @Nullable NBTTagCompound recipeTag) {
        this.name = name;
        this.requiredMicroJoules = requiredMicroJoules;
        this.target = target;
        this.toIntegrate = toIntegrate;
        this.output = output;
        this.recipeTag = recipeTag;
    }

    public IntegrationRecipe(@Nonnull String name, long requiredMicroJoules, @Nonnull StackDefinition target, @Nonnull ImmutableList<StackDefinition> toIntegrate, @Nonnull ItemStack output, @Nullable NBTTagCompound recipeTag) {
        this(BuildCraftAPI.nameToResourceLocation(name), requiredMicroJoules, target, toIntegrate, output, recipeTag);
    }

    public IntegrationRecipe(@Nonnull ResourceLocation name, long requiredMicroJoules, @Nonnull StackDefinition target, @Nonnull ImmutableList<StackDefinition> toIntegrate, @Nonnull ItemStack output) {
        this(name, requiredMicroJoules, target, toIntegrate, output, null);
    }

    public IntegrationRecipe(@Nonnull String name, long requiredMicroJoules, @Nonnull StackDefinition target, @Nonnull ImmutableList<StackDefinition> toIntegrate, @Nonnull ItemStack output) {
        this(name, requiredMicroJoules, target, toIntegrate, output, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntegrationRecipe that = (IntegrationRecipe) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
