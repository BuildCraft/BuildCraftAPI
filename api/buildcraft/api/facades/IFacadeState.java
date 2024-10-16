package buildcraft.api.facades;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

public interface IFacadeState {
    boolean isTransparent();

    BlockState getBlockState();

    ItemStack getRequiredStack();
}
