package fuzs.sealife.common.data.tags;

import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import fuzs.sealife.common.init.ModEntityTypes;
import fuzs.sealife.common.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypeIds;

public class ModEntityTypeTagsProvider extends AbstractTagProvider<EntityType<?>> {

    public ModEntityTypeTagsProvider(DataProviderContext context) {
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
                .add(EntityTypeIds.COD, EntityTypeIds.SALMON)
                .add(ModEntityTypes.ANCHOVY,
                        ModEntityTypes.BASS,
                        ModEntityTypes.CARP,
                        ModEntityTypes.CHUB,
                        ModEntityTypes.GOLDFISH,
                        ModEntityTypes.NEON_TETRA,
                        ModEntityTypes.PERCH,
                        ModEntityTypes.SARDINE,
                        ModEntityTypes.TROUT,
                        ModEntityTypes.WALLEYE)
                .addOptional("aquaculture:atlantic_herring",
                        "aquaculture:synodontis",
                        "aquaculture:bluegill",
                        "aquaculture:brown_shrooma",
                        "aquaculture:red_shrooma",
                        "aquaculture:perch");
        this.tag(ModRegistry.UNCOMMON_FISHES_ENTITY_TYPE_TAG)
                .add(EntityTypeIds.PUFFERFISH, EntityTypeIds.TROPICAL_FISH)
                .add(ModEntityTypes.ANGELFISH,
                        ModEntityTypes.BLUE_TANG,
                        ModEntityTypes.BOWFIN,
                        ModEntityTypes.BUTTERFLYFISH,
                        ModEntityTypes.CATFISH,
                        ModEntityTypes.DAMSELFISH,
                        ModEntityTypes.KOI,
                        ModEntityTypes.LAMPREY,
                        ModEntityTypes.NORTHERN_PIKE,
                        ModEntityTypes.PICKEREL,
                        ModEntityTypes.PUPFISH,
                        ModEntityTypes.SIAMESE_FIGHTING_FISH,
                        ModEntityTypes.WHITEMARGIN_STARGAZER,
                        ModEntityTypes.TUNA)
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
                .add(ModEntityTypes.ANGLERFISH,
                        ModEntityTypes.ELECTRIC_RAY,
                        ModEntityTypes.LUNGFISH,
                        ModEntityTypes.MANTA_RAY,
                        ModEntityTypes.PIRANHA,
                        ModEntityTypes.SILVER_STRIPE_BLAASOP,
                        ModEntityTypes.STINGRAY)
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
