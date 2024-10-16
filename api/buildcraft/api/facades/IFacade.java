package buildcraft.api.facades;

import net.minecraft.nbt.CompoundNBT;

public interface IFacade {
    FacadeType getType();

    boolean isHollow();

    IFacadePhasedState[] getPhasedStates();

    CompoundNBT writeToNbt();
}
