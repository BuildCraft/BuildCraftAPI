package buildcraft.api.transport.pipe;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/** Called in
 * {@link Block#onBlockPlacedBy(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, EntityLivingBase, ItemStack)} */
public class PipeEventPlaced extends PipeEvent {

    public final EntityLivingBase placer;
    public final ItemStack placeStack;

    public PipeEventPlaced(IPipeHolder holder, EntityLivingBase placer, ItemStack placeStack) {
        super(holder);
        this.placer = placer;
        this.placeStack = placeStack;
    }
}
