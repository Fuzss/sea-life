package fuzs.sealife.neoforge;

import fuzs.puzzleslib.api.event.v1.server.LootTableLoadCallback;
import fuzs.sealife.SeaLife;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.neoforged.fml.common.Mod;
import uk.joshiejack.piscary.init.ModLootTables;

@Mod(SeaLife.MOD_ID)
public class SeaLifeNeoForge {

    public SeaLifeNeoForge() {
        ModConstructor.construct(SeaLife.MOD_ID, SeaLife::new);
        LootTableLoadCallback.EVENT.register(ModLootTables::onLootTableLoad);
    }
}
