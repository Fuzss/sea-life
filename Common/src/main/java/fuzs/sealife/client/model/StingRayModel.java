package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class StingRayModel extends FishModel<LivingEntityRenderState> {

    public StingRayModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create().texOffs(35, 65).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 1.0F, 13.0F),
                PartPose.offset(0.0F, 20.0F, 15.0F));

        partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(0, 26)
                        .addBox(-4.0F, -1.0F, -7.0F, 8.0F, 1.0F, 22.0F)
                        .texOffs(39, 28)
                        .addBox(-4.0F, -6.0F, -6.0F, 8.0F, 2.0F, 21.0F)
                        .texOffs(0, 0)
                        .addBox(-5.0F, -4.0F, -8.0F, 10.0F, 3.0F, 23.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        partDefinition.addOrReplaceChild("left_wing",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(0.0F, -0.5F, -9.0F, 6.0F, 2.0F, 18.0F)
                        .texOffs(52, 53)
                        .addBox(6.0F, -0.5F, -8.0F, 5.0F, 2.0F, 12.0F)
                        .texOffs(0, 8)
                        .addBox(11.0F, -0.5F, -6.0F, 5.0F, 2.0F, 6.0F)
                        .texOffs(0, 26)
                        .addBox(16.0F, -0.5F, -5.0F, 5.0F, 2.0F, 4.0F),
                PartPose.offset(4.0F, 21.0F, 4.0F));

        partDefinition.addOrReplaceChild("right_wing",
                CubeListBuilder.create()
                        .texOffs(43, 0)
                        .addBox(-6.0F, -0.5F, -9.0F, 6.0F, 2.0F, 18.0F)
                        .texOffs(30, 51)
                        .addBox(-11.0F, -0.5F, -8.0F, 5.0F, 2.0F, 12.0F)
                        .texOffs(0, 0)
                        .addBox(-16.0F, -0.5F, -6.0F, 5.0F, 2.0F, 6.0F)
                        .texOffs(0, 16)
                        .addBox(-21.0F, -0.5F, -5.0F, 5.0F, 2.0F, 4.0F),
                PartPose.offset(-4.0F, 21.0F, 4.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}