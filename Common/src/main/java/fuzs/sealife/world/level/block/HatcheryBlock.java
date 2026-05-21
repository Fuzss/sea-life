package fuzs.sealife.world.level.block;

import com.mojang.serialization.MapCodec;
import fuzs.puzzleslib.api.block.v1.entity.TickingEntityBlock;
import fuzs.puzzleslib.api.util.v1.ShapesHelper;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.init.ModRegistry;
import fuzs.sealife.world.level.block.entity.HatcheryBlockEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class HatcheryBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, TickingEntityBlock<HatcheryBlockEntity> {
    public static final int MAX_CAPACITY = 12;
    public static final int COMMON_CYCLES = 3;
    public static final int UNCOMMON_CYCLES = 5;
    public static final int RARE_CYCLES = 7;
    public static final MapCodec<HatcheryBlock> CODEC = simpleCodec(HatcheryBlock::new);
    protected static final VoxelShape SHAPE_INSIDE = ShapesHelper.column(14.0, 1.0, 16.0);
    protected static final VoxelShape SHAPE = Shapes.join(ShapesHelper.column(16.0, 0.0, 15.0),
            SHAPE_INSIDE,
            BooleanOp.ONLY_FIRST);
    protected static final VoxelShape COLLISION_SHAPE = Shapes.join(Shapes.block(), SHAPE_INSIDE, BooleanOp.ONLY_FIRST);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty STAGE = IntegerProperty.create("stage",
            0,
            Math.max(Math.max(COMMON_CYCLES, UNCOMMON_CYCLES), RARE_CYCLES));

    public HatcheryBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE).setValue(STAGE, 0));
    }

    /**
     * @see SpawnEggItem#byId(EntityType)
     */
    public static Optional<? extends Holder<Item>> byId(EntityType<?> type) {
        return BuiltInRegistries.ITEM.holders().filter((Holder.Reference<Item> holder) -> {
            return holder.value() instanceof MobBucketItem item && item.type == type;
        }).findAny();
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, bl);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // collision shape with full height sides to prevent water from flowing out of the block
        return COLLISION_SHAPE;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return super.isRandomlyTicking(state) && state.getValue(WATERLOGGED);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(3) == 0) {
            if (serverLevel.getBlockEntity(blockPos) instanceof HatcheryBlockEntity blockEntity
                    && blockEntity.getEntityType() != null && blockEntity.getCount() < MAX_CAPACITY) {
                int hatchingCycles = getHatchingCycles(blockEntity.getEntityType());
                if (blockState.getValue(STAGE) < hatchingCycles) {
                    serverLevel.setBlock(blockPos, blockState.cycle(STAGE), Block.UPDATE_ALL);
                } else {
                    blockEntity.addFish(blockEntity.getEntityType(), 1);
                    serverLevel.setBlock(blockPos, blockState.setValue(STAGE, 0), Block.UPDATE_ALL);
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
            return UNCOMMON_CYCLES;
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemInHand, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
        if (level.getBlockEntity(blockPos) instanceof HatcheryBlockEntity blockEntity) {
            if (itemInHand.is(Items.WATER_BUCKET)) {
                if (!blockEntity.isEmpty()) {
                    Optional<ItemStack> optional = byId(blockEntity.getEntityType()).map(ItemStack::new);
                    if (optional.isPresent()) {
                        ItemStack resultItemStack = ItemUtils.createFilledResult(itemInHand, player, optional.get());
                        if (!level.isClientSide()) {
                            level.setBlock(blockPos, blockState.setValue(STAGE, 0), Block.UPDATE_ALL);
                            blockEntity.removeFish(1, false);
                            CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, optional.get());
                            player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
                        }

                        player.setItemInHand(interactionHand, resultItemStack);
                        return ItemInteractionResult.sidedSuccess(level.isClientSide());
                    }
                }
            } else if (itemInHand.getItem() instanceof MobBucketItem item) {
                if (blockEntity.getCount() < MAX_CAPACITY && (blockEntity.getEntityType() == null
                        || blockEntity.getEntityType() == item.type)) {
                    ItemStack itemStack = blockState.getValue(WATERLOGGED) ? new ItemStack(Items.WATER_BUCKET) :
                            new ItemStack(Items.BUCKET);
                    ItemStack resultItemStack = ItemUtils.createFilledResult(itemInHand, player, itemStack);
                    if (!level.isClientSide()) {
                        // similar to SimpleWaterloggedBlock::placeLiquid
                        if (!blockState.getValue(WATERLOGGED)) {
                            FluidState fluidState = Fluids.WATER.getSource(false);
                            level.setBlock(blockPos,
                                    blockState.setValue(BlockStateProperties.WATERLOGGED, true),
                                    Block.UPDATE_ALL);
                            level.scheduleTick(blockPos,
                                    fluidState.getType(),
                                    fluidState.getType().getTickDelay(level));
                        }

                        CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, resultItemStack);
                        player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
                        blockEntity.addFish(item.type, 1);
                    }

                    player.setItemInHand(interactionHand, resultItemStack);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide());
                } else {
                    return ItemInteractionResult.CONSUME;
                }
            }
        }

        return super.useItemOn(itemInHand, blockState, level, blockPos, player, interactionHand, hitResult);
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
    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return level.getBlockEntity(blockPos) instanceof HatcheryBlockEntity blockEntity ? blockEntity.getCount() : 0;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof HatcheryBlockEntity blockEntity) {
                blockEntity.removeFish(blockEntity.getCount(), true);
            }

            super.onRemove(state, level, pos, newState, movedByPiston);
        }
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, STAGE);
    }
}
