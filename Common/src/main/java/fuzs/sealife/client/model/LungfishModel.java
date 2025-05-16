package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class LungfishModel extends FishModel<LivingEntityRenderState> {

    public LungfishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(16, 15)
                        .addBox(-1.5F, -1.0F, 1.0F, 3.0F, 3.0F, 3.0F)
                        .texOffs(0, 16)
                        .addBox(-1.0F, -1.25F, 6.0F, 2.0F, 2.0F, 2.0F)
                        .texOffs(18, 7)
                        .addBox(-0.5F, -1.75F, 8.0F, 1.0F, 1.0F, 1.0F)
                        .texOffs(18, 0)
                        .addBox(-1.5F, -0.5F, 4.0F, 3.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 22.0F, 6.0F));

        partDefinition1.addOrReplaceChild("cube",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.5F, 7.0F, 0.0F, 2.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

        partDefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 14)
                        .addBox(-2.0F, -4.0F, -11.0F, 4.0F, 4.0F, 8.0F)
                        .texOffs(0, 0)
                        .addBox(-1.5F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F)
                        .texOffs(18, 4)
                        .addBox(-1.0F, -2.6F, -14.0F, 2.0F, 2.0F, 1.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition partDefinition2 = partDefinition.addOrReplaceChild("fins",
                CubeListBuilder.create(),
                PartPose.offset(-1.0F, 23.0F, -2.0F));

        partDefinition2.addOrReplaceChild("right_fin",
                CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 0.0F, -4.0F, -0.1745F, -0.6109F, 0.2618F));

        partDefinition2.addOrReplaceChild("left_fin",
                CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, 0.0F, -4.0F, -0.1745F, 0.6109F, -0.2618F));

        partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(16, 8)
                        .addBox(0.0F, -5.0F, -1.0F, 0.0F, 1.0F, 6.0F)
                        .texOffs(0, 5)
                        .addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F)
                        .texOffs(0, 0)
                        .addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 10.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 32, 32);
    }
}