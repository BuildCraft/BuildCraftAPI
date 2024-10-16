package buildcraft.api.transport.pipe;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface IPipeBehaviourRenderer<B extends PipeBehaviour> {
    // void render(B behaviour, double x, double y, double z, float partialTicks, BufferBuilder bb);
    public void render(B gate, float partialTicks, MatrixStack poseStack, IVertexBuilder vertexConsumer, int combinedLight, int combinedOverlay);
}
