package fuzs.sealife.common.data.client;

import fuzs.puzzleslib.common.api.client.data.v2.AbstractParticleProvider;
import net.minecraft.resources.Identifier;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.sealife.common.init.ModRegistry;

public class ModParticleProvider extends AbstractParticleProvider {

    public ModParticleProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addParticles() {
        this.add(ModRegistry.BUBBLE_PARTICLE_TYPE.value(), Identifier.withDefaultNamespace("bubble"), -1);
    }
}
