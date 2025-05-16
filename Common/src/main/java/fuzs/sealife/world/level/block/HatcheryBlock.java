package fuzs.sealife.world.level.block;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import fuzs.puzzleslib.api.block.v1.entity.TickingEntityBlock;
import fuzs.puzzleslib.api.util.v1.InteractionResultHelper;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.world.item.crafting.PiscaryRegistries;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
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
                if (!blockEntity.isEmpty() && !level.isClientSide()) {
                    Item item = bucketableMobs.get(blockEntity.getEntityType());
                    if (item != null) {
                        ItemStack itemStack = new ItemStack(item);
                        ItemStack resultItemStack = ItemUtils.createFilledResult(itemInHand,
                                player, itemStack);
                        CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, itemStack);
                        blockEntity.removeFish();
                        player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
                    }
                }
            }
        }


        return super.useItemOn(itemInHand, state, level, pos, player, interactionHand, hitResult);
    }

    @Override
    public @NotNull InteractionResult use(@Nonnull BlockState state, @NotNull Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand interactionHand, @Nonnull BlockHitResult blockRayTraceResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!(level.getBlockEntity(pos) instanceof HatcheryBlockEntity blockEntity)) return InteractionResult.PASS;
        if (itemInHand.getItem() == Items.BUCKET) {
            if (!level.isClientSide) {
                itemInHand.consume(1, player);
                level.destroyBlock(pos, true);
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Items.WATER_BUCKET));
            }

            return InteractionResultHelper.sidedSuccess(level.isClientSide);
        } else if (itemInHand.is(Items.WATER_BUCKET)) {
            if (!blockEntity.isEmpty() && !level.isClientSide) {
                itemInHand.consume(1, player);
                ItemHandlerHelper.giveItemToPlayer(player,
                        PiscaryRegistries.getFishBucket(level, blockEntity.getEntityType()));
                blockEntity.removeFish();
                player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            }

            return InteractionResultHelper.sidedSuccess(level.isClientSide);
        } else if (itemInHand.getItem() instanceof MobBucketItem item) {
            if (blockEntity.isEmpty() && !level.isClientSide) {
                blockEntity.setEntityTypeAndCount(item.type, 1);
                ItemStack itemStack = ItemUtils.createFilledResult(itemInHand,
                        player,
                        new ItemStack(Items.WATER_BUCKET));
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, itemStack);
                player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            }

            return InteractionResultHelper.sidedSuccess(level.isClientSide);
        } else if (!blockEntity.isEmpty() && blockEntity.getCount() > 1) {
            if (!level.isClientSide) {
                blockEntity.extractFish(true).die(level.damageSources().drown());
            }
            return InteractionResultHelper.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
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