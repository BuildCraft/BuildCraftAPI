package buildcraft.api.transport.pipe;

import buildcraft.api.core.EnumPipePart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import javax.annotation.Nonnull;
import java.io.IOException;

public abstract class PipeBehaviour implements ICapabilityProvider {
    public final IPipe pipe;

    public PipeBehaviour(IPipe pipe) {
        this.pipe = pipe;
    }

    public PipeBehaviour(IPipe pipe, CompoundNBT nbt) {
        this.pipe = pipe;
    }

    public CompoundNBT writeToNbt() {
        CompoundNBT nbt = new CompoundNBT();

        return nbt;
    }

    public void writePayload(PacketBuffer buffer, Dist side) {
    }

    // public void readPayload(PacketBuffer buffer, Dist side, MessageContext ctx) throws IOException {}
    public void readPayload(PacketBuffer buffer, NetworkDirection side, NetworkEvent.Context ctx) throws IOException {
    }

    /** @deprecated Replaced by {@link #getTextureData(Direction)}. */
    @Deprecated
    public int getTextureIndex(Direction face) {
        return 0;
    }

    public PipeFaceTex getTextureData(Direction face) {
        return PipeFaceTex.get(getTextureIndex(face));
    }

    // Event handling

    public boolean canConnect(Direction face, PipeBehaviour other) {
        return true;
    }

    public boolean canConnect(Direction face, TileEntity oTile) {
        return true;
    }

    /** Used to force a connection to a given tile, even if the {@link PipeFlow} wouldn't normally connect to it. */
    public boolean shouldForceConnection(Direction face, TileEntity oTile) {
        return false;
    }

    public boolean onPipeActivate(PlayerEntity player, RayTraceResult trace, float hitX, float hitY, float hitZ, EnumPipePart part) {
        return false;
    }

    public void onEntityCollide(Entity entity) {
    }

    public void onTick() {
    }

    // 1.18.2: getCapability().isPresent()
//    @Override
//    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing) {
//        return getCapability(capability, facing) != null;
//    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        return LazyOptional.empty();
    }

    public void addDrops(NonNullList<ItemStack> toDrop, int fortune) {
    }
}
