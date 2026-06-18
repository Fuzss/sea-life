package fuzs.sealife.neoforge;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.sealife.common.SeaLife;
import fuzs.sealife.common.data.ModRecipeProvider;
import fuzs.sealife.common.data.loot.ModBlockLootProvider;
import fuzs.sealife.common.data.loot.ModEntityTypeLootProvider;
import fuzs.sealife.common.data.loot.ModFishingLootProvider;
import fuzs.sealife.common.data.loot.ModTreasureItemLootProvider;
import fuzs.sealife.common.data.tags.*;
import fuzs.sealife.common.init.ModRegistry;
import net.neoforged.fml.common.Mod;

@Mod(SeaLife.MOD_ID)
public class SeaLifeNeoForge {

    public SeaLifeNeoForge() {
        ModConstructor.construct(SeaLife.MOD_ID, SeaLife::new);
        DataProviderHelper.registerDataProviders(SeaLife.MOD_ID,
                ModRegistry.REGISTRY_SET_BUILDER,
                ModBlockLootProvider::new,
                ModEntityTypeLootProvider::new,
                ModFishingLootProvider::new,
                ModTreasureItemLootProvider::new,
                ModBiomeTagsProvider::new,
                ModBlockTagsProvider::new,
                ModEntityTypeTagsProvider::new,
                ModItemTagsProvider::new,
                ModPaintingVariantTagsProvider::new,
                ModRecipeProvider::new);
    }
}
