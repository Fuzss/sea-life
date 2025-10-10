package fuzs.sealife.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.api.client.data.v2.models.ItemModelGenerationHelper;
import fuzs.puzzleslib.api.client.data.v2.models.ModelTemplateHelper;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.sealife.SeaLife;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.init.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;

public class ModModelProvider extends AbstractModelProvider {
    public static final ModelTemplate TEMPLATE_HATCHERY = ModelTemplateHelper.createBlockModelTemplate(SeaLife.id(
            "template_hatchery"), TextureSlot.TEXTURE);
    public static final TexturedModel.Provider PROVIDER_HATCHERY = TexturedModel.createDefault(TextureMapping::defaultTexture,
            TEMPLATE_HATCHERY);

    public ModModelProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBlockModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialBlock(ModBlocks.FISH_TRAP.value(), TexturedModel.CUBE_INNER_FACES);
        blockModelGenerators.createTrivialBlock(ModBlocks.HATCHERY.value(), PROVIDER_HATCHERY);
    }

    @Override
    public void addItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.FISH_BONES.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FISH_FOSSIL.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.OLD_BOOT.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EMPTY_CAN.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PIRATE_TREASURE.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FISH_FINGERS.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SASHIMI.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FISH_STEW.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANCHOVY.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANGELFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANGLERFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BASS.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLUE_TANG.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BOWFIN.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BUTTERFLYFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CARP.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CATFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHUB.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DAMSELFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ELECTRIC_RAY.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KOI.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LAMPREY.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LUNGFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MANTA_RAY.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MINNOW.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NEON_TETRA.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NORTHERN_PIKE.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PERCH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PICKEREL.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PIRANHA.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PUPFISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SARDINE.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SIAMESE_FIGHTING_FISH.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STINGRAY.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_STRIPE_BLAASOP.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TROUT.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TUNA.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WALLEYE.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WHITEMARGIN_STARGAZER.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANCHOVY_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANGELFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANGLERFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BASS_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLUE_TANG_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BOWFIN_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BUTTERFLYFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CARP_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CATFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHUB_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DAMSELFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ELECTRIC_RAY_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.KOI_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LAMPREY_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LUNGFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MANTA_RAY_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MINNOW_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NEON_TETRA_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NORTHERN_PIKE_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PERCH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PICKEREL_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PIRANHA_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PUPFISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SARDINE_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SIAMESE_FIGHTING_FISH_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WHITEMARGIN_STARGAZER_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STINGRAY_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SILVER_STRIPE_BLAASOP_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TROUT_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TUNA_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WALLEYE_BUCKET.value(), ModelTemplates.FLAT_ITEM);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.ANCHOVY_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.ANGELFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.ANGLERFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.BASS_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.BLUE_TANG_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.BOWFIN_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.BUTTERFLYFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.CARP_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.CATFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.CHUB_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.DAMSELFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.ELECTRIC_RAY_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.GOLDFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.KOI_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.LAMPREY_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.LUNGFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.MANTA_RAY_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.MINNOW_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.NEON_TETRA_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.NORTHERN_PIKE_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.PERCH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.PICKEREL_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.PIRANHA_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.PUPFISH_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.SARDINE_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.SIAMESE_FIGHTING_FISH_SPAWN_EGG.value(),
                itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.WHITEMARGIN_STARGAZER_SPAWN_EGG.value(),
                itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.STINGRAY_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.SILVER_STRIPE_BLAASOP_SPAWN_EGG.value(),
                itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.TROUT_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.TUNA_SPAWN_EGG.value(), itemModelGenerators);
        ItemModelGenerationHelper.generateSpawnEgg(ModItems.WALLEYE_SPAWN_EGG.value(), itemModelGenerators);
    }
}
