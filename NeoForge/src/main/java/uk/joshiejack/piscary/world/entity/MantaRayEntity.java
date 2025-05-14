package uk.joshiejack.piscary.world.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class MantaRayEntity extends SolitaryFishEntity {

    public MantaRayEntity(EntityType<? extends MantaRayEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected boolean canRide(Entity entity) {
        return true;
    }
}
