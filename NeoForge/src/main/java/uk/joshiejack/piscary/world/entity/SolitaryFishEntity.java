package uk.joshiejack.piscary.world.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import uk.joshiejack.piscary.Piscary;

import javax.annotation.Nonnull;

public class SolitaryFishEntity extends AbstractFish {

    public SolitaryFishEntity(EntityType<? extends SolitaryFishEntity> entity, Level world) {
        super(entity, world);
    }

    public static AttributeSupplier.Builder createSpecialAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D);
    }

    @Nonnull
    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(Piscary.MODID,
                BuiltInRegistries.ENTITY_TYPE.getKey(getType()).getPath() + "_bucket")));
    }

    @Nonnull
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    @Override
    public EntityDimensions getDimensions(Pose p_213305_1_) {
        return EntityDimensions.scalable(0.9F, 0.3F);
    }
}
