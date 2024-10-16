package buildcraft.api.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumPowerStage implements IStringSerializable {
    BLUE,
    GREEN,
    YELLOW,
    RED,
    OVERHEAT,
    BLACK;

    public static final EnumPowerStage[] VALUES = values();

    private final String modelName = name().toLowerCase(Locale.ROOT);

    public String getModelName() {
        return modelName;
    }

    @Override
    public String getSerializedName() {
        return getModelName();
    }
}
