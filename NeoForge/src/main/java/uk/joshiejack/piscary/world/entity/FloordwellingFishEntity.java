package uk.joshiejack.piscary.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class FloordwellingFishEntity extends SolitaryFishEntity {

    public FloordwellingFishEntity(EntityType<? extends FloordwellingFishEntity> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2,
                new AvoidEntityGoal<>(this, Player.class, 4.0F, 0.8D, 0.7D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(4, new SwimGoal(this));
    }

    static class SwimGoal extends RandomSwimmingGoal {

        public SwimGoal(AbstractFish abstractFish) {
            super(abstractFish, 1.0D, 40);
        }

        @Nullable
        protected Vec3 getPosition() {
            Vec3 vector3d = DefaultRandomPos.getPos(this.mob, 1, 1);
            for (int i = 0; vector3d != null && !this.mob.level()
                    .getBlockState(BlockPos.containing(vector3d))
                    .isPathfindable(PathComputationType.WATER) && this.mob.level()
                    .getBlockState(BlockPos.containing(vector3d).below())
                    .getFluidState()
                    .is(FluidTags.WATER) && i++ < 10; vector3d = DefaultRandomPos.getPos(this.mob, 10, 1)) {
            }

            return vector3d;
        }
    }
}
