package uk.joshiejack.piscary.world.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.init.ModBlocks;

@SuppressWarnings("ConstantConditions")
public class PiscaryBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Piscary.MOD_ID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FishTrapBlockEntity>> FISH_TRAP = BLOCK_ENTITY_TYPE.register("fish_trap", () -> BlockEntityType.Builder.of(FishTrapBlockEntity::new, ModBlocks.FISH_TRAP.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HatcheryBlockEntity>> HATCHERY = BLOCK_ENTITY_TYPE.register("hatchery", () -> BlockEntityType.Builder.of(HatcheryBlockEntity::new, ModBlocks.HATCHERY.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RecyclerBlockEntity>> RECYCLER = BLOCK_ENTITY_TYPE.register("recycler", () -> BlockEntityType.Builder.of(RecyclerBlockEntity::new, ModBlocks.RECYCLER.get()).build(null));
}
