package buildcraft.api.transport.pluggable;

import buildcraft.api.core.InvalidInputDataException;
import buildcraft.api.transport.pipe.IPipeHolder;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public final class PluggableDefinition {
    public final ResourceLocation identifier;

    public final IPluggableNetLoader loader;
    public final IPluggableNbtReader reader;

    @Nullable
    public final IPluggableCreator creator;

    public PluggableDefinition(ResourceLocation identifier, IPluggableNbtReader reader, IPluggableNetLoader loader) {
        this.identifier = identifier;
        this.reader = reader;
        this.loader = loader;
        this.creator = null;
    }

    public PluggableDefinition(ResourceLocation identifier, @Nullable IPluggableCreator creator) {
        this.identifier = identifier;
        this.reader = creator;
        this.loader = creator;
        this.creator = creator;
    }

    public PipePluggable readFromNbt(IPipeHolder holder, Direction side, CompoundNBT nbt) {
        return reader.readFromNbt(this, holder, side, nbt);
    }

    public PipePluggable loadFromBuffer(IPipeHolder holder, Direction side, PacketBuffer buffer)
            throws InvalidInputDataException {
        return loader.loadFromBuffer(this, holder, side, buffer);
    }

    @FunctionalInterface
    public interface IPluggableNbtReader {
        /** Reads the pipe pluggable from NBT. Unlike {@link IPluggableNetLoader} (which is allowed to fail and throw an
         * exception if the wrong data is given) this should make a best effort to read the pluggable from nbt, or fall
         * back to sensible defaults. */
        PipePluggable readFromNbt(PluggableDefinition definition, IPipeHolder holder, Direction side, CompoundNBT nbt);
    }

    @FunctionalInterface
    public interface IPluggableNetLoader {
        PipePluggable loadFromBuffer(PluggableDefinition definition, IPipeHolder holder, Direction side, PacketBuffer buffer) throws InvalidInputDataException;
    }

    @FunctionalInterface
    public interface IPluggableCreator extends IPluggableNbtReader, IPluggableNetLoader {
        @Override
        default PipePluggable loadFromBuffer(PluggableDefinition definition, IPipeHolder holder, Direction side, PacketBuffer buffer) {
            return createSimplePluggable(definition, holder, side);
        }

        @Override
        default PipePluggable readFromNbt(PluggableDefinition definition, IPipeHolder holder, Direction side, CompoundNBT nbt) {
            return createSimplePluggable(definition, holder, side);
        }

        PipePluggable createSimplePluggable(PluggableDefinition definition, IPipeHolder holder, Direction side);
    }
}
