package buildcraft.api.imc;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

/** Used in {@link buildcraft.api.facades.FacadeAPI} */
public class BcImcMessage {
    @Nonnull
    private final Object value;

    public BcImcMessage(@Nonnull Object value) {
        this.value = value;
    }

    public ResourceLocation getResourceLocationValue() {
        return (ResourceLocation) value;
    }

    public CompoundTag getNBTValue() {
        return (CompoundTag) value;
    }

    public boolean isNBTMessage() {
        return CompoundTag.class.isAssignableFrom(getMessageType());
    }

    public Class<?> getMessageType() {
        return value.getClass();
    }
}
