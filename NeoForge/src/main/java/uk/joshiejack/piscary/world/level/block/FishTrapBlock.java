package uk.joshiejack.piscary.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import uk.joshiejack.piscary.init.ModLootTables;
import uk.joshiejack.piscary.world.level.block.entity.FishTrapBlockEntity;
import uk.joshiejack.piscary.world.item.crafting.BaitRegistry;

import java.util.List;


public class FishTrapBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
    public static final List<BlockPos> WATER_OFFSETS = BlockPos.withinManhattanStream(BlockPos.ZERO, 1, 1, 1)
            .filter((BlockPos blockPos) -> blockPos.distManhattan(BlockPos.ZERO) == 1)
            .map(BlockPos::immutable)
            .toList();
    static final int TIME_UNITS = 600;
    public static final BooleanProperty BAITED = BooleanProperty.create("baited");

    public FishTrapBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BAITED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BAITED);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return Fluids.WATER.getSource(false);
    }

    private ResourceKey<LootTable> getLootTable(ItemStack bait, RandomSource randomSource) {
        if (randomSource.nextInt(4) == 0) {
            ResourceLocation lootTable = BaitRegistry.getValue(bait).getLootTable();
            return lootTable != BaitRegistry.BaitData.EMPTY.getLootTable() ? lootTable : BuiltInLootTables.FISHING_FISH;
        } else {
            return BuiltInLootTables.FISHING_JUNK;
        }
    }

    public boolean isSurroundedByWater(Level level, BlockPos blockPos) {
        int waterOnSides = 0;
        for (BlockPos offsetPos : WATER_OFFSETS) {
            if (level.getFluidState(blockPos.offset(offsetPos)).is(FluidTags.WATER)) {
                waterOnSides++;
            }
        }
        return waterOnSides >= 5;
    }

    @Override
    public void tick(BlockState state, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        BlockEntity tile = serverLevel.getBlockEntity(blockPos);
        if (!(tile instanceof FishTrapBlockEntity trap)) return;
        if (this.isSurroundedByWater(serverLevel, blockPos)) {
            if (trap.isBaited()) {
                LootParams.Builder builder = new LootParams.Builder(serverLevel).withParameter(LootContextParams.ORIGIN,
                        Vec3.atCenterOf(blockPos)).withParameter(LootContextParams.TOOL, trap.getItem(0));


                LootParams lootParams = new LootParams.Builder(serverLevel).withParameter(
                                LootContextParams.ORIGIN,
                                Vec3.atCenterOf(blockPos))
                        .withParameter(LootContextParams.TOOL, stack)
                        .create(LootContextParamSets.FISHING);
                LootTable lootTable = serverLevel.getServer()
                        .reloadableRegistries()
                        .getLootTable(ModLootTables.FISH_TRAP);
                List<ItemStack> list = lootTable.getRandomItems(lootParams);


                ItemStack stack = ItemStack.EMPTY;
                while (stack.isEmpty()) {
                    LootTable loottable = serverLevel.getServer()
                            .getLootData()
                            .getLootTable(this.getLootTable(trap.getItem(0), random));
                    List<ItemStack> result = loottable.getRandomItems(builder.create(LootContextParamSets.FISHING));
                    if (!result.isEmpty()) stack = result.get(0);
                }

                trap.setItem(0, stack);
                trap.setTimeCaught(serverLevel.getDayTime());
            }
        } else {
            serverLevel.scheduleTick(blockPos, this, TIME_UNITS);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FishTrapBlockEntity(pos, state);
    }
}
