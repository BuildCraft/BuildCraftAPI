package buildcraft.api.enums;

import buildcraft.api.core.IEngineType;
import net.minecraft.util.IStringSerializable;

public enum EnumEngineType implements IStringSerializable, IEngineType {
    WOOD("core", "wood"),
    STONE("energy", "stone"),
    IRON("energy", "iron"),
    // CREATIVE("energy", "creative"),
    CREATIVE("core", "creative"),
    ;

    public final String unlocalizedTag;
    @Deprecated()
    public final String resourceLocation;

    public static final EnumEngineType[] VALUES = values();

    EnumEngineType(String mod, String loc) {
        unlocalizedTag = loc;
        resourceLocation = "buildcraft" + mod + ":blocks/engine/inv/" + loc;
    }

    @Deprecated()
    @Override
    public String getItemModelLocation() {
        return resourceLocation;
    }

    @Override
    public String getSerializedName() {
        return unlocalizedTag;
    }

//    public static EnumEngineType fromMeta(int meta) {
//        if (meta < 0 || meta >= VALUES.length) {
//            meta = 0;
//        }
//        return VALUES[meta];
//    }
}
