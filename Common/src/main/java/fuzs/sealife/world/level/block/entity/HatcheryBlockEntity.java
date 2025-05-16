package fuzs.sealife.world.level.block.entity;

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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.init.ModRegistry;

public class HatcheryBlockEntity extends BlockEntity implements TickingBlockEntity {
    static final int TIME_UNITS = 24_000;
    static final int COMMON_CYCLES = 3;
    static final int UNCOMMON_CYCLES = 5;
    static final int RARE_CYCLES = 7;
    static final String TAG_ENTITY = "Entity";
    static final String TAG_COUNT = "Count";
    static final String TAG_TICKS_PASSED = "TicksPassed";
    static final String TAG_TIMES_PULLED = "TimesPulled";

    @Nullable
    private EntityType<?> entityType;
    private int count;
    private int ticksPassed;
    private int breakChance = 128;
    @Nullable
    private HatcheryRenderData renderer;

    public HatcheryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlocks.HATCHERY_BLOCK_ENTITY_TYPE.value(), blockPos, blockState);
    }

    public boolean isEmpty() {
        return this.entityType == null || this.count == 0;
    }

    public void setEntityTypeAndCount(EntityType<?> entityType, int count) {
        this.entityType = entityType;
        this.count = count;
        this.markUpdated();
        if (!this.getLevel().isClientSide) {
            this.setChanged();
        } else {
            this.getRenderData().reload(this.entityType, count, this.getLevel().random);
        }
    }

    @Override
    public void clientTick() {
        if (this.getEntityType() != null) {
            this.getRenderData().tick();
        }
    }

    @Override
    public void serverTick() {
        if (this.getEntityType() != null) {
            if (this.getLevel().getGameTime() % 100 == 0 && this.count < 10) {
                int ticksRequired = getHatchingCycles(this.getEntityType()) * TIME_UNITS;
                if (ticksRequired > 0) {
                    this.ticksPassed += 100;
                    if (this.ticksPassed >= ticksRequired) {
                        this.ticksPassed = 0;
                        this.count++;
                        this.setEntityTypeAndCount(this.entityType, this.count);
                    }
                }
            }
        }
    }

    public static int getHatchingCycles(EntityType<?> entityType) {
        if (entityType.is(ModRegistry.COMMON_FISHES_ENTITY_TYPE_TAG)) {
            return COMMON_CYCLES;
        } else if (entityType.is(ModRegistry.UNCOMMON_FISHES_ENTITY_TYPE_TAG)) {
            return UNCOMMON_CYCLES;
        } else if (entityType.is(ModRegistry.RARE_FISHES_ENTITY_TYPE_TAG)) {
            return RARE_CYCLES;
        } else {
            return 0;
        }
    }

    public void extractFish(boolean adjustCount) {
        Entity entity = this.entityType.spawn((ServerLevel) this.getLevel(),
                ItemStack.EMPTY,
                null,
                this.worldPosition,
                EntitySpawnReason.BUCKET,
                true,
                false);
        if (entity instanceof Bucketable bucketable) {
            bucketable.setFromBucket(true);
        }

        if (adjustCount) {
            this.count--;
            this.setEntityTypeAndCount(this.entityType, this.count);
        }
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
        if (this.getLevel().random.nextInt(100) > this.breakChance) {
            BlockState state = this.getLevel().getBlockState(this.worldPosition);
            this.getLevel().setBlock(this.worldPosition, Blocks.WATER.defaultBlockState(), 2);
            this.getLevel()
                    .levelEvent(null, LevelEvent.PARTICLES_DESTROY_BLOCK, this.worldPosition, Block.getId(state));
            this.spawnFish(this.count);
            return;
        } else {
            this.breakChance -= 25;
        }

        this.breakChance = Mth.clamp(this.breakChance, 0, 100);
        this.markUpdated();
    }

    public HatcheryRenderData getRenderData() {
        if (this.renderer == null) {
            return this.renderer = new HatcheryRenderData(this);
        } else {
            return this.renderer;
        }
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
        if (this.getLevel().isClientSide) {
            this.getRenderData().reload(this.entityType, this.count, this.getLevel().random);
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

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        if (this.hasLevel()) {
            this.spawnFish(this.getCount());
        }
    }
}
