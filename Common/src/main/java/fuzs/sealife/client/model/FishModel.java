package fuzs.sealife.client.model;

import fuzs.puzzleslib.api.client.renderer.v1.model.RootedEntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class FishModel<T extends Entity> extends RootedEntityModel<T> {
    private final ModelPart tail;

    public FishModel(ModelPart modelPart) {
        super(modelPart);
        this.tail = modelPart.hasChild("body_back") ? modelPart.getChild("body_back") : modelPart.getChild("tail");
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float flopSpeed = entity.isInWater() ? 1.0F : 1.7F;
        float flopAmount = entity.isInWater() ? 1.0F : 1.3F;
        this.tail.yRot = -flopAmount * 0.35F * Mth.sin(flopSpeed * 0.6F * ageInTicks);
    }
}
