package uk.joshiejack.piscary.world.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import uk.joshiejack.penguinlib.network.PenguinNetwork;
import uk.joshiejack.penguinlib.network.packet.SetHeldItemPacket;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.item.crafting.BaitRegistry;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Piscary.MODID)
public class BaitHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void removeBaitAfterFishing(ItemFishedEvent event) {
        Player player = event.getEntity();
        removeBait(player, getHand(player), 1);
    }

    @SubscribeEvent
    public static void removeBaitFromFishingRod(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if (!player.isShiftKeyDown() || !(event.getItemStack().getItem() instanceof FishingRodItem)) return;
        if (removeBait(player, getHand(player), 64)) {
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void applyBaitModifiers(EntityJoinLevelEvent event) {
        if (!event.getLevel().isClientSide() || !(event.getEntity() instanceof FishingHook bobber)) return;
        Player player = bobber.getPlayerOwner();
        if (player == null) return;
        ItemStack fishingRod = getFishingRodFromPlayer(player);
        if (!fishingRod.isEmpty()) return;
        ItemStack bait = getBaitStack(fishingRod);
        if (!bait.isEmpty()) return;
        BaitRegistry.BaitData data = BaitRegistry.getValue(bait);
        int enchantability = fishingRod.getEnchantmentValue();
        int speedBoost = enchantability * data.getSpeed() + 35;
        int luckBoost = data.getLuck();
        bobber.lureSpeed += (enchantability * speedBoost);
        bobber.luck += luckBoost;
    }

    private static ItemStack getFishingRodFromPlayer(Player player) {
        return player.getMainHandItem().getItem() instanceof FishingRodItem ? player.getMainHandItem()
                : player.getOffhandItem().getItem() instanceof FishingRodItem ? player.getOffhandItem() : ItemStack.EMPTY;
    }

    private static InteractionHand getHand(Player player) {
        return player.getMainHandItem().getItem() instanceof FishingRodItem ? InteractionHand.MAIN_HAND : player.getOffhandItem().getItem() instanceof FishingRodItem ? InteractionHand.OFF_HAND : null;
    }

    @SuppressWarnings("ConstantConditions")
    private static boolean removeBait(Player player, @Nullable InteractionHand hand, int amount) {
        if (hand == null) return false;
        ItemStack rod = player.getItemInHand(hand);
        CompoundTag tag = rod.hasTag() ? rod.getTag() : new CompoundTag();
        int existing = tag.getInt("Bait");
        int newValue = existing - amount;
        if (newValue < 0) tag.remove("Bait");
        else tag.putInt("Bait", newValue);

        rod.setTag(tag); //Reset the tag
        if (amount > 1 && existing > 0) {
            ItemStack ret = ItemStack.of(tag.getCompound("Stack"));
            if (newValue < 0) ret.setCount(amount + newValue);
            else ret.setCount(amount);
            ItemHandlerHelper.giveItemToPlayer(player, ret);
        }

        player.setItemInHand(hand, rod);
        if (!player.level().isClientSide)
            PenguinNetwork.sendToClient((ServerPlayer) player, new SetHeldItemPacket(hand, rod));
        return existing > 0;
    }

    @SuppressWarnings("ConstantConditions")
    public static ItemStack getBaitStack(ItemStack stack) {
        return stack.hasTag() ? ItemStack.of(stack.getTag().getCompound("Stack")) : ItemStack.EMPTY;
    }
}
