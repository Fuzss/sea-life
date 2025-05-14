package uk.joshiejack.piscary.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import uk.joshiejack.piscary.Piscary;

public class PiscarySoundDefinitions extends SoundDefinitionsProvider {
    /**
     * Creates a new instance of this data provider.
     *
     * @param output The {@linkplain PackOutput} instance provided by the data generator.
     * @param helper The existing file helper provided by the event you are initializing this provider in.
     */
    public PiscarySoundDefinitions(PackOutput output, ExistingFileHelper helper) {
        super(output, Piscary.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(Piscary.PiscarySounds.RECYCLER.value(), definition().subtitle("subtitles.recycler")
                .with(sound("recycler_1"), sound("recycler_2"), sound("recycler_3")));
    }

    protected static SoundDefinition.Sound sound(final String name) {
        return sound(new ResourceLocation(Piscary.MOD_ID, name));
    }
}
