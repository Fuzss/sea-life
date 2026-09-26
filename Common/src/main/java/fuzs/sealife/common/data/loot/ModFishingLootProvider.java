package fuzs.sealife.common.data.loot;

import fuzs.puzzleslib.common.api.data.v3.loot.AbstractLootSubProvider;
import fuzs.sealife.common.init.ModLootTables;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

public class ModFishingLootProvider extends AbstractLootSubProvider {

    public ModFishingLootProvider(LootTableSubProvider.Context output) {
        super(output);
    }

    @Override
    public void generate() {
        Holder.Reference<LootTable> fishingFish = this.output.lookup(Registries.LOOT_TABLE)
                .getOrThrow(BuiltInLootTables.FISHING_FISH);
        Holder.Reference<LootTable> fishingJunk = this.output.lookup(Registries.LOOT_TABLE)
                .getOrThrow(BuiltInLootTables.FISHING_JUNK);
        this.output.accept(ModLootTables.FISH_TRAP,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(NestedLootTable.lootTableReference(fishingFish).setWeight(3))
                                .add(NestedLootTable.lootTableReference(fishingJunk).setWeight(1))));
    }
}
