package buildcraft.api.tiles;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public interface IDebuggable {
    /** Get the debug information from a tile entity as a list of strings, used for the F3 debug menu. The left and
     * right parameters correspond to the sides of the F3 screen.
     *
     * @param left {@link I18n} doesn't exist in Server Side, so we should use {@link ITextComponent}.
     * @param side The side the block was clicked on, may be null if we don't know, or is the "centre" side */
//    void getDebugInfo(List<String> left, List<String> right, Direction side);
    void getDebugInfo(List<ITextComponent> left, List<ITextComponent> right, Direction side);

    /** Same as {@link #getDebugInfo(List, List, Direction)}, but only for client
     *
     * @param side same as for {@link #getDebugInfo(List, List, Direction)} */
    @OnlyIn(Dist.CLIENT)
    default void getClientDebugInfo(List<String> left, List<String> right, Direction side) {
    }
}
