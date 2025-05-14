package uk.joshiejack.piscary.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import uk.joshiejack.penguinlib.data.TimeUnitRegistry;
import uk.joshiejack.penguinlib.data.database.CSVUtils;
import uk.joshiejack.penguinlib.data.generator.AbstractDatabaseProvider;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;
import uk.joshiejack.piscary.init.PiscaryItems;

import java.util.function.Supplier;

public class PiscaryDatabase extends AbstractDatabaseProvider {
    public PiscaryDatabase(PackOutput output) {
        super(output, Piscary.MODID);
    }

    @Override
    protected void addDatabaseEntries() {
        addTimeUnitForMachine(PiscaryBlockEntities.FISH_TRAP.get(), TimeUnitRegistry.Defaults.HALF_HOUR);
        addTimeUnitForMachine(PiscaryBlockEntities.RECYCLER.get(), TimeUnitRegistry.Defaults.HOUR);
        addTimeUnitForMachine(PiscaryBlockEntities.HATCHERY.get(), TimeUnitRegistry.Defaults.DAY);
        addLootTableMerge(BuiltInLootTables.FISHING_FISH);
        addLootTableMerge(BuiltInLootTables.FISHING_JUNK);
        addLootTableMerge(BuiltInLootTables.FISHING_TREASURE);
        addBait(PiscaryItems.BAIT, BuiltInLootTables.FISHING_FISH, 1, 0);
        addAquacultureBait("worm", BuiltInLootTables.FISHING_FISH, 1, 0);
        //################# FISH HATCHERY DATA ##################//
//        addHatcheryEntryAny(() -> EntityType.COD, 3);
//        addHatcheryEntryAny(() -> EntityType.SALMON, 3);
//        addHatcheryEntryAny(() -> EntityType.PUFFERFISH, 5);
//        addHatcheryEntryAny(() -> EntityType.TROPICAL_FISH, 5);
//        addHatcheryEntry(PiscaryEntities.ANCHOVY.value(), 3);
//        addHatcheryEntry(PiscaryEntities.ANGELFISH.value(), 5);
//        addHatcheryEntry(PiscaryEntities.ANGLERFISH.value(), 7);
//        addHatcheryEntry(PiscaryEntities.BASS.value(), 3);
//        addHatcheryEntry(PiscaryEntities.BLUE_TANG.value(), 5);
//        addHatcheryEntry(PiscaryEntities.BOWFIN.value(), 5);
//        addHatcheryEntry(PiscaryEntities.BUTTERFLYFISH.value(), 5);
//        addHatcheryEntry(PiscaryEntities.CARP.value(), 3);
//        addHatcheryEntry(PiscaryEntities.CATFISH.value(), 5);
//        addHatcheryEntry(PiscaryEntities.CHUB.value(), 3);
//        addHatcheryEntry(PiscaryEntities.DAMSELFISH.value(), 5);
//        addHatcheryEntry(PiscaryEntities.ELECTRIC_RAY.value(), 7);
//        addHatcheryEntry(PiscaryEntities.GOLDFISH.value(), 3);
//        addHatcheryEntry(PiscaryEntities.KOI.value(), 5);
//        addHatcheryEntry(PiscaryEntities.LAMPREY.value(), 5);
//        addHatcheryEntry(PiscaryEntities.LUNGFISH.value(), 7);
//        addHatcheryEntry(PiscaryEntities.MANTA_RAY.value(), 7);
//        addHatcheryEntry(PiscaryEntities.NEON_TETRA.value(), 3);
//        addHatcheryEntry(PiscaryEntities.NORTHERN_PIKE.value(), 5);
//        addHatcheryEntry(PiscaryEntities.PERCH.value(), 3);
//        addHatcheryEntry(PiscaryEntities.PICKEREL.value(), 5);
//        addHatcheryEntry(PiscaryEntities.PIRANHA.value(), 7);
//        addHatcheryEntry(PiscaryEntities.PUPFISH.value(), 5);
//        addHatcheryEntry(PiscaryEntities.SARDINE.value(), 3);
//        addHatcheryEntry(PiscaryEntities.SIAMESE_FIGHTING_FISH.value(), 5);
//        addHatcheryEntry(PiscaryEntities.SILVER_STRIPE_BLAASOP.value(), 7);
//        addHatcheryEntry(PiscaryEntities.WHITEMARGIN_STARGAZER.value(), 5);
//        addHatcheryEntry(PiscaryEntities.STINGRAY.value(), 7);
//        addHatcheryEntry(PiscaryEntities.TROUT.value(), 3);
//        addHatcheryEntry(PiscaryEntities.TUNA.value(), 5);
//        addHatcheryEntry(PiscaryEntities.WALLEYE.value(), 3);
        //################# AQUACULTURE HATCHERY ##################//
//        addAquacultureHatcheryEntry("atlantic_cod", 6);
//        addAquacultureHatcheryEntry("blackfish", 5);
//        addAquacultureHatcheryEntry("pacific_halibut", 7);
//        addAquacultureHatcheryEntry("atlantic_halibut", 7);
//        addAquacultureHatcheryEntry("atlantic_herring", 3);
//        addAquacultureHatcheryEntry("pink_salmon", 6);
//        addAquacultureHatcheryEntry("pollock", 5);
//        addAquacultureHatcheryEntry("rainbow_trout", 6);
//        addAquacultureHatcheryEntry("bayad", 6);
//        addAquacultureHatcheryEntry("boulti", 5);
//        addAquacultureHatcheryEntry("capitaine", 7);
//        addAquacultureHatcheryEntry("synodontis", 3);
//        addAquacultureHatcheryEntry("smallmouth_bass", 5);
//        addAquacultureHatcheryEntry("bluegill", 3);
//        addAquacultureHatcheryEntry("brown_trout", 5);
//        addAquacultureHatcheryEntry("carp", 5);
//        addAquacultureHatcheryEntry("catfish", 5);
//        addAquacultureHatcheryEntry("gar", 6);
//        addAquacultureHatcheryEntry("minnow", 4);
//        addAquacultureHatcheryEntry("muskellunge", 7);
//        addAquacultureHatcheryEntry("perch", 3);
//        addAquacultureHatcheryEntry("arapaima", 7);
//        addAquacultureHatcheryEntry("piranha", 7);
//        addAquacultureHatcheryEntry("tambaqui", 6);
//        addAquacultureHatcheryEntry("brown_shrooma", 2);
//        addAquacultureHatcheryEntry("red_shrooma", 2);
//        addAquacultureHatcheryEntry("jellyfish", 5);
//        addAquacultureHatcheryEntry("red_grouper", 6);
//        addAquacultureHatcheryEntry("tuna", 7);
        //################# FISH SPAWN SETTINGS ##################//
        //TODO: Move to datapack entries
//        addFishSpawnSettings(PiscaryEntities.ANCHOVY, 14, 8, 12);
//        addFishSpawnSettings(PiscaryEntities.ANGELFISH, 3, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.ANGLERFISH, 1, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.BASS, 6, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.BLUE_TANG, 1, 2, 3);
//        addFishSpawnSettings(PiscaryEntities.BOWFIN, 3, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.BUTTERFLYFISH, 1, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.CARP, 2, 4, 6);
//        addFishSpawnSettings(PiscaryEntities.CATFISH, 3, 1, 2);
//        addFishSpawnSettings(PiscaryEntities.CHUB, 10, 5, 7);
//        addFishSpawnSettings(PiscaryEntities.DAMSELFISH, 3, 2, 3);
//        addFishSpawnSettings(PiscaryEntities.ELECTRIC_RAY, 1, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.GOLDFISH, 12, 1, 2);
//        addFishSpawnSettings(PiscaryEntities.KOI, 1, 1, 2);
//        addFishSpawnSettings(PiscaryEntities.LAMPREY, 4, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.LUNGFISH, 1, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.MANTA_RAY, 1, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.MINNOW, 14, 5, 8);
//        addFishSpawnSettings(PiscaryEntities.NEON_TETRA, 2, 5, 8);
//        addFishSpawnSettings(PiscaryEntities.NORTHERN_PIKE, 1, 1, 2);
//        addFishSpawnSettings(PiscaryEntities.PERCH, 10, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.PICKEREL, 2, 2, 3);
//        addFishSpawnSettings(PiscaryEntities.PIRANHA, 1, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.PUPFISH, 4, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.SARDINE, 12, 7, 12);
//        addFishSpawnSettings(PiscaryEntities.SIAMESE_FIGHTING_FISH, 2, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.SILVER_STRIPE_BLAASOP, 1, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.WHITEMARGIN_STARGAZER, 2, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.STINGRAY, 1, 1, 1);
//        addFishSpawnSettings(PiscaryEntities.TROUT, 8, 4, 6);
//        addFishSpawnSettings(PiscaryEntities.TUNA, 2, 3, 5);
//        addFishSpawnSettings(PiscaryEntities.WALLEYE, 5, 2, 3);
        //################# FISH BIOMES DATA ##################//
        //TODO: Move to datpack entries
//        addFishSpawns(PiscaryEntities.ANCHOVY, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.ANCHOVY, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.ANGELFISH, REQUIRE, JUNGLE);
//        addFishSpawns(PiscaryEntities.ANGLERFISH, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.ANGLERFISH, REQUIRE, SNOWY);
//        addFishSpawns(PiscaryEntities.BASS, EXCLUDE, COLD);
//        addFishSpawns(PiscaryEntities.BASS, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.BLUE_TANG, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.BLUE_TANG, REQUIRE, HOT);
//        addFishSpawns(PiscaryEntities.BOWFIN, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.BOWFIN, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.BUTTERFLYFISH, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.BUTTERFLYFISH, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.CARP, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.CARP, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.CATFISH, REQUIRE, RIVER);
//        addFishSpawns(PiscaryEntities.CHUB, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.CHUB, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.DAMSELFISH, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.DAMSELFISH, REQUIRE, HOT);
//        addFishSpawns(PiscaryEntities.ELECTRIC_RAY, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.GOLDFISH, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.GOLDFISH, EXCLUDE, WET);
//        addFishSpawns(PiscaryEntities.KOI, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.KOI, EXCLUDE, WET);
//        addFishSpawns(PiscaryEntities.LAMPREY, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.LAMPREY, EXCLUDE, COLD);
//        addFishSpawns(PiscaryEntities.LUNGFISH, EXCLUDE, COLD);
//        addFishSpawns(PiscaryEntities.LUNGFISH, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.MANTA_RAY, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.MANTA_RAY, EXCLUDE, SNOWY);
//        addFishSpawns(PiscaryEntities.MINNOW, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.NEON_TETRA, REQUIRE, JUNGLE);
//        addFishSpawns(PiscaryEntities.NORTHERN_PIKE, REQUIRE, SNOWY);
//        addFishSpawns(PiscaryEntities.NORTHERN_PIKE, REQUIRE, RIVER);
//        addFishSpawns(PiscaryEntities.PERCH, REQUIRE, RIVER);
//        addFishSpawns(PiscaryEntities.PICKEREL, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.PICKEREL, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.PIRANHA, REQUIRE, JUNGLE);
//        addFishSpawns(PiscaryEntities.PUPFISH, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.PUPFISH, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.SARDINE, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.SARDINE, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.SIAMESE_FIGHTING_FISH, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.SIAMESE_FIGHTING_FISH, EXCLUDE, OCEAN);
//        addFishSpawns(PiscaryEntities.SILVER_STRIPE_BLAASOP, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.SILVER_STRIPE_BLAASOP, REQUIRE, SNOWY);
//        addFishSpawns(PiscaryEntities.WHITEMARGIN_STARGAZER, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.WHITEMARGIN_STARGAZER, REQUIRE, HOT);
//        addFishSpawns(PiscaryEntities.STINGRAY, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.TROUT, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.TUNA, REQUIRE, OCEAN);
//        addFishSpawns(PiscaryEntities.TUNA, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.WALLEYE, EXCLUDE, HOT);
//        addFishSpawns(PiscaryEntities.WALLEYE, EXCLUDE, COLD);
        //TODO?addHatcheryRenderEntry(() -> (AbstractFish)EntityType.PUFFERFISH, -90F);
        //addHatcheryAdvancedEntry(() -> EntityType.SKELETON, 1, Items.BONE, Items.SKELETON_SPAWN_EGG);
    }

    public enum SpawnType {
        REQUIRE, EXCLUDE
    }

    protected void addAquacultureBait(String name, ResourceLocation lootTable, int speed, int luck) {
        addBait(new ResourceLocation("aquaculture", name).toString(), lootTable.toString(), speed, luck);
    }

    protected void addAquacultureHatcheryEntry(String name, int days) {
        addHatcheryEntry(new ResourceLocation("aquaculture", name).toString(), days);
    }

    protected void addBait(Supplier<Item> item, ResourceLocation lootTable, int speed, int luck) {
        addBait(BuiltInRegistries.ITEM.getKey(item.get()).toString(), lootTable.toString(), speed, luck);
    }

    protected void addBait(String itemRegistryName, String lootTable, int speed, int luck) {
        addEntry("bait", "Item,Loot Table,Speed,Luck", CSVUtils.join(itemRegistryName, lootTable, speed, luck));
    }

    protected void addHatcheryRenderEntry(Supplier<EntityType<? extends AbstractFish>> entity, float rotation) {
        addEntry("hatchery_renderers", "Entity,Rotation", CSVUtils.join(BuiltInRegistries.ENTITY_TYPE.getKey(entity.get()).toString(), rotation));
    }

    protected void addHatcheryEntry(EntityType<? extends AbstractFish> entity, int cycles) {
        addEntry("hatchery", "Entity,Cycles", CSVUtils.join(BuiltInRegistries.ENTITY_TYPE.getKey(entity).toString(), cycles));
    }

    protected void addHatcheryEntryAny(Supplier<EntityType<?>> entity, int cycles) {
        addEntry("hatchery", "Entity,Cycles", CSVUtils.join(BuiltInRegistries.ENTITY_TYPE.getKey(entity.get()).toString(), cycles));
    }

    protected void addHatcheryAdvancedEntry(Supplier<EntityType<? extends AbstractFish>> entity, int cycles, Item waterbucket, Item fishbucket) {
        addEntry("hatchery_advanced", "Entity,Cycles,Water Bucket,Fish Bucket", CSVUtils.join(BuiltInRegistries.ENTITY_TYPE.getKey(entity.get()).toString(), cycles, BuiltInRegistries.ITEM.getKey(waterbucket).toString(), BuiltInRegistries.ITEM.getKey(fishbucket).toString()));
    }


    protected void addHatcheryEntry(String entityRegistryName, int days) {
        addEntry("hatchery", "Entity,Cycles", CSVUtils.join(entityRegistryName, days));
    }
//
//    protected void addFishSpawns(Supplier<EntityType<?>> entity, SpawnType type, BiomeDictionary.Type biome) {
//        addEntry("fish_spawn_biomes", "Entity,Type,Biome Type",
//                CSVUtils.join(Objects.requireNonNull(entity.get().getRegistryName()).toString(), type.name().toLowerCase(Locale.ROOT), biome.getName().toLowerCase(Locale.ROOT)));
//    }
//
//    protected void addFishSpawnSettings(Supplier<EntityType<?>> entity, int weight, int min, int max) {
//        addEntry("fish_spawn_settings", "Entity,Weight,Min,Max",
//                CSVUtils.join(Objects.requireNonNull(entity.get().getRegistryName()).toString(), weight, min, max));
//    }
}
