package buildcraft.api.transport;

import buildcraft.api.mj.MjAPI;
import buildcraft.api.transport.neptune.IFlowPower;
import buildcraft.api.transport.neptune.IPipeHolder;

public abstract class PipeEventPower extends PipeEvent {
    public final IFlowPower flow;

    protected PipeEventPower(IPipeHolder holder, IFlowPower flow) {
        super(holder);
        this.flow = flow;
    }

    protected PipeEventPower(boolean canBeCancelled, IPipeHolder holder, IFlowPower flow) {
        super(canBeCancelled, holder);
        this.flow = flow;
    }

    public static class Configure extends PipeEventPower {
        private long maxPower = 10 * MjAPI.MJ;
        private boolean receiver = false;

        public Configure(IPipeHolder holder, IFlowPower flow) {
            super(holder, flow);
        }

        public long getMaxPower() {
            return this.maxPower;
        }

        public void setMaxPower(long maxPower) {
            this.maxPower = maxPower;
        }

        public boolean isReceiver() {
            return this.receiver;
        }

        /** Sets this pipe to be one that receives power from external sources. */
        public void setReceiver(boolean receiver) {
            this.receiver = receiver;
        }
    }
}
