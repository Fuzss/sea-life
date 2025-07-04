package fuzs.sealife.neoforge.data.client;

import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.neoforge.api.client.data.v2.AbstractParticleProvider;
import fuzs.puzzleslib.neoforge.api.data.v2.core.NeoForgeDataProviderContext;
import fuzs.sealife.init.ModRegistry;

public class ModParticleProvider extends AbstractParticleProvider {

    public ModParticleProvider(NeoForgeDataProviderContext context) {
        super(context);
    }

    @Override
    public void addParticles() {
        this.add(ModRegistry.BUBBLE_PARTICLE_TYPE.value(), ResourceLocationHelper.withDefaultNamespace("bubble"), -1);
    }
}
