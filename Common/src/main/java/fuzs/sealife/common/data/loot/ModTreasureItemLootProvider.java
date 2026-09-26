package fuzs.sealife.common.data.loot;

import fuzs.puzzleslib.common.api.data.v3.loot.AbstractLootSubProvider;
import fuzs.sealife.common.init.ModLootTables;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

public class ModTreasureItemLootProvider extends AbstractLootSubProvider {

    public ModTreasureItemLootProvider(LootTableSubProvider.Context output) {
        super(output);
    }

    @Override
    public void generate() {
        this.output.accept(ModLootTables.TREASURE_ITEM,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(NestedLootTable.lootTableReference(this.output.lookup(Registries.LOOT_TABLE)
                                        .getOrThrow(BuiltInLootTables.BURIED_TREASURE)))));
    }
}
