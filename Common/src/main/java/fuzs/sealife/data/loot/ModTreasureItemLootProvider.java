package fuzs.sealife.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.sealife.init.ModLootTables;
import fuzs.sealife.init.ModRegistry;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

public class ModTreasureItemLootProvider extends AbstractLootProvider.Simple {

    public ModTreasureItemLootProvider(DataProviderContext context) {
        super(ModRegistry.TREASURE_ITEM_LOOT_CONTEXT_PARAM_SET, context);
    }

    @Override
    public void addLootTables() {
        this.add(ModLootTables.TREASURE_ITEM,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(NestedLootTable.lootTableReference(BuiltInLootTables.BURIED_TREASURE))));
    }
}
