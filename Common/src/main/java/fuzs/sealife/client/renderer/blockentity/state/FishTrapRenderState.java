package fuzs.sealife.client.renderer.blockentity.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.state.ItemClusterRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class FishTrapRenderState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
    public final ItemClusterRenderState cluster = new ItemClusterRenderState();
    public float spin;
    public boolean isBait;
}
