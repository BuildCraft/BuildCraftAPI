package buildcraft.api.transport.pipe;

import net.minecraft.util.EnumFacing;

import net.minecraftforge.energy.IEnergyStorage;

public interface IFlowRedstoneFlux extends IFlowPowerLike {
    /** Makes this pipe reconfigure itself, possibly due to the addition of new modules. */
    @Override
    void reconfigure();

    /** Attempts to extract power from the {@link IEnergyStorage} connected to this pipe on the given side.
     * 
     * @param maxPower The Maximum amount of power that can be extracted.
     * @param from The side (of this pipe) to take power from.
     * @return The amount of power extracted. */
    int tryExtractPower(int maxPower, EnumFacing from);
}
