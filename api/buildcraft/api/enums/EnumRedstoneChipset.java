package buildcraft.api.enums;

import buildcraft.api.BCItems;
import buildcraft.api.items.IChipset;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

// public enum EnumRedstoneChipset implements IStringSerializable
public enum EnumRedstoneChipset implements IStringSerializable {
    RED,
    IRON,
    GOLD,
    QUARTZ,
    DIAMOND;

    private final String name = name().toLowerCase(Locale.ROOT);

    public ItemStack getStack(int stackSize) {
        Item chipset = null;
        switch (this) {
            case RED:
                chipset = BCItems.Silicon.CHIPSET_REDSTONE;
                break;
            case IRON:
                chipset = BCItems.Silicon.CHIPSET_IRON;
                break;
            case GOLD:
                chipset = BCItems.Silicon.CHIPSET_GOLD;
                break;
            case QUARTZ:
                chipset = BCItems.Silicon.CHIPSET_QUARTZ;
                break;
            case DIAMOND:
                chipset = BCItems.Silicon.CHIPSET_DIAMOND;
                break;
        }
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
