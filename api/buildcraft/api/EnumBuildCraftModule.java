package buildcraft.api;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Predicate;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;

public enum EnumBuildCraftModule {
    LIB,
    // Base module for all BC.
    CORE,
    // Potentially optional modules for adding more BC functionality
    BUILDERS,
    ENERGY,
    FACTORY,
    ROBOTICS,
    SILICON,
    TRANSPORT,
    // Optional module for compatibility with other mods
    COMPAT;

    public static final EnumBuildCraftModule[] VALUES = values();

    public static boolean isBuildCraftMod(String modid) {
        return Arrays.stream(VALUES).map(EnumBuildCraftModule::getModid).anyMatch(Predicate.isEqual(modid));
    }

    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public String getModid() {
        return "buildcraft" + getName();
    }

    public boolean isLoaded() {
        if (!Loader.instance().hasReachedState(LoaderState.CONSTRUCTING)) {
            throw new RuntimeException("Accessed isLoaded method too early! You can only use it from construction onwards!");
        }
        return Loader.isModLoaded(getModid());
    }
}
