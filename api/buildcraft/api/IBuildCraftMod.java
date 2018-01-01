package buildcraft.api;

/** Allows a mod (or addon) to register networking packets in the message manager. */
public interface IBuildCraftMod {
    /** @return The name that will be used for the fml networking channel name. The shorter the better, although it
     *         can't be too short or it might collide with other mod channels. */
    String getNetworkName();
}
