package uk.joshiejack.piscary.data;

import it.unimi.dsi.fastutil.Pair;
import joptsimple.internal.Strings;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.init.ModEntityTypes;
import uk.joshiejack.piscary.init.PiscaryItems;

import java.util.Objects;

public class PiscaryItemModels extends ItemModelProvider {
    public PiscaryItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Piscary.MODID, existingFileHelper);
    }

    private void registerModels(DeferredRegister<Item> items) {
        items.getEntries().stream()
                .map(dh -> Pair.of(dh.getId(), dh.get()))
                .forEach(pair -> {
                    String path = Objects.requireNonNull(pair.key()).getPath();
                    Item item = pair.value();
                    if (item instanceof BlockItem)
                        getBuilder(path).parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
                    else {
                        if (path.contains("spawn_egg")) {
                            withExistingParent(path, mcLoc("item/template_spawn_egg"));
                        } else {
                            String subdir =
                                    path.contains("bait") ? Strings.EMPTY :
                                            item.getFoodProperties() != null && item.getFoodProperties().getNutrition() > 3 ? "meal/" :
                                                    pair.key().getPath().contains("bucket") ? "bucket/" :
                                                            item.getFoodProperties() == null ? "loot/" :
                                                                    "fish/";
                            singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + subdir + path.replace("_bucket", "")));
                        }
                    }
                });
    }

    @Override
    protected void registerModels() {
        registerModels(PiscaryItems.ITEMS);
        registerModels(ModEntityTypes.ITEMS);
    }
}
