package uk.joshiejack.piscary.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import uk.joshiejack.penguinlib.client.renderer.block.entity.AbstractMachineBlockEntityRenderer;
import uk.joshiejack.piscary.world.block.entity.RecyclerBlockEntity;

@SuppressWarnings("unused")
public class RecyclerBlockEntityRenderer extends AbstractMachineBlockEntityRenderer<RecyclerBlockEntity> {
    public RecyclerBlockEntityRenderer(BlockEntityRendererProvider.Context dispatcher) {
        super(dispatcher);
    }

    @Override
    protected double getYOffset() {
        return 2.5D;
    }
}