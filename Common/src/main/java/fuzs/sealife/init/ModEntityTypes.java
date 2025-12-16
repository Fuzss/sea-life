package fuzs.sealife.init;

import fuzs.puzzleslib.api.core.v1.context.EntityAttributesContext;
import fuzs.puzzleslib.api.core.v1.context.SpawnPlacementsContext;
import fuzs.sealife.world.entity.animal.*;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.fish.AbstractFish;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModEntityTypes {
    public static final Holder.Reference<EntityType<ShoalingFish>> ANCHOVY = ModRegistry.REGISTRIES.registerEntityType(
            "anchovy",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.ANCHOVY_BUCKET, 24),
                    MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> ANGELFISH = ModRegistry.REGISTRIES.registerEntityType(
            "angelfish",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.ANGELFISH_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> ANGLERFISH = ModRegistry.REGISTRIES.registerEntityType(
            "anglerfish",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.ANGLERFISH_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.7F, 0.6F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> BASS = ModRegistry.REGISTRIES.registerEntityType(
            "bass",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.BASS_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> BLUE_TANG = ModRegistry.REGISTRIES.registerEntityType(
            "blue_tang",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.BLUE_TANG_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.3F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> BOWFIN = ModRegistry.REGISTRIES.registerEntityType(
            "bowfin",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.BOWFIN_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.9F, 0.3F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> BUTTERFLYFISH = ModRegistry.REGISTRIES.registerEntityType(
            "butterflyfish",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.BUTTERFLYFISH_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> CARP = ModRegistry.REGISTRIES.registerEntityType(
            "carp",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.CARP_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> CATFISH = ModRegistry.REGISTRIES.registerEntityType(
            "catfish",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.CATFISH_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.9F, 0.3F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> CHUB = ModRegistry.REGISTRIES.registerEntityType(
            "chub",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.CHUB_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> DAMSELFISH = ModRegistry.REGISTRIES.registerEntityType(
            "damselfish",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.DAMSELFISH_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ElectricRay>> ELECTRIC_RAY = ModRegistry.REGISTRIES.registerEntityType(
            "electric_ray",
            () -> EntityType.Builder.of(ElectricRay::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> GOLDFISH = ModRegistry.REGISTRIES.registerEntityType(
            "goldfish",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.GOLDFISH_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.3F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> KOI = ModRegistry.REGISTRIES.registerEntityType("koi",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.KOI_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> LAMPREY = ModRegistry.REGISTRIES.registerEntityType(
            "lamprey",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.LAMPREY_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(1.0F, 0.2F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> LUNGFISH = ModRegistry.REGISTRIES.registerEntityType(
            "lungfish",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.LUNGFISH_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<MantaRay>> MANTA_RAY = ModRegistry.REGISTRIES.registerEntityType(
            "manta_ray",
            () -> EntityType.Builder.of(MantaRay::new, MobCategory.WATER_CREATURE)
                    .sized(3.5F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> MINNOW = ModRegistry.REGISTRIES.registerEntityType(
            "minnow",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.MINNOW_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.3F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> NEON_TETRA = ModRegistry.REGISTRIES.registerEntityType(
            "neon_tetra",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.NEON_TETRA_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> NORTHERN_PIKE = ModRegistry.REGISTRIES.registerEntityType(
            "northern_pike",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.NORTHERN_PIKE_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.7F, 0.4F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> PERCH = ModRegistry.REGISTRIES.registerEntityType(
            "perch",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.PERCH_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> PICKEREL = ModRegistry.REGISTRIES.registerEntityType(
            "pickerel",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.PICKEREL_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<Piranha>> PIRANHA = ModRegistry.REGISTRIES.registerEntityType(
            "piranha",
            () -> EntityType.Builder.of(Piranha::new, MobCategory.MONSTER).sized(0.7F, 0.4F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> PUPFISH = ModRegistry.REGISTRIES.registerEntityType(
            "pupfish",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.PUPFISH_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.3F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> SARDINE = ModRegistry.REGISTRIES.registerEntityType(
            "sardine",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.SARDINE_BUCKET, 16),
                    MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> SIAMESE_FIGHTING_FISH = ModRegistry.REGISTRIES.registerEntityType(
            "siamese_fighting_fish",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.SIAMESE_FIGHTING_FISH_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.5F, 0.3F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> WHITEMARGIN_STARGAZER = ModRegistry.REGISTRIES.registerEntityType(
            "whitemargin_stargazer",
            () -> EntityType.Builder.of(FloordwellingFish.create(() -> ModItems.WHITEMARGIN_STARGAZER_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.7F, 0.5F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<StingRay>> STINGRAY = ModRegistry.REGISTRIES.registerEntityType(
            "stingray",
            () -> EntityType.Builder.of(StingRay::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<SolitaryFish>> SILVER_STRIPE_BLAASOP = ModRegistry.REGISTRIES.registerEntityType(
            "silver_stripe_blaasop",
            () -> EntityType.Builder.of(SolitaryFish.create(() -> ModItems.SILVER_STRIPE_BLAASOP_BUCKET),
                    MobCategory.WATER_AMBIENT).sized(0.7F, 0.4F).clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> TROUT = ModRegistry.REGISTRIES.registerEntityType(
            "trout",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.TROUT_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> TUNA = ModRegistry.REGISTRIES.registerEntityType(
            "tuna",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.TUNA_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(4));
    public static final Holder.Reference<EntityType<ShoalingFish>> WALLEYE = ModRegistry.REGISTRIES.registerEntityType(
            "walleye",
            () -> EntityType.Builder.of(ShoalingFish.create(() -> ModItems.WALLEYE_BUCKET), MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F)
                    .clientTrackingRange(4));

    public static void bootstrap() {
        // NO-OP
    }

    public static void onRegisterEntityAttributes(EntityAttributesContext context) {
        context.registerAttributes(ANCHOVY.value(), createMediumFishAttributes());
        context.registerAttributes(ANGELFISH.value(), createMediumFishAttributes());
        context.registerAttributes(ANGLERFISH.value(), createLargeFishAttributes());
        context.registerAttributes(BASS.value(), createSmallFishAttributes());
        context.registerAttributes(BLUE_TANG.value(), createMediumFishAttributes());
        context.registerAttributes(BOWFIN.value(), createLargeFishAttributes());
        context.registerAttributes(BUTTERFLYFISH.value(), createMediumFishAttributes());
        context.registerAttributes(CARP.value(), createSmallFishAttributes());
        context.registerAttributes(CATFISH.value(), createLargeFishAttributes());
        context.registerAttributes(CHUB.value(), createMediumFishAttributes());
        context.registerAttributes(DAMSELFISH.value(), createMediumFishAttributes());
        context.registerAttributes(ELECTRIC_RAY.value(), createRayAttributes());
        context.registerAttributes(GOLDFISH.value(), createMediumFishAttributes());
        context.registerAttributes(KOI.value(), createSmallFishAttributes());
        context.registerAttributes(LAMPREY.value(), createMediumFishAttributes());
        context.registerAttributes(LUNGFISH.value(), createLargeFishAttributes());
        context.registerAttributes(MANTA_RAY.value(), createMantaRayAttributes());
        context.registerAttributes(MINNOW.value(), createMediumFishAttributes());
        context.registerAttributes(NEON_TETRA.value(), createMediumFishAttributes());
        context.registerAttributes(NORTHERN_PIKE.value(), createMediumFishAttributes());
        context.registerAttributes(PERCH.value(), createSmallFishAttributes());
        context.registerAttributes(PICKEREL.value(), createMediumFishAttributes());
        context.registerAttributes(PIRANHA.value(), createPiranhaAttributes());
        context.registerAttributes(PUPFISH.value(), createMediumFishAttributes());
        context.registerAttributes(SARDINE.value(), createMediumFishAttributes());
        context.registerAttributes(SIAMESE_FIGHTING_FISH.value(), createMediumFishAttributes());
        context.registerAttributes(WHITEMARGIN_STARGAZER.value(), createSmallFishAttributes());
        context.registerAttributes(STINGRAY.value(), createRayAttributes());
        context.registerAttributes(SILVER_STRIPE_BLAASOP.value(), createMediumFishAttributes());
        context.registerAttributes(TROUT.value(), createMediumFishAttributes());
        context.registerAttributes(TUNA.value(), createLargeFishAttributes());
        context.registerAttributes(WALLEYE.value(), createMediumFishAttributes());
    }

    public static AttributeSupplier.Builder createSmallFishAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0);
    }

    private static AttributeSupplier.Builder createMediumFishAttributes() {
        return AbstractFish.createAttributes();
    }

    public static AttributeSupplier.Builder createLargeFishAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0);
    }

    public static AttributeSupplier.Builder createRayAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0).add(Attributes.MOVEMENT_SPEED, 0.5);
    }

    public static AttributeSupplier.Builder createMantaRayAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0).add(Attributes.MOVEMENT_SPEED, 0.4);
    }

    public static AttributeSupplier.Builder createPiranhaAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0)
                .add(Attributes.MOVEMENT_SPEED, 1.2)
                .add(Attributes.ATTACK_DAMAGE, 4.0);
    }

    public static void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        context.registerSpawnPlacement(ANCHOVY.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(ANGELFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(ANGLERFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(BASS.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(BLUE_TANG.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(BOWFIN.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(BUTTERFLYFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(CARP.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(CATFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(CHUB.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(DAMSELFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(ELECTRIC_RAY.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(GOLDFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(KOI.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(LAMPREY.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(LUNGFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(MANTA_RAY.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(MINNOW.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(NEON_TETRA.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(NORTHERN_PIKE.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(PERCH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(PICKEREL.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(PIRANHA.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(PUPFISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(SARDINE.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(SIAMESE_FIGHTING_FISH.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(WHITEMARGIN_STARGAZER.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(STINGRAY.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(SILVER_STRIPE_BLAASOP.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(TROUT.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(TUNA.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
        context.registerSpawnPlacement(WALLEYE.value(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractFish::checkSurfaceWaterAnimalSpawnRules);
    }
}
