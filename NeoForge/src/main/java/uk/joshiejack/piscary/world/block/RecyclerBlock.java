package uk.joshiejack.piscary.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.penguinlib.world.block.RotatableDoubleBlock;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;
import uk.joshiejack.piscary.world.block.entity.RecyclerBlockEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RecyclerBlock extends RotatableDoubleBlock implements EntityBlock {
    private static final VoxelShape SHAPE = Block.box(1D, 0D, 1D, 15D, 16D, 15D);

    public RecyclerBlock() {
        super(Block.Properties.of().mapColor(MapColor.METAL)
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .strength(1.2F)
                .noCollission()
                .noOcclusion()
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL));
        hasInventory = true;
    }

    @Override
    @SuppressWarnings("deprecation")
    @Nonnull
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected int getExtractAmount(IItemHandler handler, int slot) {
        return handler.getStackInSlot(slot).isEmpty() ? 0 : handler.getStackInSlot(slot).getCount();
    }

    @Nonnull
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new RecyclerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, PiscaryBlockEntities.RECYCLER.get(), RecyclerBlockEntity::serverTick);
    }
}
