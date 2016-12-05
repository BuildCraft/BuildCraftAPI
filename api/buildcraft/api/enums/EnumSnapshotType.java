package buildcraft.api.enums;

public enum EnumSnapshotType {
//    NONE(0),
    BLUEPRINT(30),
    TEMPLATE(10);

    public int creationTime;

    EnumSnapshotType(int creationTime) {
        this.creationTime = creationTime;
    }
//
//    public static EnumSnapshotType valueOf(int index) {
//        if (index <= 0 || index >= values().length) {
//            return NONE;
//        } else {
//            return values()[index];
//        }
//    }
//
//    public static EnumSnapshotType getType(ItemStack item) {
//        if (item == null) {
//            return NONE;
//        } else if (item.getItem() instanceof IBlueprintItem) {
//            return ((IBlueprintItem) item.getItem()).getType(item);
//        } else {
//            return NONE;
//        }
//    } // moved to ItemSnapshot
}
