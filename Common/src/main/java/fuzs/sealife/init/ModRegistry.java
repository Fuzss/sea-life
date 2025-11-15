package fuzs.sealife.init;

import fuzs.puzzleslib.api.init.v3.registry.ContentRegistrationHelper;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import fuzs.sealife.SeaLife;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.context.ContextKeySet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class ModRegistry {
    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder().add(Registries.PAINTING_VARIANT,
            ModPaintingVariants::bootstrap);
    static final RegistryManager REGISTRIES = RegistryManager.from(SeaLife.MOD_ID);
    public static final Holder.Reference<SimpleParticleType> BUBBLE_PARTICLE_TYPE = REGISTRIES.registerParticleType(
            "bubble");
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(
            ModItems.PUPFISH);

    static final TagFactory TAGS = TagFactory.make(SeaLife.MOD_ID);
    public static final TagKey<Item> RAW_FISH_FOODS_ITEM_TAG = TagFactory.COMMON.registerItemTag("foods/raw_fish");
    public static final TagKey<Item> RAW_MEAT_FOODS_ITEM_TAG = TagFactory.COMMON.registerItemTag("foods/raw_meat");
    public static final TagKey<Biome> IS_COLD_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_cold");
    public static final TagKey<Biome> IS_HOT_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_hot");
    public static final TagKey<Biome> IS_SNOWY_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_snowy");
    public static final TagKey<Biome> IS_WET_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_wet");
    public static final TagKey<Biome> IS_PLAINS_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_plains");
    public static final TagKey<Biome> IS_SNOWY_PLAINS_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_snowy_plains");
    public static final TagKey<Biome> IS_SWAMP_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_swamp");
    public static final TagKey<Item> FISHES_ITEM_TAG = TAGS.registerItemTag("fishes");
    public static final TagKey<Item> FISHING_BAIT_ITEM_TAG = TAGS.registerItemTag("fishing_bait");
    public static final TagKey<EntityType<?>> FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("fishes");
    public static final TagKey<EntityType<?>> COMMON_FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("common_fishes");
    public static final TagKey<EntityType<?>> UNCOMMON_FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag(
            "uncommon_fishes");
    public static final TagKey<EntityType<?>> RARE_FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("rare_fishes");
    public static final TagKey<Biome> SPAWNS_ANCHOVY_BIOME_TAG = TAGS.registerBiomeTag("spawns_anchovy");
    public static final TagKey<Biome> SPAWNS_ANGELFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_angelfish");
    public static final TagKey<Biome> SPAWNS_ANGLERFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_anglerfish");
    public static final TagKey<Biome> SPAWNS_BASS_BIOME_TAG = TAGS.registerBiomeTag("spawns_bass");
    public static final TagKey<Biome> SPAWNS_BLUE_TANG_BIOME_TAG = TAGS.registerBiomeTag("spawns_blue_tang");
    public static final TagKey<Biome> SPAWNS_BOWFIN_BIOME_TAG = TAGS.registerBiomeTag("spawns_bowfin");
    public static final TagKey<Biome> SPAWNS_BUTTERFLYFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_butterflyfish");
    public static final TagKey<Biome> SPAWNS_CARP_BIOME_TAG = TAGS.registerBiomeTag("spawns_carp");
    public static final TagKey<Biome> SPAWNS_CATFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_catfish");
    public static final TagKey<Biome> SPAWNS_CHUB_BIOME_TAG = TAGS.registerBiomeTag("spawns_chub");
    public static final TagKey<Biome> SPAWNS_DAMSELFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_damselfish");
    public static final TagKey<Biome> SPAWNS_ELECTRIC_RAY_BIOME_TAG = TAGS.registerBiomeTag("spawns_electric_ray");
    public static final TagKey<Biome> SPAWNS_GOLDFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_goldfish");
    public static final TagKey<Biome> SPAWNS_KOI_BIOME_TAG = TAGS.registerBiomeTag("spawns_koi");
    public static final TagKey<Biome> SPAWNS_LAMPREY_BIOME_TAG = TAGS.registerBiomeTag("spawns_lamprey");
    public static final TagKey<Biome> SPAWNS_LUNGFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_lungfish");
    public static final TagKey<Biome> SPAWNS_MANTA_RAY_BIOME_TAG = TAGS.registerBiomeTag("spawns_manta_ray");
    public static final TagKey<Biome> SPAWNS_MINNOW_BIOME_TAG = TAGS.registerBiomeTag("spawns_minnow");
    public static final TagKey<Biome> SPAWNS_NEON_TETRA_BIOME_TAG = TAGS.registerBiomeTag("spawns_neon_tetra");
    public static final TagKey<Biome> SPAWNS_NORTHERN_PIKE_BIOME_TAG = TAGS.registerBiomeTag("spawns_northern_pike");
    public static final TagKey<Biome> SPAWNS_PERCH_BIOME_TAG = TAGS.registerBiomeTag("spawns_perch");
    public static final TagKey<Biome> SPAWNS_PICKEREL_BIOME_TAG = TAGS.registerBiomeTag("spawns_pickerel");
    public static final TagKey<Biome> SPAWNS_PIRANHA_BIOME_TAG = TAGS.registerBiomeTag("spawns_piranha");
    public static final TagKey<Biome> SPAWNS_PUPFISH_BIOME_TAG = TAGS.registerBiomeTag("spawns_pupfish");
    public static final TagKey<Biome> SPAWNS_SARDINE_BIOME_TAG = TAGS.registerBiomeTag("spawns_sardine");
    public static final TagKey<Biome> SPAWNS_SIAMESE_FIGHTING_FISH_BIOME_TAG = TAGS.registerBiomeTag(
            "spawns_siamese_fighting_fish");
    public static final TagKey<Biome> SPAWNS_WHITEMARGIN_STARGAZER_BIOME_TAG = TAGS.registerBiomeTag(
            "spawns_whitemargin_stargazer");
    public static final TagKey<Biome> SPAWNS_STINGRAY_BIOME_TAG = TAGS.registerBiomeTag("spawns_stingray");
    public static final TagKey<Biome> SPAWNS_SILVER_STRIPE_BLAASOP_BIOME_TAG = TAGS.registerBiomeTag(
            "spawns_silver_stripe_blaasop");
    public static final TagKey<Biome> SPAWNS_TROUT_BIOME_TAG = TAGS.registerBiomeTag("spawns_trout");
    public static final TagKey<Biome> SPAWNS_TUNA_BIOME_TAG = TAGS.registerBiomeTag("spawns_tuna");
    public static final TagKey<Biome> SPAWNS_WALLEYE_BIOME_TAG = TAGS.registerBiomeTag("spawns_walleye");

    public static final ContextKeySet TREASURE_ITEM_LOOT_CONTEXT_PARAM_SET = ContentRegistrationHelper.registerContextKeySet(
            SeaLife.id("treasure_item"),
            (ContextKeySet.Builder builder) -> builder.required(LootContextParams.ORIGIN)
                    .required(LootContextParams.TOOL)
                    .optional(LootContextParams.THIS_ENTITY));

    public static void bootstrap() {
        ModBlocks.bootstrap();
        ModEntityTypes.bootstrap();
        ModItems.bootstrap();
        ModLootTables.bootstrap();
    }
}
