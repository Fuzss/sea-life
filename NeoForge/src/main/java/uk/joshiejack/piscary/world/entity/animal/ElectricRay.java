package uk.joshiejack.piscary.world.entity.animal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import uk.joshiejack.piscary.init.PiscaryItems;

public class ElectricRay extends AbstractRay {

    public ElectricRay(EntityType<? extends ElectricRay> entityType, Level level) {
        super(entityType, level, PiscaryItems.ELECTRIC_RAY_BUCKET);
    }

    @Override
    protected float getApplyEffectChance() {
        return 0.05F;
    }

    @Override
    protected void touch(ServerLevel serverLevel, Mob mob) {
        if (mob.hurtServer(serverLevel, this.damageSources().lightningBolt(), 3.0F)) {
            this.playSound(SoundEvents.PUFFER_FISH_STING, 1.0F, 1.0F);
        }
    }
}
