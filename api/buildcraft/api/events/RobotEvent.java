/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.events;

import buildcraft.api.robots.EntityRobotBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

public abstract class RobotEvent extends Event {
    public final EntityRobotBase robot;

    public RobotEvent(EntityRobotBase robot) {
        this.robot = robot;
    }

    @Cancelable
    public static class Place extends RobotEvent {
        public final PlayerEntity player;

        public Place(EntityRobotBase robot, PlayerEntity player) {
            super(robot);
            this.player = player;
        }
    }

    @Cancelable
    public static class Interact extends RobotEvent {
        public final PlayerEntity player;
        public final ItemStack item;

        public Interact(EntityRobotBase robot, PlayerEntity player, ItemStack item) {
            super(robot);
            this.player = player;
            this.item = item;
        }
    }

    @Cancelable
    public static class Dismantle extends RobotEvent {
        public final PlayerEntity player;

        public Dismantle(EntityRobotBase robot, PlayerEntity player) {
            super(robot);
            this.player = player;
        }
    }
}
