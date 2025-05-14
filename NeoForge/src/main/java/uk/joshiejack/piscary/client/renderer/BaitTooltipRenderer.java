package uk.joshiejack.piscary.client.renderer;

import net.minecraft.world.item.ItemStack;

//@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class BaitTooltipRenderer {
//    @SubscribeEvent //TODO: Add bait renderer using the same method as i did for the experience bar
//    public static void onTooltipRender(RenderTooltipEvent.PostText event) {
//        Screen gui = Minecraft.getInstance().screen;
//        if (gui == null) return; //Do nothing if screen is null
//        ItemStack stack = event.getStack();
//        if (stack.getItem() instanceof FishingRodItem) {
//            int amount = getBaitAmount(stack);
//            if (amount > 0) {
//                MatrixStack matrix = event.getMatrixStack();
//                RenderSystem.disableRescaleNormal();
//                RenderHelper.turnOff();
//                RenderSystem.disableDepthTest();
//                int k = 8;
//                int i1 = event.getX() + event.getWidth() + 10;
//                int j1 = event.getY();
//                int k1 = 7;
//
//                if (j1 + k1 + 6 > gui.height) {
//                    j1 = gui.height - k1 - 6;
//                }
//
//                int zLevel = (int) 500.0F;
//                int l1 = -267386864;
//
//                matrix.pushPose();
//                Matrix4f mat = matrix.last().pose();
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
//                int i2 = 1347420415;
//                int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
//                GuiUtils.drawGradientRect(mat, zLevel, i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);
//                RenderSystem.disableDepthTest();
//
//                ItemStack inStack = BaitHandler.getBaitStack(stack);
//                ItemStack bait = withSize(inStack, getBaitAmount(stack));
//                matrix.pushPose();
//                float scale = 0.75F;
//                RenderSystem.scalef(scale, scale, 1F);
//                int is = (int) ((float) i1/scale) - 2;
//                int js = (int) ((float) j1/scale) - 2;
//                String s = bait.getCount() >= 1000 ? "" + StringHelper.convertNumberToString(bait.getCount(), true) : bait.getCount() > 1 ? bait.getCount() + "" : "";
//                gui.getMinecraft().getItemRenderer().blitOffset = 500;
//                gui.getMinecraft().getItemRenderer().renderAndDecorateItem(Objects.requireNonNull(gui.getMinecraft().player), bait, is, js);
//                gui.getMinecraft().getItemRenderer().renderGuiItemDecorations(gui.getMinecraft().font, bait, is, js, s);
//                matrix.popPose();
//            }
//        }
//    }
//
//

    private static ItemStack withSize(ItemStack stack, int count) {
        stack.setCount(count);
        return stack;
    }

    @SuppressWarnings("ConstantConditions")
    private static int getBaitAmount(ItemStack stack) {
        return stack.hasTag() ? stack.getTag().getInt("Bait") : 0;
    }
}
