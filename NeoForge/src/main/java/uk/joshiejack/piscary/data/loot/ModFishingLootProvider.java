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
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import uk.joshiejack.piscary.init.ModLootTables;
import uk.joshiejack.piscary.init.PiscaryItems;

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
                                .add(LootItem.lootTableItem(PiscaryItems.ANCHOVY.get())
                                        .setWeight(32)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.ANGELFISH.get())
                                        .setWeight(3)
                                        .when(inJungleBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.ANGLERFISH.get())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inSnowyBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.BASS.get())
                                        .setWeight(12)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inColdBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.BLUE_TANG.get())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.BOWFIN.get())
                                        .setWeight(3)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.BUTTERFLYFISH.get())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.CARP.get())
                                        .setWeight(2)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.CATFISH.get()).setWeight(3).when(inRiverBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.CHUB.get())
                                        .setWeight(54)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.DAMSELFISH.get())
                                        .setWeight(3)
                                        .when(inOceanBiome)
                                        .when(inHotBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.ELECTRIC_RAY.get())
                                        .setWeight(1)
                                        .when(inOceanBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.GOLDFISH.get())
                                        .setWeight(37)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inSwampyBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.KOI.get())
                                        .setWeight(1)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inSwampyBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.LAMPREY.get())
                                        .setWeight(4)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inColdBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.LUNGFISH.get())
                                        .setWeight(1)
                                        .when(InvertedLootItemCondition.invert(inColdBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.MANTA_RAY.get())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inSnowyBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.MINNOW.get())
                                        .setWeight(102)
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.NEON_TETRA.get())
                                        .setWeight(2)
                                        .when(inJungleBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.NORTHERN_PIKE.get())
                                        .setWeight(1)
                                        .when(inSnowyBiome)
                                        .when(inRiverBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.PERCH.get()).setWeight(21).when(inRiverBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.PICKEREL.get())
                                        .setWeight(2)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.PIRANHA.get())
                                        .setWeight(1)
                                        .when(inJungleBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.PUPFISH.get())
                                        .setWeight(4)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.SARDINE.get())
                                        .setWeight(30)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inHotBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.SIAMESE_FIGHTING_FISH.get())
                                        .setWeight(2)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inOceanBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.STINGRAY.get())
                                        .setWeight(1)
                                        .when(inOceanBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.SILVER_STRIPE_BLAASOP.get())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(inSnowyBiome))
                                .add(LootItem.lootTableItem(PiscaryItems.TROUT.get())
                                        .setWeight(14)
                                        .when(InvertedLootItemCondition.invert(inHotBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.TUNA.get())
                                        .setWeight(2)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inHotBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.WALLEYE.get())
                                        .setWeight(8)
                                        .when(InvertedLootItemCondition.invert(inHotBiome))
                                        .when(InvertedLootItemCondition.invert(inColdBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.WHITEMARGIN_STARGAZER.get())
                                        .setWeight(2)
                                        .when(inHotBiome)
                                        .when(inOceanBiome))));
        this.add(ModLootTables.FISHING_JUNK_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(PiscaryItems.FISH_BONES.get()).setWeight(17))
                                .add(LootItem.lootTableItem(PiscaryItems.EMPTY_CAN.get()).setWeight(16))));
        this.add(ModLootTables.FISHING_TREASURE_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(5))
                                .add(LootItem.lootTableItem(PiscaryItems.FISH_FOSSIL.get())
                                        .setWeight(10)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inSnowyBiome)))
                                .add(LootItem.lootTableItem(PiscaryItems.PIRATE_TREASURE.get())
                                        .setWeight(1)
                                        .when(inOceanBiome)
                                        .when(InvertedLootItemCondition.invert(inSnowyBiome)))));
    }
}
