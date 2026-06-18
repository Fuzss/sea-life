package fuzs.sealife.common.data.tags;

import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import fuzs.sealife.common.init.ModItems;
import fuzs.sealife.common.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

public class ModItemTagsProvider extends AbstractTagProvider<Item> {

    public ModItemTagsProvider(DataProviderContext context) {
        super(Registries.ITEM, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(ModRegistry.FISHES_ITEM_TAG)
                .add(ModItems.ANCHOVY,
                        ModItems.ANGELFISH,
                        ModItems.ANGLERFISH,
                        ModItems.BASS,
                        ModItems.BLUE_TANG,
                        ModItems.BOWFIN,
                        ModItems.BUTTERFLYFISH,
                        ModItems.CARP,
                        ModItems.CATFISH,
                        ModItems.CHUB,
                        ModItems.DAMSELFISH,
                        ModItems.ELECTRIC_RAY,
                        ModItems.GOLDFISH,
                        ModItems.KOI,
                        ModItems.LAMPREY,
                        ModItems.LUNGFISH,
                        ModItems.MANTA_RAY,
                        ModItems.MINNOW,
                        ModItems.NEON_TETRA,
                        ModItems.NORTHERN_PIKE,
                        ModItems.PERCH,
                        ModItems.PICKEREL,
                        ModItems.PIRANHA,
                        ModItems.PUPFISH,
                        ModItems.SARDINE,
                        ModItems.SIAMESE_FIGHTING_FISH,
                        ModItems.WHITEMARGIN_STARGAZER,
                        ModItems.STINGRAY,
                        ModItems.SILVER_STRIPE_BLAASOP,
                        ModItems.TROUT,
                        ModItems.TUNA,
                        ModItems.WALLEYE);
        this.tag(ItemTags.FISHES).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.WOLF_FOOD)
                .add(ModItems.FISH_FINGERS, ModItems.SASHIMI, ModItems.FISH_STEW)
                .addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.OCELOT_FOOD).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.CAT_FOOD).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ModRegistry.RAW_FISH_FOODS_ITEM_TAG).addTag(ModRegistry.FISHES_ITEM_TAG);
        this.tag(ItemTags.PIGLIN_LOVED).add(ModItems.GOLDFISH);
        this.tag(ModRegistry.FISHING_BAIT_ITEM_TAG)
                .add(ItemIds.ROTTEN_FLESH)
                .addOptionalTag(ModRegistry.RAW_MEAT_FOODS_ITEM_TAG);
        this.tag("c:foods/soup").add(ModItems.FISH_FINGERS, ModItems.SASHIMI, ModItems.FISH_STEW);
    }
}
