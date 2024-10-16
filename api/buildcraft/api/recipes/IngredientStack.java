/*
 * Copyright (c) 2017 SpaceToad and the BuildCraft team
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/
 */

package buildcraft.api.recipes;

import com.google.gson.JsonElement;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.crafting.CraftingHelper;

public final class IngredientStack {
    public final Ingredient ingredient;
    public final int count;

    public IngredientStack(Ingredient ingredient, int count) {
        this.ingredient = ingredient;
        this.count = count;
    }

    public IngredientStack(Ingredient ingredient) {
        this(ingredient, 1);
    }

    // public static IngredientStack of(Object o)
    public static IngredientStack of(JsonElement o) {
        return new IngredientStack(CraftingHelper.getIngredient(o));
    }

    public static IngredientStack of(ItemStack o) {
        return new IngredientStack(Ingredient.of(o));
    }

    public static IngredientStack of(IItemProvider o) {
        return new IngredientStack(Ingredient.of(o));
    }

    public static IngredientStack of(INamedTag tag) {
        return new IngredientStack(Ingredient.of(tag));
    }

    public void toNetwork(PacketBuffer buffer) {
        buffer.writeInt(this.count);
        this.ingredient.toNetwork(buffer);
    }

    public static IngredientStack fromNetwork(PacketBuffer buffer) {
        int countIn = buffer.readInt();
        Ingredient ingredientIn = Ingredient.fromNetwork(buffer);
        return new IngredientStack(ingredientIn, countIn);
    }
}
