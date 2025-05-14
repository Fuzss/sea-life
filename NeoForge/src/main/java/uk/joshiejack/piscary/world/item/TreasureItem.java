package uk.joshiejack.piscary.world.item;

import com.google.common.collect.Lists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.neoforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;
import java.util.List;

public class TreasureItem extends Item {

    public TreasureItem(Item.Properties properties) {
        super(properties);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    @Nonnull
    public InteractionResultHolder<ItemStack> use(@Nonnull Level world, Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (world instanceof ServerLevel level) {
            LootParams.Builder builder = new LootParams.Builder(level)
                    .withParameter(LootContextParams.ORIGIN, player.position())
                    .withParameter(LootContextParams.TOOL, stack)
                    .withParameter(LootContextParams.KILLER_ENTITY, player)
                    .withOptionalParameter(LootContextParams.THIS_ENTITY, player)
                    .withLuck(player.getLuck());


            List<ItemStack> result = Lists.newArrayList();
            while (result.isEmpty()) {
                ResourceLocation table = BuiltInLootTables.all().stream()
                        .skip(player.getRandom().nextInt(BuiltInLootTables.all().size()))
                        .findFirst().orElse(BuiltInLootTables.FISHING);
                LootTable loottable = world.getServer().getLootData().getLootTable(table);
                result = loottable.getRandomItems(builder.create(LootContextParamSets.FISHING));
            }

            result.forEach((itemstack) -> ItemHandlerHelper.giveItemToPlayer(player, itemstack));
        }

        stack.shrink(1);
        return InteractionResultHolder.success(stack);
    }
}
