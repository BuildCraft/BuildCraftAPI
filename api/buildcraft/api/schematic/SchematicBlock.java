package buildcraft.api.schematic;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class SchematicBlock {
    public BlockPos relativePos;
    public final IBlockState blockState;
    // TODO: tile
    public final List<ItemStack> requiredItems;

    public SchematicBlock(BlockPos relativePos, IBlockState blockState, List<ItemStack> requiredItems) {
        this.relativePos = relativePos;
        this.blockState = blockState;
        this.requiredItems = requiredItems;
    }

    public SchematicBlock(NBTTagCompound nbt) {
        this(null, null, null);
    }

    public NBTTagCompound writeToNBT() {
        return null;
    }

    public void rotateClockwise() {
        relativePos = new BlockPos(relativePos.getZ(), relativePos.getY(), -relativePos.getX());
    }
}
