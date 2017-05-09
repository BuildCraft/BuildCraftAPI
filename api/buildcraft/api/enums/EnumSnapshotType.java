package buildcraft.api.enums;

public enum EnumSnapshotType {
    TEMPLATE(3),
    BLUEPRINT(9);

    public final int maxPerTick;

    EnumSnapshotType(int maxPerTick) {
        this.maxPerTick = maxPerTick;
    }
}
