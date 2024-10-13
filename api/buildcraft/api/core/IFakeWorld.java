package buildcraft.api.core;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;

import java.util.function.Supplier;

public abstract class IFakeWorld extends Level {
    protected IFakeWorld(WritableLevelData data, ResourceKey<Level> dim, Holder<DimensionType> dimensionType, Supplier<ProfilerFiller> profiler, boolean pIsClientSide, boolean p_204154_, long p_204155_) {
        super(data, dim, dimensionType, profiler, pIsClientSide, p_204154_, p_204155_);
    }
}
