package uk.joshiejack.piscary.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import uk.joshiejack.piscary.init.ModEntityTypes;
import uk.joshiejack.piscary.init.PiscaryItems;

public class ModEntityTypeLootProvider extends AbstractLootProvider.EntityTypes {

    public ModEntityTypeLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.addFishLootTable(ModEntityTypes.ANCHOVY, PiscaryItems.ANCHOVY);
        this.addFishLootTable(ModEntityTypes.ANGELFISH, PiscaryItems.ANGELFISH);
        this.addFishLootTable(ModEntityTypes.ANGLERFISH,
                PiscaryItems.ANGLERFISH,
                Items.GLOWSTONE_DUST.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.BASS, PiscaryItems.BASS);
        this.addFishLootTable(ModEntityTypes.BLUE_TANG,
                PiscaryItems.BLUE_TANG,
                Items.BLUE_DYE.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.BOWFIN, PiscaryItems.BOWFIN);
        this.addFishLootTable(ModEntityTypes.BUTTERFLYFISH, PiscaryItems.BUTTERFLYFISH);
        this.addFishLootTable(ModEntityTypes.CARP, PiscaryItems.CARP);
        this.addFishLootTable(ModEntityTypes.CATFISH, PiscaryItems.CATFISH);
        this.addFishLootTable(ModEntityTypes.CHUB, PiscaryItems.CHUB);
        this.addFishLootTable(ModEntityTypes.DAMSELFISH, PiscaryItems.DAMSELFISH);
        this.addFishLootTable(ModEntityTypes.ELECTRIC_RAY,
                PiscaryItems.ELECTRIC_RAY,
                Items.REDSTONE.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.GOLDFISH,
                PiscaryItems.GOLDFISH,
                Items.GOLD_NUGGET.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.KOI, PiscaryItems.KOI);
        this.addFishLootTable(ModEntityTypes.LAMPREY, PiscaryItems.LAMPREY);
        this.addFishLootTable(ModEntityTypes.LUNGFISH, PiscaryItems.LUNGFISH);
        this.addFishLootTable(ModEntityTypes.MANTA_RAY, PiscaryItems.MANTA_RAY);
        this.addFishLootTable(ModEntityTypes.MINNOW, PiscaryItems.MINNOW);
        this.addFishLootTable(ModEntityTypes.NEON_TETRA, PiscaryItems.NEON_TETRA);
        this.addFishLootTable(ModEntityTypes.NORTHERN_PIKE, PiscaryItems.NORTHERN_PIKE);
        this.addFishLootTable(ModEntityTypes.PERCH, PiscaryItems.PERCH);
        this.addFishLootTable(ModEntityTypes.PICKEREL, PiscaryItems.PICKEREL);
        this.addFishLootTable(ModEntityTypes.PIRANHA, PiscaryItems.PIRANHA);
        this.addFishLootTable(ModEntityTypes.PUPFISH, PiscaryItems.PUPFISH);
        this.addFishLootTable(ModEntityTypes.SARDINE, PiscaryItems.SARDINE);
        this.addFishLootTable(ModEntityTypes.SIAMESE_FIGHTING_FISH, PiscaryItems.SIAMESE_FIGHTING_FISH);
        this.addFishLootTable(ModEntityTypes.WHITEMARGIN_STARGAZER, PiscaryItems.WHITEMARGIN_STARGAZER);
        this.addFishLootTable(ModEntityTypes.STINGRAY, PiscaryItems.STINGRAY);
        this.addFishLootTable(ModEntityTypes.SILVER_STRIPE_BLAASOP, PiscaryItems.SILVER_STRIPE_BLAASOP);
        this.addFishLootTable(ModEntityTypes.TROUT, PiscaryItems.TROUT);
        this.addFishLootTable(ModEntityTypes.TUNA, PiscaryItems.TUNA);
        this.addFishLootTable(ModEntityTypes.WALLEYE, PiscaryItems.WALLEYE);
    }

    private void addFishLootTable(Holder<EntityType<?>> entityType, Holder<Item> fishItem) {
        this.addFishLootTable(entityType, fishItem, Items.BONE_MEAL.builtInRegistryHolder());
    }

    private void addFishLootTable(Holder<EntityType<?>> entityType, Holder<Item> fishItem, Holder<Item> bonusItem) {
        this.add(entityType.value(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(fishItem.value())
                                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(bonusItem.value()))
                                .when(LootItemRandomChanceCondition.randomChance(0.05F))));
    }
}
