package uk.joshiejack.piscary.world.item.crafting;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import uk.joshiejack.penguinlib.event.DatabaseLoadedEvent;
import uk.joshiejack.penguinlib.world.item.crafting.SimplePenguinRecipe;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.mixin.PiscaryBucketAccessor;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Piscary.MOD_ID)
public class PiscaryRegistries {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Piscary.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Piscary.MOD_ID);
    public static final DeferredHolder<RecipeSerializer<?>, SimplePenguinRecipe.Serializer<RecyclerRecipe>> RECYCLER_SERIALIZER = SERIALIZERS.register("recycler", () -> new SimplePenguinRecipe.Serializer<>(RecyclerRecipe::new));
    public static final DeferredHolder<RecipeType<?>, RecipeType<RecyclerRecipe>> RECYCLER = RECIPE_TYPES.register("recycler", () -> RecipeType.simple(Piscary.id("recycler")));
    public static final DataMapType<EntityType<?>, HatcheryEntry> HATCHERY = DataMapType.builder(new ResourceLocation(Piscary.MOD_ID, "hatchery"), Registries.ENTITY_TYPE,
            HatcheryEntry.CODEC).synced(HatcheryEntry.CODEC, true).build();

    //    private static final Map<EntityType<?>, HatcheryEntry> HATCHERY = new Object2ObjectOpenHashMap<>();
    //private static final Map<Item, EntityType<?>> BUCKET_TO_FISH = new Object2ObjectOpenHashMap<>();

    @SubscribeEvent
    public static void onDatabaseLoaded(DatabaseLoadedEvent event) {
//        HATCHERY.clear(); //Reset all the data in the hatchery :)
//        event.table("hatchery").rows().stream()
//                .map(row -> Pair.of(row.entity(), row.getAsInt("cycles")))
//                .filter(pair -> pair.getKey() != null)
//                .forEach(pair -> HATCHERY.put(pair.getKey(), new HatcheryEntry(pair.getValue(), Items.WATER_BUCKET, Items.AIR)));
        //Create a new table so the old one still functions
//        event.table("hatchery_advanced").rows().stream()
//                .map(row -> Pair.of(row.entity(), new HatcheryEntry(row.getAsInt("cycles"), row.item("water bucket"), row.item("fish bucket"))))
//                .filter(pair -> pair.getKey() != null && !pair.getValue().isAir())
//                .forEach(pair -> {
//                    HATCHERY.put(pair.getKey(), pair.getValue());
//                    BUCKET_TO_FISH.put(pair.getValue().getFishBucket(), pair.getKey());
//                });
    }

    public static boolean containsFish(ItemStack itemStack) {
        return itemStack.getItem() instanceof MobBucketItem;
    }

    @SuppressWarnings("deprecation")
    public static ItemStack getFishBucket(Level world, EntityType<?> type) {
        HatcheryEntry entry = type.builtInRegistryHolder().getData(HATCHERY);
        return entry != null ? entry.getFishBucket(world, type) : ItemStack.EMPTY;
    }

    @Nullable
    public static EntityType<?> getFishFromItem(ItemStack itemStack) {
        return itemStack.getItem() instanceof MobBucketItem item ? item.type : null;
    }

    @SuppressWarnings("deprecation")
    public static int getCycles(EntityType<?> type) {
        HatcheryEntry entry = type.builtInRegistryHolder().getData(HATCHERY);
        return entry != null ? entry.getCycles() : HatcheryEntry.DEFAULT.getCycles();
    }

    @SuppressWarnings("deprecation")
    public static boolean canContainFish(ItemStack held, @Nullable EntityType<?> type) {
        HatcheryEntry entry = type != null ? type.builtInRegistryHolder().getData(HATCHERY) : null;
        return entry != null  && entry.getWaterBucket() == held.getItem();
    }

    @SuppressWarnings("deprecation")
    public static ItemStack getWaterBucket(Level world, EntityType<?> type) {
        HatcheryEntry entry = type.builtInRegistryHolder().getData(HATCHERY);
        return entry != null ? new ItemStack(entry.getWaterBucket()) : ItemStack.EMPTY;
    }
}