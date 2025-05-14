package uk.joshiejack.piscary.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import uk.joshiejack.piscary.init.ModBlocks;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.dropSelf(ModBlocks.RECYCLER.get());
        this.dropSelf(ModBlocks.HATCHERY.get());
        this.dropSelf(ModBlocks.FISH_TRAP.get());
    }
}
