package uk.joshiejack.piscary.world.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import uk.joshiejack.penguinlib.world.block.entity.machine.MachineBlockEntity;
import uk.joshiejack.penguinlib.world.block.entity.machine.RecipeMachineBlockEntity;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;
import uk.joshiejack.piscary.world.item.crafting.RecyclerRecipe;

public class RecyclerBlockEntity extends RecipeMachineBlockEntity<RecyclerRecipe> {

    public RecyclerBlockEntity(BlockPos pos, BlockState state) {
        super(PiscaryBlockEntities.RECYCLER.get(), pos, state, PiscaryRegistries.RECYCLER.get());
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, RecyclerBlockEntity entity) {
        MachineBlockEntity.serverTick(level, pos, state, entity);
        if (level.getGameTime() % 50L == 1L) {
            if (entity.isActive()) {
                double d0 = (double) pos.getX() + 0.5D;
                double d1 = (double) pos.getY() + 0.5D;
                double d2 = (double) pos.getZ() + 0.5D;
                level.playSound(null, d0, d1, d2, Piscary.PiscarySounds.RECYCLER.value(), SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
            }
        }
    }

}
