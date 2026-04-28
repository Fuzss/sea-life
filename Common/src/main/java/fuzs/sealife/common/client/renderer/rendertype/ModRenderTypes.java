//package fuzs.sealife.client.renderer.rendertype;
//
//import fuzs.sealife.SeaLife;
//import net.minecraft.client.renderer.RenderPipelines;
//import net.minecraft.client.renderer.rendertype.RenderType;
//import net.minecraft.resources.Identifier;
//import net.minecraft.util.Util;
//
//import java.util.function.Function;
//
///**
// * Custom render types that support the lightmap.
// */
//public final class ModRenderTypes {
//    /**
//     * @see net.minecraft.client.renderer.rendertype.RenderTypes#TEXT
//     */
//    private static final Function<Identifier, RenderType> TEXT = Util.memoize((Identifier identifier) -> create(SeaLife.id(
//                    "text").toString(),
//            786432,
//            false,
//            false,
//            RenderPipelines.TEXT,
//            CompositeState.builder()
//                    .setTextureState(new TextureStateShard(identifier, false))
//                    .setLightmapState(LIGHTMAP)
//                    .createCompositeState(false)));
//
//    private static final Function<ResourceLocation, RenderType> TEXT = Util.memoize(
//            (Function<ResourceLocation, RenderType>)(id -> create(
//                    "text",
//                    786432,
//                    false,
//                    false,
//                    RenderPipelines.TEXT,
//                    RenderType.CompositeState.builder()
//                            .setTextureState(new RenderStateShard.TextureStateShard(id, false))
//                            .setLightmapState(LIGHTMAP)
//                            .createCompositeState(false)
//            ))
//    );
//
//    private ModRenderTypes() {
//        // NO-OP
//    }
//
//    public static RenderType text(Identifier location) {
//        return TEXT.apply(location);
//    }
//}
