/*
 * Copyright (c) 2017 SpaceToad and the BuildCraft team
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/
 */

package buildcraft.api.template;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import buildcraft.api.enums.EnumHandlerPriority;

public interface ITemplateRegistry {
    /** Adds a handler with a {@link EnumHandlerPriority} of {@linkplain EnumHandlerPriority#NORMAL} */
    default void addHandler(ITemplateHandler handler) {
        addHandler(handler, EnumHandlerPriority.NORMAL);
    }

    void addHandler(ITemplateHandler handler, EnumHandlerPriority priority);

    boolean handle(World world, BlockPos pos, EntityPlayer player, ItemStack stack);
}
