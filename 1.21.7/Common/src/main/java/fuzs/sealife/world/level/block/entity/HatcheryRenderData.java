package fuzs.sealife.world.level.block.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class HatcheryRenderData {
    private FishData[] data = new FishData[0];
    @Nullable
    private Entity displayEntity;

    public void reload(Level level, @Nullable EntityType<?> entityType, int count) {
        this.displayEntity = entityType != null ? entityType.create(level, EntitySpawnReason.LOAD) : null;
        FishData[] data = new FishData[entityType != null ? count : 0];
        for (int i = 0; i < data.length; i++) {
            data[i] = i < this.data.length ? this.data[i] : new FishData(level.getRandom());
        }

        this.data = data;
    }

    public void tick() {
        if (this.displayEntity != null) {
            this.displayEntity.tickCount++;
            for (FishData fishData : this.data) {
                fishData.tick();
            }
        }
    }

    @Nullable
    public Entity getDisplayEntity() {
        return this.displayEntity;
    }

    public int getCount() {
        return this.data.length;
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
