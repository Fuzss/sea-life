package uk.joshiejack.piscary.world.block.entity;

import fuzs.puzzleslib.api.block.v1.entity.TickingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import uk.joshiejack.piscary.client.renderer.HatcheryFishRender;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;

public class HatcheryBlockEntity extends BlockEntity implements TickingBlockEntity {
    static final int TIME_UNITS = 24_000;
    static final String TAG_ENTITY = "Entity";
    static final String TAG_COUNT = "Count";
    static final String TAG_TICKS_PASSED = "TicksPassed";
    static final String TAG_TIMES_PULLED = "TimesPulled";

    @Nullable
    private EntityType<?> entityType;
    private int count = 0;
    private int ticksPassed = 0;
    private int breakChance = 125;
    @Nullable
    private HatcheryFishRender renderer;

    public HatcheryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(PiscaryBlockEntities.HATCHERY.value(), blockPos, blockState);
    }

    public boolean isEmpty() {
        return this.entityType == null || this.count <= 0;
    }

    public void setEntityTypeAndCount(EntityType<?> type, int count) {
        this.entityType = type;
        this.count = count;
        this.markUpdated();
        if (!this.level.isClientSide) {
            this.setChanged();
        } else {
            this.getRenderer().reloadFish(this.entityType, count, this.level.random);
        }
    }

    @Override
    public void serverTick() {
        serverTick(this.getLevel(), this.getBlockPos(), this);
    }

    public static void serverTick(Level level, BlockPos pos, HatcheryBlockEntity entity) {
        if (entity.getEntityType() == null) return;
        if (level.isClientSide) {
            entity.getRenderer().updateFish();
        }
        if (level.getGameTime() % 100 == 0 && entity.count < 10) {
            int ticksRequired = PiscaryRegistries.getCycles(entity.getEntityType()) * TIME_UNITS;
            if (ticksRequired >= 1) {
                entity.ticksPassed += 100;
                if (entity.ticksPassed >= ticksRequired) {
                    entity.ticksPassed = 0; //Reset
                    entity.count++;
                    entity.setEntityTypeAndCount(entity.entityType, entity.count);
                }
            }
        }
    }

    public LivingEntity extractFish(boolean adjustCount) {
        Entity entity = this.entityType.spawn((ServerLevel) this.level,
                ItemStack.EMPTY,
                null,
                this.worldPosition,
                EntitySpawnReason.BUCKET,
                true,
                false);
        if (entity != null) {
            ((Bucketable) entity).setFromBucket(true);
        }

        if (adjustCount) {
            this.count--;
            this.setEntityTypeAndCount(this.entityType, this.count);
        }

        return (LivingEntity) entity;
    }

    public void spawnFish(int count) {
        if (this.entityType != null) {
            for (int i = 0; i < count; i++) {
                this.extractFish(false);
            }
        }
    }

    public void removeFish() {
        this.count--;
        if (this.level.random.nextInt(100) > this.breakChance) {
            BlockState state = this.level.getBlockState(this.worldPosition);
            this.level.setBlock(this.worldPosition, Blocks.WATER.defaultBlockState(), 2);
            this.level.levelEvent(null, 2001, this.worldPosition, Block.getId(state));
            this.spawnFish(this.count);
            return;
        } else {
            this.breakChance -= 25;
        }

        this.breakChance = Mth.clamp(this.breakChance, 0, 100);
        this.markUpdated();
    }

    public HatcheryFishRender getRenderer() {
        if (this.renderer == null) this.renderer = new HatcheryFishRender(this);
        return this.renderer;
    }

    @Nullable
    public EntityType<?> getEntityType() {
        return this.entityType;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.entityType = tag.read(TAG_ENTITY, BuiltInRegistries.ENTITY_TYPE.byNameCodec()).orElse(null);
        this.count = tag.getByteOr(TAG_COUNT, (byte) 0);
        this.ticksPassed = tag.getIntOr(TAG_TICKS_PASSED, 0);
        this.breakChance = tag.getByteOr(TAG_TIMES_PULLED, (byte) 0);
        if (this.level.isClientSide) {
            this.getRenderer().reloadFish(this.entityType, this.count, this.level.random);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.storeNullable(TAG_ENTITY, BuiltInRegistries.ENTITY_TYPE.byNameCodec(), this.entityType);
        tag.putByte(TAG_COUNT, (byte) this.count);
        tag.putInt(TAG_TICKS_PASSED, this.ticksPassed);
        tag.putByte(TAG_TIMES_PULLED, (byte) this.breakChance);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
}
