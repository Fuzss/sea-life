package fuzs.sealife.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractParticleProvider;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.sealife.init.ModRegistry;

public class ModParticleProvider extends AbstractParticleProvider {

    public ModParticleProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addParticles() {
        this.add(ModRegistry.BUBBLE_PARTICLE_TYPE.value(), ResourceLocationHelper.withDefaultNamespace("bubble"), -1);
    }
}
