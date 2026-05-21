package fuzs.sealife.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.sealife.init.ModEntityTypes;
import fuzs.sealife.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeTagProvider extends AbstractTagProvider<EntityType<?>> {

    public ModEntityTypeTagProvider(DataProviderContext context) {
        super(Registries.ENTITY_TYPE, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS).addTag(ModRegistry.FISHES_ENTITY_TYPE_TAG);
        this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).addTag(ModRegistry.FISHES_ENTITY_TYPE_TAG);
        this.tag(EntityTypeTags.AQUATIC).addTag(ModRegistry.FISHES_ENTITY_TYPE_TAG);
        this.tag(EntityTypeTags.NOT_SCARY_FOR_PUFFERFISH).addTag(ModRegistry.FISHES_ENTITY_TYPE_TAG);
        this.tag(ModRegistry.FISHES_ENTITY_TYPE_TAG)
                .addTag(ModRegistry.COMMON_FISHES_ENTITY_TYPE_TAG,
                        ModRegistry.UNCOMMON_FISHES_ENTITY_TYPE_TAG,
                        ModRegistry.RARE_FISHES_ENTITY_TYPE_TAG);
        this.tag(ModRegistry.COMMON_FISHES_ENTITY_TYPE_TAG)
                .add(EntityType.COD,
                        EntityType.SALMON,
                        ModEntityTypes.ANCHOVY.value(),
                        ModEntityTypes.BASS.value(),
                        ModEntityTypes.CARP.value(),
                        ModEntityTypes.CHUB.value(),
                        ModEntityTypes.GOLDFISH.value(),
                        ModEntityTypes.NEON_TETRA.value(),
                        ModEntityTypes.PERCH.value(),
                        ModEntityTypes.SARDINE.value(),
                        ModEntityTypes.TROUT.value(),
                        ModEntityTypes.WALLEYE.value())
                .addOptional("aquaculture:atlantic_herring",
                        "aquaculture:synodontis",
                        "aquaculture:bluegill",
                        "aquaculture:brown_shrooma",
                        "aquaculture:red_shrooma",
                        "aquaculture:perch");
        this.tag(ModRegistry.UNCOMMON_FISHES_ENTITY_TYPE_TAG)
                .add(EntityType.PUFFERFISH,
                        EntityType.TROPICAL_FISH,
                        ModEntityTypes.ANGELFISH.value(),
                        ModEntityTypes.BLUE_TANG.value(),
                        ModEntityTypes.BOWFIN.value(),
                        ModEntityTypes.BUTTERFLYFISH.value(),
                        ModEntityTypes.CATFISH.value(),
                        ModEntityTypes.DAMSELFISH.value(),
                        ModEntityTypes.KOI.value(),
                        ModEntityTypes.LAMPREY.value(),
                        ModEntityTypes.NORTHERN_PIKE.value(),
                        ModEntityTypes.PICKEREL.value(),
                        ModEntityTypes.PUPFISH.value(),
                        ModEntityTypes.SIAMESE_FIGHTING_FISH.value(),
                        ModEntityTypes.WHITEMARGIN_STARGAZER.value(),
                        ModEntityTypes.TUNA.value())
                .addOptional("aquaculture:blackfish",
                        "aquaculture:pollock",
                        "aquaculture:boulti",
                        "aquaculture:smallmouth_bass",
                        "aquaculture:brown_trout",
                        "aquaculture:carp",
                        "aquaculture:catfish",
                        "aquaculture:minnow",
                        "aquaculture:jellyfish");
        this.tag(ModRegistry.RARE_FISHES_ENTITY_TYPE_TAG)
                .add(ModEntityTypes.ANGLERFISH.value(),
                        ModEntityTypes.ELECTRIC_RAY.value(),
                        ModEntityTypes.LUNGFISH.value(),
                        ModEntityTypes.MANTA_RAY.value(),
                        ModEntityTypes.PIRANHA.value(),
                        ModEntityTypes.SILVER_STRIPE_BLAASOP.value(),
                        ModEntityTypes.STINGRAY.value())
                .addOptional("aquaculture:atlantic_cod",
                        "aquaculture:pacific_halibut",
                        "aquaculture:atlantic_halibut",
                        "aquaculture:pink_salmon",
                        "aquaculture:rainbow_trout",
                        "aquaculture:bayad",
                        "aquaculture:capitaine",
                        "aquaculture:gar",
                        "aquaculture:muskellunge",
                        "aquaculture:arapaima",
                        "aquaculture:piranha",
                        "aquaculture:tambaqui",
                        "aquaculture:red_grouper",
                        "aquaculture:tuna");
    }
}
