package fuzs.sealife.fabric;

import fuzs.sealife.SeaLife;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class SeaLifeFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(SeaLife.MOD_ID, SeaLife::new);
    }
}
