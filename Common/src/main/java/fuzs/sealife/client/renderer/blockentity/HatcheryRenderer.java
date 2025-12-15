package fuzs.sealife.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fuzs.sealife.client.renderer.blockentity.state.HatcheryRenderState;
import fuzs.sealife.world.level.block.entity.HatcheryBlockEntity;
import fuzs.sealife.world.level.block.entity.HatcheryRenderData;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class HatcheryRenderer implements BlockEntityRenderer<HatcheryBlockEntity, HatcheryRenderState> {
    private final EntityRenderDispatcher entityRenderer;

    public HatcheryRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.entityRenderer();
    }

    @Override
    public HatcheryRenderState createRenderState() {
        return new HatcheryRenderState();
    }

    @Override
    public void extractRenderState(HatcheryBlockEntity blockEntity, HatcheryRenderState renderState, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity,
                renderState,
                partialTick,
                cameraPosition,
                breakProgress);
        HatcheryRenderData renderData = blockEntity.getRenderData();
        renderState.setData(renderData.getRawData(), partialTick);
        if (renderData.getDisplayEntity() != null) {
            renderState.displayEntity = this.entityRenderer.extractEntity(renderData.getDisplayEntity(), partialTick);
            renderState.displayEntity.lightCoords = renderState.lightCoords;
        }
    }

    @Override
    public void submit(HatcheryRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        EntityType<?> entityType = renderState.displayEntity.entityType;
        if (entityType != null) {
            for (int i = 0; i < renderState.getCount(); i++) {
                poseStack.pushPose();
                poseStack.translate(0.5D, 0.6D, 0.5D);
                float maxBbDimension = Math.max(renderState.displayEntity.boundingBoxWidth,
                        renderState.displayEntity.boundingBoxHeight);
                float height = renderState.getHeight(i) + 0.021F;
                if ((double) maxBbDimension > 1.0D) {
                    height += 1.6F;
                }

                boolean clockwise = renderState.isClockwise(i);
                poseStack.translate(0.0D, (double) -0.25F + (0.1 + height * 0.075F), 0.0D);
                float rotation = renderState.getRotation(i);
                poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
                poseStack.translate(0.0D, -0.7F + (maxBbDimension > 1 ? 0.1F : 0F), 0.0D);
                poseStack.mulPose(Axis.XP.rotationDegrees(-90F));
                poseStack.mulPose(Axis.YP.rotationDegrees(-90F));
                float scale = 0.53125F;
                poseStack.scale(scale, scale, scale);
                if (maxBbDimension > 1.0D) {
                    poseStack.scale(0.2F, 0.2F, 0.2F);
                } else {
                    poseStack.scale(0.5F, 0.5F, 0.5F);
                }

                poseStack.translate(1.35F, 0F, 1.35F);
                poseStack.mulPose(Axis.XP.rotationDegrees(clockwise ? -65F : 65F));
                this.entityRenderer.submit(renderState.displayEntity,
                        cameraRenderState,
                        0.0,
                        0.0,
                        0.0,
                        poseStack,
                        nodeCollector);
                poseStack.popPose();
            }
        }
    }
}
