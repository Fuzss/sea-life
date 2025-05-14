package fuzs.sealife.fabric.client;

import fuzs.sealife.SeaLife;
import fuzs.sealife.client.SeaLifeClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class SeaLifeFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(SeaLife.MOD_ID, SeaLifeClient::new);
    }
}
