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
import uk.joshiejack.piscary.init.ModItems;

public class ModEntityTypeLootProvider extends AbstractLootProvider.EntityTypes {

    public ModEntityTypeLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.addFishLootTable(ModEntityTypes.ANCHOVY, ModItems.ANCHOVY);
        this.addFishLootTable(ModEntityTypes.ANGELFISH, ModItems.ANGELFISH);
        this.addFishLootTable(ModEntityTypes.ANGLERFISH,
                ModItems.ANGLERFISH,
                Items.GLOWSTONE_DUST.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.BASS, ModItems.BASS);
        this.addFishLootTable(ModEntityTypes.BLUE_TANG, ModItems.BLUE_TANG, Items.BLUE_DYE.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.BOWFIN, ModItems.BOWFIN);
        this.addFishLootTable(ModEntityTypes.BUTTERFLYFISH, ModItems.BUTTERFLYFISH);
        this.addFishLootTable(ModEntityTypes.CARP, ModItems.CARP);
        this.addFishLootTable(ModEntityTypes.CATFISH, ModItems.CATFISH);
        this.addFishLootTable(ModEntityTypes.CHUB, ModItems.CHUB);
        this.addFishLootTable(ModEntityTypes.DAMSELFISH, ModItems.DAMSELFISH);
        this.addFishLootTable(ModEntityTypes.ELECTRIC_RAY,
                ModItems.ELECTRIC_RAY,
                Items.REDSTONE.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.GOLDFISH,
                ModItems.GOLDFISH,
                Items.GOLD_NUGGET.builtInRegistryHolder());
        this.addFishLootTable(ModEntityTypes.KOI, ModItems.KOI);
        this.addFishLootTable(ModEntityTypes.LAMPREY, ModItems.LAMPREY);
        this.addFishLootTable(ModEntityTypes.LUNGFISH, ModItems.LUNGFISH);
        this.addFishLootTable(ModEntityTypes.MANTA_RAY, ModItems.MANTA_RAY);
        this.addFishLootTable(ModEntityTypes.MINNOW, ModItems.MINNOW);
        this.addFishLootTable(ModEntityTypes.NEON_TETRA, ModItems.NEON_TETRA);
        this.addFishLootTable(ModEntityTypes.NORTHERN_PIKE, ModItems.NORTHERN_PIKE);
        this.addFishLootTable(ModEntityTypes.PERCH, ModItems.PERCH);
        this.addFishLootTable(ModEntityTypes.PICKEREL, ModItems.PICKEREL);
        this.addFishLootTable(ModEntityTypes.PIRANHA, ModItems.PIRANHA);
        this.addFishLootTable(ModEntityTypes.PUPFISH, ModItems.PUPFISH);
        this.addFishLootTable(ModEntityTypes.SARDINE, ModItems.SARDINE);
        this.addFishLootTable(ModEntityTypes.SIAMESE_FIGHTING_FISH, ModItems.SIAMESE_FIGHTING_FISH);
        this.addFishLootTable(ModEntityTypes.WHITEMARGIN_STARGAZER, ModItems.WHITEMARGIN_STARGAZER);
        this.addFishLootTable(ModEntityTypes.STINGRAY, ModItems.STINGRAY);
        this.addFishLootTable(ModEntityTypes.SILVER_STRIPE_BLAASOP, ModItems.SILVER_STRIPE_BLAASOP);
        this.addFishLootTable(ModEntityTypes.TROUT, ModItems.TROUT);
        this.addFishLootTable(ModEntityTypes.TUNA, ModItems.TUNA);
        this.addFishLootTable(ModEntityTypes.WALLEYE, ModItems.WALLEYE);
    }

    private void addFishLootTable(Holder<? extends EntityType<?>> entityType, Holder<Item> fishItem) {
        this.addFishLootTable(entityType, fishItem, Items.BONE_MEAL.builtInRegistryHolder());
    }

    private void addFishLootTable(Holder<? extends EntityType<?>> entityType, Holder<Item> fishItem, Holder<Item> bonusItem) {
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
