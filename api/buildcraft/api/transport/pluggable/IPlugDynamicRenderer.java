package buildcraft.api.transport.pluggable;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

public interface IPlugDynamicRenderer<P extends PipePluggable> {
    // void render(P plug, double x, double y, double z, float partialTicks, BufferBuilder bb);
    void render(P gate, float partialTicks, MatrixStack poseStack, IVertexBuilder vertexConsumer, int combinedLight, int combinedOverlay);
}
