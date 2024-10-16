package buildcraft.api.transport.pipe;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

public interface IPipeFlowRenderer<F extends PipeFlow> {
    /** @param flow The flow to render
     * @param bufferBuilder The (optional) vertex buffer that you can render into. Note that you can still do GL stuff. */
//    void render(F flow, double x, double y, double z, float partialTicks, BufferBuilder bufferBuilder);
    void render(F flow, float partialTicks, MatrixStack poseStack, IVertexBuilder bufferBuilder, int combinedLight, int combinedOverlay);
}
