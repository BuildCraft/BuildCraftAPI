package buildcraft.api.tiles;

import buildcraft.api.core.CapabilitiesHelper;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nonnull;

public class TilesAPI {
    @Nonnull
    public static Capability<IControllable> CAP_CONTROLLABLE;

    @Nonnull
    public static Capability<IHasWork> CAP_HAS_WORK;

    @Nonnull
    public static Capability<IHeatable> CAP_HEATABLE;

    @Nonnull
    public static Capability<ITileAreaProvider> CAP_TILE_AREA_PROVIDER;

    // static
    public static void regCaps() {
        CAP_CONTROLLABLE = CapabilitiesHelper.registerCapability(IControllable.class);
        CAP_HAS_WORK = CapabilitiesHelper.registerCapability(IHasWork.class);
        CAP_HEATABLE = CapabilitiesHelper.registerCapability(IHeatable.class);
        CAP_TILE_AREA_PROVIDER = CapabilitiesHelper.registerCapability(ITileAreaProvider.class);
    }
}
