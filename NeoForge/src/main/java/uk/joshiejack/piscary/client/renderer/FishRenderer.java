package uk.joshiejack.piscary.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.AbstractFish;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.piscary.Piscary;

public class FishRenderer extends MobRenderer<AbstractFish, EntityModel<AbstractFish>> {
    private final ResourceLocation texture;

    public FishRenderer(EntityRendererProvider.Context manager, EntityModel<AbstractFish> model, String entity) {
        super(manager, model, 0.35F);
        this.texture = new ResourceLocation(Piscary.MODID, "textures/entity/" + entity + ".png");
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AbstractFish entity) {
        return texture;
    }

    @Override
    protected void setupRotations(@NotNull AbstractFish fish, @NotNull PoseStack stack, float x, float y, float z) {
        super.setupRotations(fish, stack, x, y, z);
        float f = 1.0F;
        float f1 = 1.0F;
        if (!fish.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * x);
        stack.mulPose(Axis.YP.rotationDegrees(f2));
        stack.translate(0.0D, 0.0D, -0.4F);
        if (!fish.isInWater()) {
            stack.translate(0.2F, 0.1F, 0.0D);
            stack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }
}
