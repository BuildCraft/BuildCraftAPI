package buildcraft.api.mj;

public class MjRfConversion {

    /** Maximum MJ per RF, or minimum of 5 RF to make 1 MJ. */
    public static final long MAX_MJ_PER_RF = MjAPI.MJ / 5;

    /** Minimum MJ per RF, or maximum of 10,000 RF to make 1 MJ */
    public static final long MIN_MJ_PER_RF = MjAPI.MJ / 10_000;

    /** Default MJ per RF. */
    public static final long DEFAULT_MJ_PER_RF = MjAPI.MJ / 10;

    /** micro MJ per 1 int rf. */
    public final long mjPerRf;

    /** Set to true if {@link #mjPerRf} has been set to the {@link #DEFAULT_MJ_PER_RF} because the passed in value was
     * out-of-bounds. (This is used to differentiate between it being explicitly set to the default value). */
    public final boolean usingDefaultValue;

    private MjRfConversion(long mjPerRf) {
        if (MIN_MJ_PER_RF <= mjPerRf && mjPerRf <= MAX_MJ_PER_RF) {
            usingDefaultValue = false;
            this.mjPerRf = mjPerRf;
        } else {
            usingDefaultValue = true;
            this.mjPerRf = DEFAULT_MJ_PER_RF;
        }
    }

    /** @param mjPerRf Micro Minecraft Joules per 1 RF */
    public static MjRfConversion createRaw(long mjPerRf) {
        return new MjRfConversion(mjPerRf);
    }

    /** @param configMjPerRf {@link MjAPI#MJ} per RF. This is rounded to the nearest 100 micro MJ */
    public static MjRfConversion createParsed(double configMjPerRf) {
        long value = Math.round(configMjPerRf * 10_000);
        return new MjRfConversion(value * MjAPI.MJ / 10_000);
    }

    public static MjRfConversion createDefault() {
        // -10 is always out of range
        return new MjRfConversion(-10);
    }
}
