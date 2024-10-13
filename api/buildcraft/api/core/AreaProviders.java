package buildcraft.api.core;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class AreaProviders {
    public static final List<IAreaProviderGetter> providers = new ArrayList<>();

    public interface IAreaProviderGetter {
        /** @return All of the {@link IAreaProvider}'s that contain the specified block psoition. */
        List<IAreaProvider> getAreaProviders(Level world, BlockPos at);
    }

    public static List<IAreaProvider> getAreaProviders(Level world, BlockPos at) {
        List<IAreaProvider> list = new ArrayList<>();
        for (IAreaProviderGetter getter : providers) {
            list.addAll(getter.getAreaProviders(world, at));
        }
        return list;
    }
}
