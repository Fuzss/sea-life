package fuzs.sealife.common.data.loot;

import fuzs.puzzleslib.common.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.sealife.common.init.ModBlocks;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.dropSelf(ModBlocks.FISH_TRAP.value());
        this.dropSelf(ModBlocks.HATCHERY.value());
    }
}
