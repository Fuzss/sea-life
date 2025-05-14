package uk.joshiejack.piscary.data;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.init.ModBlocks;
import uk.joshiejack.piscary.world.block.RecyclerBlock;

public class PiscaryBlockStates extends BlockStateProvider {
    public PiscaryBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Piscary.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile upper = models().getExistingFile(new ResourceLocation(Piscary.MODID, "recycler_upper"));
        ModelFile lower = models().getExistingFile(new ResourceLocation(Piscary.MODID, "recycler_lower"));

        VariantBlockStateBuilder builder = getVariantBuilder(ModBlocks.RECYCLER.get());
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.UPPER).with(RecyclerBlock.FACING, Direction.WEST).modelForState().modelFile(upper).rotationY(90).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.UPPER).with(RecyclerBlock.FACING, Direction.EAST).modelForState().modelFile(upper).rotationY(270).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.UPPER).with(RecyclerBlock.FACING, Direction.SOUTH).modelForState().modelFile(upper).rotationY(0).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.UPPER).with(RecyclerBlock.FACING, Direction.NORTH).modelForState().modelFile(upper).rotationY(180).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.LOWER).with(RecyclerBlock.FACING, Direction.WEST).modelForState().modelFile(lower).rotationY(90).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.LOWER).with(RecyclerBlock.FACING, Direction.EAST).modelForState().modelFile(lower).rotationY(270).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.LOWER).with(RecyclerBlock.FACING, Direction.SOUTH).modelForState().modelFile(lower).rotationY(0).addModel();
        builder.partialState().with(RecyclerBlock.HALF, DoubleBlockHalf.LOWER).with(RecyclerBlock.FACING, Direction.NORTH).modelForState().modelFile(lower).rotationY(180).addModel();
    }
}
