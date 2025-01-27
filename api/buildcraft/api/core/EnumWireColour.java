package buildcraft.api.core;

import net.minecraft.world.item.DyeColor;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/** A subset of colours from {@link DyeColor} that are suitable for use in LED's or wires (or equivalent). In other
 * words they must all be uniquely identifiable from both their lit and dark colours, and not look similar to other
 * colours. */
@Deprecated(forRemoval = true)
public enum EnumWireColour {
    // We disallow all variants of grey and black, as they don't make much sense relative to LED's.
    // In theory we could keep black OR dark gey LED's (as they are very distant) but it's simpler not to.
    WHITE(DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK),
    ORANGE(DyeColor.ORANGE),
    // MAGENTA -> PINK
    LIGHT_BLUE(DyeColor.LIGHT_BLUE, DyeColor.CYAN),
    YELLOW(DyeColor.YELLOW),
    LIME(DyeColor.LIME),
    PINK(DyeColor.PINK, DyeColor.MAGENTA),
    // GRAY -> WHITE
    // SILVER (LIGHT_GRAY) -> WHITE
    // CYAN -> LIGHT_BLUE
    PURPLE(DyeColor.PURPLE),
    BLUE(DyeColor.BLUE),
    BROWN(DyeColor.BROWN),
    GREEN(DyeColor.GREEN),
    RED(DyeColor.RED),
    // BLACK -> WHITE
    ;

    private static final EnumMap<DyeColor, EnumWireColour> DYE_TO_WIRE;

    static {
        DYE_TO_WIRE = new EnumMap<>(DyeColor.class);
        for (EnumWireColour wire : values()) {
            for (DyeColor dye : wire.similarBasedColours) {
                EnumWireColour prev = DYE_TO_WIRE.put(dye, wire);
                if (prev != null) {
                    throw new Error(wire + " attempted to override " + prev + " for the dye " + dye + "!");
                }
            }
        }

        for (DyeColor dye : DyeColor.values()) {
            EnumWireColour wire = DYE_TO_WIRE.get(dye);
            if (wire == null) {
                throw new Error(dye + " isn't mapped to a wire colour!");
            }
        }
    }

    /** The primary minecraft colour that this is based on. */
    public final DyeColor primaryIdenticalColour;

    /** A set of similar minecraft colours that this single colour is based on. Always includes
     * {@link #primaryIdenticalColour}. */
    public final Set<DyeColor> similarBasedColours;

    private EnumWireColour(DyeColor primary, DyeColor... secondary) {
        this.primaryIdenticalColour = primary;
        this.similarBasedColours = EnumSet.of(primary, secondary);
    }

    public static EnumWireColour convertToWire(DyeColor dye) {
        return DYE_TO_WIRE.get(dye);
    }
}
