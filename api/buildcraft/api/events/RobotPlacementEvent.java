/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class RobotPlacementEvent extends Event {
    public PlayerEntity player;
    public String robotProgram;

    public RobotPlacementEvent(PlayerEntity player, String robotProgram) {
        this.player = player;
        this.robotProgram = robotProgram;
    }
}
