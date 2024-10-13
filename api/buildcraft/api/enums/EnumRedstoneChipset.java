package buildcraft.api.enums;

import buildcraft.api.BCItems;
import buildcraft.api.items.IChipset;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;

// public enum EnumRedstoneChipset implements IStringSerializable
public enum EnumRedstoneChipset implements StringRepresentable {
    RED,
    IRON,
    GOLD,
    QUARTZ,
    DIAMOND;

    private final String name = name().toLowerCase(Locale.ROOT);

    public ItemStack getStack(int stackSize) {
        Item chipset = switch (this) {
            case RED -> BCItems.Silicon.CHIPSET_REDSTONE;
            case IRON -> BCItems.Silicon.CHIPSET_IRON;
            case GOLD -> BCItems.Silicon.CHIPSET_GOLD;
            case QUARTZ -> BCItems.Silicon.CHIPSET_QUARTZ;
            case DIAMOND -> BCItems.Silicon.CHIPSET_DIAMOND;
        };
        if (chipset == null) {
            return ItemStack.EMPTY;
        } else {
            return new ItemStack(chipset, stackSize);
        }
    }

    public ItemStack getStack() {
        return getStack(1);
    }

    public static EnumRedstoneChipset fromStack(ItemStack stack) {
//        if (stack == null)
        if (stack == null || !(stack.getItem() instanceof IChipset)) {
            return RED;
        }
//        return fromOrdinal(stack.getMetadata());
        return ((IChipset) stack.getItem()).getType();
    }

    public static EnumRedstoneChipset fromOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal >= values().length) {
            return RED;
        }
        return values()[ordinal];
    }

    @Override
//    public String getName()
    public String getSerializedName() {
        return name;
    }
}
