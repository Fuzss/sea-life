package uk.joshiejack.piscary.world.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class StingRayEntity extends FloordwellingFishEntity {

    public StingRayEntity(EntityType<? extends StingRayEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void playerTouch(Player player) {
        if (this.random.nextFloat() < 0.1F && !player.hasEffect(MobEffects.POISON)) {
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 300));
        }
    }
}
