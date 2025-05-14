package uk.joshiejack.piscary.client.model;


import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;


public class LongFishModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MOD_ID, "long_fish"), "main");

	public LongFishModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -3.0F, -6.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 4).addBox(-1.0F, -2.6F, -7.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fins = body.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, -2.0F));

		PartDefinition fin_right_r1 = fins.addOrReplaceChild("fin_right_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, -0.1745F, -0.6109F, 0.2618F));

		PartDefinition fin_left_r1 = fins.addOrReplaceChild("fin_left_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 3.0F, -0.1745F, 0.6109F, -0.2618F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(17, 14).addBox(-1.1947F, -1.0F, 6.9933F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-0.6947F, -1.25F, 12.9933F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(17, 14).addBox(-0.1947F, -1.75F, 14.9933F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-1.1947F, -0.5F, 10.9933F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.3F, 22.0F, 6.0F));

		PartDefinition tailfin_r1 = tail.addOrReplaceChild("tailfin_r1", CubeListBuilder.create().texOffs(7, 27).addBox(-3.1947F, -0.75F, -1.0067F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition backfin_r1 = tail.addOrReplaceChild("backfin_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.3053F, 1.4128F, 13.9335F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition middle = tail.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(17, 15).addBox(0.0F, -6.0F, 6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(0.0F, 0.0F, 9.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(0.0F, 0.0F, 9.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-2.0F, -4.0F, 5.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.3F, 2.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}