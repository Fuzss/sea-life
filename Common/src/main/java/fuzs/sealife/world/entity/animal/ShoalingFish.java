package fuzs.sealife.world.entity.animal;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.OptionalInt;

public class ShoalingFish extends AbstractSchoolingFish {
    private final Holder<Item> bucketItem;
    private final OptionalInt maxSchoolSize;

    public ShoalingFish(EntityType<? extends ShoalingFish> entityType, Level level, Holder<Item> bucketItem) {
        this(entityType, level, bucketItem, OptionalInt.empty());
    }

    public ShoalingFish(EntityType<? extends ShoalingFish> entityType, Level level, Holder<Item> bucketItem, OptionalInt maxSchoolSize) {
        super(entityType, level);
        this.bucketItem = bucketItem;
        this.maxSchoolSize = maxSchoolSize;
    }

    public static <T extends ShoalingFish> EntityType.EntityFactory<T> create(Holder<Item> bucketItem) {
        return (EntityType<T> entityType, Level level) -> (T) new ShoalingFish(entityType, level, bucketItem);
    }

    public static <T extends ShoalingFish> EntityType.EntityFactory<T> create(Holder<Item> bucketItem, int maxSchoolSize) {
        return (EntityType<T> entityType, Level level) -> (T) new ShoalingFish(entityType,
                level,
                bucketItem,
                OptionalInt.of(maxSchoolSize));
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(this.bucketItem);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public int getMaxSchoolSize() {
        return this.maxSchoolSize.orElseGet(super::getMaxSchoolSize);
    }
}
