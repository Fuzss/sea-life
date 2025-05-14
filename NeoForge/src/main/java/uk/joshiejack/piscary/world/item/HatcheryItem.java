package uk.joshiejack.piscary.world.item;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class HatcheryItem extends BlockItem {
    public HatcheryItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Nonnull
    @Override
    public InteractionResult useOn(@Nonnull UseOnContext ctx) {
        return InteractionResult.PASS;
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level world, @NotNull Player player, @Nonnull InteractionHand hand) {
        BlockHitResult blockraytraceresult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
        boolean waterAbove = world.getBlockState(blockraytraceresult1.getBlockPos()).getFluidState().is(FluidTags.WATER);
        if (!waterAbove && world.getBlockState(blockraytraceresult.getBlockPos()).getFluidState().is(FluidTags.WATER)) {
            InteractionResult actionresulttype = super.useOn(new UseOnContext(player, hand, blockraytraceresult));
            return new InteractionResultHolder<>(actionresulttype, player.getItemInHand(hand));
        }

        return new InteractionResultHolder<>(InteractionResult.PASS, player.getItemInHand(hand));
    }
}
