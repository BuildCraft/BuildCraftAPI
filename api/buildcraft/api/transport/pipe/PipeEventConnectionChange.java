package buildcraft.api.transport.pipe;

import net.minecraft.util.EnumFacing;

/** Fired whenever a connection change is picked up by an {@link IPipe}. This even doesn't include the new value
 * (boolean isConnected) as it can be accessed via {@link IPipe#isConnected(EnumFacing)}. */
public class PipeEventConnectionChange extends PipeEvent {

    public final EnumFacing direction;

    public PipeEventConnectionChange(IPipeHolder holder, EnumFacing direction) {
        super(holder);
        this.direction = direction;
    }
}
