package fuzs.sealife.neoforge.client;

import fuzs.sealife.SeaLife;
import fuzs.sealife.client.SeaLifeClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = SeaLife.MOD_ID, dist = Dist.CLIENT)
public class SeaLifeNeoForgeClient {

    public SeaLifeNeoForgeClient() {
        ClientModConstructor.construct(SeaLife.MOD_ID, SeaLifeClient::new);
    }
}
