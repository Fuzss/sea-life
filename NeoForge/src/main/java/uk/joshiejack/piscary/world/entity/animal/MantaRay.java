package uk.joshiejack.piscary.world.entity.animal;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import uk.joshiejack.piscary.init.ModItems;

/**
 * TODO make this rideable like pigs
 */
public class MantaRay extends SolitaryFish {

    public MantaRay(EntityType<? extends MantaRay> entityType, Level level) {
        super(entityType, level, ModItems.MANTA_RAY_BUCKET);
    }
}
