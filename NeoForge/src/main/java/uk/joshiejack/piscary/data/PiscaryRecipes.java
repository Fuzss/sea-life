package uk.joshiejack.piscary.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.penguinlib.util.PenguinTags;
import uk.joshiejack.penguinlib.world.item.PenguinItems;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.init.PiscaryItems;
import uk.joshiejack.piscary.world.item.crafting.RecyclerRecipe;

public class PiscaryRecipes extends RecipeProvider {
    public PiscaryRecipes(PackOutput output) {
        super(output);
    }

    private ResourceLocation rl (String name) {
        return Piscary.id(name);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        //Food
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PiscaryItems.FISH_FINGERS::get).requires(PenguinTags.RAW_FISHES).requires(PenguinTags.BREAD).requires(PenguinItems.PLATE.get()).unlockedBy("has_fishes", has(ItemTags.FISHES)).unlockedBy("has_bread", has(PenguinTags.BREAD)).save(consumer, rl("fish_fingers"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PiscaryItems.SASHIMI::get).requires(PenguinTags.RAW_FISHES).requires(PenguinItems.PLATE.get()).unlockedBy("has_fishes", has(ItemTags.FISHES)).save(consumer, rl("sashimi"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, PiscaryItems.FISH_STEW::get).requires(PenguinTags.RAW_FISHES).requires(Tags.Items.CROPS_CARROT).requires(PenguinItems.DEEP_BOWL.get()).unlockedBy("has_fishes", has(ItemTags.FISHES)).unlockedBy("has_carrot", has(Tags.Items.CROPS_CARROT)).save(consumer, rl("fish_stew"));
        //Bait
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PiscaryItems.BAIT::get, 64).requires(Items.BEEF).unlockedBy("has_beef", has(Items.BEEF)).save(consumer, rl("bait"));
        //Machines
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, PiscaryItems.FISH_TRAP::get).define('W', ItemTags.LOGS).define('S', Tags.Items.STRING).pattern("WSW").pattern("S S").pattern("WSW").unlockedBy("has_string", has(Tags.Items.STRING)).save(consumer, rl("fish_trap"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, PiscaryItems.HATCHERY::get).define('F', ItemTags.WOODEN_FENCES).define('S', ItemTags.WOODEN_SLABS).pattern("F F").pattern("F F").pattern("SSS").unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer, rl("hatchery"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, PiscaryItems.RECYCLER::get).define('S', Tags.Items.STONE).define('W', Tags.Items.RODS_WOODEN).define('P', Blocks.PISTON).define('L', Blocks.LEVER).pattern("SWS").pattern("SPS").pattern("SLS").unlockedBy("has_redstone", has(Tags.Items.DUSTS_REDSTONE)).save(consumer, rl("recycler"));
        //Recycler
        RecyclerRecipe.recycler(Ingredient.of(PiscaryItems.FISH_BONES.get()), Items.BONE_MEAL, 2).save(consumer, rl("fish_bones"));
        RecyclerRecipe.recycler(Ingredient.of(PiscaryItems.EMPTY_CAN.get()), Items.IRON_NUGGET, 3).save(consumer, rl("tin_can"));
        RecyclerRecipe.recycler(Ingredient.of(PiscaryItems.FISH_FOSSIL.get()), Items.COAL, 1).save(consumer, rl("fossil"));
        RecyclerRecipe.recycler(Ingredient.of(ItemTags.WOOL), Items.STRING, 3).save(consumer, rl("wool"));
    }
}
