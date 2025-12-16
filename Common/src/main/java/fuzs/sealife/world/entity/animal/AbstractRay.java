package fuzs.sealife.world.entity.animal;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.fish.Pufferfish;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public abstract class AbstractRay extends FloordwellingFish {

    public AbstractRay(EntityType<? extends AbstractRay> entityType, Level level, Holder<Item> bucketItem) {
        super(entityType, level, bucketItem);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level() instanceof ServerLevel serverLevel && this.isAlive()
                && this.random.nextFloat() < this.getApplyEffectChance()) {
            for (Mob mob : this.level()
                    .getEntitiesOfClass(Mob.class,
                            this.getBoundingBox().inflate(0.3),
                            (Mob mobX) -> Pufferfish.TARGETING_CONDITIONS.test(serverLevel, this, mobX))) {
                if (mob.isAlive()) {
                    this.touch(serverLevel, mob);
                }
            }
        }
    }

    protected abstract float getApplyEffectChance();

    protected abstract void touch(ServerLevel serverLevel, Mob mob);
}
