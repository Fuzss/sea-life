package fuzs.sealife.world.item.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HatcheryEntry {
    public static final Codec<HatcheryEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("cycles").forGetter(HatcheryEntry::getCycles),
            BuiltInRegistries.ITEM.byNameCodec().optionalFieldOf("empty_bucket", Items.WATER_BUCKET).forGetter(HatcheryEntry::getWaterBucket),
            BuiltInRegistries.ITEM.byNameCodec().optionalFieldOf("fish_bucket", Items.AIR).forGetter(HatcheryEntry::getFishBucket)
    ).apply(instance, HatcheryEntry::new));
    public static final HatcheryEntry DEFAULT = new HatcheryEntry(3, Items.AIR, Items.AIR);
    private final int cycles;
    private final Item fishBucket;
    private final Item emptyBucket;

    public HatcheryEntry(int cycles, Item emptyBucket, Item bucket) {
        this.cycles = cycles;
        this.emptyBucket = emptyBucket;
        this.fishBucket = bucket;
    }

    public static HatcheryEntry simple(int cycles) {
        return new HatcheryEntry(cycles, Items.WATER_BUCKET, Items.AIR);
    }

    public int getCycles() {
        return cycles;
    }

    public boolean isAir() {
        return fishBucket == Items.AIR;
    }

    public Item getFishBucket() {
        return fishBucket;
    }

    public ItemStack getFishBucket(Level level, EntityType<?> entityType) {
        if (fishBucket != Items.AIR) return new ItemStack(fishBucket);
        if (entityType == null) return ItemStack.EMPTY;
        Entity entity = entityType.create(level, EntitySpawnReason.LOAD);
        return entity instanceof Bucketable fish ? fish.getBucketItemStack() : ItemStack.EMPTY;
    }

    public Item getWaterBucket() {
        return emptyBucket;
    }
}
