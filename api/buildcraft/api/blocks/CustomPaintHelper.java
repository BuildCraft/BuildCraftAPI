package buildcraft.api.blocks;

import buildcraft.api.core.BCDebugging;
import buildcraft.api.core.BCLog;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/** Provides a simple way to paint a single block, iterating through all {@link ICustomPaintHandler}'s that are
 * registered for the block. */
public enum CustomPaintHelper {
    INSTANCE;

    /* If you want to test your class-based rotation registration then add the system property
     * "-Dbuildcraft.api.rotation.debug.class=true" to your launch. */
    private static final boolean DEBUG = BCDebugging.shouldDebugLog("api.painting");

    private final Map<Block, List<ICustomPaintHandler>> handlers = Maps.newIdentityHashMap();
    private final List<ICustomPaintHandler> allHandlers = Lists.newArrayList();

    /** Registers a handler that will be called LAST for ALL blocks, if all other paint handlers have returned PASS or
     * none are registered for that block. */
    public void registerHandlerForAll(ICustomPaintHandler handler) {
        if (DEBUG) {
            BCLog.logger.info("[api.painting] Adding a paint handler for ALL blocks (" + handler.getClass() + ")");
        }
        allHandlers.add(handler);
    }

    /** Register's a paint handler for every class of a given block. */
    public void registerHandlerForAll(Class<? extends Block> blockClass, ICustomPaintHandler handler) {
//        for (Block block : Block.REGISTRY)
        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            Class<? extends Block> foundClass = block.getClass();
            if (blockClass.isAssignableFrom(foundClass)) {
                if (DEBUG) {
                    BCLog.logger.info("[api.painting] Found an assignable block " + block.getRegistryName() + " (" + foundClass + ") for " + blockClass);
                }
                registerHandlerInternal(block, handler);
            }
        }
    }

    public void registerHandler(Block block, ICustomPaintHandler handler) {
        if (registerHandlerInternal(block, handler)) {
            if (DEBUG) {
                BCLog.logger.info("[api.painting] Setting a paint handler for block " + block.getRegistryName() + "(" + handler.getClass() + ")");
            }
        } else if (DEBUG) {
            BCLog.logger.info("[api.painting] Adding another paint handler for block " + block.getRegistryName() + "(" + handler.getClass() + ")");
        }
    }

    private boolean registerHandlerInternal(Block block, ICustomPaintHandler handler) {
        if (!handlers.containsKey(block)) {
            List<ICustomPaintHandler> forBlock = Lists.newArrayList();
            forBlock.add(handler);
            handlers.put(block, forBlock);
            return true;
        } else {
            handlers.get(block).add(handler);
            return false;
        }
    }

    /** Attempts to paint a block at the given position. Basically iterates through all registered paint handlers. */
    public InteractionResult attemptPaintBlock(Level world, BlockPos pos, BlockState state, Vec3 hitPos, @Nullable Direction hitSide, @Nullable DyeColor paint) {
        Block block = state.getBlock();
        if (block instanceof ICustomPaintHandler) {
            return ((ICustomPaintHandler) block).attemptPaint(world, pos, state, hitPos, hitSide, paint);
        }
        List<ICustomPaintHandler> custom = handlers.get(block);
        if (custom == null || custom.isEmpty()) {
            return defaultAttemptPaint(world, pos, state, hitPos, hitSide, paint);
        }
        for (ICustomPaintHandler handler : custom) {
            InteractionResult result = handler.attemptPaint(world, pos, state, hitPos, hitSide, paint);
            if (result != InteractionResult.PASS) {
                return result;
            }
        }
        return defaultAttemptPaint(world, pos, state, hitPos, hitSide, paint);
    }

    private InteractionResult defaultAttemptPaint(Level world, BlockPos pos, BlockState state, Vec3 hitPos, Direction hitSide, @Nullable DyeColor paint) {
        for (ICustomPaintHandler handler : allHandlers) {
            InteractionResult result = handler.attemptPaint(world, pos, state, hitPos, hitSide, paint);
            if (result != InteractionResult.PASS) {
                return result;
            }
        }
        if (paint == null) {
            return InteractionResult.FAIL;
        }
//        Block b = state.getBlock();
//        if (b.recolorBlock(world, pos, hitSide, paint))
        if (recolorBlock(world, pos, hitSide, paint)) {
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    /**
     * From 1.12.2 Block
     * Common way to recolor a block with an external tool
     *
     * @param world The world
     * @param pos   Block position in world
     * @param side  The side hit with the coloring tool
     * @param color The color to change to
     * @return If the recoloring was successful
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static boolean recolorBlock(Level world, BlockPos pos, Direction side, DyeColor color) {
        BlockState state = world.getBlockState(pos);
        for (Property prop : state.getProperties()) {
            if (prop.getName().equals("color") && prop.getValueClass() == DyeColor.class) {
                DyeColor current = (DyeColor) state.getValue(prop);
                if (current != color && prop.getPossibleValues().contains(color)) {
                    world.setBlock(pos, state.setValue(prop, color), Block.UPDATE_ALL);
                    return true;
                }
            }
        }
        return false;
    }
}
