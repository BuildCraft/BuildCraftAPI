package buildcraft.api.mj;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import net.minecraftforge.common.util.INBTSerializable;

import io.netty.buffer.ByteBuf;

/** Provides a basic implementation of a simple battery. Note that you should call {@link #tick(World, BlockPos)} or
 * {@link #tick(World, Vec3d)} every tick to allow for losing excess power. */
public class MjBattery implements INBTSerializable<NBTTagCompound> {
    private final long capacity;
    private long microJoules = 0;

    public MjBattery(long capacity) {
        this.capacity = capacity;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setLong("stored", microJoules);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        microJoules = nbt.getLong("stored");
    }

    public void writeToBuffer(ByteBuf buffer) {
        buffer.writeLong(microJoules);
    }

    public void readFromBuffer(ByteBuf buffer) {
        microJoules = buffer.readLong();
    }

    public void addPower(long microJoulesToAdd) {
        this.microJoules += microJoulesToAdd;
    }

    /** Attempts to add power, but only if this is not already full.
     * 
     * @param microJoulesToAdd The power to add.
     * @return True if the power was accepted. */
    public boolean addPowerChecking(long microJoulesToAdd) {
        if (isFull()) {
            return false;
        } else {
            addPower(microJoulesToAdd);
            return true;
        }
    }

    public long extractAll() {
        return extractPower(0, microJoules);
    }

    public long extractPower(long min, long max) {
        if (microJoules < min) return 0;
        long extracting = Math.min(microJoules, max);
        microJoules -= extracting;
        return extracting;
    }

    public boolean isFull() {
        return microJoules >= capacity;
    }

    public long getStored() {
        return microJoules;
    }

    public long getCapacity() {
        return capacity;
    }

    public void tick(World world, BlockPos position) {
        tick(world, new Vec3d(position.getX() + 0.5, position.getY() + 0.5, position.getZ() + 0.5));
    }

    public void tick(World world, Vec3d position) {
        if (microJoules > capacity * 2) {
            losePower(world, position);
        }
    }

    protected void losePower(World world, Vec3d position) {
        long diff = microJoules - capacity * 2;
        long lost = ceilDivide(diff, 32);
        microJoules -= lost;
        MjAPI.EFFECT_MANAGER.createPowerLossEffect(world, position, lost);
    }

    private static long ceilDivide(long val, long by) {
        return (val / by) + (val % by == 0 ? 0 : 1);
    }

    public String getDebugString() {
        return MjAPI.formatMj(microJoules) + " / " + MjAPI.formatMj(capacity) + " Mj";
    }
}