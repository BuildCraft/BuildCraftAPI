package buildcraft.api.transport.pipe;

import net.minecraft.util.EnumFacing;

public abstract class PipeEventRedstoneFlux extends PipeEvent {
    public final IFlowRedstoneFlux flow;

    protected PipeEventRedstoneFlux(IPipeHolder holder, IFlowRedstoneFlux flow) {
        super(holder);
        this.flow = flow;
    }

    protected PipeEventRedstoneFlux(boolean canBeCancelled, IPipeHolder holder, IFlowRedstoneFlux flow) {
        super(canBeCancelled, holder);
        this.flow = flow;
    }

    public static class Configure extends PipeEventRedstoneFlux {
        private int maxPower = 100;
        private boolean receiver = false;
        private boolean disabled = false;

        public Configure(IPipeHolder holder, IFlowRedstoneFlux flow) {
            super(holder, flow);
        }

        public int getMaxPower() {
            return this.maxPower;
        }

        public void setMaxPower(int maxPower) {
            this.maxPower = maxPower;
        }

        public boolean isReceiver() {
            return this.receiver;
        }

        /** Sets this pipe to be one that receives power from external sources. */
        public void setReceiver(boolean receiver) {
            this.receiver = receiver;
        }

        public void disableTransfer() {
            disabled = true;
        }

        public boolean isTransferDisabled() {
            return disabled;
        }
    }

    public static class PrimaryDirection extends PipeEventRedstoneFlux {
        private EnumFacing facing;

        public PrimaryDirection(IPipeHolder holder, IFlowRedstoneFlux flow, EnumFacing facing) {
            super(holder, flow);
            this.facing = facing;
        }

        public EnumFacing getFacing() {
            return facing;
        }

        public void setFacing(EnumFacing facing) {
            this.facing = facing;
        }
    }
}
