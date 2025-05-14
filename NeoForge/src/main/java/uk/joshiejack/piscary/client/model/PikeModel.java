package uk.joshiejack.piscary.client.model;


import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;


public class PikeModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MOD_ID, "pike"), "main");

	public PikeModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 23).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -2.25F, 4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(0.0F, -4.75F, 7.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 10.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(35, 14).addBox(-2.0F, -6.0F, -11.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(21, 0).addBox(-1.5F, -5.0F, -16.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 15).addBox(-1.0F, -3.6F, -20.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 15).addBox(-1.0F, -3.6F, -20.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition middle = body.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(16, 17).addBox(0.0F, -5.0F, -1.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(21, 8).addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(16, 12).addBox(0.5F, -10.0F, 3.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin_left_r1 = middle.addOrReplaceChild("fin_left_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, 7.0F, -0.1745F, 0.6109F, -0.2618F));

		PartDefinition fin_right_r1 = middle.addOrReplaceChild("fin_right_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 7.0F, -0.1745F, -0.6109F, 0.2618F));

		PartDefinition fins = body.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, -2.0F));

		PartDefinition fin_right_r2 = fins.addOrReplaceChild("fin_right_r2", CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -2.0F, -0.1745F, -0.6109F, 0.2618F));

		PartDefinition fin_right_r3 = fins.addOrReplaceChild("fin_right_r3", CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -8.0F, -0.1745F, -0.6109F, 0.2618F));

		PartDefinition fin_left_r2 = fins.addOrReplaceChild("fin_left_r2", CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -2.0F, -0.1745F, 0.6109F, -0.2618F));

		PartDefinition fin_left_r3 = fins.addOrReplaceChild("fin_left_r3", CubeListBuilder.create().texOffs(21, 6).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -8.0F, -0.1745F, 0.6109F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}