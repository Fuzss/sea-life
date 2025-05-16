package fuzs.sealife.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.AbstractFish;

import java.util.function.Function;

public class FishRenderer extends MobRenderer<AbstractFish, LivingEntityRenderState, EntityModel<LivingEntityRenderState>> {
    private final ResourceLocation textureLocation;
    private final boolean panicOnLand;

    public FishRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, Function<ModelPart, EntityModel<LivingEntityRenderState>> modelFactory) {
        this(context, modelLayerLocation, modelFactory, true);
    }

    public FishRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, Function<ModelPart, EntityModel<LivingEntityRenderState>> modelFactory, boolean panicOnLand) {
        super(context, modelFactory.apply(context.bakeLayer(modelLayerLocation)), 0.35F);
        this.textureLocation = modelLayerLocation.model().withPath((String s) -> "textures/entity/fish/" + s + ".png");
        this.panicOnLand = panicOnLand;
    }

    @Override
    public ResourceLocation getTextureLocation(LivingEntityRenderState renderState) {
        return this.textureLocation;
    }

    @Override
    protected void setupRotations(LivingEntityRenderState renderState, PoseStack poseStack, float bodyRot, float scale) {
        super.setupRotations(renderState, poseStack, bodyRot, scale);
        float flopAmount;
        float flopSpeed;
        if (this.panicOnLand && !renderState.isInWater) {
            flopAmount = 1.3F;
            flopSpeed = 1.7F;
        } else {
            flopAmount = 1.0F;
            flopSpeed = 1.0F;
        }

        float yRot = flopAmount * 4.3F * Mth.sin(flopSpeed * 0.6F * renderState.ageInTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.translate(0.0F, 0.0F, -0.4F);
        if (!renderState.isInWater) {
            poseStack.translate(0.2F, 0.1F, 0.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
