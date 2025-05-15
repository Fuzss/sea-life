package uk.joshiejack.piscary.world.level.block.entity;

import fuzs.puzzleslib.api.container.v1.ListBackedContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import uk.joshiejack.penguinlib.data.TimeUnitRegistry;
import uk.joshiejack.penguinlib.world.block.entity.inventory.InventoryBlockEntity;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.init.ModBlocks;
import uk.joshiejack.piscary.world.level.block.FishTrapBlock;
import uk.joshiejack.piscary.world.item.crafting.BaitRegistry;

import javax.annotation.Nonnull;

public class FishTrapBlockEntity extends BlockEntity implements ListBackedContainer {
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private long timeCaught;

    public FishTrapBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlocks.FISH_TRAP_BLOCK_ENTITY_TYPE.value(), blockPos, blockState);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public void setItem(int slot, @Nonnull ItemStack stack) {
        if (BaitRegistry.isBait(stack)) {
            level.setBlock(worldPosition, level.getBlockState(worldPosition).setValue(FishTrapBlock.TRAP_STATE, FishTrapBlock.FishTrapState.BAITED), 3);
            level.scheduleTick(worldPosition, getBlockState().getBlock(), getTimeUnit());
        } else
            level.setBlock(worldPosition, level.getBlockState(worldPosition).setValue(FishTrapBlock.TRAP_STATE, FishTrapBlock.FishTrapState.EMPTY), 3);
        super.setItem(slot, stack);
    }

    public int getTimeUnit() {
        long half = TimeUnitRegistry.get(Piscary.MOD_ID + ":fish_trap");
        return (int) half + (level.random.nextInt((int) half * 2) * (1 + level.random.nextInt(3)));
    }

    @Override
    public boolean canPlaceItem(int slot, @Nonnull ItemStack stack) {
        return items.get(slot).isEmpty() && BaitRegistry.isBait(stack);
    }

    @Nonnull
    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (BaitRegistry.isBait(items.get(0)) || items.get(0).isEmpty())
            return ItemStack.EMPTY;
        else {
            if (shouldTrapBreak())
                level.destroyBlock(worldPosition, false);
            return super.removeItem(slot, amount);
        }
    }

    @SuppressWarnings("ConstantConditions")
    private boolean shouldTrapBreak() {
        long difference = level.getDayTime() - timeCaught; //Always break after two days, 50% between 1 day and 2 days, 20% otherwise,
        return difference >= 48000 || (difference < 24000 && level.random.nextInt(5) <= 1) || (difference >= 24000 && level.random.nextInt(2) == 0);
    }

    public boolean isBaited() {
        return BaitRegistry.isBait(items.get(0));
    }

    public void setTimeCaught(long timeCaught) {
        this.timeCaught = timeCaught;
        this.setChanged();
    }

    @Override
    public void load(@Nonnull CompoundTag nbt) {
        super.load(nbt);
        timeCaught = nbt.getLong("TimeCaught");
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        nbt.putLong("TimeCaught", timeCaught);
        super.saveAdditional(nbt);
    }

    @Override
    public NonNullList<ItemStack> getContainerItems() {
        return this.items;
    }
}
