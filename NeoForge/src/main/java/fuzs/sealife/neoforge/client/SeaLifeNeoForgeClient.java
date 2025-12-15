package fuzs.sealife.neoforge.client;

import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.sealife.SeaLife;
import fuzs.sealife.client.SeaLifeClient;
import fuzs.sealife.data.client.ModLanguageProvider;
import fuzs.sealife.data.client.ModModelProvider;
import fuzs.sealife.data.client.ModParticleProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = SeaLife.MOD_ID, dist = Dist.CLIENT)
public class SeaLifeNeoForgeClient {

    public SeaLifeNeoForgeClient() {
        ClientModConstructor.construct(SeaLife.MOD_ID, SeaLifeClient::new);
        DataProviderHelper.registerDataProviders(SeaLife.MOD_ID,
                ModLanguageProvider::new,
                ModModelProvider::new,
                ModParticleProvider::new);
    }
}
