/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution. */
package buildcraft.api.boards;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Constants;

import java.util.List;
import java.util.Random;

public abstract class RedstoneBoardNBT<T> {

    private static Random rand = new Random();

    public abstract String getID();

    public abstract void addInformation(ItemStack stack, PlayerEntity player, List<String> list, boolean advanced);

    public abstract String getDisplayName();

    public abstract IRedstoneBoard<T> create(CompoundNBT nbt, T object);

    public abstract String getItemModelLocation();

    public void createBoard(CompoundNBT nbt) {
        nbt.putString("id", getID());
    }

    public int getParameterNumber(CompoundNBT nbt) {
        if (!nbt.contains("parameters")) {
            return 0;
        } else {
            return nbt.getList("parameters", Constants.NBT.TAG_COMPOUND).size();
        }
    }

    public float nextFloat(int difficulty) {
        return 1F - (float) Math.pow(rand.nextFloat(), 1F / difficulty);
    }
}
