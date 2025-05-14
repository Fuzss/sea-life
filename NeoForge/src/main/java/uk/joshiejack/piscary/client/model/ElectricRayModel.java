package uk.joshiejack.piscary.client.model;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;


public class ElectricRayModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MOD_ID, "electricray"), "main");
	private final ModelPart wing_left;
	private final ModelPart wing_right;

	public ElectricRayModel(ModelPart root) {
		super(root);
		this.wing_left = root.getChild("wing_left");
		this.wing_right = root.getChild("wing_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 3.0F, -1.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(60, 40).addBox(-4.5F, 4.0F, 7.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 15.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -3.0F, -8.0F, 10.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition wing_left = partdefinition.addOrReplaceChild("wing_left", CubeListBuilder.create().texOffs(43, 0).addBox(0.0F, 1.0F, -9.0F, 6.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(22, 48).addBox(6.0F, 2.0F, -8.0F, 5.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 21.0F, 4.0F));

		PartDefinition wing_right = partdefinition.addOrReplaceChild("wing_right", CubeListBuilder.create().texOffs(36, 28).addBox(-6.0F, 1.0F, -9.0F, 6.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-11.0F, 2.0F, -8.0F, 5.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 21.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(tail, body, wing_left, wing_right);
	}
}