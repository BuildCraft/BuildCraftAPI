package buildcraft.api.mj;

import buildcraft.api.BCModules;

public interface IMjToRfStatus {

    public static IMjToRfStatus get() {
        return MjToRfStatusHolder.STATUS;
    }

    MjRfConversion getConversion();

    boolean isAutoconvertEnabled();
}

final class MjToRfStatusHolder implements IMjToRfStatus {

    static final IMjToRfStatus STATUS = get0();

    private static IMjToRfStatus get0() {
        if (BCModules.LIB.isLoaded()) {
            try {
                return (IMjToRfStatus) Class.forName("buildcraft.lib.BCLibConfig$MjToRfStatus").newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new Error(e);
            }
        } else {
            return new MjToRfStatusHolder();
        }
    }

    private final MjRfConversion defaultConversion = MjRfConversion.createDefault();

    @Override
    public MjRfConversion getConversion() {
        return defaultConversion;
    }

    @Override
    public boolean isAutoconvertEnabled() {
        return false;
    }
}
