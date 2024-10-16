package buildcraft.api.net;

import buildcraft.api.core.BCLog;
import net.minecraft.network.PacketBuffer;

public interface IMessage {
    void fromBytes(PacketBuffer buf);

    void toBytes(PacketBuffer buf);

    public static IMessage staticFromBytes(Class<? extends IMessage> clazz, PacketBuffer buf) {
        try {
            IMessage message = clazz.newInstance();
            message.fromBytes(buf);
            return message;
        } catch (Exception e) {
            BCLog.logger.error(e);
            return null;
        }
    }
}
