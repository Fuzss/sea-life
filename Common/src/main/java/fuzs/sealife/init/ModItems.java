package fuzs.sealife.init;

import fuzs.sealife.world.item.TreasureItem;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
    public static final FoodProperties FISH_FINGERS_FOOD = new FoodProperties.Builder().nutrition(11)
            .saturationModifier(1.0F)
            .build();
    public static final FoodProperties SASHIMI_FOOD = new FoodProperties.Builder().nutrition(5)
            .saturationModifier(0.5F)
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
            () -> new Item.Properties().food(FISH_FINGERS_FOOD, FISH_FINGERS_CONSUMABLE).usingConvertsTo(Items.BOWL));
    public static final Holder.Reference<Item> SASHIMI = ModRegistry.REGISTRIES.registerItem("sashimi",
            () -> new Item.Properties().food(SASHIMI_FOOD).usingConvertsTo(Items.BOWL));
    public static final Holder.Reference<Item> FISH_STEW = ModRegistry.REGISTRIES.registerItem("fish_stew",
            () -> new Item.Properties().food(FISH_STEW_FOOD).usingConvertsTo(Items.BOWL));
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
    public static final Holder.Reference<Item> ANCHOVY_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.ANCHOVY);
    public static final Holder.Reference<Item> ANGELFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.ANGELFISH);
    public static final Holder.Reference<Item> ANGLERFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.ANGLERFISH);
    public static final Holder.Reference<Item> BASS_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.BASS);
    public static final Holder.Reference<Item> BLUE_TANG_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.BLUE_TANG);
    public static final Holder.Reference<Item> BOWFIN_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.BOWFIN);
    public static final Holder.Reference<Item> BUTTERFLYFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.BUTTERFLYFISH);
    public static final Holder.Reference<Item> CARP_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.CARP);
    public static final Holder.Reference<Item> CATFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.CATFISH);
    public static final Holder.Reference<Item> CHUB_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.CHUB);
    public static final Holder.Reference<Item> DAMSELFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.DAMSELFISH);
    public static final Holder.Reference<Item> ELECTRIC_RAY_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.ELECTRIC_RAY);
    public static final Holder.Reference<Item> GOLDFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.GOLDFISH);
    public static final Holder.Reference<Item> KOI_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.KOI);
    public static final Holder.Reference<Item> LAMPREY_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.LAMPREY);
    public static final Holder.Reference<Item> LUNGFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.LUNGFISH);
    public static final Holder.Reference<Item> MANTA_RAY_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.MANTA_RAY);
    public static final Holder.Reference<Item> MINNOW_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.MINNOW);
    public static final Holder.Reference<Item> NEON_TETRA_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.NEON_TETRA);
    public static final Holder.Reference<Item> NORTHERN_PIKE_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.NORTHERN_PIKE);
    public static final Holder.Reference<Item> PERCH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.PERCH);
    public static final Holder.Reference<Item> PICKEREL_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.PICKEREL);
    public static final Holder.Reference<Item> PIRANHA_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.PIRANHA);
    public static final Holder.Reference<Item> PUPFISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.PUPFISH);
    public static final Holder.Reference<Item> SARDINE_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.SARDINE);
    public static final Holder.Reference<Item> SIAMESE_FIGHTING_FISH_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.SIAMESE_FIGHTING_FISH);
    public static final Holder.Reference<Item> WHITEMARGIN_STARGAZER_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.WHITEMARGIN_STARGAZER);
    public static final Holder.Reference<Item> STINGRAY_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.STINGRAY);
    public static final Holder.Reference<Item> SILVER_STRIPE_BLAASOP_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.SILVER_STRIPE_BLAASOP);
    public static final Holder.Reference<Item> TROUT_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.TROUT);
    public static final Holder.Reference<Item> TUNA_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.TUNA);
    public static final Holder.Reference<Item> WALLEYE_SPAWN_EGG = ModRegistry.REGISTRIES.registerSpawnEggItem(
            ModEntityTypes.WALLEYE);

    public static void bootstrap() {
        // NO-OP
    }
}
