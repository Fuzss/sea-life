package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class FatFishModel extends FishModel<LivingEntityRenderState> {

    public FatFishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(22, 2)
                        .addBox(0.0F, -6.3F, 4.0F, 0.0F, 8.0F, 4.0F)
                        .texOffs(0, 4)
                        .addBox(0.0F, -4.3F, 0.0F, 0.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 23.0F, 9.75F));

        partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-2.0F, -8.0F, -3.0F, 4.0F, 8.0F, 14.0F)
                        .texOffs(0, 0)
                        .addBox(-2.0F, -5.2F, -5.0F, 4.0F, 4.0F, 2.0F)
                        .texOffs(0, 18)
                        .addBox(0.0F, -12.0F, 3.0F, 0.0F, 4.0F, 6.0F)
                        .texOffs(0, 0)
                        .addBox(0.0F, 0.0F, 3.0F, 0.0F, 2.0F, 6.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("fins",
                CubeListBuilder.create(),
                PartPose.offset(-1.0F, 23.0F, -2.0F));
        partDefinition1.addOrReplaceChild("right_fin",
                CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, -1.0F, 3.0F, -0.1745F, -0.6109F, 0.2618F));
        partDefinition1.addOrReplaceChild("left_fin",
                CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, -1.0F, 3.0F, -0.1745F, 0.6109F, -0.2618F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
