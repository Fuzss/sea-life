package uk.joshiejack.piscary.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemStack;
import uk.joshiejack.penguinlib.client.renderer.block.entity.AbstractItemTileEntityRenderer;
import uk.joshiejack.piscary.world.block.entity.FishTrapBlockEntity;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class FishTrapBlockEntityRenderer extends AbstractItemTileEntityRenderer<FishTrapBlockEntity> {
    public FishTrapBlockEntityRenderer(BlockEntityRendererProvider.Context dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(@Nonnull FishTrapBlockEntity tile, float partialTicks, @Nonnull PoseStack matrix, @Nonnull MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
        ItemStack inSlot = tile.getItem(0);
        if (!inSlot.isEmpty() && !tile.isBaited())
            renderSpeechBubble(inSlot, matrix, buffer, combinedLightIn, combinedOverlayIn);
    }
}