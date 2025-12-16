package fuzs.sealife.config;

import fuzs.puzzleslib.api.config.v3.Config;
import fuzs.puzzleslib.api.config.v3.ConfigCore;

public class ServerConfig implements ConfigCore {
    @Config(description = "Chance in percent for the fish trap block to permanently break when taking out the caught item.")
    @Config.DoubleRange(min = 0.0, max = 1.0)
    public double fishTrapBreakingChance = 0.25;
}
