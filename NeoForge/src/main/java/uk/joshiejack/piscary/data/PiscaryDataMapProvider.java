package uk.joshiejack.piscary.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.DataMapProvider;
import uk.joshiejack.piscary.init.ModEntityTypes;
import uk.joshiejack.piscary.world.item.crafting.HatcheryEntry;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;

import java.util.concurrent.CompletableFuture;

public class PiscaryDataMapProvider extends DataMapProvider {
    public PiscaryDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void gather() {
        final var hatchery = builder(PiscaryRegistries.HATCHERY);
        //Vanilla
        hatchery.add(EntityType.COD.getDefaultLootTable(), HatcheryEntry.simple(3), false);
        hatchery.add(EntityType.SALMON.getDefaultLootTable(), HatcheryEntry.simple(3), false);
        hatchery.add(EntityType.PUFFERFISH.getDefaultLootTable(), HatcheryEntry.simple(5), false);
        hatchery.add(EntityType.TROPICAL_FISH.getDefaultLootTable(), HatcheryEntry.simple(5), false);

        //Piscary
        hatchery.add(ModEntityTypes.ANCHOVY.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.ANGELFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.ANGLERFISH.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.BASS.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.BLUE_TANG.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.BOWFIN.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.BUTTERFLYFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.CARP.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.CATFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.CHUB.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.DAMSELFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.ELECTRIC_RAY.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.GOLDFISH.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.KOI.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.LAMPREY.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.LUNGFISH.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.MANTA_RAY.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.NEON_TETRA.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.NORTHERN_PIKE.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.PERCH.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.PICKEREL.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.PIRANHA.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.PUPFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.SARDINE.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.SIAMESE_FIGHTING_FISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.SILVER_STRIPE_BLAASOP.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.WHITEMARGIN_STARGAZER.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.STINGRAY.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(ModEntityTypes.TROUT.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(ModEntityTypes.TUNA.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(ModEntityTypes.WALLEYE.getKey(), HatcheryEntry.simple(3), false);

        //Aquaculture
        hatchery.add(new ResourceLocation("aquaculture", "atlantic_cod"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "blackfish"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "pacific_halibut"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "atlantic_halibut"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "atlantic_herring"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "pink_salmon"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "pollock"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "rainbow_trout"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "bayad"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "boulti"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "capitaine"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "synodontis"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "smallmouth_bass"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "bluegill"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "brown_trout"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "carp"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "catfish"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "gar"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "minnow"), HatcheryEntry.simple(4), false);
        hatchery.add(new ResourceLocation("aquaculture", "muskellunge"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "perch"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "arapaima"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "piranha"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "tambaqui"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "brown_shrooma"), HatcheryEntry.simple(2), false);
        hatchery.add(new ResourceLocation("aquaculture", "red_shrooma"), HatcheryEntry.simple(2), false);
        hatchery.add(new ResourceLocation("aquaculture", "jellyfish"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "red_grouper"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "tuna"), HatcheryEntry.simple(7), false);
    }
}