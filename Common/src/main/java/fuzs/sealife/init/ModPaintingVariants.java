package fuzs.sealife.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.decoration.PaintingVariants;

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
        PaintingVariants.register(context, ALBATROSS, 16, 16);
        PaintingVariants.register(context, BOATS, 16, 16);
        PaintingVariants.register(context, LIGHTHOUSE, 32, 16);
        PaintingVariants.register(context, SUNSET, 16, 16);
        PaintingVariants.register(context, WINDOW, 32, 16);
    }
}
