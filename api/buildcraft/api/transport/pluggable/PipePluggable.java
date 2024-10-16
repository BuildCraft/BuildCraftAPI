package buildcraft.api.transport.pluggable;

import buildcraft.api.transport.pipe.IPipeHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;

public abstract class PipePluggable {
    public final PluggableDefinition definition;
    public final IPipeHolder holder;
    public final Direction side;

    public PipePluggable(PluggableDefinition definition, IPipeHolder holder, Direction side) {
        this.definition = definition;
        this.holder = holder;
        this.side = side;
    }

    public CompoundNBT writeToNbt() {
        CompoundNBT nbt = new CompoundNBT();
        return nbt;
    }

    /** Writes the payload that will be passed into
     * {@link PluggableDefinition#loadFromBuffer(IPipeHolder, Direction, PacketBuffer)} on the client. (This is called
     * on the server and sent to the client). Note that this will be called *instead* of write and read payload. */
    public void writeCreationPayload(PacketBuffer buffer) {

    }

    public void writePayload(PacketBuffer buffer, Dist side) {

    }

    public void readPayload(PacketBuffer buffer, NetworkDirection side, NetworkEvent.Context ctx) throws IOException {

    }

    public final void scheduleNetworkUpdate() {
        holder.scheduleNetworkUpdate(IPipeHolder.PipeMessageReceiver.PLUGGABLES[side.ordinal()]);
    }

    public void onTick() {
    }

    /** @return A bounding box that will be used for collisions and raytracing. */
    public abstract VoxelShape getBoundingBox();

    /** @return True if the pipe cannot connect outwards (it is blocked), or False if this does not block the pipe. */
    public boolean isBlocking() {
        return false;
    }

    /** Gets the value of a specified capability key, or null if the given capability is not supported at the call time.
     * This is effectively {@link ICapabilityProvider}, but where
     * {@link ICapabilityProvider#getCapability(Capability, Direction)#isPresent()} will return true when this returns a non-null
     * value. */
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return LazyOptional.empty();
    }

    /** Gets the {@link Capability} that is accessible from the pipe that this is attached to.
     *
     * @param cap
     * @return */
    public <T> T getInternalCapability(@Nonnull Capability<T> cap) {
        return null;
    }

    /** Called whenever this pluggable is removed from the pipe. */
    public void onRemove() {
    }

    /** @param toDrop A list containing all the items to drop (so you should add your items to this list) */
    public void addDrops(NonNullList<ItemStack> toDrop, int fortune) {
        ItemStack stack = getPickStack();
        if (!stack.isEmpty()) {
            toDrop.add(stack);
        }
    }

    /** Called whenever this pluggable is picked by the player (similar to Block.getPickBlock)
     *
     * @return The stack that should be picked, or ItemStack.EMPTY if no stack can be picked from this pluggable. */
    public ItemStack getPickStack() {
        return ItemStack.EMPTY;
    }

    public boolean onPluggableActivate(PlayerEntity player, RayTraceResult trace, float hitX, float hitY, float hitZ) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    public PluggableModelKey getModelRenderKey(RenderType layer) {
        return null;
    }

    /** Called if the {@link IPluggableStaticBaker} returns quads with tint indexes set to
     * <code>data * 6 + key.side.ordinal()</code>. <code>"data"</code> is passed in here as <code>"tintIndex"</code>.
     *
     * @return The tint index to render the quad with, or -1 for default. */
    @OnlyIn(Dist.CLIENT)
    public int getBlockColor(int tintIndex) {
        return -1;
    }

    /** PipePluggable version of
     * {@link Block#canBeConnectedTo(IWorld, BlockPos, Direction)}. */
    public boolean canBeConnected() {
        return false;
    }

    /** PipePluggable version of
     * {@link BlockState#isSideSolid(IBlockAccess, BlockPos, Direction)} */
    public boolean isSideSolid() {
        return false;
    }

    /** PipePluggable version of {@link Block#getExplosionResistance(BlockState, IBlockReader, BlockPos, Explosion)} */
//    public float getExplosionResistance(@Nullable Entity exploder, Explosion explosion)
    public float getExplosionResistance(@Nonnull Entity exploder, Explosion explosion) {
        return 0;
    }

    public boolean canConnectToRedstone(@Nullable Direction to) {
        return false;
    }

    // Calen: seems use block Shape in 1.18.2
//    /** PipePluggable version of
//     * {@link net.minecraft.block.state.IBlockState#getBlockFaceShape(IBlockAccess, BlockPos, EnumFacing)} */
//    public BlockFaceShape getBlockFaceShape() {
//        return BlockFaceShape.UNDEFINED;
//    }

    public void onPlacedBy(PlayerEntity player) {

    }
}
