/*
 * Copyright (c) 2017 SpaceToad and the BuildCraft team
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/
 */

package buildcraft.api.mj;

/**
 * This interface should be defined by any Tile which wants to receive power from BuildCraft lasers.
 * <p>
 * The respective Block MUST implement {@link ILaserTargetBlock}!
 */
public interface ILaserTarget {
    /**
     * Returns power that the target currently has
     *
     * @return The number of micro Minecraft Joules
     */
    long getLaserPower();

    /**
     * Returns power that the target currently needs to make whole recipe.
     * Returns 0 if no power is needed (tile has nothing to do)
     *
     * @return The number of micro Minecraft Joules
     */
    long getTargetLaserPower();

    /**
     * Transfers power from the laser to the target
     *
     * @param microJoules The number of micro Minecraft Joules to accept
     */
    void receiveLaserPower(long microJoules);
}
