package uk.joshiejack.piscary.data;

import com.google.common.collect.Lists;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.penguinlib.data.generator.PenguinItemTags;
import uk.joshiejack.penguinlib.util.PenguinTags;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.init.PiscaryItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PiscaryItemTags extends PenguinItemTags {
    public PiscaryItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockLookup, ExistingFileHelper existingFileHelper) {
        super(output, provider, blockLookup, existingFileHelper, Piscary.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        List<Item> fishes = Lists.newArrayList(PiscaryItems.ANCHOVY.get(), PiscaryItems.ANGELFISH.get(), PiscaryItems.ANGLERFISH.get(), PiscaryItems.BASS.get()
                , PiscaryItems.BLUE_TANG.get(), PiscaryItems.BOWFIN.get(), PiscaryItems.BUTTERFLYFISH.get(), PiscaryItems.CARP.get()
                , PiscaryItems.CATFISH.get(), PiscaryItems.CHUB.get()
                , PiscaryItems.DAMSELFISH.get(), PiscaryItems.ELECTRIC_RAY.get(), PiscaryItems.GOLDFISH.get()
                , PiscaryItems.KOI.get(), PiscaryItems.LAMPREY.get(), PiscaryItems.LUNGFISH.get(), PiscaryItems.MANTA_RAY.get()
                , PiscaryItems.MINNOW.get(), PiscaryItems.NEON_TETRA.get(), PiscaryItems.NORTHERN_PIKE.get(), PiscaryItems.PERCH.get()
                , PiscaryItems.PICKEREL.get(), PiscaryItems.PIRANHA.get(), PiscaryItems.PUPFISH.get()
                , PiscaryItems.SARDINE.get(), PiscaryItems.SIAMESE_FIGHTING_FISH.get(), PiscaryItems.WHITEMARGIN_STARGAZER.get()
                , PiscaryItems.STINGRAY.get(), PiscaryItems.SILVER_STRIPE_BLAASOP.get(), PiscaryItems.TROUT.get(), PiscaryItems.TUNA.get()
                , PiscaryItems.WALLEYE.get());
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item> rawTag = tag(PenguinTags.RAW_FISHES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item> allTag = tag(ItemTags.FISHES);

        fishes.forEach(fish -> {
            rawTag.add(fish);
            allTag.add(fish);
        });

        tag(ItemTags.PIGLIN_LOVED).add(PiscaryItems.GOLDFISH.get());
    }
}
