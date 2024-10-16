package buildcraft.api.facades;

import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public interface IFacadePhasedState {
    IFacadeState getState();

    @Nullable
    DyeColor getActiveColor();
}
