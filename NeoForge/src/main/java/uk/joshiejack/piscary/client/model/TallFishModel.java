package uk.joshiejack.piscary.client.model;


import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.client.model.AbstractFishModel;


public class TallFishModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MODID, "fatfishmodel"), "main");
	public TallFishModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(4, 2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(0.0F, 3.0F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(0.0F, 1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 4.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(0.0F, -5.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 16);
	}
}