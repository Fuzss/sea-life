package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class LongFishModel extends FishModel<LivingEntityRenderState> {

    public LongFishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        partDefinition1.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 10.0F)
                        .texOffs(0, 0)
                        .addBox(-1.5F, -3.0F, -6.0F, 3.0F, 3.0F, 2.0F)
                        .texOffs(18, 4)
                        .addBox(-1.0F, -2.6F, -7.0F, 2.0F, 2.0F, 1.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition partDefinition2 = partDefinition1.addOrReplaceChild("fins",
                CubeListBuilder.create(),
                PartPose.offset(-1.0F, -1.0F, -2.0F));

        partDefinition2.addOrReplaceChild("right_fin",
                CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, -0.1745F, -0.6109F, 0.2618F));

        partDefinition2.addOrReplaceChild("left_fin",
                CubeListBuilder.create()
                        .texOffs(0, 3)
                        .addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F)
                        .texOffs(0, 3)
                        .addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(3.0F, 0.0F, 3.0F, -0.1745F, 0.6109F, -0.2618F));

        PartDefinition partDefinition3 = partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(17, 14)
                        .addBox(-1.1947F, -1.0F, 6.9933F, 3.0F, 3.0F, 4.0F)
                        .texOffs(0, 16)
                        .addBox(-0.6947F, -1.25F, 12.9933F, 2.0F, 2.0F, 2.0F)
                        .texOffs(17, 14)
                        .addBox(-0.1947F, -1.75F, 14.9933F, 1.0F, 1.0F, 1.0F)
                        .texOffs(18, 0)
                        .addBox(-1.1947F, -0.5F, 10.9933F, 3.0F, 2.0F, 2.0F),
                PartPose.offset(-0.3F, 22.0F, 6.0F));

        partDefinition3.addOrReplaceChild("tailfin",
                CubeListBuilder.create().texOffs(7, 27).addBox(-3.1947F, -0.75F, -1.0067F, 7.0F, 0.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.3491F, 0.0F, 0.0F));

        partDefinition3.addOrReplaceChild("backfin",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.3053F, 1.4128F, 13.9335F, 0.0F, 2.0F, 5.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

        partDefinition3.addOrReplaceChild("middle",
                CubeListBuilder.create()
                        .texOffs(17, 15)
                        .addBox(0.0F, -6.0F, 6.0F, 0.0F, 2.0F, 6.0F)
                        .texOffs(0, 23)
                        .addBox(0.0F, 0.0F, 9.0F, 0.0F, 3.0F, 4.0F)
                        .texOffs(0, 23)
                        .addBox(0.0F, 0.0F, 9.0F, 0.0F, 3.0F, 4.0F)
                        .texOffs(0, 14)
                        .addBox(-2.0F, -4.0F, 5.0F, 4.0F, 4.0F, 9.0F),
                PartPose.offset(0.3F, 2.0F, -6.0F));

        return LayerDefinition.create(meshDefinition, 32, 32);
    }
}