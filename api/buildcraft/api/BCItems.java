package buildcraft.api;

import buildcraft.api.items.FluidItemDrops;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class BCItems {

    public static class Lib {
        @ObjectHolder(registryName = "item", value = "buildcraftlib:guide")
        public static final Item GUIDE = null;
        @ObjectHolder(registryName = "item", value = "buildcraftlib:guide_note")
        public static final Item GUIDE_NOTE = null;
        @ObjectHolder(registryName = "item", value = "buildcraftlib:debugger")
        public static final Item DEBUGGER = null;
    }

    public static class Core {
        @ObjectHolder(registryName = "item", value = "buildcraftcore:gear_wood")
        public static final Item GEAR_WOOD = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:gear_stone")
        public static final Item GEAR_STONE = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:gear_iron")
        public static final Item GEAR_IRON = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:gear_gold")
        public static final Item GEAR_GOLD = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:gear_diamond")
        public static final Item GEAR_DIAMOND = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:wrench")
        public static final Item WRENCH = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:paintbrush_clean")
        public static final Item PAINTBRUSH_CLEAN = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:list")
        public static final Item LIST = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:map_location")
        public static final Item MAP_LOCATION = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:marker_connector")
        public static final Item MARKER_CONNECTOR = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:volume_box")
        public static final Item VOLUME_BOX = null;
        @ObjectHolder(registryName = "item", value = "buildcraftcore:goggles")
        public static final Item GOGGLES = null;

        /**
         * It is recommended that you refer to {@link FluidItemDrops#item} when creating fluid drops rather than
         * this.
         */
        @ObjectHolder(registryName = "item", value = "buildcraftcore:fragile_fluid_shard")
        public static final Item FRAGILE_FLUID_SHARD = null;
    }

    public static class Builders {
//        @ObjectHolder(registryName = "item", value = "buildcraftbuilders:")
    }

    public static class Energy {
        @ObjectHolder(registryName = "item", value = "buildcraftenergy:glob_oil")
        public static final Item GLOB_OIL = null;
    }

    public static class Factory {
        @ObjectHolder(registryName = "item", value = "buildcraftfactory:plastic_sheet")
        public static final Item PLASTIC_SHEET = null;
        @ObjectHolder(registryName = "item", value = "buildcraftfactory:water_gel_spawn")
        public static final Item WATER_GEL_SPAWN = null;
        @ObjectHolder(registryName = "item", value = "buildcraftfactory:gel")
        public static final Item GEL = null;
    }

    public static class Transport {
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:plug_blocker")
        public static final Item PLUG_BLOCKER = null;
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:plug_power_adaptor")
        public static final Item PLUG_POWER_ADAPTOR = null;

        @ObjectHolder(registryName = "item", value = "buildcrafttransport:pipe_structure_cobblestone_colorless")
        public static final Item PIPE_STRUCTURE_COBBLESTONE_COLORLESS = null;
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:pipe_items_wood_colorless")
        public static final Item PIPE_ITEMS_WOOD_COLORLESS = null;
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:pipe_items_emzuli_colorless")
        public static final Item PIPE_ITEMS_EMZULI_COLORLESS = null;
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:pipe_items_diamond_wood_colorless")
        public static final Item PIPE_ITEMS_DIAMOND_WOOD_COLORLESS = null;
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:pipe_fluids_wood_colorless")
        public static final Item PIPE_FLUIDS_WOOD_COLORLESS = null;
        @ObjectHolder(registryName = "item", value = "buildcrafttransport:pipe_fluids_diamond_wood_colorless")
        public static final Item PIPE_FLUIDS_DIAMOND_WOOD_COLORLESS = null;
    }

    public static class Silicon {
        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:chipset_redstone")
        public static final Item CHIPSET_REDSTONE = null;
        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:chipset_iron")
        public static final Item CHIPSET_IRON = null;
        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:chipset_gold")
        public static final Item CHIPSET_GOLD = null;
        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:chipset_quartz")
        public static final Item CHIPSET_QUARTZ = null;
        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:chipset_diamond")
        public static final Item CHIPSET_DIAMOND = null;

        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:plug_pulsar")
        public static final Item PLUG_PULSAR = null;
        @ObjectHolder(registryName = "item", value = "buildcraftsilicon:plug_facade")
        public static final Item PLUG_FACADE = null;
    }

    public static class Robotics {
//        @ObjectHolder(registryName = "item", value = "buildcraftrobotics:")
    }
}
