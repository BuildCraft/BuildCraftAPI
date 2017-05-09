package buildcraft.api.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumOptionalSnapshotType implements IStringSerializable {
    NONE(null),
    TEMPLATE(EnumSnapshotType.TEMPLATE),
    BLUEPRINT(EnumSnapshotType.BLUEPRINT);

    public final EnumSnapshotType type;

    EnumOptionalSnapshotType(EnumSnapshotType type) {
        this.type = type;
    }

    public static EnumOptionalSnapshotType fromNullable(EnumSnapshotType type) {
        if (type == null) {
            return NONE;
        }
        switch (type) {
            case TEMPLATE:
                return TEMPLATE;
            case BLUEPRINT:
                return BLUEPRINT;
            default:
                return NONE;
        }
    }

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
