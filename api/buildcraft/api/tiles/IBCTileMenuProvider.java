package buildcraft.api.tiles;

import buildcraft.api.net.IMessage;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;

public interface IBCTileMenuProvider extends MenuProvider {
    public abstract IMessage onServerPlayerOpenNoSend(Player player);
}
