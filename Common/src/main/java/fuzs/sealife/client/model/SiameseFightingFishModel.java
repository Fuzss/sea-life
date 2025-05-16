package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class SiameseFightingFishModel extends FishModel<LivingEntityRenderState> {

    public SiameseFightingFishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F)
                        .texOffs(0, 0)
                        .addBox(0.0F, -3.4F, -0.5F, 0.0F, 7.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 23.0F, 0.5F, 0.0F, 0.0436F, 0.0F));

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(11, 11)
                        .addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F)
                        .texOffs(8, 0)
                        .addBox(-1.0F, -1.6F, -3.0F, 2.0F, 1.0F, 1.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition partDefinition2 = partDefinition1.addOrReplaceChild("fins",
                CubeListBuilder.create(),
                PartPose.offset(-1.0F, -1.0F, -0.75F));

        partDefinition2.addOrReplaceChild("right_fin",
                CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.1745F, -0.6109F, 0.2618F));

        partDefinition2.addOrReplaceChild("left_fin",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F),
                PartPose.offsetAndRotation(2.0F, 0.0F, 1.0F, -0.1745F, 0.6109F, -0.2618F));

        return LayerDefinition.create(meshDefinition, 32, 16);
    }
}