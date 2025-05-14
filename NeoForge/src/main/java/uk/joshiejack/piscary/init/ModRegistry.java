package uk.joshiejack.piscary.init;

import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import uk.joshiejack.piscary.Piscary;

public class ModRegistry {
    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder().add(Registries.PAINTING_VARIANT,
            ModPaintingVariants::bootstrap);
    static final RegistryManager REGISTRIES = RegistryManager.from(Piscary.MODID);

    public static void bootstrap() {

    }
}
