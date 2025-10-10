package fuzs.sealife.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import java.util.Collection;

@Deprecated
public final class CreativeModeTabHelper {
    static final Collection<Item> POTION_ITEMS = ImmutableSet.of(Items.POTION,
            Items.SPLASH_POTION,
            Items.LINGERING_POTION,
            Items.TIPPED_ARROW);

    private CreativeModeTabHelper() {
        // NO-OP
    }

    public static Component getTitle(ResourceLocation resourceLocation) {
        String translationKey = "itemGroup.%s.%s".formatted(resourceLocation.getNamespace(),
                resourceLocation.getPath());
        return Component.translatable(translationKey);
    }

    public static CreativeModeTab.DisplayItemsGenerator getDisplayItems(String modId) {
        return (CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) -> {
            itemDisplayParameters.holders().lookup(Registries.ITEM).ifPresent(registryLookup -> {
                registryLookup.listElements()
                        .filter(holder -> holder.key().location().getNamespace().equals(modId))
                        .map(ItemStack::new)
                        .forEach(itemStack -> output.accept(itemStack,
                                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
            });
            itemDisplayParameters.holders().lookup(Registries.ENCHANTMENT).ifPresent(registryLookup -> {
                CreativeModeTabs.generateEnchantmentBookTypesOnlyMaxLevel((ItemStack itemStack, CreativeModeTab.TabVisibility tabVisibility) -> {
                    if (itemStack.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY)
                            .keySet()
                            .stream()
                            .findAny()
                            .flatMap(Holder::unwrapKey)
                            .map(ResourceKey::location)
                            .map(ResourceLocation::getNamespace)
                            .filter(modId::equals)
                            .isPresent()) {
                        output.accept(itemStack, tabVisibility);
                    }
                }, registryLookup, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            });
            itemDisplayParameters.holders().lookup(Registries.POTION).ifPresent(registryLookup -> {
                for (Item item : POTION_ITEMS) {
                    CreativeModeTabs.generatePotionEffectTypes((ItemStack itemStack, CreativeModeTab.TabVisibility tabVisibility) -> {
                                if (itemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)
                                        .potion()
                                        .flatMap(Holder::unwrapKey)
                                        .map(ResourceKey::location)
                                        .map(ResourceLocation::getNamespace)
                                        .filter(modId::equals)
                                        .isPresent()) {
                                    output.accept(itemStack, tabVisibility);
                                }
                            },
                            registryLookup,
                            item,
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS,
                            itemDisplayParameters.enabledFeatures());
                }
            });
            itemDisplayParameters.holders()
                    .lookup(Registries.PAINTING_VARIANT)
                    .ifPresent(registryLookup -> CreativeModeTabs.generatePresetPaintings(output,
                            itemDisplayParameters.holders(),
                            registryLookup,
                            holder -> holder.unwrapKey()
                                    .map(ResourceKey::location)
                                    .map(ResourceLocation::getNamespace)
                                    .filter(modId::equals)
                                    .isPresent(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
        };
    }
}
