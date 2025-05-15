package uk.joshiejack.piscary.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import uk.joshiejack.piscary.init.ModLootTables;
import uk.joshiejack.piscary.init.ModItems;

public class ModFishingLootProvider extends AbstractLootProvider.Simple {
    static final TagKey<Biome> IS_COLD_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_cold");
    static final TagKey<Biome> IS_HOT_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_hot");
    static final TagKey<Biome> IS_SNOWY_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_snowy");
    static final TagKey<Biome> IS_WET_BIOME_TAG = TagFactory.COMMON.registerBiomeTag("is_wet");

    public ModFishingLootProvider(DataProviderContext context) {
        super(LootContextParamSets.FISHING, context);
    }

    @Override
    public void addLootTables() {
        HolderLookup.RegistryLookup<Biome> biomeLookup = this.registries().lookupOrThrow(Registries.BIOME);
        LootItemCondition.Builder inOceanBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(BiomeTags.IS_OCEAN)));
        LootItemCondition.Builder inColdBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(IS_COLD_BIOME_TAG)));
        LootItemCondition.Builder inHotBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(IS_HOT_BIOME_TAG)));
        LootItemCondition.Builder inSnowyBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(IS_SNOWY_BIOME_TAG)));
        LootItemCondition.Builder inRiverBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(BiomeTags.IS_RIVER)));
        LootItemCondition.Builder inSwampyBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(IS_WET_BIOME_TAG)));
        LootItemCondition.Builder inJungleBiome = LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(biomeLookup.getOrThrow(BiomeTags.IS_JUNGLE)));
        this.add(ModLootTables.FISHING_FISH_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ModItems.ANCHOVY.value())
                                        .setWeight(32)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(ModItems.ANGELFISH.value())
                                        .setWeight(3)
                                        .when(inJungleBiome))
                                .add(LootItem.lootTableItem(ModItems.ANGLERFISH.value())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inSnowyBiome))
                                .add(LootItem.lootTableItem(ModItems.BASS.value())
                                        .setWeight(12)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inColdBiome)))
                                .add(LootItem.lootTableItem(ModItems.BLUE_TANG.value())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(ModItems.BOWFIN.value())
                                        .setWeight(3)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.BUTTERFLYFISH.value())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(ModItems.CARP.value())
                                        .setWeight(2)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.CATFISH.value())
                                        .setWeight(3)
                                        .when(inRiverBiome))
                                .add(LootItem.lootTableItem(ModItems.CHUB.value())
                                        .setWeight(54)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.DAMSELFISH.value())
                                        .setWeight(3)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(ModItems.ELECTRIC_RAY.value())
                                        .setWeight(1)
                                        .when(inOceanBiome))
                                .add(LootItem.lootTableItem(ModItems.GOLDFISH.value())
                                        .setWeight(37)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inSwampyBiome)))
                                .add(LootItem.lootTableItem(ModItems.KOI.value())
                                        .setWeight(1)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inSwampyBiome)))
                                .add(LootItem.lootTableItem(ModItems.LAMPREY.value())
                                        .setWeight(4)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inColdBiome)))
                                .add(LootItem.lootTableItem(ModItems.LUNGFISH.value())
                                        .setWeight(1)
                                        .when(InvertedLootItemCondition.invert(inColdBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.MANTA_RAY.value())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inSnowyBiome)))
                                .add(LootItem.lootTableItem(ModItems.MINNOW.value())
                                        .setWeight(102)
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.NEON_TETRA.value())
                                        .setWeight(2)
                                        .when(inJungleBiome))
                                .add(LootItem.lootTableItem(ModItems.NORTHERN_PIKE.value())
                                        .setWeight(1)
                                        .when(inSnowyBiome)
                                        .when(inRiverBiome))
                                .add(LootItem.lootTableItem(ModItems.PERCH.value())
                                        .setWeight(21)
                                        .when(inRiverBiome))
                                .add(LootItem.lootTableItem(ModItems.PICKEREL.value())
                                        .setWeight(2)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.PIRANHA.value())
                                        .setWeight(1)
                                        .when(inJungleBiome))
                                .add(LootItem.lootTableItem(ModItems.PUPFISH.value())
                                        .setWeight(4)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.SARDINE.value())
                                        .setWeight(30)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inHotBiome)))
                                .add(LootItem.lootTableItem(ModItems.SIAMESE_FIGHTING_FISH.value())
                                        .setWeight(2)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(ModItems.STINGRAY.value())
                                        .setWeight(1)
                                        .when(inOceanBiome))
                                .add(LootItem.lootTableItem(ModItems.SILVER_STRIPE_BLAASOP.value())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inSnowyBiome))
                                .add(LootItem.lootTableItem(ModItems.TROUT.value())
                                        .setWeight(14)
                                        .when(InvertedLootItemCondition.invert(inHotBiome)))
                                .add(LootItem.lootTableItem(ModItems.TUNA.value())
                                        .setWeight(2)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inHotBiome)))
                                .add(LootItem.lootTableItem(ModItems.WALLEYE.value())
                                        .setWeight(8)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inColdBiome)))
                                .add(LootItem.lootTableItem(ModItems.WHITEMARGIN_STARGAZER.value())
                                        .setWeight(2)
                                        .when(inHotBiome)
                                        .when(inOceanBiome))));
        this.add(ModLootTables.FISHING_JUNK_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ModItems.FISH_BONES.value()).setWeight(17))
                                .add(LootItem.lootTableItem(ModItems.EMPTY_CAN.value()).setWeight(16))));
        this.add(ModLootTables.FISHING_TREASURE_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(5))
                                .add(LootItem.lootTableItem(ModItems.FISH_FOSSIL.value())
                                        .setWeight(10)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inSnowyBiome)))
                                .add(LootItem.lootTableItem(ModItems.PIRATE_TREASURE.value())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inSnowyBiome)))));
        this.add(ModLootTables.FISH_TRAP,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(NestedLootTable.lootTableReference(BuiltInLootTables.FISHING_FISH).setWeight(3))
                                .add(NestedLootTable.lootTableReference(BuiltInLootTables.FISHING_JUNK).setWeight(1))));
    }
}
