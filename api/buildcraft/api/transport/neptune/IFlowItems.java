package buildcraft.api.transport.neptune;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;

import buildcraft.api.core.IStackFilter;
import buildcraft.api.transport.IInjectable;

public interface IFlowItems extends IInjectable {
    /** Attempts to extract items from the inventory connected to this pipe on the given side.
     * 
     * @param count
     * @param from
     * @param colour The colour that extracted items should be painted.
     * @param filter The filter to determine what can be extracted.
     * @return The number of items extracted. */
    int tryExtractItems(int count, EnumFacing from, EnumDyeColor colour, IStackFilter filter);
}
