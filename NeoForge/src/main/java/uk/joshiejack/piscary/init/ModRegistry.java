package uk.joshiejack.piscary.init;

import fuzs.puzzleslib.api.init.v3.LootContextKeySetFactory;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.context.ContextKeySet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import uk.joshiejack.piscary.Piscary;

public class ModRegistry {
    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder().add(Registries.PAINTING_VARIANT,
            ModPaintingVariants::bootstrap);
    static final RegistryManager REGISTRIES = RegistryManager.from(Piscary.MOD_ID);
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(
            ModItems.PUPFISH);

    static final TagFactory TAGS = TagFactory.make(Piscary.MOD_ID);
    public static final TagKey<Item> FISHES_ITEM_TAG = TAGS.registerItemTag("fishes");
    public static final TagKey<Item> FISHING_BAIT_ITEM_TAG = TAGS.registerItemTag("fishing_bait");
    public static final TagKey<EntityType<?>> FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("fishes");
    public static final TagKey<EntityType<?>> COMMON_FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("common_fishes");
    public static final TagKey<EntityType<?>> UNCOMMON_FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag(
            "uncommon_fishes");
    public static final TagKey<EntityType<?>> RARE_FISHES_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("rare_fishes");
    public static final TagKey<Item> RAW_FISH_FOODS_ITEM_TAG = TagFactory.COMMON.registerItemTag("foods/raw_fish");
    public static final TagKey<Item> RAW_MEAT_FOODS_ITEM_TAG = TagFactory.COMMON.registerItemTag("foods/raw_meat");

    public static final ContextKeySet TREASURE_ITEM_LOOT_CONTEXT_PARAM_SET = LootContextKeySetFactory.registerContextKeySet(
            Piscary.id("treasure_item"),
            (ContextKeySet.Builder builder) -> builder.required(LootContextParams.ORIGIN)
                    .required(LootContextParams.TOOL)
                    .optional(LootContextParams.THIS_ENTITY));

    public static void bootstrap() {
        ModBlocks.bootstrap();
        ModEntityTypes.bootstrap();
        ModItems.bootstrap();
        ModLootTables.bootstrap();
    }
}
