package uk.joshiejack.piscary.client.model;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;


public class LungfishModel extends AbstractFishModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Piscary.MOD_ID, "lungfish"), "main");
	private final ModelPart head;
	private final ModelPart fins;

	public LungfishModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.fins = root.getChild("fins");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 15).addBox(-1.5F, -1.0F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-1.0F, -1.25F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 7).addBox(-0.5F, -1.75F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-1.5F, -0.5F, 4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 6.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.5F, 7.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -4.0F, -11.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -3.0F, -13.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 4).addBox(-1.0F, -2.6F, -14.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition fins = partdefinition.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(-1.0F, 23.0F, -2.0F));

		PartDefinition fin_right_r1 = fins.addOrReplaceChild("fin_right_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -4.0F, -0.1745F, -0.6109F, 0.2618F));

		PartDefinition fin_left_r1 = fins.addOrReplaceChild("fin_left_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -4.0F, -0.1745F, 0.6109F, -0.2618F));

		PartDefinition middle = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 8).addBox(0.0F, -5.0F, -1.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(tail, head, fins, body);
	}
}