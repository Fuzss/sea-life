package fuzs.sealife.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.sealife.init.ModPaintingVariants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ModPaintingVariantTagProvider extends AbstractTagProvider<PaintingVariant> {

    public ModPaintingVariantTagProvider(DataProviderContext context) {
        super(Registries.PAINTING_VARIANT, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .add(ModPaintingVariants.ALBATROSS,
                        ModPaintingVariants.BOATS,
                        ModPaintingVariants.LIGHTHOUSE,
                        ModPaintingVariants.SUNSET,
                        ModPaintingVariants.WINDOW);
    }
}
