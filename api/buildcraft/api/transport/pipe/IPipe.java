package buildcraft.api.transport.pipe;

import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public interface IPipe extends ICapabilityProvider {
    IPipeHolder getHolder();

    PipeDefinition getDefinition();

    PipeBehaviour getBehaviour();

    PipeFlow getFlow();

    DyeColor getColour();

    void setColour(DyeColor colour);

    void markForUpdate();

    TileEntity getConnectedTile(Direction side);

    IPipe getConnectedPipe(Direction side);

    boolean isConnected(Direction side);

    ConnectedType getConnectedType(Direction side);

    enum ConnectedType {
        TILE,
        PIPE
    }
}
