package fuzs.sealife.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.entity.decoration.painting.PaintingVariants;

public class ModPaintingVariants {
    public static final ResourceKey<PaintingVariant> ALBATROSS = ModRegistry.REGISTRIES.makeResourceKey(Registries.PAINTING_VARIANT,
            "albatross");
    public static final ResourceKey<PaintingVariant> BOATS = ModRegistry.REGISTRIES.makeResourceKey(Registries.PAINTING_VARIANT,
            "boats");
    public static final ResourceKey<PaintingVariant> LIGHTHOUSE = ModRegistry.REGISTRIES.makeResourceKey(Registries.PAINTING_VARIANT,
            "lighthouse");
    public static final ResourceKey<PaintingVariant> SUNSET = ModRegistry.REGISTRIES.makeResourceKey(Registries.PAINTING_VARIANT,
            "sunset");
    public static final ResourceKey<PaintingVariant> WINDOW = ModRegistry.REGISTRIES.makeResourceKey(Registries.PAINTING_VARIANT,
            "window");

    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        PaintingVariants.register(context, ALBATROSS, 1, 1);
        PaintingVariants.register(context, BOATS, 1, 1);
        PaintingVariants.register(context, LIGHTHOUSE, 2, 1);
        PaintingVariants.register(context, SUNSET, 1, 1);
        PaintingVariants.register(context, WINDOW, 2, 1);
    }
}
