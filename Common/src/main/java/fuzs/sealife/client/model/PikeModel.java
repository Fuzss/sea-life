package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class PikeModel extends FishModel<LivingEntityRenderState> {

    public PikeModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(24, 23)
                        .addBox(-1.5F, -3.0F, -1.0F, 3.0F, 4.0F, 5.0F)
                        .texOffs(0, 0)
                        .addBox(-1.0F, -2.25F, 4.0F, 2.0F, 2.0F, 3.0F)
                        .texOffs(0, 15)
                        .addBox(0.0F, -4.75F, 7.0F, 0.0F, 7.0F, 4.0F),
                PartPose.offset(0.0F, 22.0F, 10.0F));

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(35, 14)
                        .addBox(-2.0F, -6.0F, -11.0F, 4.0F, 6.0F, 8.0F)
                        .texOffs(21, 0)
                        .addBox(-1.5F, -5.0F, -16.0F, 3.0F, 5.0F, 5.0F)
                        .texOffs(30, 15)
                        .addBox(-1.0F, -3.6F, -20.0F, 2.0F, 3.0F, 4.0F)
                        .texOffs(30, 15)
                        .addBox(-1.0F, -3.6F, -20.0F, 2.0F, 3.0F, 4.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition partDefinition2 = partDefinition1.addOrReplaceChild("middle",
                CubeListBuilder.create()
                        .texOffs(16, 17)
                        .addBox(0.0F, -5.0F, -1.0F, 0.0F, 1.0F, 6.0F)
                        .texOffs(21, 8)
                        .addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F)
                        .texOffs(0, 0)
                        .addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 13.0F)
                        .texOffs(16, 12)
                        .addBox(0.5F, -10.0F, 3.0F, 0.0F, 4.0F, 7.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        partDefinition2.addOrReplaceChild("left_middle_fin",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F)
                        .texOffs(0, 0)
                        .addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F),
                PartPose.offsetAndRotation(2.0F, -1.0F, 7.0F, -0.1745F, 0.6109F, -0.2618F));

        partDefinition2.addOrReplaceChild("right_middle_fin",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F),
                PartPose.offsetAndRotation(-2.0F, -1.0F, 7.0F, -0.1745F, -0.6109F, 0.2618F));

        PartDefinition partDefinition3 = partDefinition1.addOrReplaceChild("fins",
                CubeListBuilder.create(),
                PartPose.offset(-1.0F, -1.0F, -2.0F));

        partDefinition3.addOrReplaceChild("outer_right_back_fin",
                CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 0.0F, -2.0F, -0.1745F, -0.6109F, 0.2618F));

        partDefinition3.addOrReplaceChild("inner_right_back_fin",
                CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 0.0F, -8.0F, -0.1745F, -0.6109F, 0.2618F));

        partDefinition3.addOrReplaceChild("outer_left_back_fin",
                CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, 0.0F, -2.0F, -0.1745F, 0.6109F, -0.2618F));

        partDefinition3.addOrReplaceChild("inner_left_back_fin",
                CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, 0.0F, -8.0F, -0.1745F, 0.6109F, -0.2618F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}