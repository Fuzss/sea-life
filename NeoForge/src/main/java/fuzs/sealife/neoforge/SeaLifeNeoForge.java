package fuzs.sealife.neoforge;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.sealife.common.SeaLife;
import fuzs.sealife.common.data.ModRecipeProvider;
import fuzs.sealife.common.data.loot.ModBlockLootProvider;
import fuzs.sealife.common.data.loot.ModEntityLootProvider;
import fuzs.sealife.common.data.loot.ModFishingLootProvider;
import fuzs.sealife.common.data.loot.ModTreasureItemLootProvider;
import fuzs.sealife.common.data.tags.*;
import fuzs.sealife.common.init.ModPaintingVariants;
import fuzs.sealife.common.init.ModRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.fml.common.Mod;

@Mod(SeaLife.MOD_ID)
public class SeaLifeNeoForge {

    public SeaLifeNeoForge() {
        ModConstructor.construct(SeaLife.MOD_ID, SeaLife::new);
        DataProviderBuilder.of(SeaLife.MOD_ID)
                .addWorldBootstrap(Registries.PAINTING_VARIANT, ModPaintingVariants::bootstrap)
                .addProvider(ModBiomeTagsProvider::new,
                        ModBlockTagsProvider::new,
                        ModEntityTypeTagsProvider::new,
                        ModItemTagsProvider::new,
                        ModPaintingVariantTagsProvider::new)
                .addLootProvider(ModBlockLootProvider::new, LootContextParamSets.BLOCK)
                .addLootProvider(ModEntityLootProvider::new, LootContextParamSets.ENTITY)
                .addLootProvider(ModFishingLootProvider::new, LootContextParamSets.FISHING)
                .addLootProvider(ModTreasureItemLootProvider::new,
                        ModRegistry.TREASURE_ITEM_LOOT_CONTEXT_PARAM_SET.value())
                .addRecipeProvider(ModRecipeProvider::new);
    }
}
