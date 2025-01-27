package buildcraft.api;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;

public class BCBlocks {

    public static class Core {
        @ObjectHolder(registryName = "block", value = "buildcraftcore:spring_water")
        public static final Block SPRING_WATER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:spring_oil")
        public static final Block SPRING_OIL = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:decorated_destroy")
        public static final Block DECORATED_DESTROY = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:decorated_blueprint")
        public static final Block DECORATED_BLUEPRINT = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:decorated_template")
        public static final Block DECORATED_TEMPLATE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:decorated_paper")
        public static final Block DECORATED_PAPER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:decorated_leather")
        public static final Block DECORATED_LEATHER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:decorated_laser_back")
        public static final Block DECORATED_LASER_BACK = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:engine_wood")
        public static final Block ENGINE_WOOD = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:engine_stone")
        public static final Block ENGINE_STONE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:engine_iron")
        public static final Block ENGINE_IRON = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:engine_creative")
        public static final Block ENGINE_CREATIVE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:marker_volume")
        public static final Block MARKER_VOLUME = null;
        @ObjectHolder(registryName = "block", value = "buildcraftcore:marker_path")
        public static final Block MARKER_PATH = null;
    }

    public static class Builders {
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:architect")
        public static final Block ARCHITECT = null;
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:builder")
        public static final Block BUILDER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:filler")
        public static final Block FILLER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:library")
        public static final Block LIBRARY = null;
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:replacer")
        public static final Block REPLACER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:quarry")
        public static final Block QUARRY = null;
        @ObjectHolder(registryName = "block", value = "buildcraftbuilders:frame")
        public static final Block FRAME = null;
    }

    public static class Energy {
        // Fluid blocks can be accessed ~somewhere else~
//        @ObjectHolder(registryName = "block", value = "buildcraftenergy:")
    }

    public static class Factory {
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:autoworkbench_item")
        public static final Block AUTOWORKBENCH_ITEM = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:mining_well")
        public static final Block MINING_WELL = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:pump")
        public static final Block PUMP = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:tube")
        public static final Block TUBE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:flood_gate")
        public static final Block FLOOD_GATE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:tank")
        public static final Block TANK = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:chute")
        public static final Block CHUTE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:water_gel")
        public static final Block WATER_GEL = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:distiller")
        public static final Block DISTILLER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftfactory:heat_exchange")
        public static final Block HEAT_EXCHANGE = null;
    }

    public static class Transport {
        @ObjectHolder(registryName = "block", value = "buildcrafttransport:filtered_buffer")
        public static final Block FILTERED_BUFFER = null;
        @ObjectHolder(registryName = "block", value = "buildcrafttransport:pipe_holder")
        public static final Block PIPE_HOLDER = null;
    }

    public static class Silicon {
        @ObjectHolder(registryName = "block", value = "buildcraftsilicon:laser")
        public static final Block LASER = null;
        @ObjectHolder(registryName = "block", value = "buildcraftsilicon:assembly_table")
        public static final Block ASSEMBLY_TABLE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftsilicon:advanced_crafting_table")
        public static final Block ADVANCED_CRAFTING_TABLE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftsilicon:integration_table")
        public static final Block INTEGRATION_TABLE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftsilicon:charging_table")
        public static final Block CHARGING_TABLE = null;
        @ObjectHolder(registryName = "block", value = "buildcraftsilicon:programming_table")
        public static final Block PROGRAMMING_TABLE = null;
    }

    public static class Robotics {
//        @ObjectHolder(registryName = "block", value = "buildcraftrobotics:")
    }
}
