package buildcraft.api.core;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;

import java.util.function.Supplier;

public abstract class IFakeWorld extends Level {
    protected IFakeWorld(WritableLevelData data, ResourceKey<Level> dim, RegistryAccess registryAccess, Holder<DimensionType> dimensionType, Supplier<ProfilerFiller> profiler, boolean pIsClientSide, boolean isDebug, long biomeZoomSeed, int maxChainedNeighborUpdates) {
        super(data, dim, registryAccess, dimensionType, profiler, pIsClientSide, isDebug, biomeZoomSeed, maxChainedNeighborUpdates);
    }
}
