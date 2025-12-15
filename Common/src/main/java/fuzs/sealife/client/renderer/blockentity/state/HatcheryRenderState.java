package fuzs.sealife.client.renderer.blockentity.state;

import fuzs.sealife.world.level.block.entity.HatcheryRenderData;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

import java.util.ArrayList;
import java.util.List;

public class HatcheryRenderState extends BlockEntityRenderState {
    private List<FishRenderState> data = new ArrayList<>();
    public EntityRenderState displayEntity = new EntityRenderState();

    public void setData(HatcheryRenderData.FishData[] data, float partialTick) {
        this.data = new ArrayList<>();
        for (HatcheryRenderData.FishData fishData : data) {
            this.data.add(new FishRenderState(fishData.getRotation(partialTick),
                    fishData.isClockwise(),
                    fishData.getHeight()));
        }
    }

    public int getCount() {
        return this.data.size();
    }

    public float getRotation(int index) {
        return this.data.get(index).rotation();
    }

    public boolean isClockwise(int index) {
        return this.data.get(index).clockwise();
    }

    public float getHeight(int index) {
        return this.data.get(index).height();
    }

    private record FishRenderState(float rotation, boolean clockwise, float height) {

    }
}
