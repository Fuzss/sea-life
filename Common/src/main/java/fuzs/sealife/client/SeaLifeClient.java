package fuzs.sealife.client;

import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.core.v1.context.BlockEntityRenderersContext;
import fuzs.puzzleslib.api.client.core.v1.context.EntityRenderersContext;
import fuzs.puzzleslib.api.client.core.v1.context.LayerDefinitionsContext;
import fuzs.puzzleslib.api.client.core.v1.context.RenderTypesContext;
import fuzs.sealife.client.model.*;
import fuzs.sealife.client.model.geom.ModModelLayers;
import fuzs.sealife.client.renderer.blockentity.FishTrapBlockEntityRenderer;
import fuzs.sealife.client.renderer.blockentity.HatcheryBlockEntityRenderer;
import fuzs.sealife.client.renderer.entity.FishRenderer;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.init.ModEntityTypes;
import net.minecraft.client.model.SalmonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.level.block.Block;

public class SeaLifeClient implements ClientModConstructor {

    @Override
    public void onRegisterBlockEntityRenderers(BlockEntityRenderersContext context) {
        context.registerBlockEntityRenderer(ModBlocks.FISH_TRAP_BLOCK_ENTITY_TYPE.value(),
                FishTrapBlockEntityRenderer::new);
        context.registerBlockEntityRenderer(ModBlocks.HATCHERY_BLOCK_ENTITY_TYPE.value(),
                HatcheryBlockEntityRenderer::new);
    }

    @Override
    public void onRegisterEntityRenderers(EntityRenderersContext context) {
        registerEntityRenderer(context, ModEntityTypes.ANCHOVY.value(), ModModelLayers.ANCHOVY);
        registerEntityRenderer(context, ModEntityTypes.ANGELFISH.value(), ModModelLayers.ANGELFISH);
        registerEntityRenderer(context, ModEntityTypes.ANGLERFISH.value(), ModModelLayers.ANGLERFISH);
        registerEntityRenderer(context, ModEntityTypes.BASS.value(), ModModelLayers.BASS);
        registerEntityRenderer(context, ModEntityTypes.BLUE_TANG.value(), ModModelLayers.BLUE_TANG);
        registerEntityRenderer(context, ModEntityTypes.BOWFIN.value(), ModModelLayers.BOWFIN);
        registerEntityRenderer(context, ModEntityTypes.BUTTERFLYFISH.value(), ModModelLayers.BUTTERFLYFISH);
        registerEntityRenderer(context, ModEntityTypes.CARP.value(), ModModelLayers.CARP);
        registerEntityRenderer(context, ModEntityTypes.CATFISH.value(), ModModelLayers.CATFISH);
        registerEntityRenderer(context, ModEntityTypes.CHUB.value(), ModModelLayers.CHUB);
        registerEntityRenderer(context, ModEntityTypes.DAMSELFISH.value(), ModModelLayers.DAMSELFISH);
        context.registerEntityRenderer(ModEntityTypes.ELECTRIC_RAY.value(),
                (EntityRendererProvider.Context contextX) -> new FishRenderer(contextX,
                        ModModelLayers.ELECTRIC_RAY,
                        FishModel::new,
                        false));
        registerEntityRenderer(context, ModEntityTypes.GOLDFISH.value(), ModModelLayers.GOLDFISH);
        registerEntityRenderer(context, ModEntityTypes.KOI.value(), ModModelLayers.KOI);
        registerEntityRenderer(context, ModEntityTypes.LAMPREY.value(), ModModelLayers.LAMPREY);
        registerEntityRenderer(context, ModEntityTypes.LUNGFISH.value(), ModModelLayers.LUNGFISH);
        context.registerEntityRenderer(ModEntityTypes.MANTA_RAY.value(),
                (EntityRendererProvider.Context contextX) -> new FishRenderer(contextX,
                        ModModelLayers.MANTA_RAY,
                        FishModel::new,
                        false));
        registerEntityRenderer(context, ModEntityTypes.MINNOW.value(), ModModelLayers.MINNOW);
        registerEntityRenderer(context, ModEntityTypes.NEON_TETRA.value(), ModModelLayers.NEON_TETRA);
        registerEntityRenderer(context, ModEntityTypes.NORTHERN_PIKE.value(), ModModelLayers.NORTHERN_PIKE);
        registerEntityRenderer(context, ModEntityTypes.PERCH.value(), ModModelLayers.PERCH);
        registerEntityRenderer(context, ModEntityTypes.PICKEREL.value(), ModModelLayers.PICKEREL);
        registerEntityRenderer(context, ModEntityTypes.PIRANHA.value(), ModModelLayers.PIRANHA);
        registerEntityRenderer(context, ModEntityTypes.PUPFISH.value(), ModModelLayers.PUPFISH);
        registerEntityRenderer(context, ModEntityTypes.SARDINE.value(), ModModelLayers.SARDINE);
        registerEntityRenderer(context,
                ModEntityTypes.SIAMESE_FIGHTING_FISH.value(),
                ModModelLayers.SIAMESE_FIGHTING_FISH);
        registerEntityRenderer(context,
                ModEntityTypes.SILVER_STRIPE_BLAASOP.value(),
                ModModelLayers.SILVER_STRIPE_BLAASOP);
        context.registerEntityRenderer(ModEntityTypes.STINGRAY.value(),
                (EntityRendererProvider.Context contextX) -> new FishRenderer(contextX,
                        ModModelLayers.STINGRAY,
                        FishModel::new,
                        false));
        registerEntityRenderer(context, ModEntityTypes.TROUT.value(), ModModelLayers.TROUT);
        registerEntityRenderer(context, ModEntityTypes.TUNA.value(), ModModelLayers.TUNA);
        registerEntityRenderer(context, ModEntityTypes.WALLEYE.value(), ModModelLayers.WALLEYE);
        registerEntityRenderer(context,
                ModEntityTypes.WHITEMARGIN_STARGAZER.value(),
                ModModelLayers.WHITEMARGIN_STARGAZER);
    }

    static <T extends AbstractFish> void registerEntityRenderer(EntityRenderersContext context, EntityType<? extends T> entityType, ModelLayerLocation modelLayerLocation) {
        context.registerEntityRenderer(entityType,
                (EntityRendererProvider.Context contextX) -> new FishRenderer(contextX,
                        modelLayerLocation,
                        FishModel::new));
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(ModModelLayers.ANCHOVY, SmallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.ANGELFISH, AngelfishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.ANGLERFISH, AnglerfishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.BASS, FatFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.BLUE_TANG, TallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.BOWFIN, LongFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.BUTTERFLYFISH, AngelfishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.CARP, FatFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.CATFISH, LongFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.CHUB, SalmonModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.DAMSELFISH, TallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.ELECTRIC_RAY, ElectricRayModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.GOLDFISH, SmallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.KOI, FatFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.LAMPREY, LampreyModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.LUNGFISH, LongFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.MANTA_RAY, MantaRayModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.MINNOW, SmallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.NEON_TETRA, SmallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.NORTHERN_PIKE, PikeModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PERCH, FatFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PICKEREL, PikeModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PIRANHA, FatFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PUPFISH, SmallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.SARDINE, SmallFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.SIAMESE_FIGHTING_FISH,
                SiameseFightingFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.SILVER_STRIPE_BLAASOP, SalmonModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.STINGRAY, StingRayModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.TROUT, SalmonModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.TUNA, FatFishModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.WALLEYE, SalmonModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.WHITEMARGIN_STARGAZER, StargazerModel::createBodyLayer);
    }

    @Override
    public void onRegisterBlockRenderTypes(RenderTypesContext<Block> context) {
        context.registerRenderType(RenderType.cutout(), ModBlocks.FISH_TRAP.value(), ModBlocks.HATCHERY.value());
    }
}
