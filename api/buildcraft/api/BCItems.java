package buildcraft.api;

import buildcraft.api.items.FluidItemDrops;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class BCItems {

    @ObjectHolder("buildcraftlib")
    public static class Lib {
        public static final Item GUIDE = null;
        public static final Item GUIDE_NOTE = null;
        public static final Item DEBUGGER = null;
    }

    @ObjectHolder("buildcraftcore")
    public static class Core {
        public static final Item GEAR_WOOD = null;
        public static final Item GEAR_STONE = null;
        public static final Item GEAR_IRON = null;
        public static final Item GEAR_GOLD = null;
        public static final Item GEAR_DIAMOND = null;
        public static final Item WRENCH = null;
        public static final Item PAINTBRUSH_CLEAN = null;
        public static final Item LIST = null;
        public static final Item MAP_LOCATION = null;
        public static final Item MARKER_CONNECTOR = null;
        public static final Item VOLUME_BOX = null;
        public static final Item GOGGLES = null;

        /** It is recommended that you refer to {@link FluidItemDrops#item} when creating fluid drops rather than
         * this. */
        public static final Item FRAGILE_FLUID_SHARD = null;
    }

    @ObjectHolder("buildcraftbuilders")
    public static class Builders {

    }

    @ObjectHolder("buildcraftenergy")
    public static class Energy {
        public static final Item GLOB_OIL = null;
    }

    @ObjectHolder("buildcraftfactory")
    public static class Factory {
        public static final Item PLASTIC_SHEET = null;
        public static final Item WATER_GEL_SPAWN = null;
        public static final Item GEL = null;
    }

    @ObjectHolder("buildcrafttransport")
    public static class Transport {
        public static final Item PLUG_BLOCKER = null;
        public static final Item PLUG_POWER_ADAPTOR = null;

        public static final Item PIPE_STRUCTURE_COBBLESTONE_COLORLESS = null;
        public static final Item PIPE_ITEMS_WOOD_COLORLESS = null;
        public static final Item PIPE_ITEMS_EMZULI_COLORLESS = null;
        public static final Item PIPE_ITEMS_DIAMOND_WOOD_COLORLESS = null;
        public static final Item PIPE_FLUIDS_WOOD_COLORLESS = null;
        public static final Item PIPE_FLUIDS_DIAMOND_WOOD_COLORLESS = null;
    }

    @ObjectHolder("buildcraftsilicon")
    public static class Silicon {
        public static final Item CHIPSET_REDSTONE = null;
        public static final Item CHIPSET_IRON = null;
        public static final Item CHIPSET_GOLD = null;
        public static final Item CHIPSET_QUARTZ = null;
        public static final Item CHIPSET_DIAMOND = null;

        public static final Item PLUG_PULSAR = null;
        public static final Item PLUG_FACADE = null;
    }

    @ObjectHolder("buildcraftrobotics")
    public static class Robotics {

    }
}
