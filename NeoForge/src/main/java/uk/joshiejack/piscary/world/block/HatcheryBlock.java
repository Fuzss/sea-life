package uk.joshiejack.piscary.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.penguinlib.world.block.PenguinBlock;
import uk.joshiejack.piscary.world.block.entity.HatcheryBlockEntity;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HatcheryBlock extends PenguinBlock implements EntityBlock {

    private static final VoxelShape SHAPE = Block.box(0D, 0D, 0D, 16D, 16D, 16D);

    public HatcheryBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).randomTicks().strength(0.5F).noOcclusion());
    }

    @Override
    public @NotNull InteractionResult use(@Nonnull BlockState state, @NotNull Level world, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult blockRayTraceResult) {
        BlockEntity tile = world.getBlockEntity(pos);
        ItemStack held = player.getItemInHand(hand);
        if (!(tile instanceof HatcheryBlockEntity hatchery)) return InteractionResult.PASS;
        if (held.getItem() == Items.BUCKET) {
            if (!world.isClientSide) {
                if (!player.getAbilities().instabuild) {
                    held.shrink(1);
                }

                world.destroyBlock(pos, true);
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Items.WATER_BUCKET));
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (PiscaryRegistries.canContainFish(held, hatchery.getEntityType())) {
            if (!hatchery.isEmpty() && !world.isClientSide) {
                if (!player.getAbilities().instabuild) {
                    held.shrink(1); //Reduce ot y
                }

                ItemHandlerHelper.giveItemToPlayer(player, PiscaryRegistries.getFishBucket(world, hatchery.getEntityType()));
                hatchery.removeFish(); //Remove the fish from the hatchery
                player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (PiscaryRegistries.containsFish(held)) {
            if (hatchery.isEmpty() && !world.isClientSide) {
                EntityType<?> type = PiscaryRegistries.getFishFromItem(held);
                if (!player.getAbilities().instabuild) {
                    held.shrink(1); //Reduce ot y
                }

                hatchery.setEntityTypeAndCount(type, 1); //Set the hatchery to the correct fish bucket entity type
                ItemHandlerHelper.giveItemToPlayer(player, PiscaryRegistries.getWaterBucket(world, type));
                player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (!hatchery.isEmpty() && hatchery.getCount() > 1) {
            if (!world.isClientSide)
                hatchery.extractFish(true).die(world.damageSources().drown());
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState oldState, @Nonnull Level world, @Nonnull BlockPos pos, BlockState newState, boolean p_196243_5_) {
        if (!oldState.is(newState.getBlock())) {
            BlockEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof HatcheryBlockEntity) {
                ((HatcheryBlockEntity) tileentity).spawnFish(((HatcheryBlockEntity) tileentity).getCount());
            }

            super.onRemove(oldState, world, pos, newState, p_196243_5_);
        }
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public FluidState getFluidState(@Nonnull BlockState state) {
        return Fluids.WATER.getSource(false);
    }

    @Override
    @SuppressWarnings("deprecation")
    @Nonnull
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Nonnull
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new HatcheryBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ?
                createTickerHelper(type, PiscaryBlockEntities.HATCHERY.get(),
                        (lvl, pos, st, entity) -> {
                            if (entity.getEntityType() != null)
                                entity.getRenderer().updateFish();
                        }) :
                createTickerHelper(type, PiscaryBlockEntities.HATCHERY.get(),
                        (lvl, pos, st, entity) -> HatcheryBlockEntity.serverTick(lvl, pos, entity));
    }
}