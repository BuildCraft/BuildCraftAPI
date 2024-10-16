package buildcraft.api.transport;

import buildcraft.api.core.EnumHandlerPriority;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IStripesRegistry {
    /** Adds a handler with a {@link EnumHandlerPriority} of {@linkplain EnumHandlerPriority#NORMAL} */
    default void addHandler(IStripesHandlerItem handler) {
        addHandler(handler, EnumHandlerPriority.NORMAL);
    }

    void addHandler(IStripesHandlerItem handler, EnumHandlerPriority priority);

    /** Adds a handler with a {@link EnumHandlerPriority} of {@linkplain EnumHandlerPriority#NORMAL NORMAL} */
    default void addHandler(IStripesHandlerBlock handler) {
        addHandler(handler, EnumHandlerPriority.NORMAL);
    }

    void addHandler(IStripesHandlerBlock handler, EnumHandlerPriority priority);

    /** @param pos The position of the stripes pipe.
     * @return True if a handler handled the itemstack, false otherwise (and so nothing has been done) */
    boolean handleItem(World world,
                       BlockPos pos,
                       Direction direction,
                       ItemStack stack,
                       PlayerEntity player,
                       IStripesActivator activator);

    /** @return True if a handler broke a block, false otherwise (and so nothing has been done) */
    boolean handleBlock(World world,
                        BlockPos pos,
                        Direction direction,
                        PlayerEntity player,
                        IStripesActivator activator);
}
