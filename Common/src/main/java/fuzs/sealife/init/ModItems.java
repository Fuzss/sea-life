package fuzs.sealife.init;

import fuzs.sealife.world.item.TreasureItem;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.material.Fluids;

public class ModItems {
    public static final FoodProperties SMALL_FISH_FOOD = new FoodProperties.Builder().nutrition(1)
            .saturationModifier(0.1F)
            .build();
    public static final FoodProperties MEDIUM_FISH_FOOD = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.1F)
            .build();
    public static final FoodProperties LARGE_FISH_FOOD = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.1F)
            .build();
    public static final FoodProperties FISH_FINGERS_FOOD = new FoodProperties.Builder().nutrition(5)
            .saturationModifier(0.3F)
            .build();
    public static final FoodProperties SASHIMI_FOOD = new FoodProperties.Builder().nutrition(4)
            .saturationModifier(0.4F)
            .build();
    public static final FoodProperties FISH_STEW_FOOD = new FoodProperties.Builder().nutrition(7)
            .saturationModifier(0.6F)
            .build();
    public static final Consumable FISH_FINGERS_CONSUMABLE = Consumables.defaultFood().consumeSeconds(0.8F).build();
    // Blocks
    public static final Holder.Reference<Item> FISH_TRAP = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.FISH_TRAP);
    public static final Holder.Reference<Item> HATCHERY = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.HATCHERY);
    // Loot
    public static final Holder.Reference<Item> FISH_BONES = ModRegistry.REGISTRIES.registerItem("fish_bones");
    public static final Holder.Reference<Item> FISH_FOSSIL = ModRegistry.REGISTRIES.registerItem("fish_fossil");
    public static final Holder.Reference<Item> OLD_BOOT = ModRegistry.REGISTRIES.registerItem("old_boot");
    public static final Holder.Reference<Item> EMPTY_CAN = ModRegistry.REGISTRIES.registerItem("empty_can");
    public static final Holder.Reference<Item> PIRATE_TREASURE = ModRegistry.REGISTRIES.registerItem("pirate_treasure",
            (Item.Properties properties) -> new TreasureItem(properties, ModLootTables.TREASURE_ITEM),
            () -> new Item.Properties().stacksTo(16).useCooldown(0.2F));
    // Meals
    public static final Holder.Reference<Item> FISH_FINGERS = ModRegistry.REGISTRIES.registerItem("fish_fingers",
            () -> new Item.Properties().food(FISH_FINGERS_FOOD, FISH_FINGERS_CONSUMABLE));
    public static final Holder.Reference<Item> SASHIMI = ModRegistry.REGISTRIES.registerItem("sashimi",
            () -> new Item.Properties().food(SASHIMI_FOOD));
    public static final Holder.Reference<Item> FISH_STEW = ModRegistry.REGISTRIES.registerItem("fish_stew",
            () -> new Item.Properties().food(FISH_STEW_FOOD));
    // Fish
    public static final Holder.Reference<Item> ANCHOVY = ModRegistry.REGISTRIES.registerItem("anchovy",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> ANGELFISH = ModRegistry.REGISTRIES.registerItem("angelfish",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> ANGLERFISH = ModRegistry.REGISTRIES.registerItem("anglerfish",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> BASS = ModRegistry.REGISTRIES.registerItem("bass",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> BLUE_TANG = ModRegistry.REGISTRIES.registerItem("blue_tang",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> BOWFIN = ModRegistry.REGISTRIES.registerItem("bowfin",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> BUTTERFLYFISH = ModRegistry.REGISTRIES.registerItem("butterflyfish",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> CARP = ModRegistry.REGISTRIES.registerItem("carp",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> CATFISH = ModRegistry.REGISTRIES.registerItem("catfish",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> CHUB = ModRegistry.REGISTRIES.registerItem("chub",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> DAMSELFISH = ModRegistry.REGISTRIES.registerItem("damselfish",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> ELECTRIC_RAY = ModRegistry.REGISTRIES.registerItem("electric_ray",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> GOLDFISH = ModRegistry.REGISTRIES.registerItem("goldfish",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> KOI = ModRegistry.REGISTRIES.registerItem("koi",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> LAMPREY = ModRegistry.REGISTRIES.registerItem("lamprey",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> LUNGFISH = ModRegistry.REGISTRIES.registerItem("lungfish",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> MANTA_RAY = ModRegistry.REGISTRIES.registerItem("manta_ray",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> MINNOW = ModRegistry.REGISTRIES.registerItem("minnow",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> NEON_TETRA = ModRegistry.REGISTRIES.registerItem("neon_tetra",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> NORTHERN_PIKE = ModRegistry.REGISTRIES.registerItem("northern_pike",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> PERCH = ModRegistry.REGISTRIES.registerItem("perch",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> PICKEREL = ModRegistry.REGISTRIES.registerItem("pickerel",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> PIRANHA = ModRegistry.REGISTRIES.registerItem("piranha",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> PUPFISH = ModRegistry.REGISTRIES.registerItem("pupfish",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> SARDINE = ModRegistry.REGISTRIES.registerItem("sardine",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> SIAMESE_FIGHTING_FISH = ModRegistry.REGISTRIES.registerItem(
            "siamese_fighting_fish",
            () -> new Item.Properties().food(SMALL_FISH_FOOD));
    public static final Holder.Reference<Item> STINGRAY = ModRegistry.REGISTRIES.registerItem("stingray",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> SILVER_STRIPE_BLAASOP = ModRegistry.REGISTRIES.registerItem(
            "silver_stripe_blaasop",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> TROUT = ModRegistry.REGISTRIES.registerItem("trout",
            () -> new Item.Properties().food(MEDIUM_FISH_FOOD));
    public static final Holder.Reference<Item> TUNA = ModRegistry.REGISTRIES.registerItem("tuna",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> WALLEYE = ModRegistry.REGISTRIES.registerItem("walleye",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    public static final Holder.Reference<Item> WHITEMARGIN_STARGAZER = ModRegistry.REGISTRIES.registerItem(
            "whitemargin_stargazer",
            () -> new Item.Properties().food(LARGE_FISH_FOOD));
    // Buckets
    public static final Holder.Reference<Item> ANCHOVY_BUCKET = ModRegistry.REGISTRIES.registerItem("anchovy_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.ANCHOVY.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> ANGELFISH_BUCKET = ModRegistry.REGISTRIES.registerItem("angelfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.ANGELFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> ANGLERFISH_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "anglerfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.ANGLERFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> BASS_BUCKET = ModRegistry.REGISTRIES.registerItem("bass_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.BASS.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> BLUE_TANG_BUCKET = ModRegistry.REGISTRIES.registerItem("blue_tang_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.BLUE_TANG.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> BOWFIN_BUCKET = ModRegistry.REGISTRIES.registerItem("bowfin_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.BOWFIN.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> BUTTERFLYFISH_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "butterflyfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.BUTTERFLYFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> CARP_BUCKET = ModRegistry.REGISTRIES.registerItem("carp_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.CARP.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> CATFISH_BUCKET = ModRegistry.REGISTRIES.registerItem("catfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.CATFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> CHUB_BUCKET = ModRegistry.REGISTRIES.registerItem("chub_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.CHUB.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> DAMSELFISH_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "damselfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.DAMSELFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> ELECTRIC_RAY_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "electric_ray_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.ELECTRIC_RAY.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> GOLDFISH_BUCKET = ModRegistry.REGISTRIES.registerItem("goldfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.GOLDFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> KOI_BUCKET = ModRegistry.REGISTRIES.registerItem("koi_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.KOI.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> LAMPREY_BUCKET = ModRegistry.REGISTRIES.registerItem("lamprey_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.LAMPREY.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> LUNGFISH_BUCKET = ModRegistry.REGISTRIES.registerItem("lungfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.LUNGFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> MANTA_RAY_BUCKET = ModRegistry.REGISTRIES.registerItem("manta_ray_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.MANTA_RAY.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> MINNOW_BUCKET = ModRegistry.REGISTRIES.registerItem("minnow_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.MINNOW.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> NEON_TETRA_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "neon_tetra_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.NEON_TETRA.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> NORTHERN_PIKE_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "northern_pike_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.NORTHERN_PIKE.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> PERCH_BUCKET = ModRegistry.REGISTRIES.registerItem("perch_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.PERCH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> PICKEREL_BUCKET = ModRegistry.REGISTRIES.registerItem("pickerel_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.PICKEREL.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> PIRANHA_BUCKET = ModRegistry.REGISTRIES.registerItem("piranha_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.PIRANHA.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> PUPFISH_BUCKET = ModRegistry.REGISTRIES.registerItem("pupfish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.PUPFISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> SARDINE_BUCKET = ModRegistry.REGISTRIES.registerItem("sardine_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.SARDINE.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> SIAMESE_FIGHTING_FISH_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "siamese_fighting_fish_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.SIAMESE_FIGHTING_FISH.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> WHITEMARGIN_STARGAZER_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "whitemargin_stargazer_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.WHITEMARGIN_STARGAZER.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> STINGRAY_BUCKET = ModRegistry.REGISTRIES.registerItem("stingray_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.STINGRAY.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> SILVER_STRIPE_BLAASOP_BUCKET = ModRegistry.REGISTRIES.registerItem(
            "silver_stripe_blaasop_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.SILVER_STRIPE_BLAASOP.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> TROUT_BUCKET = ModRegistry.REGISTRIES.registerItem("trout_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.TROUT.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> TUNA_BUCKET = ModRegistry.REGISTRIES.registerItem("tuna_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.TUNA.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    public static final Holder.Reference<Item> WALLEYE_BUCKET = ModRegistry.REGISTRIES.registerItem("walleye_bucket",
            (Item.Properties properties) -> new MobBucketItem(ModEntityTypes.WALLEYE.value(),
                    Fluids.WATER,
                    SoundEvents.BUCKET_EMPTY_FISH,
                    properties),
            () -> new Item.Properties().stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    // Spawn Eggs
    public static final Holder.Reference<Item> ANCHOVY_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.ANCHOVY,
            0xDBE4DF,
            0x507853);
    public static final Holder.Reference<Item> ANGELFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.ANGELFISH,
            0xF2F2F2,
            0xECE43E);
    public static final Holder.Reference<Item> ANGLERFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.ANGLERFISH,
            0x5A4229,
            0x271C0F);
    public static final Holder.Reference<Item> BASS_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.BASS,
            0xA39F6F,
            0x3E3E1C);
    public static final Holder.Reference<Item> BLUE_TANG_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.BLUE_TANG,
            0x5070D4,
            0xFFFF10);
    public static final Holder.Reference<Item> BOWFIN_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.BOWFIN,
            0x8B7B40,
            0x343523);
    public static final Holder.Reference<Item> BUTTERFLYFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.BUTTERFLYFISH,
            0xF2A905,
            0x282828);
    public static final Holder.Reference<Item> CARP_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.CARP,
            0xB99366,
            0x5A2C1D);
    public static final Holder.Reference<Item> CATFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.CATFISH,
            0xCCCC99,
            0x524941);
    public static final Holder.Reference<Item> CHUB_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.CHUB,
            0xE9BE89,
            0x4E5F93);
    public static final Holder.Reference<Item> DAMSELFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.DAMSELFISH,
            0xA8DAF4,
            0x0F1338);
    public static final Holder.Reference<Item> ELECTRIC_RAY_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.ELECTRIC_RAY,
            0xDBAD70,
            0x8A6D56);
    public static final Holder.Reference<Item> GOLDFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.GOLDFISH,
            0xFDB609,
            0xE37802);
    public static final Holder.Reference<Item> KOI_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.KOI,
            0xE2DDDA,
            0xEB4132);
    public static final Holder.Reference<Item> LAMPREY_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.LAMPREY,
            0x84736F,
            0x262120);
    public static final Holder.Reference<Item> LUNGFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.LUNGFISH,
            0x8A8168,
            0x564739);
    public static final Holder.Reference<Item> MANTA_RAY_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.MANTA_RAY,
            0x314563,
            0xD2DAE7);
    public static final Holder.Reference<Item> MINNOW_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.MINNOW,
            0xA4A750,
            0xD8BC5D);
    public static final Holder.Reference<Item> NEON_TETRA_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.NEON_TETRA,
            0x14CED5,
            0xA41904);
    public static final Holder.Reference<Item> NORTHERN_PIKE_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.NORTHERN_PIKE,
            0xA4A07D,
            0x5A513A);
    public static final Holder.Reference<Item> PERCH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.PERCH,
            0x342822,
            0xCEB14A);
    public static final Holder.Reference<Item> PICKEREL_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.PICKEREL,
            0x7B8240,
            0xB96F4A);
    public static final Holder.Reference<Item> PIRANHA_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.PIRANHA,
            0x20323E,
            0x9E1B00);
    public static final Holder.Reference<Item> PUPFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.PUPFISH,
            0x87A3CF,
            0x7454A0);
    public static final Holder.Reference<Item> SARDINE_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.SARDINE,
            0xE0DDE1,
            0x2C345A);
    public static final Holder.Reference<Item> SIAMESE_FIGHTING_FISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.SIAMESE_FIGHTING_FISH,
            0x593E83,
            0x266FCB);
    public static final Holder.Reference<Item> WHITEMARGIN_STARGAZER_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.WHITEMARGIN_STARGAZER,
            0x72513D,
            0x4382A9);
    public static final Holder.Reference<Item> STINGRAY_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.STINGRAY,
            0x779974,
            0x1B281F);
    public static final Holder.Reference<Item> SILVER_STRIPE_BLAASOP_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.SILVER_STRIPE_BLAASOP,
            0x727E6A,
            0x2F3D40);
    public static final Holder.Reference<Item> TROUT_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.TROUT,
            0xC5929D,
            0x6D5635);
    public static final Holder.Reference<Item> TUNA_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.TUNA,
            0x93A097,
            0x4A576F);
    public static final Holder.Reference<Item> WALLEYE_SPAWN_EGG = ModRegistry.REGISTRIES.registerLegacySpawnEggItem(
            ModEntityTypes.WALLEYE,
            0xE2BD65,
            0x363932);

    public static void bootstrap() {
        // NO-OP
    }
}
