package uk.joshiejack.piscary.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import uk.joshiejack.piscary.init.ModRegistry;
import uk.joshiejack.piscary.init.PiscaryItems;

public class ModItemTagProvider extends AbstractTagProvider<Item> {

    public ModItemTagProvider(DataProviderContext context) {
        super(Registries.ITEM, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(ItemTags.FISHES).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.WOLF_FOOD).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ModRegistry.RAW_FISH_FOODS_ITEM_TAG).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ModRegistry.FISHES_ITEM_TAG)
                .add(PiscaryItems.ANCHOVY.value(),
                        PiscaryItems.ANGELFISH.value(),
                        PiscaryItems.ANGLERFISH.value(),
                        PiscaryItems.BASS.value(),
                        PiscaryItems.BLUE_TANG.value(),
                        PiscaryItems.BOWFIN.value(),
                        PiscaryItems.BUTTERFLYFISH.value(),
                        PiscaryItems.CARP.value(),
                        PiscaryItems.CATFISH.value(),
                        PiscaryItems.CHUB.value(),
                        PiscaryItems.DAMSELFISH.value(),
                        PiscaryItems.ELECTRIC_RAY.value(),
                        PiscaryItems.GOLDFISH.value(),
                        PiscaryItems.KOI.value(),
                        PiscaryItems.LAMPREY.value(),
                        PiscaryItems.LUNGFISH.value(),
                        PiscaryItems.MANTA_RAY.value(),
                        PiscaryItems.MINNOW.value(),
                        PiscaryItems.NEON_TETRA.value(),
                        PiscaryItems.NORTHERN_PIKE.value(),
                        PiscaryItems.PERCH.value(),
                        PiscaryItems.PICKEREL.value(),
                        PiscaryItems.PIRANHA.value(),
                        PiscaryItems.PUPFISH.value(),
                        PiscaryItems.SARDINE.value(),
                        PiscaryItems.SIAMESE_FIGHTING_FISH.value(),
                        PiscaryItems.WHITEMARGIN_STARGAZER.value(),
                        PiscaryItems.STINGRAY.value(),
                        PiscaryItems.SILVER_STRIPE_BLAASOP.value(),
                        PiscaryItems.TROUT.value(),
                        PiscaryItems.TUNA.value(),
                        PiscaryItems.WALLEYE.value());
        this.tag(ItemTags.PIGLIN_LOVED).add(PiscaryItems.GOLDFISH.value());
    }
}
