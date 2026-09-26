package fuzs.sealife.common.init;

import com.google.common.collect.ImmutableMap;
import fuzs.puzzleslib.common.api.event.v1.server.LootTableLoadCallback;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.Map;
import java.util.function.BiConsumer;

public class ModLootTables {
    static final Map<Identifier, BiConsumer<LootPool.Builder, HolderGetter.Provider>> LOOT_TABLE_INJECTIONS;
    public static final ResourceKey<LootTable> TREASURE_ITEM = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "gameplay/treasure_item");
    public static final ResourceKey<LootTable> FISH_TRAP = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
            "gameplay/fish_trap");

    static {
        ImmutableMap.Builder<Identifier, BiConsumer<LootPool.Builder, HolderGetter.Provider>> builder = ImmutableMap.builder();
        builder.put(BuiltInLootTables.FISHING_FISH.identifier(), ModLootTables::addFishingFish);
        builder.put(BuiltInLootTables.FISHING_JUNK.identifier(), ModLootTables::addFishingJunk);
        builder.put(BuiltInLootTables.FISHING_TREASURE.identifier(), ModLootTables::addFishingTreasure);
        LOOT_TABLE_INJECTIONS = builder.build();
    }

    public static void bootstrap() {
        // NO-OP
    }

    public static void onLootTableLoad(Identifier identifier, LootTable.Builder lootTable, HolderGetter.Provider getterProvider) {
        if (LOOT_TABLE_INJECTIONS.containsKey(identifier)) {
            MutableBoolean mutableBoolean = new MutableBoolean();
            LootTableLoadCallback.forEachPool(lootTable, (LootPool.Builder lootPoolBuilder) -> {
                if (mutableBoolean.isFalse()) {
                    mutableBoolean.setTrue();
                    LOOT_TABLE_INJECTIONS.get(identifier).accept(lootPoolBuilder, getterProvider);
                }
            });
        }
    }

    public static void addFishingFish(LootPool.Builder lootPoolBuilder, HolderGetter.Provider getterProvider) {
        lootPoolBuilder.add(LootItem.lootTableItem(ModItems.ANCHOVY.value())
                        .setWeight(32)
                        .when(inOceanBiome(getterProvider))
                        .when(inHotBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.ANGELFISH.value())
                        .setWeight(3)
                        .when(inJungleBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.ANGLERFISH.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider))
                        .when(inSnowyBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.BASS.value())
                        .setWeight(12)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inColdBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.BLUE_TANG.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider))
                        .when(inHotBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.BOWFIN.value())
                        .setWeight(3)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.BUTTERFLYFISH.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider))
                        .when(inHotBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.CARP.value())
                        .setWeight(2)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.CATFISH.value()).setWeight(3).when(inRiverBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.CHUB.value())
                        .setWeight(54)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.DAMSELFISH.value())
                        .setWeight(3)
                        .when(inOceanBiome(getterProvider))
                        .when(inHotBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.ELECTRIC_RAY.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.GOLDFISH.value())
                        .setWeight(37)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inSwampyBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.KOI.value())
                        .setWeight(1)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inSwampyBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.LAMPREY.value())
                        .setWeight(4)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inColdBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.LUNGFISH.value())
                        .setWeight(1)
                        .when(InvertedLootItemCondition.invert(inColdBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.MANTA_RAY.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider))
                        .when(InvertedLootItemCondition.invert(inSnowyBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.MINNOW.value())
                        .setWeight(102)
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.NEON_TETRA.value())
                        .setWeight(2)
                        .when(inJungleBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.NORTHERN_PIKE.value())
                        .setWeight(1)
                        .when(inSnowyBiome(getterProvider))
                        .when(inRiverBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.PERCH.value()).setWeight(21).when(inRiverBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.PICKEREL.value())
                        .setWeight(2)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.PIRANHA.value()).setWeight(1).when(inJungleBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.PUPFISH.value())
                        .setWeight(4)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.SARDINE.value())
                        .setWeight(30)
                        .when(inOceanBiome(getterProvider))
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.SIAMESE_FIGHTING_FISH.value())
                        .setWeight(2)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inOceanBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.STINGRAY.value()).setWeight(1).when(inOceanBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.SILVER_STRIPE_BLAASOP.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider))
                        .when(inSnowyBiome(getterProvider)))
                .add(LootItem.lootTableItem(ModItems.TROUT.value())
                        .setWeight(14)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.TUNA.value())
                        .setWeight(2)
                        .when(inOceanBiome(getterProvider))
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.WALLEYE.value())
                        .setWeight(8)
                        .when(InvertedLootItemCondition.invert(inHotBiome(getterProvider)))
                        .when(InvertedLootItemCondition.invert(inColdBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.WHITEMARGIN_STARGAZER.value())
                        .setWeight(2)
                        .when(inHotBiome(getterProvider))
                        .when(inOceanBiome(getterProvider)));
    }

    public static void addFishingJunk(LootPool.Builder lootPoolBuilder, HolderGetter.Provider getterProvider) {
        lootPoolBuilder.add(LootItem.lootTableItem(ModItems.FISH_BONES.value()).setWeight(17))
                .add(LootItem.lootTableItem(ModItems.OLD_BOOT.value()).setWeight(14))
                .add(LootItem.lootTableItem(ModItems.EMPTY_CAN.value()).setWeight(16));
    }

    public static void addFishingTreasure(LootPool.Builder lootPoolBuilder, HolderGetter.Provider getterProvider) {
        lootPoolBuilder.add(LootItem.lootTableItem(Items.EMERALD).setWeight(5))
                .add(LootItem.lootTableItem(ModItems.FISH_FOSSIL.value())
                        .setWeight(10)
                        .when(inOceanBiome(getterProvider))
                        .when(InvertedLootItemCondition.invert(inSnowyBiome(getterProvider))))
                .add(LootItem.lootTableItem(ModItems.PIRATE_TREASURE.value())
                        .setWeight(1)
                        .when(inOceanBiome(getterProvider))
                        .when(InvertedLootItemCondition.invert(inSnowyBiome(getterProvider))));
    }

    private static LootItemCondition.Builder inOceanBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(BiomeTags.IS_OCEAN)));
    }

    private static LootItemCondition.Builder inColdBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(ModRegistry.IS_COLD_BIOME_TAG)));
    }

    private static LootItemCondition.Builder inHotBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(ModRegistry.IS_HOT_BIOME_TAG)));
    }

    private static LootItemCondition.Builder inSnowyBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(ModRegistry.IS_SNOWY_BIOME_TAG)));
    }

    private static LootItemCondition.Builder inRiverBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(BiomeTags.IS_RIVER)));
    }

    private static LootItemCondition.Builder inSwampyBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(ModRegistry.IS_WET_BIOME_TAG)));
    }

    private static LootItemCondition.Builder inJungleBiome(HolderGetter.Provider getterProvider) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location()
                .setBiomes(getterProvider.lookupOrThrow(Registries.BIOME).getOrThrow(BiomeTags.IS_JUNGLE)));
    }
}
