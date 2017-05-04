/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.recipes;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public final class BuildcraftRecipeRegistry {

    public static IAssemblyRecipeRegistry assemblyRecipes;
    public static IIntegrationRecipeRegistry integrationRecipes;
    public static IRefineryRecipeManager refineryRecipes;

    private BuildcraftRecipeRegistry() {}

    public static ResourceLocation parseRecipeName(String name) {
        if (name.indexOf(':') > 0) return new ResourceLocation(name);
        ModContainer modContainer = Loader.instance().activeModContainer();
        if (modContainer == null) {
            throw new IllegalStateException("Illegal recipe name " + name + ". Provide domain id to register it correctly.");
        }
        return new ResourceLocation(modContainer.getModId(), name);
    }
}
