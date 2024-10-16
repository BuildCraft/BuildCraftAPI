package buildcraft.api.core;

import com.google.common.collect.Maps;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.NumberNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;
import java.util.Map;

public enum EnumPipePart implements IStringSerializable {
    DOWN(Direction.DOWN),
    UP(Direction.UP),
    NORTH(Direction.NORTH),
    SOUTH(Direction.SOUTH),
    WEST(Direction.WEST),
    EAST(Direction.EAST),
    /** CENTER, UNKNOWN and ALL are all valid uses of this. */
    CENTER(null);

    public static final EnumPipePart[] VALUES = values();
    public static final EnumPipePart[] FACES;
    public static final EnumPipePart[] HORIZONTALS;

    private static final Map<Direction, EnumPipePart> facingMap = Maps.newEnumMap(Direction.class);
    private static final Map<String, EnumPipePart> nameMap = Maps.newHashMap();
    private static final int MAX_VALUES = values().length;

    public final Direction face;

    static {
        for (EnumPipePart part : values()) {
            nameMap.put(part.name(), part);
            if (part.face != null) facingMap.put(part.face, part);
        }
        FACES = fromFacingArray(Direction.values());
//        HORIZONTALS = fromFacingArray(Direction.HORIZONTALS);
        HORIZONTALS = fromFacingArray(Direction.BY_2D_DATA);
    }

    private static EnumPipePart[] fromFacingArray(Direction... faces) {
        EnumPipePart[] arr = new EnumPipePart[faces.length];
        for (int i = 0; i < faces.length; i++) {
            arr[i] = fromFacing(faces[i]);
        }
        return arr;
    }

    public static int ordinal(Direction face) {
        return face == null ? 6 : face.ordinal();
    }

    public static EnumPipePart fromFacing(Direction face) {
        if (face == null) {
            return EnumPipePart.CENTER;
        }
        return facingMap.get(face);
    }

    public static EnumPipePart[] validFaces() {
        return FACES;
    }

    public static EnumPipePart fromMeta(int meta) {
        if (meta < 0 || meta >= MAX_VALUES) {
            return EnumPipePart.CENTER;
        }
        return VALUES[meta];
    }

    EnumPipePart(Direction face) {
        this.face = face;
    }

    public int getIndex() {
        if (face == null) return 6;
        return face.get3DDataValue();
    }

    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public EnumPipePart next() {
        switch (this) {
            case DOWN:
                return EAST;
            case EAST:
                return NORTH;
            case NORTH:
                return SOUTH;
            case SOUTH:
                return UP;
            case UP:
                return WEST;
            case WEST:
                return DOWN;
            default:
                return DOWN;
        }
    }

    public EnumPipePart opposite() {
        if (this == CENTER) {
            return CENTER;
        }
        return fromFacing(face.getOpposite());
    }

    public static EnumPipePart readFromNBT(INBT base) {
        if (base == null) {
            return CENTER;
        }
        if (base instanceof StringNBT) {
            StringNBT nbtString = (StringNBT) base;
            String string = nbtString.getAsString();
            return nameMap.getOrDefault(string, CENTER);
        } else {
            byte ord = ((NumberNBT) base).getAsByte();
            if (ord < 0 || ord > 6) {
                return CENTER;
            }
            return values()[ord];
        }
    }

    public INBT writeToNBT() {
        return StringNBT.valueOf(name());
    }
}
