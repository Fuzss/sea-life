package fuzs.sealife.world.level.block;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import fuzs.puzzleslib.api.block.v1.entity.TickingEntityBlock;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.world.level.block.entity.HatcheryBlockEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Collections;
import java.util.Map;

public class HatcheryBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, TickingEntityBlock<HatcheryBlockEntity> {
    public static final MapCodec<HatcheryBlock> CODEC = simpleCodec(HatcheryBlock::new);
    static Map<EntityType<?>, Item> bucketableMobs = Collections.emptyMap();

    public HatcheryBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public static void onLoadComplete() {
        ImmutableMap.Builder<EntityType<?>, Item> builder = ImmutableMap.builder();
        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof MobBucketItem mobBucketItem) {
                builder.put(mobBucketItem.type, item);
            }
        }
        bucketableMobs = builder.build();
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemInHand, BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof HatcheryBlockEntity blockEntity) {
            if (itemInHand.is(Items.WATER_BUCKET)) {
                if (!blockEntity.isEmpty()) {
                    Item item = bucketableMobs.get(blockEntity.getEntityType());
                    if (item != null) {
                        ItemStack itemStack = new ItemStack(item);
                        ItemStack resultItemStack = ItemUtils.createFilledResult(itemInHand, player, itemStack);
                        if (!level.isClientSide()) {
                            blockEntity.removeFish();
                            CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, itemStack);
                            player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
                        }
                        return InteractionResult.SUCCESS.heldItemTransformedTo(resultItemStack);
                    }
                }
            } else if (itemInHand.getItem() instanceof MobBucketItem item) {
                ItemStack itemStack = new ItemStack(Items.WATER_BUCKET);
                ItemStack resultItemStack = ItemUtils.createFilledResult(itemInHand, player, itemStack);
                if (!level.isClientSide()) {
                    CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, resultItemStack);
                    player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
                    blockEntity.setEntityTypeAndCount(item.type, blockEntity.getCount() + 1);
                }
                return InteractionResult.SUCCESS.heldItemTransformedTo(resultItemStack);
            }
        } else {
            return InteractionResult.PASS;
        }

        return super.useItemOn(itemInHand, state, level, pos, player, interactionHand, hitResult);
    }

    @Override
    public BlockEntityType<? extends HatcheryBlockEntity> getBlockEntityType() {
        return ModBlocks.HATCHERY_BLOCK_ENTITY_TYPE.value();
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return level.getBlockEntity(pos) instanceof HatcheryBlockEntity blockEntity ? blockEntity.getCount() : 0;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }
}