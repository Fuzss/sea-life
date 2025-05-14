package uk.joshiejack.piscary.client.model;


import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;


public class LampreyModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MOD_ID, "lamprey"), "main");

	public LampreyModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(29, 31).addBox(-1.0F, 0.25F, 4.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(0.0F, -1.75F, 5.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 10.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(21, 18).addBox(-2.0F, -3.0F, -11.0F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(23, 0).addBox(-1.5F, 0.0F, -11.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-1.5F, -2.5F, -13.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 0).addBox(-1.0F, -1.25F, -14.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition middle = body.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -3.0F, -1.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(21, 19).addBox(0.5F, -5.0F, 0.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}