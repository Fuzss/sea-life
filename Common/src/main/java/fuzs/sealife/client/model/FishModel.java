package fuzs.sealife.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

public class FishModel<T extends LivingEntityRenderState> extends EntityModel<T> {
    private final ModelPart tail;

    public FishModel(ModelPart modelPart) {
        super(modelPart);
        this.tail = modelPart.getChild("tail");
    }

    @Override
    public void setupAnim(T renderState) {
        super.setupAnim(renderState);
        float flopSpeed = renderState.isInWater ? 1.0F : 1.7F;
        float flopAmount = renderState.isInWater ? 1.0F : 1.3F;
        this.tail.yRot = -flopAmount * 0.35F * Mth.sin(flopSpeed * 0.6F * renderState.ageInTicks);
    }
}
