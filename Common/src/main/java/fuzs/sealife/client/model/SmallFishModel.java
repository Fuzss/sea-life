package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class SmallFishModel extends FishModel<LivingEntityRenderState> {

    public SmallFishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(11, 2)
                        .addBox(0.0F, -1.4F, 1.25F, 0.0F, 3.0F, 2.0F)
                        .texOffs(11, 8)
                        .addBox(0.0F, -0.4F, -0.75F, 0.0F, 1.0F, 2.0F),
                PartPose.offset(0.0F, 23.0F, 5.0F));
        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 7.0F)
                        .texOffs(12, 12)
                        .addBox(-1.0F, -1.6F, -3.0F, 2.0F, 1.0F, 1.0F)
                        .texOffs(1, 11)
                        .addBox(0.0F, -4.0F, 1.0F, 0.0F, 2.0F, 3.0F)
                        .texOffs(11, 11)
                        .addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 4.0F)
                        .texOffs(11, 11)
                        .addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition partDefinition2 = partDefinition1.addOrReplaceChild("fins",
                CubeListBuilder.create(),
                PartPose.offset(-1.0F, -1.0F, -2.0F));

        partDefinition2.addOrReplaceChild("right_fin",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.1745F, -0.6109F, 0.2618F));

        partDefinition2.addOrReplaceChild("left_fin",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F),
                PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, -0.1745F, 0.6109F, -0.2618F));

        return LayerDefinition.create(meshDefinition, 32, 16);
    }
}