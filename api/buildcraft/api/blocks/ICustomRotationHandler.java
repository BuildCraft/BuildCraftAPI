package buildcraft.api.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ICustomRotationHandler {
    ActionResultType attemptRotation(World world, BlockPos pos, BlockState state, Direction sideWrenched);
}
