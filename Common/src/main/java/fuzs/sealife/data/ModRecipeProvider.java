package fuzs.sealife.data;

import fuzs.puzzleslib.api.data.v2.AbstractRecipeProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.sealife.init.ModItems;
import fuzs.sealife.init.ModRegistry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addRecipes(RecipeOutput recipeOutput) {
        //Food
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.FOOD, ModItems.FISH_FINGERS.value())
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.BREAD)
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.BREAD)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModRegistry.RAW_FISH_FOODS_ITEM_TAG),
                        this.has(ModRegistry.RAW_FISH_FOODS_ITEM_TAG))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.FOOD, ModItems.SASHIMI.value())
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModRegistry.RAW_FISH_FOODS_ITEM_TAG),
                        this.has(ModRegistry.RAW_FISH_FOODS_ITEM_TAG))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.FOOD, ModItems.FISH_STEW.value())
                .requires(ModRegistry.RAW_FISH_FOODS_ITEM_TAG)
                .requires(Items.CARROT)
                .requires(Items.BAKED_POTATO)
                .requires(Items.BEETROOT)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(ModRegistry.RAW_FISH_FOODS_ITEM_TAG),
                        this.has(ModRegistry.RAW_FISH_FOODS_ITEM_TAG))
                .save(recipeOutput);
        //Machines
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.DECORATIONS, ModItems.FISH_TRAP.value())
                .define('W', ItemTags.LOGS)
                .define('S', Items.STRING)
                .pattern("WSW")
                .pattern("S S")
                .pattern("WSW")
                .unlockedBy(getHasName(Items.STRING), this.has(Items.STRING))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(this.items(), RecipeCategory.DECORATIONS, ModItems.HATCHERY.value())
                .define('F', ItemTags.WOODEN_FENCES)
                .define('S', ItemTags.WOODEN_SLABS)
                .pattern("F F")
                .pattern("F F")
                .pattern("SSS")
                .unlockedBy(getHasName(ItemTags.PLANKS), this.has(ItemTags.PLANKS))
                .save(recipeOutput);
        //Recycler
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.MISC, Items.BONE_MEAL, 2)
                .requires(ModItems.FISH_BONES.value())
                .unlockedBy(getHasName(ModItems.FISH_BONES.value()), this.has(ModItems.FISH_BONES.value()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.MISC, Items.IRON_NUGGET, 3)
                .requires(ModItems.EMPTY_CAN.value())
                .unlockedBy(getHasName(ModItems.EMPTY_CAN.value()), this.has(ModItems.EMPTY_CAN.value()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(this.items(), RecipeCategory.MISC, Items.COAL)
                .requires(ModItems.FISH_FOSSIL.value())
                .unlockedBy(getHasName(ModItems.FISH_FOSSIL.value()), this.has(ModItems.FISH_FOSSIL.value()))
                .save(recipeOutput);
    }
}
