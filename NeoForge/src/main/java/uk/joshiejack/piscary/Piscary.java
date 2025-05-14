package uk.joshiejack.piscary;

import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import net.minecraft.DetectedVersion;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.joshiejack.piscary.data.*;
import uk.joshiejack.piscary.world.block.entity.PiscaryBlockEntities;
import uk.joshiejack.piscary.init.ModEntityTypes;
import uk.joshiejack.piscary.init.PiscaryItems;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;
import uk.joshiejack.piscary.world.loot.PiscaryLoot;

import javax.annotation.Nonnull;
import java.util.Optional;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(Piscary.MODID)
public class Piscary {
    public static final String MODID = "piscary";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Piscary.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS.register(Piscary.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Piscary.MODID))
            .icon(() -> new ItemStack(PiscaryItems.PUPFISH.asItem()))
            .displayItems((params, output) -> {
                PiscaryItems.ITEMS.getEntries().stream()
                        .map(DeferredHolder::get)
                        .forEach(output::accept);
                ModEntityTypes.ITEMS.getEntries().stream()
                        .map(DeferredHolder::get)
                        .forEach(output::accept);
            }).build());

    public Piscary(IEventBus eventBus) {
        PiscarySounds.SOUNDS.register(eventBus);
        PiscaryItems.ITEMS.register(eventBus);
        ModEntityTypes.ENTITIES.register(eventBus);
        ModEntityTypes.ITEMS.register(eventBus);
        PiscaryRegistries.RECIPE_TYPES.register(eventBus);
        PiscaryRegistries.SERIALIZERS.register(eventBus);
        PiscaryBlockEntities.BLOCK_ENTITY_TYPE.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }

    @SubscribeEvent
    public static void onDataGathering(final GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        final PackOutput output = event.getGenerator().getPackOutput();
        //Add the datapack entries
        //Client
        generator.addProvider(event.includeClient(), new PiscaryBlockStates(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new PiscaryItemModels(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new PiscaryLanguage(output));
        generator.addProvider(event.includeClient(), new PiscarySoundDefinitions(output, event.getExistingFileHelper()));

        //Server
        PiscaryBlockTags blocktags = new PiscaryBlockTags(output, event.getLookupProvider(), event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blocktags);
        generator.addProvider(event.includeServer(), new PiscaryLootTables(output));
        generator.addProvider(event.includeServer(), new PiscaryItemTags(output, event.getLookupProvider(), blocktags.contentsGetter(), event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new PiscaryRecipes(output));
        generator.addProvider(event.includeServer(), new PiscaryDatabase(output));
        generator.addProvider(event.includeServer(), new PiscaryDataMapProvider(output, event.getLookupProvider()));

        //PackMetadataGenerator
        generator.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.literal("Resources for Harvest Piscary"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
                Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE)))));
    }

    public static ResourceLocation id(String recycler) {
        return ResourceLocationHelper.fromNamespaceAndPath(MODID, recycler);
    }

    public static class PiscarySounds {
        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, Piscary.MODID);
        public static final Holder<SoundEvent> RECYCLER = createSoundEvent("recycler");

        private static Holder<SoundEvent> createSoundEvent(@Nonnull String name) {
            return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Piscary.MODID, name)));
        }
    }
}
