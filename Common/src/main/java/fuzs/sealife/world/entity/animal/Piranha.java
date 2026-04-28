package fuzs.sealife.world.entity.animal;

import fuzs.sealife.init.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FollowPlayerRiddenEntityGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.nautilus.AbstractNautilus;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.level.Level;

public class Piranha extends SolitaryFish {

    public Piranha(EntityType<? extends SolitaryFish> entityType, Level level) {
        super(entityType, level, ModItems.PIRANHA_BUCKET);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2F, true));
        this.goalSelector.addGoal(3, new FollowPlayerRiddenEntityGoal(this, AbstractBoat.class));
        this.goalSelector.addGoal(3, new FollowPlayerRiddenEntityGoal(this, AbstractNautilus.class));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 40));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
}
