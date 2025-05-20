package fuzs.sealife.client.renderer.blockentity;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FishTrapBlockEntityRenderer implements BlockEntityRenderer<FishTrapBlockEntity> {
    private final ItemRenderer itemRenderer;

    public FishTrapBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(FishTrapBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        ItemStack itemStack = blockEntity.getItem(0);
        if (!itemStack.isEmpty() && !blockEntity.isBaited()) {
        }
        this.renderSpeechBubble(blockEntity.getLevel(), itemStack, poseStack, bufferSource, packedLight, packedOverlay);
    }

    protected void renderSpeechBubble(Level level, ItemStack itemStack, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, this.getYOffset(), 0.5D);
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        Lighting.setupForFlatItems();
        poseStack.scale(0.75F, 0.75F, 0.01F);
        this.itemRenderer.renderStatic(itemStack,
                ItemDisplayContext.GUI,
                packedLight,
                packedOverlay,
                poseStack,
                bufferSource,
                level, 0);
        poseStack.scale(1.5F, 1.5F, 1.5F);
        poseStack.translate(0F, -0.05F, -0.175F);
//        BakedModel model2 = Minecraft.getInstance().getModelManager().getModel(ClientResources.SPEECH_BUBBLE);
//        renderer.render(getStick(),
//                ItemDisplayContext.GUI,
//                true,
//                poseStack,
//                bufferSource,
//                packedLight,
//                packedOverlay,
//                model2);
        Lighting.setupFor3DItems();
        poseStack.popPose();
    }

    protected double getYOffset() {
        return 1.5;
    }
}