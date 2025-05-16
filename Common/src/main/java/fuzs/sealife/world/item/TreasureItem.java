package fuzs.sealife.world.item;

import fuzs.puzzleslib.api.item.v2.GiveItemHelper;
import fuzs.puzzleslib.api.util.v1.InteractionResultHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import fuzs.sealife.init.ModRegistry;

import java.util.List;

public class TreasureItem extends Item {
    private final ResourceKey<LootTable> lootTable;

    public TreasureItem(Item.Properties properties, ResourceKey<LootTable> lootTable) {
        super(properties);
        this.lootTable = lootTable;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {

        ItemStack itemInHand = player.getItemInHand(interactionHand);
        ItemStack originalItemInHand = itemInHand.copy();
        // consume first, so the slot can potentially be used for received items
        itemInHand.consume(1, player);

        if (level instanceof ServerLevel serverLevel) {

            LootTable lootTable = serverLevel.getServer()
                    .reloadableRegistries()
                    .getLootTable(this.lootTable);
            List<ItemStack> items = lootTable.getRandomItems(new LootParams.Builder(serverLevel).withParameter(
                            LootContextParams.ORIGIN,
                            player.position())
                    .withParameter(LootContextParams.TOOL, originalItemInHand)
                    .withOptionalParameter(LootContextParams.THIS_ENTITY, player)
                    .create(ModRegistry.TREASURE_ITEM_LOOT_CONTEXT_PARAM_SET));
            for (ItemStack itemStack : items) {
                GiveItemHelper.giveItem(itemStack, (ServerPlayer) player);
            }
        }

        return InteractionResultHelper.sidedSuccess(itemInHand, level.isClientSide);
    }
}
