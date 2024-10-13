package buildcraft.api.facades;

import net.minecraft.nbt.CompoundTag;

public interface IFacade {
    FacadeType getType();

    boolean isHollow();

    IFacadePhasedState[] getPhasedStates();

    CompoundTag writeToNbt();
}
