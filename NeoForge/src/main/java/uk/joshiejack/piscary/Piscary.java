package uk.joshiejack.piscary;

import fuzs.sealife.SeaLife;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import uk.joshiejack.piscary.data.*;
import uk.joshiejack.piscary.data.client.ModLanguageProvider;
import uk.joshiejack.piscary.data.tags.ModItemTagProvider;
import uk.joshiejack.piscary.init.PiscaryBlockEntities;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;
import uk.joshiejack.piscary.world.loot.PiscaryLoot;


public class Piscary {
    public static final String MOD_ID = SeaLife.MOD_ID;

    public Piscary(IEventBus eventBus) {
        PiscaryRegistries.RECIPE_TYPES.register(eventBus);
        PiscaryRegistries.SERIALIZERS.register(eventBus);
    }

    @SubscribeEvent
    public static void onDataGathering(final GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        final PackOutput output = event.getGenerator().getPackOutput();
        //Add the datapack entries
        //Client
        generator.addProvider(event.includeClient(), new PiscaryBlockStates(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new PiscaryItemModels(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(output));
        generator.addProvider(event.includeClient(), new PiscarySoundDefinitions(output, event.getExistingFileHelper()));

        //Server
        PiscaryBlockTags blocktags = new PiscaryBlockTags(output, event.getLookupProvider(), event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blocktags);
        generator.addProvider(event.includeServer(), new PiscaryLootTables(output));
        generator.addProvider(event.includeServer(), new ModItemTagProvider(output, event.getLookupProvider(), blocktags.contentsGetter(), event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output));
        generator.addProvider(event.includeServer(), new PiscaryDataMapProvider(output, event.getLookupProvider()));
    }

    public static ResourceLocation id(String recycler) {
        return SeaLife.id(recycler);
    }
}
