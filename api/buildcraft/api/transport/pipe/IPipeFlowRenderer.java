package buildcraft.api.transport.pipe;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;

public interface IPipeFlowRenderer<F extends PipeFlow> {
    /** @param flow The flow to render
     * @param bufferSource The buffer source of (optional) vertex buffer that you can render into. Note that you can still do GL stuff. */
//    void render(F flow, double x, double y, double z, float partialTicks, BufferBuilder bufferBuilder);
    void render(F flow, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay);
}
