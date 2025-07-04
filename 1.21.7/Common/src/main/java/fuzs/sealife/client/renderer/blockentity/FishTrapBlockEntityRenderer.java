package fuzs.sealife.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.sealife.SeaLife;
import fuzs.sealife.client.renderer.ModRenderType;
import fuzs.sealife.init.ModRegistry;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSpriteManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.state.ItemClusterRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.util.function.Function;

public class FishTrapBlockEntityRenderer implements BlockEntityRenderer<FishTrapBlockEntity> {
    public static final ResourceLocation GUI_SHEET = ResourceLocationHelper.withDefaultNamespace(
            "textures/atlas/gui.png");
    static final ResourceLocation SPEECH_BUBBLE_SPRITE = SeaLife.id("speech_bubble");

    private final GuiSpriteManager guiSpriteManager;
    private final ItemRenderer itemRenderer;
    private final ItemModelResolver itemModelResolver;
    private final RandomSource random = RandomSource.create();
    private final ItemClusterRenderState renderState = new ItemClusterRenderState();

    public FishTrapBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.guiSpriteManager = Minecraft.getInstance().getGuiSprites();
        this.itemRenderer = context.getItemRenderer();
        this.itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public void render(FishTrapBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        Level level = blockEntity.getLevel();
        if (level != null) {
            ItemStack itemStack = blockEntity.getItem(0);
            if (!itemStack.isEmpty()) {
                if (!itemStack.is(ModRegistry.FISHING_BAIT_ITEM_TAG)) {
                    this.renderSpeechBubble(blockEntity.getLevel(),
                            itemStack,
                            poseStack,
                            bufferSource,
                            packedLight,
                            packedOverlay);
                }
                this.itemModelResolver.updateForTopItem(this.renderState.item,
                        itemStack,
                        ItemDisplayContext.GROUND,
                        level,
                        null,
                        0);
                this.renderState.count = ItemClusterRenderState.getRenderedAmount(itemStack.getCount());
                this.renderState.seed = ItemClusterRenderState.getSeedForItemStack(itemStack);
                poseStack.pushPose();
                poseStack.translate(0.5F, 0.4F, 0.5F);
                poseStack.mulPose(Axis.YP.rotationDegrees(blockEntity.getSpin(partialTick)));
                ItemEntityRenderer.renderMultipleFromCount(poseStack,
                        bufferSource,
                        packedLight,
                        this.renderState,
                        this.random);
                poseStack.popPose();
            }
        }
    }

    /**
     * @see net.minecraft.client.gui.GuiGraphics#innerBlit(Function, ResourceLocation, int, int, int, int, float,
     *         float, float, float, int)
     */
    private void renderSpeechBubble(Level level, ItemStack itemStack, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(0.75F, 0.75F, 0.01F);
        this.itemRenderer.renderStatic(itemStack,
                ItemDisplayContext.GUI,
                packedLight,
                packedOverlay,
                poseStack,
                bufferSource,
                level,
                0);
        poseStack.scale(1.5F, 1.5F, 1.5F);
        poseStack.translate(0.0F, -0.05F, 0.175F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        TextureAtlasSprite sprite = this.guiSpriteManager.getSprite(SPEECH_BUBBLE_SPRITE);
        RenderType renderType = ModRenderType.text(sprite.atlasLocation());
        Matrix4f matrix4f = poseStack.last().pose();
        VertexConsumer vertexConsumer = bufferSource.getBuffer(renderType);
        vertexConsumer.addVertex(matrix4f, -0.5F, -0.5F, 0.0F)
                .setUv(sprite.getU0(), sprite.getV0())
                .setColor(-1)
                .setLight(packedLight);
        vertexConsumer.addVertex(matrix4f, -0.5F, 0.5F, 0.0F)
                .setUv(sprite.getU0(), sprite.getV1())
                .setColor(-1)
                .setLight(packedLight);
        vertexConsumer.addVertex(matrix4f, 0.5F, 0.5F, 0.0F)
                .setUv(sprite.getU1(), sprite.getV1())
                .setColor(-1)
                .setLight(packedLight);
        vertexConsumer.addVertex(matrix4f, 0.5F, -0.5F, 0.0F)
                .setUv(sprite.getU1(), sprite.getV0())
                .setColor(-1)
                .setLight(packedLight);
        poseStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(FishTrapBlockEntity blockEntity) {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 32;
    }
}