package buildcraft.api.items;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public interface INamedItem {
    // ITextComponent getName(@Nonnull ItemStack stack);
    String getName_INamedItem(@Nonnull ItemStack stack);

    boolean setName(@Nonnull ItemStack stack, String name);
}
