package buildcraft.api.imc;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;

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

    public CompoundNBT getNBTValue() {
        return (CompoundNBT) value;
    }

    public boolean isNBTMessage() {
        return CompoundNBT.class.isAssignableFrom(getMessageType());
    }

    public Class<?> getMessageType() {
        return value.getClass();
    }
}
