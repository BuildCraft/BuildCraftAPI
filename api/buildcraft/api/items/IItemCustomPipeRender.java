package buildcraft.api.items;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface IItemCustomPipeRender {
    float getPipeRenderScale(ItemStack stack);

    /** @return False to use the default renderer, true otherwise. */
    @OnlyIn(Dist.CLIENT)
    boolean renderItemInPipe(ItemStack stack, double x, double y, double z);
}
