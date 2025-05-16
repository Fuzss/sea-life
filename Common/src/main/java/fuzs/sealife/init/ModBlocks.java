package fuzs.sealife.init;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import fuzs.sealife.world.level.block.FishTrapBlock;
import fuzs.sealife.world.level.block.HatcheryBlock;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;
import fuzs.sealife.world.level.block.entity.HatcheryBlockEntity;

public class ModBlocks {
    public static final Holder.Reference<Block> FISH_TRAP = ModRegistry.REGISTRIES.registerBlock("fish_trap",
            FishTrapBlock::new,
            () -> Block.Properties.ofFullCopy(Blocks.BRAIN_CORAL).strength(0.1F).sound(SoundType.WOOL).noOcclusion());
    public static final Holder.Reference<Block> HATCHERY = ModRegistry.REGISTRIES.registerBlock("hatchery",
            HatcheryBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).randomTicks().strength(0.5F).noOcclusion());
    public static final Holder.Reference<BlockEntityType<FishTrapBlockEntity>> FISH_TRAP_BLOCK_ENTITY_TYPE = ModRegistry.REGISTRIES.registerBlockEntityType("fish_trap", FishTrapBlockEntity::new,
            FISH_TRAP);
    public static final Holder.Reference<BlockEntityType<HatcheryBlockEntity>> HATCHERY_BLOCK_ENTITY_TYPE = ModRegistry.REGISTRIES.registerBlockEntityType("hatchery", HatcheryBlockEntity::new,
            HATCHERY);

    public static void bootstrap() {
        // NO-OP
    }
}
