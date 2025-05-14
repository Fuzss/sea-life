package uk.joshiejack.piscary.client.model;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.client.model.AbstractFishModel;


public class StargazerModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MODID, "stargazer"), "main");
	private final ModelPart fins;

	public StargazerModel(ModelPart root) {
		super(root);
		this.fins = root.getChild("fins");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.3F, 4.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 3).addBox(-2.0F, -4.3F, -3.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 12.75F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -3.0F, 10.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-3.0F, -6.2F, -5.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 16).addBox(0.0F, -12.0F, 1.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(15, 12).addBox(0.0F, 0.0F, 1.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition fins = partdefinition.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(-1.0F, 23.0F, -2.0F));

		PartDefinition fin_right_r1 = fins.addOrReplaceChild("fin_right_r1", CubeListBuilder.create().texOffs(0, 8).addBox(-3.0F, -1.0F, 1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 3.0F, -0.1745F, -0.6109F, 0.2618F));

		PartDefinition fin_left_r1 = fins.addOrReplaceChild("fin_left_r1", CubeListBuilder.create().texOffs(0, 8).addBox(3.0F, -1.0F, 1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, 3.0F, -0.1745F, 0.6109F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(tail, body, fins);
	}
}