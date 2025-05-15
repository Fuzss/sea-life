package uk.joshiejack.piscary.world.level.block;

import com.mojang.serialization.MapCodec;
import fuzs.puzzleslib.api.block.v1.entity.TickingEntityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.penguinlib.world.block.PenguinBlock;
import uk.joshiejack.piscary.init.ModBlocks;
import uk.joshiejack.piscary.world.level.block.entity.HatcheryBlockEntity;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;

import javax.annotation.Nonnull;

public class HatcheryBlock extends BaseEntityBlock implements TickingEntityBlock<HatcheryBlockEntity> {

    public HatcheryBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
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

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (PiscaryRegistries.canContainFish(itemInHand, blockEntity.getEntityType())) {
            if (!blockEntity.isEmpty() && !level.isClientSide) {
                if (!player.getAbilities().instabuild) {
                    itemInHand.shrink(1); //Reduce ot y
                }

                ItemHandlerHelper.giveItemToPlayer(player, PiscaryRegistries.getFishBucket(level, blockEntity.getEntityType()));
                blockEntity.removeFish(); //Remove the fish from the hatchery
                player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (PiscaryRegistries.containsFish(itemInHand)) {
            if (blockEntity.isEmpty() && !level.isClientSide) {
                EntityType<?> type = PiscaryRegistries.getFishFromItem(itemInHand);
                if (!player.getAbilities().instabuild) {
                    itemInHand.shrink(1); //Reduce ot y
                }

                blockEntity.setEntityTypeAndCount(type, 1); //Set the hatchery to the correct fish bucket entity type
                ItemHandlerHelper.giveItemToPlayer(player, PiscaryRegistries.getWaterBucket(level, type));
                player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (!blockEntity.isEmpty() && blockEntity.getCount() > 1) {
            if (!level.isClientSide) {
                blockEntity.extractFish(true).die(level.damageSources().drown());
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    public BlockEntityType<? extends HatcheryBlockEntity> getBlockEntityType() {
        return ModBlocks.HATCHERY_BLOCK_ENTITY_TYPE.value();
    }
}