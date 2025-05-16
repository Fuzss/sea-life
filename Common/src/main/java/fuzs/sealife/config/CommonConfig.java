package fuzs.sealife.config;

import fuzs.puzzleslib.api.config.v3.Config;
import fuzs.puzzleslib.api.config.v3.ConfigCore;

public class CommonConfig implements ConfigCore {
    @Config
    public final FishSpawnConfig anchovy = new FishSpawnConfig(14, 8, 12);
    @Config
    public final FishSpawnConfig angelfish = new FishSpawnConfig(3, 3, 5);
    @Config
    public final FishSpawnConfig anglerfish = new FishSpawnConfig(1, 1, 1);
    @Config
    public final FishSpawnConfig bass = new FishSpawnConfig(6, 3, 5);
    @Config
    public final FishSpawnConfig blue_tang = new FishSpawnConfig(1, 2, 3);
    @Config
    public final FishSpawnConfig bowfin = new FishSpawnConfig(3, 3, 5);
    @Config
    public final FishSpawnConfig butterflyfish = new FishSpawnConfig(1, 3, 5);
    @Config
    public final FishSpawnConfig carp = new FishSpawnConfig(2, 4, 6);
    @Config
    public final FishSpawnConfig catfish = new FishSpawnConfig(3, 1, 2);
    @Config
    public final FishSpawnConfig chub = new FishSpawnConfig(10, 5, 7);
    @Config
    public final FishSpawnConfig damselfish = new FishSpawnConfig(3, 2, 3);
    @Config
    public final FishSpawnConfig electric_ray = new FishSpawnConfig(1, 1, 1);
    @Config
    public final FishSpawnConfig goldfish = new FishSpawnConfig(12, 1, 2);
    @Config
    public final FishSpawnConfig koi = new FishSpawnConfig(1, 1, 2);
    @Config
    public final FishSpawnConfig lamprey = new FishSpawnConfig(4, 1, 1);
    @Config
    public final FishSpawnConfig lungfish = new FishSpawnConfig(1, 1, 1);
    @Config
    public final FishSpawnConfig manta_ray = new FishSpawnConfig(1, 1, 1);
    @Config
    public final FishSpawnConfig minnow = new FishSpawnConfig(14, 5, 8);
    @Config
    public final FishSpawnConfig neon_tetra = new FishSpawnConfig(2, 5, 8);
    @Config
    public final FishSpawnConfig northern_pike = new FishSpawnConfig(1, 1, 2);
    @Config
    public final FishSpawnConfig perch = new FishSpawnConfig(10, 3, 5);
    @Config
    public final FishSpawnConfig pickerel = new FishSpawnConfig(2, 2, 3);
    @Config
    public final FishSpawnConfig piranha = new FishSpawnConfig(1, 3, 5);
    @Config
    public final FishSpawnConfig pupfish = new FishSpawnConfig(4, 3, 5);
    @Config
    public final FishSpawnConfig sardine = new FishSpawnConfig(12, 7, 12);
    @Config
    public final FishSpawnConfig siamese_fighting_fish = new FishSpawnConfig(2, 1, 1);
    @Config
    public final FishSpawnConfig silver_stripe_blaasop = new FishSpawnConfig(1, 1, 1);
    @Config
    public final FishSpawnConfig whitemargin_stargazer = new FishSpawnConfig(2, 1, 1);
    @Config
    public final FishSpawnConfig stingray = new FishSpawnConfig(1, 1, 1);
    @Config
    public final FishSpawnConfig trout = new FishSpawnConfig(8, 4, 6);
    @Config
    public final FishSpawnConfig tuna = new FishSpawnConfig(2, 3, 5);
    @Config
    public final FishSpawnConfig walleye = new FishSpawnConfig(5, 2, 3);

    public static class FishSpawnConfig implements ConfigCore {
        @Config(description = "How often this mob should spawn, higher values produce more spawns.")
        @Config.IntRange(min = 0)
        public int weight;
        @Config(description = "The minimum count of mobs to spawn in a pack.")
        @Config.IntRange(min = 0)
        public int minCount;
        @Config(description = "The maximum count of mobs to spawn in a pack.")
        @Config.IntRange(min = 0)
        public int maxCount;

        public FishSpawnConfig(int weight, int minCount, int maxCount) {
            this.weight = weight;
            this.minCount = minCount;
            this.maxCount = maxCount;
        }
    }
}
