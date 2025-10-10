package fuzs.sealife.client.renderer.blockentity;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fuzs.sealife.SeaLife;
import fuzs.sealife.client.renderer.ModRenderType;
import fuzs.sealife.client.renderer.blockentity.state.FishTrapRenderState;
import fuzs.sealife.init.ModRegistry;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public class FishTrapRenderer implements BlockEntityRenderer<FishTrapBlockEntity, FishTrapRenderState> {
    public static final RenderType RENDER_TYPE = ModRenderType.text(Sheets.GUI_SHEET);
    private static final Material SPEECH_BUBBLE_TEXTURE = new Material(Sheets.GUI_SHEET, SeaLife.id("speech_bubble"));

    private final RandomSource random = RandomSource.create();
    private final ItemModelResolver itemModelResolver;
    private final MaterialSet materials;

    public FishTrapRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
        this.materials = context.materials();
    }

    @Override
    public FishTrapRenderState createRenderState() {
        return new FishTrapRenderState();
    }

    @Override
    public void extractRenderState(FishTrapBlockEntity blockEntity, FishTrapRenderState renderState, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity,
                renderState,
                partialTick,
                cameraPosition,
                breakProgress);
        ItemStack itemStack = blockEntity.getItem(0);
        int position = (int) blockEntity.getBlockPos().asLong();
        this.itemModelResolver.updateForTopItem(renderState.item,
                itemStack,
                ItemDisplayContext.GUI,
                blockEntity.getLevel(),
                null,
                position);
        renderState.cluster.item.clear();
        renderState.spin = blockEntity.getSpin(partialTick);
        renderState.isBait = itemStack.is(ModRegistry.FISHING_BAIT_ITEM_TAG);
        Entity entity = Minecraft.getInstance().player;
        if (entity != null) {
            renderState.cluster.extractItemGroupRenderState(entity, itemStack, this.itemModelResolver);
        }
    }

    @Override
    public void submit(FishTrapRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        if (!renderState.cluster.item.isEmpty()) {
            this.submitItem(renderState, poseStack, nodeCollector);
            if (!renderState.isBait) {
                this.submitSpeechBubble(renderState, poseStack, nodeCollector, cameraRenderState);
            }
        }
    }

    private void submitItem(FishTrapRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector) {
        poseStack.pushPose();
        poseStack.translate(0.5F, 0.4F, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(renderState.spin));
        ItemEntityRenderer.renderMultipleFromCount(poseStack,
                nodeCollector,
                renderState.lightCoords,
                renderState.cluster,
                this.random);
        poseStack.popPose();
    }

    /**
     * @see net.minecraft.client.gui.GuiGraphics#innerBlit(RenderPipeline, ResourceLocation, int, int, int, int,
     *         float, float, float, float, int)
     */
    private void submitSpeechBubble(FishTrapRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.mulPose(cameraRenderState.orientation);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(0.75F, 0.75F, 0.01F);
        renderState.item.submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        poseStack.scale(1.5F, 1.5F, 1.5F);
        poseStack.translate(0.0F, -0.05F, 0.175F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        nodeCollector.submitCustomGeometry(poseStack,
                RENDER_TYPE,
                (PoseStack.Pose pose, VertexConsumer vertexConsumer) -> {
                    Matrix4f matrix4f = pose.pose();
                    TextureAtlasSprite sprite = this.materials.get(SPEECH_BUBBLE_TEXTURE);
                    vertexConsumer.addVertex(matrix4f, -0.5F, -0.5F, 0.0F)
                            .setUv(sprite.getU0(), sprite.getV0())
                            .setColor(-1)
                            .setLight(renderState.lightCoords);
                    vertexConsumer.addVertex(matrix4f, -0.5F, 0.5F, 0.0F)
                            .setUv(sprite.getU0(), sprite.getV1())
                            .setColor(-1)
                            .setLight(renderState.lightCoords);
                    vertexConsumer.addVertex(matrix4f, 0.5F, 0.5F, 0.0F)
                            .setUv(sprite.getU1(), sprite.getV1())
                            .setColor(-1)
                            .setLight(renderState.lightCoords);
                    vertexConsumer.addVertex(matrix4f, 0.5F, -0.5F, 0.0F)
                            .setUv(sprite.getU1(), sprite.getV0())
                            .setColor(-1)
                            .setLight(renderState.lightCoords);
                });
        poseStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen() {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 32;
    }
}
