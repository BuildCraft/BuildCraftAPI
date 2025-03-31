package buildcraft.api.transport.pipe;

public interface IFlowPowerLike {
    /** Makes this pipe reconfigure itself, possibly due to the addition of new modules. */
    void reconfigure();
}
