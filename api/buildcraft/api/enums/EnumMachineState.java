package buildcraft.api.enums;

import buildcraft.api.properties.BuildCraftProperties;
import net.minecraft.block.BlockState;
import net.minecraft.util.IStringSerializable;

public enum EnumMachineState implements IStringSerializable {
    OFF,
    ON,
    DONE;

    public static EnumMachineState getType(BlockState state) {
        return state.getValue(BuildCraftProperties.MACHINE_STATE);
    }

    @Override
    public String getSerializedName() {
        return name();
    }
}
