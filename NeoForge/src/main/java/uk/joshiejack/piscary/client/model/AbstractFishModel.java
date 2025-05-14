package uk.joshiejack.piscary.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.AbstractFish;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFishModel extends EntityModel<AbstractFish> {
    protected final ModelPart tail;
    protected final ModelPart body;
    protected Iterable<ModelPart> parts;


    public AbstractFishModel(ModelPart root) {
        this.tail = root.getChild("tail");
        this.body = root.getChild("body");
    }

    public Iterable<ModelPart> parts() {
        return ImmutableList.of(tail, body);
    }

    @Override
    public void setupAnim(AbstractFish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        float f1 = 1.0F;
        if (!entity.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        tail.yRot = -f * 0.35F * Mth.sin(f1 * 0.6F * ageInTicks);
    }


    @Override
    public void renderToBuffer(@NotNull PoseStack matrixStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (parts == null) parts = parts();
        parts.forEach(part -> part.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha));
    }

    protected void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
