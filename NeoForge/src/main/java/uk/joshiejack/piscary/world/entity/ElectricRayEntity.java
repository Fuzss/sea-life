package uk.joshiejack.piscary.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ElectricRayEntity extends FloordwellingFishEntity {

    public ElectricRayEntity(EntityType<? extends ElectricRayEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void playerTouch(Player player) {
        if (this.random.nextFloat() < 0.05F) player.hurt(this.damageSources().lightningBolt(), 3.0F);
    }
}
