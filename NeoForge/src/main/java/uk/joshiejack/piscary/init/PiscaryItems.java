package uk.joshiejack.piscary.init;

import net.minecraft.core.Holder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.item.BaitItem;
import uk.joshiejack.piscary.world.item.HatcheryItem;
import uk.joshiejack.piscary.world.item.PiscaryFoods;
import uk.joshiejack.piscary.world.item.TreasureItem;

public class PiscaryItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Piscary.MODID);
    //Bait
    public static final Holder.Reference<Item> BAIT = ITEMS.register("bait", BaitItem::new);
    //Fish
    public static final Holder.Reference<Item> ANCHOVY = ModRegistry.REGISTRIES.registerItem("anchovy",
            () -> new Item.Properties().food(PiscaryFoods.SMALL_FISH));
    public static final Holder.Reference<Item> ANGELFISH = ITEMS.register("angelfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> ANGLERFISH = ITEMS.register("anglerfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> BASS = ITEMS.register("bass",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> BLUE_TANG = ITEMS.register("blue_tang",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> BOWFIN = ITEMS.register("bowfin",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> BUTTERFLYFISH = ITEMS.register("butterflyfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> CARP = ITEMS.register("carp",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> CATFISH = ITEMS.register("catfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> CHUB = ITEMS.register("chub",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> DAMSELFISH = ITEMS.register("damselfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> ELECTRIC_RAY = ITEMS.register("electric_ray",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> GOLDFISH = ITEMS.register("goldfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> KOI = ITEMS.register("koi",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> LAMPREY = ITEMS.register("lamprey",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> LUNGFISH = ITEMS.register("lungfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> MANTA_RAY = ITEMS.register("manta_ray",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> MINNOW = ITEMS.register("minnow",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> NEON_TETRA = ITEMS.register("neon_tetra",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> NORTHERN_PIKE = ITEMS.register("northern_pike",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> PERCH = ITEMS.register("perch",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> PICKEREL = ITEMS.register("pickerel",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> PIRANHA = ITEMS.register("piranha",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> PUPFISH = ITEMS.register("pupfish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> SARDINE = ITEMS.register("sardine",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> SIAMESE_FIGHTING_FISH = ITEMS.register("siamese_fighting_fish",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final Holder.Reference<Item> STINGRAY = ITEMS.register("stingray",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> SILVER_STRIPE_BLAASOP = ITEMS.register("silver_stripe_blaasop",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> TROUT = ITEMS.register("trout",
            () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final Holder.Reference<Item> TUNA = ITEMS.register("tuna",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> WALLEYE = ITEMS.register("walleye",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final Holder.Reference<Item> WHITEMARGIN_STARGAZER = ITEMS.register("whitemargin_stargazer",
            () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));

    //Loot
    public static final Holder.Reference<Item> FISH_BONES = ITEMS.register("fish_bones",
            () -> new Item(new Item.Properties()));
    public static final Holder.Reference<Item> FISH_FOSSIL = ITEMS.register("fish_fossil",
            () -> new Item(new Item.Properties()));
    public static final Holder.Reference<Item> EMPTY_CAN = ITEMS.register("empty_can",
            () -> new Item(new Item.Properties()));
    public static final Holder.Reference<Item> PIRATE_TREASURE = ITEMS.register("pirate_treasure",
            () -> new TreasureItem(new Item.Properties()));
    //Meals
    public static final Holder.Reference<Item> FISH_FINGERS = ITEMS.register("fish_fingers",
            () -> new Item(new Item.Properties().food(PiscaryFoods.FISH_FINGERS)));
    public static final Holder.Reference<Item> SASHIMI = ITEMS.register("sashimi",
            () -> new Item(new Item.Properties().food(PiscaryFoods.SASHIMI)));
    public static final Holder.Reference<Item> FISH_STEW = ITEMS.register("fish_stew",
            () -> new Item(new Item.Properties().food(PiscaryFoods.FISH_STEW)));
    public static final Holder.Reference<Item> FISH_TRAP = ITEMS.register("fish_trap",
            () -> new BlockItem(ModBlocks.FISH_TRAP.get(), new Item.Properties()));
    public static final Holder.Reference<Item> HATCHERY = ITEMS.register("hatchery",
            () -> new HatcheryItem(ModBlocks.HATCHERY.get(), new Item.Properties()));
    public static final Holder.Reference<Item> RECYCLER = ITEMS.register("recycler",
            () -> new BlockItem(ModBlocks.RECYCLER.get(), new Item.Properties()));
}
