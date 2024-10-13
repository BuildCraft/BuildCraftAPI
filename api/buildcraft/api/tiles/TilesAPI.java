package buildcraft.api.tiles;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;

public class TilesAPI {
    @Nonnull
    public static final Capability<IControllable> CAP_CONTROLLABLE = CapabilityManager.get(new CapabilityToken<>() {
    });

    @Nonnull
    public static final Capability<IHasWork> CAP_HAS_WORK = CapabilityManager.get(new CapabilityToken<>() {
    });

    @Nonnull
    public static final Capability<IHeatable> CAP_HEATABLE = CapabilityManager.get(new CapabilityToken<>() {
    });

    @Nonnull
    public static final Capability<ITileAreaProvider> CAP_TILE_AREA_PROVIDER = CapabilityManager.get(new CapabilityToken<>() {
    });

    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event) {
        event.register(IControllable.class);
        event.register(IHasWork.class);
        event.register(IHeatable.class);
        event.register(ITileAreaProvider.class);
    }
}
