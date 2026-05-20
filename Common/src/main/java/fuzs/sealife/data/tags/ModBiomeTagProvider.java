package fuzs.sealife.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.sealife.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class ModBiomeTagProvider extends AbstractTagProvider<Biome> {

    public ModBiomeTagProvider(DataProviderContext context) {
        super(Registries.BIOME, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {

        // ANCHOVY - Saltwater fish found in cooler coastal waters
        this.add(ModRegistry.SPAWNS_ANCHOVY_BIOME_TAG)
                .add(Biomes.FROZEN_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.COLD_OCEAN,
                        Biomes.DEEP_COLD_OCEAN,
                        Biomes.OCEAN,
                        Biomes.DEEP_OCEAN);

        // ANGELFISH - Tropical freshwater fish primarily in jungle rivers
        this.add(ModRegistry.SPAWNS_ANGELFISH_BIOME_TAG)
                .addTag(BiomeTags.IS_JUNGLE)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG);

        // ANGLERFISH - Deep sea fish from cold ocean depths
        this.add(ModRegistry.SPAWNS_ANGLERFISH_BIOME_TAG)
                .add(Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN);

        // BASS - Temperate freshwater fish, found in various water bodies
        this.add(ModRegistry.SPAWNS_BASS_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.MEADOW)
                .addTag(ModRegistry.IS_PLAINS_BIOME_TAG)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // BLUE TANG - Tropical reef fish, warm ocean waters
        this.add(ModRegistry.SPAWNS_BLUE_TANG_BIOME_TAG)
                .add(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN);

        // BOWFIN - Freshwater fish found in swamps and slow-moving rivers
        this.add(ModRegistry.SPAWNS_BOWFIN_BIOME_TAG).add(Biomes.RIVER).addTag(ModRegistry.IS_SWAMP_BIOME_TAG);

        // BUTTERFLYFISH - Tropical reef fish in warm oceans
        this.add(ModRegistry.SPAWNS_BUTTERFLYFISH_BIOME_TAG)
                .add(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN);

        // CARP - Freshwater fish, adaptable to many freshwater habitats
        this.add(ModRegistry.SPAWNS_CARP_BIOME_TAG)
                .add(Biomes.RIVER)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG)
                .addTag(ModRegistry.IS_PLAINS_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // CATFISH - Freshwater bottom-dwellers in various water bodies
        this.add(ModRegistry.SPAWNS_CATFISH_BIOME_TAG).add(Biomes.RIVER).addTag(ModRegistry.IS_SWAMP_BIOME_TAG);

        // CHUB - Freshwater fish found in rivers and streams
        this.add(ModRegistry.SPAWNS_CHUB_BIOME_TAG).add(Biomes.RIVER, Biomes.MEADOW).addTag(BiomeTags.IS_FOREST);

        // DAMSELFISH - Bright tropical reef fish
        this.add(ModRegistry.SPAWNS_DAMSELFISH_BIOME_TAG)
                .add(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN);

        // ELECTRIC RAY - Saltwater fish found in various ocean depths
        this.add(ModRegistry.SPAWNS_ELECTRIC_RAY_BIOME_TAG)
                .add(Biomes.OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.WARM_OCEAN);

        // GOLDFISH - Domesticated freshwater fish
        this.add(ModRegistry.SPAWNS_GOLDFISH_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.MEADOW)
                .addTag(ModRegistry.IS_PLAINS_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // KOI - Ornamental variety of carp
        this.add(ModRegistry.SPAWNS_KOI_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.MEADOW, Biomes.CHERRY_GROVE)
                .addTag(ModRegistry.IS_PLAINS_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // LAMPREY - Parasitic fish found in both fresh and saltwater
        this.add(ModRegistry.SPAWNS_LAMPREY_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN);

        // LUNGFISH - Freshwater fish that can breathe air, tropical regions
        this.add(ModRegistry.SPAWNS_LUNGFISH_BIOME_TAG)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG)
                .addTag(BiomeTags.IS_JUNGLE);

        // MANTA RAY - Large ocean dwellers, warm to temperate waters
        this.add(ModRegistry.SPAWNS_MANTA_RAY_BIOME_TAG)
                .add(Biomes.OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.WARM_OCEAN);

        // MINNOW - Small freshwater fish found in various habitats
        this.add(ModRegistry.SPAWNS_MINNOW_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.MEADOW)
                .addTag(ModRegistry.IS_PLAINS_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // NEON TETRA - Tropical freshwater fish, Amazon basin
        this.add(ModRegistry.SPAWNS_NEON_TETRA_BIOME_TAG)
                .addTag(BiomeTags.IS_JUNGLE)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG);

        // NORTHERN PIKE - Freshwater predator from cold regions
        this.add(ModRegistry.SPAWNS_NORTHERN_PIKE_BIOME_TAG)
                .add(Biomes.FROZEN_RIVER, Biomes.GROVE)
                .addTag(ModRegistry.IS_SNOWY_PLAINS_BIOME_TAG)
                .addTag(BiomeTags.IS_TAIGA);

        // PERCH - Freshwater fish in lakes and rivers
        this.add(ModRegistry.SPAWNS_PERCH_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.MEADOW)
                .addTag(ModRegistry.IS_PLAINS_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // PICKEREL - Freshwater fish related to pike
        this.add(ModRegistry.SPAWNS_PICKEREL_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.MEADOW)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG)
                .addTag(BiomeTags.IS_FOREST);

        // PIRANHA - Tropical freshwater predator
        this.add(ModRegistry.SPAWNS_PIRANHA_BIOME_TAG)
                .addTag(BiomeTags.IS_JUNGLE)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG);

        // PUPFISH - Small freshwater fish found in isolated waters
        this.add(ModRegistry.SPAWNS_PUPFISH_BIOME_TAG)
                .add(Biomes.RIVER, Biomes.DESERT, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU);

        // SARDINE - Saltwater fish that form large schools
        this.add(ModRegistry.SPAWNS_SARDINE_BIOME_TAG)
                .add(Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN);

        // SIAMESE FIGHTING FISH - Tropical freshwater fish
        this.add(ModRegistry.SPAWNS_SIAMESE_FIGHTING_FISH_BIOME_TAG)
                .addTag(ModRegistry.IS_SWAMP_BIOME_TAG)
                .addTag(BiomeTags.IS_JUNGLE);

        // SILVER STRIPE BLAASOP - Cold water pufferfish
        this.add(ModRegistry.SPAWNS_SILVER_STRIPE_BLAASOP_BIOME_TAG)
                .add(Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);

        // WHITEMARGIN STARGAZER - Tropical marine fish that buries in sand
        this.add(ModRegistry.SPAWNS_WHITEMARGIN_STARGAZER_BIOME_TAG)
                .add(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN);

        // STINGRAY - Found in tropical to temperate coastal waters
        this.add(ModRegistry.SPAWNS_STINGRAY_BIOME_TAG)
                .add(Biomes.OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.WARM_OCEAN);

        // TROUT - Freshwater fish, cold-water streams and lakes
        this.add(ModRegistry.SPAWNS_TROUT_BIOME_TAG).add(Biomes.GROVE).addTag(BiomeTags.IS_TAIGA, BiomeTags.IS_RIVER);

        // TUNA - Large open-ocean predators
        this.add(ModRegistry.SPAWNS_TUNA_BIOME_TAG)
                .add(Biomes.OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.WARM_OCEAN);

        // WALLEYE - Freshwater fish, northern lakes and rivers
        this.add(ModRegistry.SPAWNS_WALLEYE_BIOME_TAG).add(Biomes.RIVER, Biomes.MEADOW).addTag(BiomeTags.IS_TAIGA);
    }
}
