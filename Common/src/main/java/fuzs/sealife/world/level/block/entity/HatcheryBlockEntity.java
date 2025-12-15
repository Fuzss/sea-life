package fuzs.sealife.world.level.block.entity;

import fuzs.puzzleslib.api.block.v1.entity.TickingBlockEntity;
import fuzs.sealife.SeaLife;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.world.level.block.HatcheryBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

public class HatcheryBlockEntity extends BlockEntity implements TickingBlockEntity {
    static final String TAG_ENTITY = "Entity";
    static final String TAG_COUNT = "Count";

    private final HatcheryRenderData renderer = new HatcheryRenderData();
    @Nullable
    private EntityType<?> entityType;
    private int count;

    public HatcheryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlocks.HATCHERY_BLOCK_ENTITY_TYPE.value(), blockPos, blockState);
    }

    @Override
    public void clientTick() {
        if (!this.isEmpty()) {
            this.getRenderData().tick();
        }
    }

    public boolean isEmpty() {
        return this.entityType == null || this.count == 0;
    }

    private void setFish(@Nullable EntityType<?> entityType, int count) {
        if (entityType == null || this.entityType == null || this.entityType == entityType) {
            this.entityType = entityType;
            this.count = count;
            if (this.hasLevel()) {
                if (this.getLevel().isClientSide()) {
                    this.renderer.reload(this.getLevel(), entityType, count);
                } else {
                    this.markUpdated();
                }
            } else {
                this.renderer.clearDisplayEntity();
            }
        } else {
            SeaLife.LOGGER.warn("Unable to update hatchery at {}", this.getBlockPos());
        }
    }

    public void addFish(@Nullable EntityType<?> entityType, int amount) {
        int count = entityType != null ? Math.clamp(this.count + amount, 0, HatcheryBlock.MAX_CAPACITY) : 0;
        this.setFish(count == 0 ? null : entityType, count);
    }

    public void removeFish(int count, boolean spawnEntity) {
        if (this.entityType != null) {
            count = Math.min(this.count, count);
            for (int i = 0; i < count; i++) {
                if (spawnEntity) {
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
                }
                this.addFish(this.entityType, -1);
            }
        }
    }

    public HatcheryRenderData getRenderData() {
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
    protected void loadAdditional(ValueInput valueInput) {
        super.loadAdditional(valueInput);
        EntityType<?> entityType = valueInput.read(TAG_ENTITY, BuiltInRegistries.ENTITY_TYPE.byNameCodec())
                .orElse(null);
        int count = valueInput.getByteOr(TAG_COUNT, (byte) 0);
        this.setFish(entityType, count);
    }

    @Override
    protected void saveAdditional(ValueOutput valueOutput) {
        super.saveAdditional(valueOutput);
        valueOutput.storeNullable(TAG_ENTITY, BuiltInRegistries.ENTITY_TYPE.byNameCodec(), this.entityType);
        valueOutput.putByte(TAG_COUNT, (byte) this.count);
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
        if (this.level != null) {
            this.level.sendBlockUpdated(this.getBlockPos(),
                    this.getBlockState(),
                    this.getBlockState(),
                    Block.UPDATE_ALL);
        }
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        if (this.hasLevel()) {
            this.removeFish(this.count, true);
        }
    }
}
