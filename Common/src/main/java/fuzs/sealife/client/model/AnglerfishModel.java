package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class AnglerfishModel extends FishModel<LivingEntityRenderState> {

    public AnglerfishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(18, 13)
                        .addBox(0.0F, -7.3F, 3.0F, 0.0F, 6.0F, 6.0F)
                        .texOffs(0, 30)
                        .addBox(-2.0F, -6.0F, 0.0F, 4.0F, 3.0F, 3.0F),
                PartPose.offset(0.0F, 23.0F, 3.0F));

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-5.0F, -9.0F, -8.0F, 10.0F, 9.0F, 10.0F)
                        .texOffs(0, 19)
                        .addBox(-4.0F, -9.0F, 2.0F, 8.0F, 7.0F, 1.0F)
                        .texOffs(30, 0)
                        .addBox(-3.0F, -8.0F, 3.0F, 6.0F, 5.0F, 1.0F)
                        .texOffs(16, 25)
                        .addBox(-3.0F, -8.45F, -10.0F, 6.0F, 6.0F, 2.0F)
                        .texOffs(0, 21)
                        .addBox(0.0F, -12.0F, -3.0F, 0.0F, 3.0F, 6.0F)
                        .texOffs(12, 25)
                        .addBox(0.0F, -2.0F, 2.0F, 0.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        partDefinition1.addOrReplaceChild("light",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -6.0F, 1.0F, 2.0F, 8.0F, 2.0F),
                PartPose.offsetAndRotation(1.0F, -9.0F, -8.0F, 0.6109F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}