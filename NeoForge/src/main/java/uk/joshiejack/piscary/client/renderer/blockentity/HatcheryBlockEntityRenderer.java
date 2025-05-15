package uk.joshiejack.piscary.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.Vec3;
import uk.joshiejack.piscary.world.level.block.entity.HatcheryBlockEntity;
import uk.joshiejack.piscary.world.level.block.entity.HatcheryRenderData;

public class HatcheryBlockEntityRenderer implements BlockEntityRenderer<HatcheryBlockEntity> {
    private final EntityRenderDispatcher entityRenderer;

    public HatcheryBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.getEntityRenderer();
    }

    @Override
    public void render(HatcheryBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        HatcheryRenderData renderer = blockEntity.getRenderData();
        Entity entity = renderer.getOrCreateDisplayEntity(blockEntity.getEntityType());
        if (entity != null) {
            for (int i = 0; i < blockEntity.getCount(); i++) {
                poseStack.pushPose();
                poseStack.translate(0.5D, 0.6D, 0.5D);
                float maxBbDimension = Math.max(entity.getBbWidth(), entity.getBbHeight());
                float height = renderer.getHeight(i) + 0.021F;
                if ((double) maxBbDimension > 1.0D) {
                    height += 1.6F;
                }

                boolean clockwise = renderer.isClockwise(i);
                poseStack.translate(0.0D, (double) -0.25F + (0.1 + height * 0.075F), 0.0D);
                float rotation = renderer.getRotation(i);
                poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
                poseStack.translate(0.0D, -0.7F + (maxBbDimension > 1 ? 0.1F : 0F), 0.0D);
                poseStack.mulPose(Axis.XP.rotationDegrees(-90F));
                poseStack.mulPose(Axis.YP.rotationDegrees(-90F));
                float f = 0.53125F;
                poseStack.scale(f, f, f);
                if (maxBbDimension > 1.0D) {
                    poseStack.scale(0.2F, 0.2F, 0.2F);
                } else {
                    poseStack.scale(0.5F, 0.5F, 0.5F);
                }
                poseStack.translate(1.35F, 0F, 1.35F);
                poseStack.mulPose(Axis.XP.rotationDegrees(clockwise ? -65F : 65F));
                entity.setPose(Pose.SWIMMING);
//                if (HatcheryClient.rotates(entity.getType())) {
//                    poseStack.mulPose(Axis.ZP.rotationDegrees(HatcheryClient.getRotation(entity.getType())));
//                }

                this.entityRenderer.render(entity, 0.0, 0.0, 0.0, partialTick, poseStack, bufferSource, 15728880);
                poseStack.popPose();
            }
        }
    }

    @Override
    public boolean shouldRenderOffScreen(HatcheryBlockEntity blockEntity) {
        return blockEntity.getEntityType() != null;
    }
}
