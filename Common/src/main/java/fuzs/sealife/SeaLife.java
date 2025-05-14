package fuzs.sealife;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.context.EntityAttributesContext;
import fuzs.puzzleslib.api.core.v1.context.SpawnPlacementsContext;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeaLife implements ModConstructor {
    public static final String MOD_ID = "sealife";
    public static final String MOD_NAME = "Sea Life";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onConstructMod() {
        ModConstructor.super.onConstructMod();
    }

    @Override
    public void onRegisterEntityAttributes(EntityAttributesContext context) {
        ModConstructor.super.onRegisterEntityAttributes(context);
    }

    @Override
    public void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        ModConstructor.super.onRegisterSpawnPlacements(context);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocationHelper.fromNamespaceAndPath(MOD_ID, path);
    }
}
