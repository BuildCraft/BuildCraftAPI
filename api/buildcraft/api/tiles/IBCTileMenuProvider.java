package buildcraft.api.tiles;

import buildcraft.api.net.IMessage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;

public interface IBCTileMenuProvider extends INamedContainerProvider {
    public abstract IMessage onServerPlayerOpenNoSend(PlayerEntity player);
}
