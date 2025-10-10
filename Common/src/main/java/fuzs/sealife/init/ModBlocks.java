package fuzs.sealife.init;

import fuzs.sealife.world.level.block.FishTrapBlock;
import fuzs.sealife.world.level.block.HatcheryBlock;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;
import fuzs.sealife.world.level.block.entity.HatcheryBlockEntity;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Holder.Reference<Block> FISH_TRAP = ModRegistry.REGISTRIES.registerBlock("fish_trap",
            FishTrapBlock::new,
            () -> BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(0.6F)
                    .sound(SoundType.WOOD)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
                    .randomTicks()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never));
    public static final Holder.Reference<Block> HATCHERY = ModRegistry.REGISTRIES.registerBlock("hatchery",
            HatcheryBlock::new,
            () -> BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(0.6F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()
                    .randomTicks());
    public static final Holder.Reference<BlockEntityType<FishTrapBlockEntity>> FISH_TRAP_BLOCK_ENTITY_TYPE = ModRegistry.REGISTRIES.registerBlockEntityType(
            "fish_trap",
            FishTrapBlockEntity::new,
            FISH_TRAP);
    public static final Holder.Reference<BlockEntityType<HatcheryBlockEntity>> HATCHERY_BLOCK_ENTITY_TYPE = ModRegistry.REGISTRIES.registerBlockEntityType(
            "hatchery",
            HatcheryBlockEntity::new,
            HATCHERY);

    public static void bootstrap() {
        // NO-OP
    }
}
