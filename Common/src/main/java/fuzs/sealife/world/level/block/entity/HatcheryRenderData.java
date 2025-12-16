package fuzs.sealife.world.level.block.entity;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

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

    public FishData[] getRawData() {
        return this.data;
    }

    @Nullable
    public Entity getDisplayEntity() {
        return this.displayEntity;
    }

    public void clearDisplayEntity() {
        this.displayEntity = null;
    }

    public static final class FishData {
        private int rotation, oldRotation;
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
            this.rotation = this.oldRotation = rotation;
            this.clockwise = clockwise;
            this.speed = speed;
            this.height = height;
        }

        public void tick() {
            this.oldRotation = this.rotation;
            this.rotation += this.speed * (this.clockwise ? -10 : 10);
        }

        public float getRotation(float partialTick) {
            return Mth.lerp(partialTick, this.getRotationDegrees(this.oldRotation), this.getRotationDegrees(this.rotation));
        }

        private float getRotationDegrees(int rotation) {
            return 720.0F * (rotation & 0x3FFF) / 0x3FFF;
        }

        public boolean isClockwise() {
            return this.clockwise;
        }

        public float getHeight() {
            return this.height;
        }
    }
}
