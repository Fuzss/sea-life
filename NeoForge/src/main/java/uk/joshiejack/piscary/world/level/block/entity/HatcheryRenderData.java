package uk.joshiejack.piscary.world.level.block.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public class HatcheryRenderData {
    private final HatcheryBlockEntity blockEntity;
    private final long[] rotations = new long[10];
    private final boolean[] clockwise = new boolean[10];
    private final int[] speed = new int[10];
    private final float[] height = new float[10];
    @Nullable
    private Entity displayEntity;

    public HatcheryRenderData(HatcheryBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    public Entity reload(EntityType<?> entityType, int count, RandomSource randomSource) {
        this.displayEntity = this.getOrCreateDisplayEntity(entityType);
        for (int i = 0; i < count; i++) {
            this.rotations[i] = randomSource.nextInt(720000);
            this.clockwise[i] = randomSource.nextBoolean();
            this.speed[i] = 1 + randomSource.nextInt(5);
            this.height[i] = i;
        }

        return this.displayEntity;
    }

    public void tick() {
        if (this.displayEntity == null) {
            this.reload(this.blockEntity.getEntityType(),
                    this.blockEntity.getCount(),
                    this.blockEntity.getLevel().random);
        }
        for (int i = 0; i < this.blockEntity.getCount(); i++) {
            this.rotations[i] = this.rotations[i] + (this.clockwise[i] ? -this.speed[i] * 10L : this.speed[i] * 10L);
        }

        this.displayEntity.tickCount++;
    }

    @Nullable
    public Entity getOrCreateDisplayEntity(EntityType<?> entityType) {
        if (this.displayEntity == null) {
            return this.displayEntity = this.blockEntity.getEntityType() == null ? null :
                    entityType.create(this.blockEntity.getLevel(), EntitySpawnReason.LOAD);
        } else {
            return this.displayEntity;
        }
    }

    public float getRotation(int i) {
        return (float) (720.0 * (this.rotations[i] & 0x3FFFL) / 0x3FFFL);
    }

    public float getHeight(int i) {
        return this.height[i];
    }

    public boolean isClockwise(int i) {
        return this.clockwise[i];
    }
}
