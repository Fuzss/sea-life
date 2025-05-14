package uk.joshiejack.piscary.init;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.penguinlib.world.block.entity.inventory.InventoryBlockEntity;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.block.FishTrapBlock;
import uk.joshiejack.piscary.world.block.HatcheryBlock;
import uk.joshiejack.piscary.world.block.RecyclerBlock;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;

public class ModBlocks {
    public static final DeferredBlock<Block> FISH_TRAP = ModRegistry.REGISTRIES.registerBlock("fish_trap", FishTrapBlock::new);
    public static final DeferredBlock<Block> HATCHERY = ModRegistry.REGISTRIES.registerBlock("hatchery", HatcheryBlock::new);
    public static final DeferredBlock<Block> RECYCLER = ModRegistry.REGISTRIES.registerBlock("recycler", RecyclerBlock::new);

    @SubscribeEvent
    public static void registerHandlers(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PiscaryBlockEntities.FISH_TRAP.get(), InventoryBlockEntity.getItemProvider());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PiscaryBlockEntities.RECYCLER.get(), InventoryBlockEntity.getItemProvider());
    }
}
