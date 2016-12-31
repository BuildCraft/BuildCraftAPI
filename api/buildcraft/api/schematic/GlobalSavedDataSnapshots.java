package buildcraft.api.schematic;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GlobalSavedDataSnapshots {
    public static final Map<Side, GlobalSavedDataSnapshots> instances = new EnumMap<>(Side.class);
    public static Map<UUID, Template> templates = new HashMap<>();

    public GlobalSavedDataSnapshots(Side side) {
        try {
            File file = new File(FMLCommonHandler.instance().getSavesDirectory().getParentFile(), "snapshots-" + side.name().toLowerCase(Locale.ROOT));
            if (!file.exists()) {
                file.mkdirs();
            }
            for (File f : file.listFiles()) {
                Template template = new Template();
                template.deserializeNBT(CompressedStreamTools.read(f));
                templates.put(UUID.fromString(f.getName()), template);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GlobalSavedDataSnapshots get(Side side) {
        if (!instances.containsKey(side)) {
            instances.put(side, new GlobalSavedDataSnapshots(side));
        }

        return instances.get(side);
    }
}
