package uk.joshiejack.piscary.client;


import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SalmonModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.client.model.*;
import uk.joshiejack.piscary.client.renderer.*;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;
import uk.joshiejack.piscary.init.ModEntityTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Piscary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PiscaryClient {

    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(PiscaryBlockEntities.FISH_TRAP.get(), FishTrapBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(PiscaryBlockEntities.HATCHERY.get(), HatcheryBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(PiscaryBlockEntities.RECYCLER.get(), RecyclerBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onEntityRenderRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AngelfishModel.LAYER_LOCATION, AngelfishModel::createBodyLayer);
        event.registerLayerDefinition(AnglerfishModel.LAYER_LOCATION, AnglerfishModel::createBodyLayer);
        event.registerLayerDefinition(ElectricRayModel.LAYER_LOCATION, ElectricRayModel::createBodyLayer);
        event.registerLayerDefinition(FatFishModel.LAYER_LOCATION, FatFishModel::createBodyLayer);
        event.registerLayerDefinition(LampreyModel.LAYER_LOCATION, LampreyModel::createBodyLayer);
        event.registerLayerDefinition(LongFishModel.LAYER_LOCATION, LongFishModel::createBodyLayer);
        event.registerLayerDefinition(LungfishModel.LAYER_LOCATION, LungfishModel::createBodyLayer);
        event.registerLayerDefinition(MantaRayModel.LAYER_LOCATION, MantaRayModel::createBodyLayer);
        event.registerLayerDefinition(PikeModel.LAYER_LOCATION, PikeModel::createBodyLayer);
        event.registerLayerDefinition(SiameseFightingFishModel.LAYER_LOCATION, SiameseFightingFishModel::createBodyLayer);
        event.registerLayerDefinition(SmallFishModel.LAYER_LOCATION, SmallFishModel::createBodyLayer);
        event.registerLayerDefinition(StargazerModel.LAYER_LOCATION, StargazerModel::createBodyLayer);
        event.registerLayerDefinition(StingRayModel.LAYER_LOCATION, StingRayModel::createBodyLayer);
        event.registerLayerDefinition(TallFishModel.LAYER_LOCATION, TallFishModel::createBodyLayer);
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        Map<String, Function<EntityRendererProvider.Context, ? extends EntityModel<?>>> map = new HashMap<>();
        put(map, ctx -> new AngelfishModel(ctx.bakeLayer(AngelfishModel.LAYER_LOCATION)), "angelfish", "butterflyfish");
        put(map, ctx -> new AnglerfishModel(ctx.bakeLayer(AnglerfishModel.LAYER_LOCATION)), "anglerfish");
        put(map, ctx -> new ElectricRayModel(ctx.bakeLayer(ElectricRayModel.LAYER_LOCATION)), "electric_ray");
        put(map, ctx -> new FatFishModel(ctx.bakeLayer(FatFishModel.LAYER_LOCATION)), "bass", "carp", "koi", "perch", "piranha", "tuna");
        put(map, ctx -> new LampreyModel(ctx.bakeLayer(LampreyModel.LAYER_LOCATION)), "lamprey");
        put(map, ctx -> new LongFishModel(ctx.bakeLayer(LongFishModel.LAYER_LOCATION)), "bowfin", "lungfish", "catfish");
        put(map, ctx -> new MantaRayModel(ctx.bakeLayer(MantaRayModel.LAYER_LOCATION)), "manta_ray");
        put(map, ctx -> new PikeModel(ctx.bakeLayer(PikeModel.LAYER_LOCATION)), "pickerel", "northern_pike");
        put(map, ctx -> new SalmonModel<>(ctx.bakeLayer(ModelLayers.SALMON)), "chub", "silver_stripe_blaasop", "trout", "walleye");
        put(map, ctx -> new StingRayModel(ctx.bakeLayer(StingRayModel.LAYER_LOCATION)), "stingray");
        put(map, ctx -> new SiameseFightingFishModel(ctx.bakeLayer(SiameseFightingFishModel.LAYER_LOCATION)), "siamese_fighting_fish");
        put(map, ctx -> new SmallFishModel(ctx.bakeLayer(SmallFishModel.LAYER_LOCATION)), "anchovy", "goldfish", "minnow", "neon_tetra", "pupfish", "sardine");
        put(map, ctx -> new StargazerModel(ctx.bakeLayer(StargazerModel.LAYER_LOCATION)), "whitemargin_stargazer");
        put(map, ctx -> new TallFishModel(ctx.bakeLayer(TallFishModel.LAYER_LOCATION)), "blue_tang", "damselfish");


        ModEntityTypes.ENTITIES.getEntries().forEach(fish -> {
            Function<EntityRendererProvider.Context, ? extends EntityModel<?>> m = map.get(fish.getId().getPath());
            if (fish.getId().getPath().contains("ray")) {
                event.registerEntityRenderer((EntityType<AbstractFish>) fish.get(), ctx -> new RayRenderer(ctx, (EntityModel<AbstractFish>) m.apply(ctx), fish.getId().getPath()));
            } else {
                 event.registerEntityRenderer((EntityType<AbstractFish>) fish.get(), ctx -> new FishRenderer(ctx, (EntityModel<AbstractFish>) m.apply(ctx), fish.getId().getPath()));
            }
        });
//
//        Function<EntityRendererProvider.Context, AbstractFishModel> angelfish = ctx -> new AngelfishModel(ctx.bakeLayer(AngelfishModel.LAYER_LOCATION));
//        event.registerEntityRenderer(PiscaryEntities.ANGELFISH.get(), ctx -> new FishRenderer(ctx, new AngelfishModel(ctx.bakeLayer(AngelfishModel.LAYER_LOCATION)), "angelfish"));
    }

    @SuppressWarnings("unchecked, rawtypes")
//    @SubscribeEvent
//    public static void onClientSetupEvent(FMLClientSetupEvent event) {
//        Map<String, EntityModel<AbstractFish>> map = new HashMap<>();
//        put(map, new AngelfishModel(), "angelfish", "butterflyfish");
//        put(map, new AnglerfishModel(), "anglerfish");
//        put(map, new ElectricRayModel(), "electric_ray");
//        put(map, new FatFishModel(), "bass", "carp", "koi", "perch", "piranha", "tuna");
//        put(map, new LampreyModel(), "lamprey");
//        put(map, new LongFishModel(), "bowfin", "lungfish", "catfish");
//        put(map, new MantaRayModel(), "manta_ray");
//        put(map, new PikeModel(), "pickerel", "northern_pike");
//        put(map, new RayModel(), "stingray");
//        put(map, new SalmonModel<>(), "chub", "silver_stripe_blaasop", "trout", "walleye");
//        put(map, new SiameseFightingFishModel(), "siamese_fighting_fish");
//        put(map, new SmallFishModel(), "anchovy", "goldfish", "minnow", "neon_tetra", "pupfish", "sardine");
//        put(map, new StargazerModel(), "whitemargin_stargazer");
//        put(map, new TallFishModel(), "blue_tang", "damselfish");
//        PiscaryEntities.ENTITIES.getEntries().forEach(fish -> {
//            EntityModel m = map.get(fish.getId().getPath());
//            //Piscary.LOGGER.info("Registering: " + fish.getId() + " as " + m);
//            RenderingRegistry.registerEntityRenderingHandler(fish.get(),
//                    (manager) -> (EntityRenderer) (
//                            fish.getId().getPath().contains("ray") ? new RayRenderer(manager, map.get(fish.getId().getPath()), fish.getId().getPath())
//                            : new FishRenderer(manager, map.get(fish.getId().getPath()), fish.getId().getPath())));
//        });
//
//        event.enqueueWork(() -> {
//            RenderTypeLookup.setRenderLayer(PiscaryBlocks.FISH_TRAP.get(), RenderType.cutout());
//            RenderTypeLookup.setRenderLayer(PiscaryBlocks.HATCHERY.get(), RenderType.cutout());
//            RenderTypeLookup.setRenderLayer(PiscaryBlocks.RECYCLER.get(), RenderType.cutout());
//        });
//    }

    private static void put(Map<String, Function<EntityRendererProvider.Context, ? extends EntityModel<?>>> map, Function<EntityRendererProvider.Context, ? extends EntityModel<?>> model, String... obj) {
        for (String str : obj)
            map.put(str, model);
    }
}
