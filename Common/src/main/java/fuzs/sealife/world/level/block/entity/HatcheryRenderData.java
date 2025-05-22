package fuzs.sealife.world.level.block.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HatcheryRenderData {
    private final HatcheryBlockEntity blockEntity;
    private FishData[] data = new FishData[0];
    @Nullable
    private Entity displayEntity;

    public HatcheryRenderData(HatcheryBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    public void reload(EntityType<?> entityType, int count, RandomSource randomSource) {
        this.displayEntity = this.getOrCreateDisplayEntity(entityType);
        FishData[] data = new FishData[count];
        for (int i = 0; i < data.length; i++) {
            data[i] = i < this.data.length ? this.data[i] : new FishData(randomSource);
        }

        this.data = data;
    }

    public void tick() {
        if (this.displayEntity == null) {
            this.reload(this.blockEntity.getEntityType(),
                    this.blockEntity.getCount(),
                    this.blockEntity.getLevel().getRandom());
        }

        for (FishData fishData : this.data) {
            fishData.tick();
        }

        this.displayEntity.tickCount++;
    }

    @Nullable
    public Entity getOrCreateDisplayEntity(EntityType<?> entityType) {
        if (this.displayEntity == null) {
            Objects.requireNonNull(this.blockEntity.getLevel(), "level is null");
            return this.displayEntity = this.blockEntity.getEntityType() == null ? null :
                    entityType.create(this.blockEntity.getLevel(), EntitySpawnReason.LOAD);
        } else {
            return this.displayEntity;
        }
    }

    public void clearDisplayEntity() {
        this.displayEntity = null;
    }

    public float getRotation(int index) {
        return this.data[index].getRotation();
    }

    public float getHeight(int index) {
        return this.data[index].getHeight();
    }

    public boolean isClockwise(int index) {
        return this.data[index].isClockwise();
    }

    public static final class FishData {
        private int rotation;
        private final boolean clockwise;
        private final int speed;
        private final float height;

        public FishData(RandomSource randomSource) {
            this(randomSource.nextInt(720_000),
                    randomSource.nextBoolean(),
                    1 + randomSource.nextInt(5),
                    randomSource.nextFloat() * 9.0F);
        }

        public FishData(int rotation, boolean clockwise, int speed, float height) {
            this.rotation = rotation;
            this.clockwise = clockwise;
            this.speed = speed;
            this.height = height;
        }

        public void tick() {
            this.rotation += this.speed * (this.clockwise ? -10 : 10);
        }

        public float getRotation() {
            return 720.0F * (this.rotation & 0x3FFF) / 0x3FFF;
        }

        public boolean isClockwise() {
            return this.clockwise;
        }

        public float getHeight() {
            return this.height;
        }
    }
}
