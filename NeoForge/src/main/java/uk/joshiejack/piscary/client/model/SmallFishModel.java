package uk.joshiejack.piscary.client.model;


import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;


public class SmallFishModel extends AbstractFishModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MOD_ID, "small_fish"), "main");

    public SmallFishModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(11, 2).addBox(0.0F, -1.4F, 1.25F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(11, 8).addBox(0.0F, -0.4F, -0.75F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 5.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(-1.0F, -1.6F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 11).addBox(0.0F, -4.0F, 1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition fins = body.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, -2.0F));

        PartDefinition fin_right_r1 = fins.addOrReplaceChild("fin_right_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.1745F, -0.6109F, 0.2618F));

        PartDefinition fin_left_r1 = fins.addOrReplaceChild("fin_left_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, -0.1745F, 0.6109F, -0.2618F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}