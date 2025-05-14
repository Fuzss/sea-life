package uk.joshiejack.piscary.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import uk.joshiejack.penguinlib.client.renderer.block.entity.AbstractItemTileEntityRenderer;
import uk.joshiejack.piscary.client.HatcheryClient;
import uk.joshiejack.piscary.world.block.entity.HatcheryBlockEntity;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class HatcheryBlockEntityRenderer extends AbstractItemTileEntityRenderer<HatcheryBlockEntity> {
    public HatcheryBlockEntityRenderer(BlockEntityRendererProvider.Context dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(@Nonnull HatcheryBlockEntity tile, float partialTicks, @Nonnull PoseStack matrix, @Nonnull MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
        HatcheryFishRender renderer = tile.getRenderer();
        Entity entity = renderer.getOrCreateDisplayEntity(tile.getEntityType());
        for (int i = 0; i < tile.getCount(); i++) {
            if (entity != null) {
                matrix.pushPose();
                matrix.translate(0.5D, 0.6D, 0.5D);
                float f = 0.53125F;
                float f1 = Math.max(entity.getBbWidth(), entity.getBbHeight());
                float height = renderer.getHeight(i) + 0.021F;
                if ((double) f1 > 1.0D) {
                    height += 1.6F;
                }

                boolean clockwise = renderer.isClockwise(i);
                matrix.translate(0.0D, (double) -0.25F + (0.1 + height * 0.075F), 0.0D);
                float rotation = renderer.getRotation(i);
                matrix.mulPose(Axis.YP.rotationDegrees(rotation));
                matrix.translate(0.0D, -0.7F + (f1 > 1 ? 0.1F : 0F), 0.0D);
                matrix.mulPose(Axis.XP.rotationDegrees(-90F));
                matrix.mulPose(Axis.YP.rotationDegrees(-90F));
                matrix.scale(f, f, f);
                EntityRenderDispatcher rm = Minecraft.getInstance().getEntityRenderDispatcher();
                matrix.pushPose();
                if (f1 > 1.0D) {
                    matrix.scale(0.2F, 0.2F, 0.2F);
                } else matrix.scale(0.5F, 0.5F, 0.5F);
                matrix.translate(1.35F, 0F, 1.35F);
                matrix.mulPose(Axis.XP.rotationDegrees(clockwise ? -65F : 65F));
                entity.setPose(Pose.SWIMMING);
                if (HatcheryClient.rotates(entity.getType())) {
                    matrix.mulPose(Axis.ZP.rotationDegrees(HatcheryClient.getRotation(entity.getType())));
                }

                runAsFancy(() -> Minecraft.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 1.0F, matrix, buffer, 15728880));
                matrix.popPose();
                matrix.popPose();
            }
        }
    }

    private void runAsFancy(Runnable r) {
        boolean flag = Minecraft.useShaderTransparency();
        if (!flag) {
            r.run();
        } else {
            Options gamesettings = Minecraft.getInstance().options;
            GraphicsStatus graphicsfanciness = gamesettings.graphicsMode().get();
            gamesettings.graphicsMode().set(GraphicsStatus.FABULOUS);
            r.run();
            gamesettings.graphicsMode().set(graphicsfanciness);
        }
    }

    @Override
    public boolean shouldRenderOffScreen(HatcheryBlockEntity te) {
        return te.getEntityType() != null;
    }
}
