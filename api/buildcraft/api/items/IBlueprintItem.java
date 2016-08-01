package buildcraft.api.items;

import net.minecraft.item.ItemStack;

import buildcraft.api.enums.EnumSnapshotType;

public interface IBlueprintItem extends INamedItem {
    EnumSnapshotType getType(ItemStack stack);
}
