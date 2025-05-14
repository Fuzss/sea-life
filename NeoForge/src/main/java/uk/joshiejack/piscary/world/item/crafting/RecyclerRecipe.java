package uk.joshiejack.piscary.world.item.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import uk.joshiejack.penguinlib.data.generator.builder.SimplePenguinRecipeBuilder;
import uk.joshiejack.penguinlib.world.item.crafting.SimplePenguinRecipe;
import uk.joshiejack.piscary.init.ModBlocks;

import javax.annotation.Nonnull;

public class RecyclerRecipe extends SimplePenguinRecipe<RecyclerRecipe> {
    public RecyclerRecipe(Ingredient ingredient, ItemStack output) {
        super(PiscaryRegistries.RECYCLER, PiscaryRegistries.RECYCLER_SERIALIZER, ingredient, output);
    }

    @Nonnull
    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.RECYCLER.get());
    }

    public static SimplePenguinRecipeBuilder<RecyclerRecipe> recycler(Ingredient input, ItemStack output) {
        return new SimplePenguinRecipeBuilder<>(input, output, PiscaryRegistries.RECYCLER_SERIALIZER.get(), RecyclerRecipe::new);
    }

    public static SimplePenguinRecipeBuilder<RecyclerRecipe> recycler(Ingredient input, ItemLike output, int count) {
        return recycler(input, new ItemStack(output, count));
    }
}
