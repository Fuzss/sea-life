package fuzs.sealife.client.renderer;

import fuzs.sealife.SeaLife;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.TriState;

import java.util.function.Function;

/**
 * Custom render types that support the lightmap.
 */
public abstract class ModRenderType extends RenderType {
    /**
     * @see RenderType#TEXT
     */
    private static final Function<ResourceLocation, RenderType> TEXT = Util.memoize((ResourceLocation resourceLocation) -> create(
            SeaLife.id("text").toString(),
            786432,
            false,
            false,
            RenderPipelines.TEXT,
            CompositeState.builder()
                    .setTextureState(new TextureStateShard(resourceLocation, TriState.FALSE, false))
                    .setLightmapState(LIGHTMAP)
                    .createCompositeState(false)));

    private ModRenderType(String string, int i, boolean bl, boolean bl2, Runnable runnable, Runnable runnable2) {
        super(string, i, bl, bl2, runnable, runnable2);
    }

    public static RenderType text(ResourceLocation location) {
        return TEXT.apply(location);
    }
}
