package uk.joshiejack.piscary.client.model.geom;

import fuzs.puzzleslib.api.client.init.v1.ModelLayerFactory;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import uk.joshiejack.piscary.Piscary;

public class ModModelLayers {
    static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(Piscary.MOD_ID);
    public static final ModelLayerLocation ANGELFISH = MODEL_LAYERS.registerModelLayer("angelfish");
    public static final ModelLayerLocation BUTTERFLYFISH = MODEL_LAYERS.registerModelLayer("butterflyfish");
    public static final ModelLayerLocation ANGLERFISH = MODEL_LAYERS.registerModelLayer("anglerfish");
}
