package buildcraft.api.transport.pluggable;

import java.util.Objects;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;

public abstract class PluggableModelKey<K extends PluggableModelKey<K>> {
    public final BlockRenderLayer layer;
    public final IPluggableModelBaker<K> baker;
    public final EnumFacing side;
    private final int hash;

    public PluggableModelKey(BlockRenderLayer layer, IPluggableModelBaker<K> baker, EnumFacing side) {
        if (layer != BlockRenderLayer.CUTOUT && layer != BlockRenderLayer.TRANSLUCENT) {
            throw new IllegalArgumentException("Can only use CUTOUT or TRANSLUCENT at the moment (was " + layer + ")");
        }
        if (baker == null) throw new NullPointerException("baker");
        if (side == null) throw new NullPointerException("side");
        this.layer = layer;
        this.baker = baker;
        this.side = side;
        this.hash = Objects.hash(layer, baker, side);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PluggableModelKey<?> other = (PluggableModelKey<?>) obj;
        if (layer != other.layer) return false;
        if (side != other.side) return false;
        if (baker != other.baker) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
