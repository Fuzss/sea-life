package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class LampreyModel extends FishModel<LivingEntityRenderState> {

    public LampreyModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 5.0F)
                        .texOffs(29, 31)
                        .addBox(-1.0F, 0.25F, 4.0F, 2.0F, 2.0F, 7.0F)
                        .texOffs(0, 2)
                        .addBox(0.0F, -1.75F, 5.0F, 0.0F, 2.0F, 6.0F),
                PartPose.offset(0.0F, 22.0F, 10.0F));

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(21, 18)
                        .addBox(-2.0F, -3.0F, -11.0F, 4.0F, 3.0F, 8.0F)
                        .texOffs(23, 0)
                        .addBox(-1.5F, 0.0F, -11.0F, 3.0F, 1.0F, 8.0F)
                        .texOffs(0, 18)
                        .addBox(-1.5F, -2.5F, -13.0F, 3.0F, 3.0F, 2.0F)
                        .texOffs(9, 0)
                        .addBox(-1.0F, -1.25F, -14.0F, 2.0F, 2.0F, 1.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        partDefinition1.addOrReplaceChild("middle",
                CubeListBuilder.create()
                        .texOffs(0, 4)
                        .addBox(0.0F, -3.0F, -1.0F, 0.0F, 1.0F, 6.0F)
                        .texOffs(0, 0)
                        .addBox(-2.0F, -3.0F, -4.0F, 4.0F, 3.0F, 15.0F)
                        .texOffs(0, 18)
                        .addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 15.0F)
                        .texOffs(21, 19)
                        .addBox(0.5F, -5.0F, 0.0F, 0.0F, 2.0F, 10.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
