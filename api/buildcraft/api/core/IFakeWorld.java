package buildcraft.api.core;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class IFakeWorld extends World {
    protected IFakeWorld(ISpawnWorldInfo data, RegistryKey<World> dim, DimensionType dimensionType, Supplier<IProfiler> profiler, boolean pIsClientSide, boolean p_204154_, long p_204155_) {
        super(data, dim, dimensionType, profiler, pIsClientSide, p_204154_, p_204155_);
    }
}
