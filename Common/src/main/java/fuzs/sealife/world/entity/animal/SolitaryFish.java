package fuzs.sealife.world.entity.animal;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.fish.AbstractFish;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class SolitaryFish extends AbstractFish {
    private final Holder<Item> bucketItem;

    public SolitaryFish(EntityType<? extends SolitaryFish> entityType, Level level, Holder<Item> bucketItem) {
        super(entityType, level);
        this.bucketItem = bucketItem;
    }

    public static <T extends SolitaryFish> EntityType.EntityFactory<T> create(Supplier<Holder<Item>> bucketItemSupplier) {
        return (EntityType<T> entityType, Level level) -> (T) new SolitaryFish(entityType,
                level,
                bucketItemSupplier.get());
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(this.bucketItem);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }
}
