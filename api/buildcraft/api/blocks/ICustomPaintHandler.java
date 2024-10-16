package buildcraft.api.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/** Provides a way to paint blocks from any position. You can either implement this on a block, or register an instance
 * for a block with {@link CustomPaintHelper} */
public interface ICustomPaintHandler {
    /** Attempts to paint the given block. This can also only paint a specific part of the block (as the hit position is
     * given).
     *
     * @param world The world that the block is contained within.
     * @param pos The position of the block.
     * @param state The current state of the block.
     * @param hitPos The absolute hit position of the paintbrush, relative the world's origin.
     * @param hitSide The side of the block that was hit.
     * @param paintColour The paint colour to attempt to paint with, null if the paint should be cleared (so if this was
     *            a stained glass block, and null was passed, this would set it to a normal, clear, non-stained glass
     *            block.
     * @return The result of attempting to paint. SUCCESS means that you changed the block from before to a new value,
     *         FAIL means you COULD have handled the block, but it was already painted to that colour, or PASS if you
     *         have no idea how to handle the block in question. */
    ActionResultType attemptPaint(World world, BlockPos pos, BlockState state, Vector3d hitPos, @Nullable Direction hitSide, @Nullable DyeColor paintColour);
}
