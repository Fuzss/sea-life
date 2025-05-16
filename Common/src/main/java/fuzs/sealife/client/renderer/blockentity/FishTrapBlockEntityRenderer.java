package fuzs.sealife.client.renderer.blockentity;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import uk.joshiejack.penguinlib.client.renderer.block.entity.AbstractItemTileEntityRenderer;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;

import javax.annotation.Nonnull;

public class FishTrapBlockEntityRenderer implements BlockEntityRenderer<FishTrapBlockEntity> {
    private final ItemRenderer itemRenderer;

    public FishTrapBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(FishTrapBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        ItemStack itemStack = blockEntity.getItem(0);
        if (!itemStack.isEmpty() && !blockEntity.isBaited())
            this.renderSpeechBubble(itemStack, poseStack, bufferSource, packedLight, packedOverlay);
    }

    protected void renderSpeechBubble(ItemStack itemStack, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        Minecraft mc = Minecraft.getInstance();
        ItemRenderer renderer = this.itemRenderer;
        poseStack.translate(0.5D, this.getYOffset(), 0.5D);
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.pushPose();
        poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        Lighting.setupForFlatItems();
        poseStack.pushPose();
        poseStack.scale(0.75F, 0.75F, 0.01F);
        BakedModel model = renderer.getModel(itemStack, mc.level, mc.player, packedLight);
        renderer.renderStatic(itemStack, ItemDisplayContext.GUI, true, poseStack, bufferSource, packedLight, packedOverlay, model);
        poseStack.pushPose();
        poseStack.scale(1.5F, 1.5F, 1.5F);
        poseStack.translate(0F, -0.05F, -0.175F);
        BakedModel model2 = Minecraft.getInstance().getModelManager().getModel(ClientResources.SPEECH_BUBBLE);
        renderer.render(getStick(), ItemDisplayContext.GUI, true, poseStack, bufferSource, packedLight, packedOverlay, model2);
        poseStack.popPose();
        poseStack.popPose();
        Lighting.setupFor3DItems();
        poseStack.popPose();
        poseStack.popPose();
    }

    protected double getYOffset() {
        return 1.5;
    }
}