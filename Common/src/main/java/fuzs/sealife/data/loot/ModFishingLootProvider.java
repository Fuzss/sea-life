package fuzs.sealife.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.sealife.init.ModLootTables;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModFishingLootProvider extends AbstractLootProvider.Simple {

    public ModFishingLootProvider(DataProviderContext context) {
        super(LootContextParamSets.FISHING, context);
    }

    @Override
    public void addLootTables() {
        this.skipValidation(ModLootTables.FISH_TRAP);
        this.add(ModLootTables.FISH_TRAP,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(NestedLootTable.lootTableReference(BuiltInLootTables.FISHING_FISH).setWeight(3))
                                .add(NestedLootTable.lootTableReference(BuiltInLootTables.FISHING_JUNK).setWeight(1))));
    }
}
