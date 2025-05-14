package uk.joshiejack.piscary.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import uk.joshiejack.penguinlib.util.helper.FakePlayerHelper;
import uk.joshiejack.penguinlib.world.block.PenguinBlock;
import uk.joshiejack.piscary.world.block.entity.FishTrapBlockEntity;
import uk.joshiejack.piscary.world.item.crafting.BaitRegistry;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Locale;


public class FishTrapBlock extends PenguinBlock implements SimpleWaterloggedBlock, EntityBlock  {
    public static final EnumProperty<FishTrapState> TRAP_STATE = EnumProperty.create("state", FishTrapState.class);

    public FishTrapBlock() {
        super(Block.Properties.ofFullCopy(Blocks.BRAIN_CORAL).strength(0.1F).sound(SoundType.WOOL).noOcclusion());
        registerDefaultState(stateDefinition.any().setValue(TRAP_STATE, FishTrapState.EMPTY));
        hasInventory = true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TRAP_STATE);
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public FluidState getFluidState(@Nonnull BlockState state) {
        return Fluids.WATER.getSource(false);
    }

    private ResourceLocation getLootTable(ItemStack bait, RandomSource random) {
        if (random.nextInt(4) == 0) {
            ResourceLocation lootTable = BaitRegistry.getValue(bait).getLootTable();
            return lootTable != BaitRegistry.BaitData.EMPTY.getLootTable() ? lootTable : BuiltInLootTables.FISHING_FISH;
        } else return BuiltInLootTables.FISHING_JUNK;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel world, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        BlockEntity tile = world.getBlockEntity(pos);
        if (!(tile instanceof FishTrapBlockEntity)) return;
        FishTrapBlockEntity trap = (FishTrapBlockEntity) tile;
        if (trap.isSurroundedByWater()) {
            if (trap.isBaited()) {
                Player player = FakePlayerHelper.getFakePlayerWithPosition(world, pos);
                LootParams.Builder builder = new LootParams.Builder(world)
                        .withParameter(LootContextParams.ORIGIN, player.position())
                        .withParameter(LootContextParams.TOOL, trap.getItem(0))
                        .withParameter(LootContextParams.KILLER_ENTITY, player)
                        .withOptionalParameter(LootContextParams.THIS_ENTITY, player)
                        .withLuck(player.getLuck());

                ItemStack stack = ItemStack.EMPTY;
                while (stack.isEmpty()) {
                    LootTable loottable = world.getServer().getLootData().getLootTable(getLootTable(trap.getItem(0), random));
                    List<ItemStack> result = loottable.getRandomItems(builder.create(LootContextParamSets.FISHING));
                    if (!result.isEmpty())
                        stack = result.get(0);
                }

                trap.setItem(0, stack);
                trap.setTimeCaught(world.getDayTime());
            }
        } else world.scheduleTick(pos, this, trap.getTimeUnit());
    }

    @Nonnull
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new FishTrapBlockEntity(pos, state);
    }

    public enum FishTrapState implements StringRepresentable {
        EMPTY, BAITED;

        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
