package fuzs.sealife.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.sealife.init.ModItems;
import fuzs.sealife.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemTagProvider extends AbstractTagProvider<Item> {

    public ModItemTagProvider(DataProviderContext context) {
        super(Registries.ITEM, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(ModRegistry.FISHES_ITEM_TAG)
                .add(ModItems.ANCHOVY.value(),
                        ModItems.ANGELFISH.value(),
                        ModItems.ANGLERFISH.value(),
                        ModItems.BASS.value(),
                        ModItems.BLUE_TANG.value(),
                        ModItems.BOWFIN.value(),
                        ModItems.BUTTERFLYFISH.value(),
                        ModItems.CARP.value(),
                        ModItems.CATFISH.value(),
                        ModItems.CHUB.value(),
                        ModItems.DAMSELFISH.value(),
                        ModItems.ELECTRIC_RAY.value(),
                        ModItems.GOLDFISH.value(),
                        ModItems.KOI.value(),
                        ModItems.LAMPREY.value(),
                        ModItems.LUNGFISH.value(),
                        ModItems.MANTA_RAY.value(),
                        ModItems.MINNOW.value(),
                        ModItems.NEON_TETRA.value(),
                        ModItems.NORTHERN_PIKE.value(),
                        ModItems.PERCH.value(),
                        ModItems.PICKEREL.value(),
                        ModItems.PIRANHA.value(),
                        ModItems.PUPFISH.value(),
                        ModItems.SARDINE.value(),
                        ModItems.SIAMESE_FIGHTING_FISH.value(),
                        ModItems.WHITEMARGIN_STARGAZER.value(),
                        ModItems.STINGRAY.value(),
                        ModItems.SILVER_STRIPE_BLAASOP.value(),
                        ModItems.TROUT.value(),
                        ModItems.TUNA.value(),
                        ModItems.WALLEYE.value());
        this.tag(ItemTags.FISHES).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.WOLF_FOOD).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ModRegistry.RAW_FISH_FOODS_ITEM_TAG).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.PIGLIN_LOVED).add(ModItems.GOLDFISH.value());
        this.tag(ModRegistry.FISHING_BAIT_ITEM_TAG).add(Items.ROTTEN_FLESH).addTag(ModRegistry.RAW_MEAT_FOODS_ITEM_TAG);
        this.tag("c:foods/soup")
                .add(ModItems.FISH_FINGERS.value(), ModItems.SASHIMI.value(), ModItems.FISH_STEW.value());
    }
}
