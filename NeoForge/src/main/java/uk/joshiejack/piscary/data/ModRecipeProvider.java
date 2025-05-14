package uk.joshiejack.piscary.data;

import fuzs.puzzleslib.api.data.v2.AbstractRecipeProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import uk.joshiejack.piscary.init.ModRegistry;
import uk.joshiejack.piscary.init.PiscaryItems;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addRecipes(RecipeOutput recipeOutput) {
        //Food
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.FOOD, PiscaryItems.FISH_FINGERS.value())
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.BREAD)
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.BREAD)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModRegistry.RAW_FISH_FOODS_ITEM_TAG),
                        this.has(ModRegistry.RAW_FISH_FOODS_ITEM_TAG))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.FOOD, PiscaryItems.SASHIMI.value())
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModRegistry.RAW_FISH_FOODS_ITEM_TAG),
                        this.has(ModRegistry.RAW_FISH_FOODS_ITEM_TAG))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.FOOD, PiscaryItems.FISH_STEW.value())
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.CARROT)
                .requires(Items.BAKED_POTATO)
                .requires(Items.BEETROOT)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModRegistry.RAW_FISH_FOODS_ITEM_TAG),
                        this.has(ModRegistry.RAW_FISH_FOODS_ITEM_TAG))
                .save(recipeOutput);
        //Machines
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.DECORATIONS, PiscaryItems.FISH_TRAP.value())
                .define('W', ItemTags.LOGS)
                .define('S', Items.STRING)
                .pattern("WSW")
                .pattern("S S")
                .pattern("WSW")
                .unlockedBy(getHasName(Items.STRING), this.has(Items.STRING))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.DECORATIONS, PiscaryItems.HATCHERY.value())
                .define('F', ItemTags.WOODEN_FENCES)
                .define('S', ItemTags.WOODEN_SLABS)
                .pattern("F F")
                .pattern("F F")
                .pattern("SSS")
                .unlockedBy(getHasName(ItemTags.PLANKS), this.has(ItemTags.PLANKS))
                .save(recipeOutput);
        //Recycler
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.MISC, Items.BONE_MEAL, 2)
                .requires(PiscaryItems.FISH_BONES.value())
                .unlockedBy(getHasName(PiscaryItems.FISH_BONES.value()), this.has(PiscaryItems.FISH_BONES.value()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.MISC, Items.IRON_NUGGET, 3)
                .requires(PiscaryItems.EMPTY_CAN.value())
                .unlockedBy(getHasName(PiscaryItems.EMPTY_CAN.value()), this.has(PiscaryItems.EMPTY_CAN.value()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.MISC, Items.COAL)
                .requires(PiscaryItems.FISH_FOSSIL.value())
                .unlockedBy(getHasName(PiscaryItems.FISH_FOSSIL.value()), this.has(PiscaryItems.FISH_FOSSIL.value()))
                .save(recipeOutput);
    }
}
