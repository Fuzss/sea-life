package fuzs.sealife;

import fuzs.puzzleslib.api.biome.v1.BiomeLoadingContext;
import fuzs.puzzleslib.api.biome.v1.BiomeLoadingPhase;
import fuzs.puzzleslib.api.biome.v1.BiomeModificationContext;
import fuzs.puzzleslib.api.config.v3.ConfigHolder;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.context.BiomeModificationsContext;
import fuzs.puzzleslib.api.core.v1.context.EntityAttributesContext;
import fuzs.puzzleslib.api.core.v1.context.SpawnPlacementsContext;
import fuzs.puzzleslib.api.event.v1.LoadCompleteCallback;
import fuzs.puzzleslib.api.event.v1.server.LootTableLoadCallback;
import fuzs.sealife.config.CommonConfig;
import fuzs.sealife.config.ServerConfig;
import fuzs.sealife.init.ModEntityTypes;
import fuzs.sealife.init.ModLootTables;
import fuzs.sealife.init.ModRegistry;
import fuzs.sealife.world.level.block.HatcheryBlock;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class SeaLife implements ModConstructor {
    public static final String MOD_ID = "sealife";
    public static final String MOD_NAME = "Sea Life";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ConfigHolder CONFIG = ConfigHolder.builder(MOD_ID)
            .common(CommonConfig.class)
            .server(ServerConfig.class);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        LoadCompleteCallback.EVENT.register(HatcheryBlock::onLoadComplete);
        LootTableLoadCallback.EVENT.register(ModLootTables::onLootTableLoad);
    }

    @Override
    public void onRegisterEntityAttributes(EntityAttributesContext context) {
        ModEntityTypes.onRegisterEntityAttributes(context);
    }

    @Override
    public void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        ModEntityTypes.onRegisterSpawnPlacements(context);
    }

    @Override
    public void onRegisterBiomeModifications(BiomeModificationsContext context) {
        addFishSpawn(context,
                ModEntityTypes.ANCHOVY,
                ModRegistry.SPAWNS_ANCHOVY_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).anchovy);
        addFishSpawn(context,
                ModEntityTypes.ANGELFISH,
                ModRegistry.SPAWNS_ANGELFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).angelfish);
        addFishSpawn(context,
                ModEntityTypes.ANGLERFISH,
                ModRegistry.SPAWNS_ANGLERFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).anglerfish);
        addFishSpawn(context,
                ModEntityTypes.BASS,
                ModRegistry.SPAWNS_BASS_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).bass);
        addFishSpawn(context,
                ModEntityTypes.BLUE_TANG,
                ModRegistry.SPAWNS_BLUE_TANG_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).blueTang);
        addFishSpawn(context,
                ModEntityTypes.BOWFIN,
                ModRegistry.SPAWNS_BOWFIN_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).bowfin);
        addFishSpawn(context,
                ModEntityTypes.BUTTERFLYFISH,
                ModRegistry.SPAWNS_BUTTERFLYFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).butterflyfish);
        addFishSpawn(context,
                ModEntityTypes.CARP,
                ModRegistry.SPAWNS_CARP_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).carp);
        addFishSpawn(context,
                ModEntityTypes.CATFISH,
                ModRegistry.SPAWNS_CATFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).catfish);
        addFishSpawn(context,
                ModEntityTypes.CHUB,
                ModRegistry.SPAWNS_CHUB_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).chub);
        addFishSpawn(context,
                ModEntityTypes.DAMSELFISH,
                ModRegistry.SPAWNS_DAMSELFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).damselfish);
        addFishSpawn(context,
                ModEntityTypes.ELECTRIC_RAY,
                ModRegistry.SPAWNS_ELECTRIC_RAY_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).electricRay);
        addFishSpawn(context,
                ModEntityTypes.GOLDFISH,
                ModRegistry.SPAWNS_GOLDFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).goldfish);
        addFishSpawn(context,
                ModEntityTypes.KOI,
                ModRegistry.SPAWNS_KOI_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).koi);
        addFishSpawn(context,
                ModEntityTypes.LAMPREY,
                ModRegistry.SPAWNS_LAMPREY_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).lamprey);
        addFishSpawn(context,
                ModEntityTypes.LUNGFISH,
                ModRegistry.SPAWNS_LUNGFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).lungfish);
        addFishSpawn(context,
                ModEntityTypes.MANTA_RAY,
                ModRegistry.SPAWNS_MANTA_RAY_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).mantaRay);
        addFishSpawn(context,
                ModEntityTypes.MINNOW,
                ModRegistry.SPAWNS_MINNOW_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).minnow);
        addFishSpawn(context,
                ModEntityTypes.NEON_TETRA,
                ModRegistry.SPAWNS_NEON_TETRA_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).neonTetra);
        addFishSpawn(context,
                ModEntityTypes.NORTHERN_PIKE,
                ModRegistry.SPAWNS_NORTHERN_PIKE_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).northernPike);
        addFishSpawn(context,
                ModEntityTypes.PERCH,
                ModRegistry.SPAWNS_PERCH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).perch);
        addFishSpawn(context,
                ModEntityTypes.PICKEREL,
                ModRegistry.SPAWNS_PICKEREL_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).pickerel);
        addFishSpawn(context,
                ModEntityTypes.PIRANHA,
                ModRegistry.SPAWNS_PIRANHA_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).piranha);
        addFishSpawn(context,
                ModEntityTypes.PUPFISH,
                ModRegistry.SPAWNS_PUPFISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).pupfish);
        addFishSpawn(context,
                ModEntityTypes.SARDINE,
                ModRegistry.SPAWNS_SARDINE_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).sardine);
        addFishSpawn(context,
                ModEntityTypes.SIAMESE_FIGHTING_FISH,
                ModRegistry.SPAWNS_SIAMESE_FIGHTING_FISH_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).siameseFightingFish);
        addFishSpawn(context,
                ModEntityTypes.WHITEMARGIN_STARGAZER,
                ModRegistry.SPAWNS_WHITEMARGIN_STARGAZER_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).whitemarginStargazer);
        addFishSpawn(context,
                ModEntityTypes.STINGRAY,
                ModRegistry.SPAWNS_STINGRAY_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).stingray);
        addFishSpawn(context,
                ModEntityTypes.SILVER_STRIPE_BLAASOP,
                ModRegistry.SPAWNS_SILVER_STRIPE_BLAASOP_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).silverStripeBlaasop);
        addFishSpawn(context,
                ModEntityTypes.TROUT,
                ModRegistry.SPAWNS_TROUT_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).trout);
        addFishSpawn(context,
                ModEntityTypes.TUNA,
                ModRegistry.SPAWNS_TUNA_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).tuna);
        addFishSpawn(context,
                ModEntityTypes.WALLEYE,
                ModRegistry.SPAWNS_WALLEYE_BIOME_TAG,
                () -> CONFIG.get(CommonConfig.class).walleye);
    }

    static void addFishSpawn(BiomeModificationsContext context, Holder.Reference<? extends EntityType<?>> holder, TagKey<Biome> tagKey, Supplier<CommonConfig.FishSpawnConfig> configSupplier) {
        context.registerBiomeModification(BiomeLoadingPhase.ADDITIONS, (BiomeLoadingContext biomeLoadingContext) -> {
            return biomeLoadingContext.is(tagKey);
        }, (BiomeModificationContext biomeModificationContext) -> {
            CommonConfig.FishSpawnConfig config = configSupplier.get();
            biomeModificationContext.mobSpawnSettings()
                    .addSpawn(holder.value().getCategory(),
                            config.weight,
                            new MobSpawnSettings.SpawnerData(holder.value(), config.minCount, config.maxCount));
        });
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
