package uk.joshiejack.piscary.world.entity.animal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import uk.joshiejack.piscary.init.PiscaryItems;

public class StingRay extends AbstractRay {

    public StingRay(EntityType<? extends StingRay> entityType, Level level) {
        super(entityType, level, PiscaryItems.STINGRAY_BUCKET);
    }

    @Override
    protected float getApplyEffectChance() {
        return 0.1F;
    }

    @Override
    protected void touch(ServerLevel serverLevel, Mob mob) {
        if (mob.hurtServer(serverLevel, this.damageSources().lightningBolt(), 1.0F) &&
                !mob.hasEffect(MobEffects.POISON)) {
            mob.addEffect(new MobEffectInstance(MobEffects.POISON, 150, 0), this);
            this.playSound(SoundEvents.PUFFER_FISH_STING, 1.0F, 1.0F);
        }
    }
}
