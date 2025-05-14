package uk.joshiejack.piscary.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

public class PiscaryFoods {
    public static final FoodProperties SMALL_FISH = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties MEDIUM_FISH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties LARGE_FISH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build();
    public static final FoodProperties FISH_FINGERS = new FoodProperties.Builder().nutrition(5).saturationModifier(0.3F).fast().build();
    public static final FoodProperties SASHIMI = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build();
    public static final FoodProperties FISH_STEW = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build();
    public static final Consumable FISH_FINGERS_CONSUMABLE = Consumables.defaultFood().consumeSeconds(0.8F).build();
}
