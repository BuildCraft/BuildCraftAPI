package buildcraft.api.fuels;

import java.util.Locale;

public enum EnumCoolantType {
    FLUID,
    SOLID,
    ;

    public String getLowerName() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public static EnumCoolantType byName(String name) {
        return valueOf(name.toUpperCase(Locale.ROOT));
    }
}
