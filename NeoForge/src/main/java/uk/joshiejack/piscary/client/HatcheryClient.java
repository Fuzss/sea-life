package uk.joshiejack.piscary.client;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;
import uk.joshiejack.penguinlib.event.DatabaseLoadedEvent;
import uk.joshiejack.piscary.Piscary;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Piscary.MODID)
public class HatcheryClient {
    private static final Object2FloatMap<EntityType<?>> HATCHERY_RENDERERS = new Object2FloatOpenHashMap<>();

    public static float getRotation(EntityType<?> type) {
        return HATCHERY_RENDERERS.getFloat(type);
    }

    public static boolean rotates(EntityType<?> type) {
        return HATCHERY_RENDERERS.containsKey(type);
    }

    @SubscribeEvent
    public static void onDatabaseLoaded(DatabaseLoadedEvent event) {
        HATCHERY_RENDERERS.clear();
        event.table("hatchery_renderers").rows().stream()
                .map(row -> Pair.of(row.entity(), row.getAsFloat("rotation")))
                .filter(pair -> pair.getKey() != null)
                .forEach(pair -> HATCHERY_RENDERERS.put(pair.getLeft(), (float) pair.getRight()));
    }
}
