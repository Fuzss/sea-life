package uk.joshiejack.piscary.world.item.crafting;

import joptsimple.internal.Strings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import uk.joshiejack.penguinlib.event.DatabaseLoadedEvent;
import uk.joshiejack.piscary.Piscary;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Piscary.MODID)
public class BaitRegistry {
    private static final Map<Item, BaitData> INSTANCE = new HashMap<>();

    @SubscribeEvent
    public static void onDatabaseLoaded(DatabaseLoadedEvent event) {
        INSTANCE.clear();
        event.table("bait").rows().forEach(row -> {
            Item item = row.item();
            if (item != Items.AIR)
                INSTANCE.put(item, new BaitData(row.get("loot table"), row.getColor("speed"), row.getAsInt("luck")));
        });
    }

    public static BaitData getValue(ItemStack stack) {
        return INSTANCE.getOrDefault(stack.getItem(), BaitData.EMPTY);
    }

    public static boolean isBait(ItemStack stack) {
        return INSTANCE.containsKey(stack.getItem());
    }

    public static class BaitData {
        public static final BaitData EMPTY = new BaitData(Strings.EMPTY, 0, 0);
        private final ResourceLocation lootTable;
        private final int speed, luck;

        BaitData(@Nonnull String lootTable, int speed, int luck) {
            this.lootTable = new ResourceLocation(lootTable);
            this.speed = speed;
            this.luck = luck;
        }

        @Nullable
        public ResourceLocation getLootTable() {
            return lootTable;
        }

        public int getSpeed() {
            return speed;
        }

        public int getLuck() {
            return luck;
        }
    }
}
