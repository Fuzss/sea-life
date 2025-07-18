package fuzs.sealife.neoforge;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.sealife.SeaLife;
import fuzs.sealife.data.ModRecipeProvider;
import fuzs.sealife.data.loot.ModBlockLootProvider;
import fuzs.sealife.data.loot.ModEntityTypeLootProvider;
import fuzs.sealife.data.loot.ModFishingLootProvider;
import fuzs.sealife.data.loot.ModTreasureItemLootProvider;
import fuzs.sealife.data.tags.*;
import fuzs.sealife.init.ModRegistry;
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
                ModBiomeTagProvider::new,
                ModBlockTagProvider::new,
                ModEntityTypeTagProvider::new,
                ModItemTagProvider::new,
                ModPaintingVariantTagProvider::new,
                ModRecipeProvider::new);
    }
}
