package fuzs.sealife.common.data.loot;

import fuzs.puzzleslib.common.api.data.v3.loot.AbstractBlockLootSubProvider;
import fuzs.sealife.common.init.ModBlocks;
import net.minecraft.data.loot.LootTableSubProvider;

public class ModBlockLootProvider extends AbstractBlockLootSubProvider {

    public ModBlockLootProvider(LootTableSubProvider.Context output) {
        super(output);
    }

    @Override
    public void generate() {
        this.dropSelf(ModBlocks.FISH_TRAP.value());
        this.dropSelf(ModBlocks.HATCHERY.value());
    }
}
