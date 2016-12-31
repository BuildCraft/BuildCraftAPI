package buildcraft.api.schematic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.util.INBTSerializable;

import java.io.File;

public abstract class Snapshot implements INBTSerializable<NBTTagCompound> {
//    public UUID uuid;
//
//    public String getId() {
//        return owner + "-" + name.replace(" ", "_") + "-" + creation + "-" + uuid.replace("-", "_");
//    }
//
//    @Override
//    public NBTTagCompound serializeNBT() {
//        NBTTagCompound nbt = new NBTTagCompound();
//        nbt.setString("owner", owner);
//        nbt.setString("name", name);
//        nbt.setString("creation", creation);
//        nbt.setString("uuid", uuid);
//        return nbt;
//    }
//
//    @Override
//    public void deserializeNBT(NBTTagCompound nbt) {
//        owner = nbt.getString("owner");
//        name = nbt.getString("name");
//        creation = nbt.getString("creation");
//        uuid = nbt.getString("uuid");
//    }
//
//    public void writeToFile(MinecraftServer server) {
//        File file = new File(server.getFolderName(), )
//    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

    }
}
