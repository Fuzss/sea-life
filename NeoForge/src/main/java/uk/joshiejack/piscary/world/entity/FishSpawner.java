//package uk.joshiejack.piscary.world.entity;
//
//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;
//import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
//import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
//import net.minecraft.world.entity.EntityClassification;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.util.RegistryKey;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.MobSpawnInfo;
//import net.minecraftforge.common.BiomeDictionary;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//import net.minecraftforge.eventbus.api.EventPriority;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.ForgeRegistries;
//import uk.joshiejack.penguinlib.events.DatabaseLoadedEvent;
//import uk.joshiejack.piscary.Piscary;
//
//import java.util.Locale;
//
///** TODO: move to datapack entries */
//@Mod.EventBusSubscriber(modid = Piscary.MODID)
//public class FishSpawner {
//    private static final Multimap<EntityType<?>, BiomeDictionary.Type> INCLUDE = HashMultimap.create();
//    private static final Multimap<EntityType<?>, BiomeDictionary.Type> EXCLUDE = HashMultimap.create();
//    private static final Object2ObjectMap<EntityType<?>, FishSpawnSettings> SETTINGS = new Object2ObjectOpenHashMap<>();
//
//    @SubscribeEvent
//    public static void onDatabaseReloaded(DatabaseLoadedEvent event) {
//        INCLUDE.clear();
//        EXCLUDE.clear();
//        SETTINGS.clear();
//        event.table("fish_spawn_biomes").rows().forEach(row -> {
//            EntityType<?> type = row.entity();
//            BiomeDictionary.Type biomeType = BiomeDictionary.Type.getType(row.get("biome type").toString().toUpperCase(Locale.ROOT));
//            if (type != null && biomeType != null)
//                if (row.get("type").equals("exclude"))
//                    EXCLUDE.get(type).add(biomeType);
//                else
//                    INCLUDE.get(type).add(biomeType);
//        });
//
//        event.table("fish_spawn_settings").rows().forEach(row -> {
//            EntityType<?> type = row.entity();
//            if (type != null)
//                SETTINGS.put(type, new FishSpawnSettings(row.getAsInt("min"), row.getAsInt("max"), row.getAsInt("weight")));
//        });
//    }
//
//    @SubscribeEvent(priority = EventPriority.HIGH)
//    public static void addSpawn(BiomeLoadingEvent event) {
//        if (event.getName() != null) {
//            Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
//            if (biome != null) {
//                SETTINGS.forEach((entity, settings) -> {
//                    if (canFishSpawnHere(entity, RegistryKey.create(ForgeRegistries.Keys.BIOMES, event.getName()))) {
//                        EntityClassification classification = entity == PiscaryEntities.PIRANHA.get() ? EntityClassification.MONSTER :
//                                entity == PiscaryEntities.MANTA_RAY.get() ? EntityClassification.WATER_CREATURE
//                                        : EntityClassification.WATER_AMBIENT;
//                        event.getSpawns().getSpawner(classification).add(new MobSpawnInfo.Spawners(entity, settings.weight, settings.min, settings.min));
//                    }
//                });
//            }
//        }
//    }
//
//    private static boolean canFishSpawnHere(EntityType<?> entity, RegistryKey<Biome> biome) {
//        return EXCLUDE.get(entity).stream().noneMatch(t -> BiomeDictionary.hasType(biome, t)) &&
//                (INCLUDE.get(entity).isEmpty() || INCLUDE.get(entity).stream().allMatch(t -> BiomeDictionary.hasType(biome, t)));
//    }
//
//    private static class FishSpawnSettings {
//        public int min, max, weight;
//
//        public FishSpawnSettings(int min, int max, int weight) {
//            this.min = min;
//            this.min = max;
//            this.weight = weight;
//        }
//    }
//}
