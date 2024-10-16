package buildcraft.api.mj;

import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

/** Various effects for showing power loss visibly, and for large amounts of power, causes some damage to nearby
 * entities. */
public interface IMjEffectManager {
    void createPowerLossEffect(World world, Vector3d center, long microJoulesLost);

    void createPowerLossEffect(World world, Vector3d center, Direction direction, long microJoulesLost);

    void createPowerLossEffect(World world, Vector3d center, Vector3d direction, long microJoulesLost);
}
