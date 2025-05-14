package uk.joshiejack.piscary.network;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.joshiejack.penguinlib.PenguinLib;
import uk.joshiejack.penguinlib.network.packet.PenguinPacket;
import uk.joshiejack.penguinlib.util.registry.Packet;
import uk.joshiejack.piscary.world.block.entity.HatcheryBlockEntity;

@Packet(PacketFlow.CLIENTBOUND)
public record SyncHatcheryPacket(BlockPos pos, @Nullable EntityType<?> type, int count) implements PenguinPacket {
    public static final ResourceLocation ID = PenguinLib.prefix("sync_hatchery");

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }


    public SyncHatcheryPacket(FriendlyByteBuf buf) {
        this(buf.readBlockPos(), buf.readBoolean() ? buf.readById(BuiltInRegistries.ENTITY_TYPE) : null, buf.readByte());
    }

    @Override
    public void write(FriendlyByteBuf pb) {
        pb.writeBlockPos(pos);
        pb.writeBoolean(type != null);
        if (type != null)
            pb.writeId(BuiltInRegistries.ENTITY_TYPE, type);
        pb.writeByte(count);
    }

    @Override
    public void handle(Player player) {
        if (player.level().getBlockEntity(pos) instanceof HatcheryBlockEntity hatchery)
            hatchery.setEntityTypeAndCount(type, count);
    }
}
