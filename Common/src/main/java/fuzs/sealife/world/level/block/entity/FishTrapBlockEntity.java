package fuzs.sealife.world.level.block.entity;

import fuzs.puzzleslib.api.block.v1.entity.TickingBlockEntity;
import fuzs.puzzleslib.api.container.v1.ContainerSerializationHelper;
import fuzs.puzzleslib.api.container.v1.ListBackedContainer;
import fuzs.sealife.init.ModBlocks;
import fuzs.sealife.init.ModRegistry;
import fuzs.sealife.world.level.block.FishTrapBlock;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class FishTrapBlockEntity extends BlockEntity implements ListBackedContainer, TickingBlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private float currentSpin;
    private float previousSpin;
    private ItemStack displayItem = ItemStack.EMPTY;

    public FishTrapBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlocks.FISH_TRAP_BLOCK_ENTITY_TYPE.value(), blockPos, blockState);
    }

    @Override
    public void clientTick() {
        RandomSource randomSource = this.getLevel().getRandom();
        this.previousSpin = this.currentSpin;
        this.currentSpin = Mth.wrapDegrees(this.currentSpin + 5.0F);
        if (this.getLevel().getGameTime() % 100L == 0L) {
            Optional<Holder<Item>> optional = this.getLevel()
                    .registryAccess()
                    .lookupOrThrow(Registries.ITEM)
                    .get(ModRegistry.FISHING_BAIT_ITEM_TAG)
                    .flatMap((HolderSet.Named<Item> holderSet) -> {
                        return holderSet.getRandomElement(randomSource);
                    });
            this.displayItem = optional.map(ItemStack::new).orElse(ItemStack.EMPTY);
        }

        if (randomSource.nextFloat() <= 0.5F) {
            Vec3 vec3 = randomPosInsideCage(this.getBlockPos(), randomSource);
            if (this.getBlockState().getValue(FishTrapBlock.ENABLED) && this.isBaited()) {
                this.getLevel()
                        .addParticle(ModRegistry.BUBBLE_PARTICLE_TYPE.value(),
                                vec3.x(),
                                vec3.y(),
                                vec3.z(),
                                0.0,
                                0.0,
                                0.0);
            }
        }
    }

    private static Vec3 randomPosInsideCage(BlockPos pos, RandomSource random) {
        return Vec3.atLowerCornerOf(pos)
                .add(Mth.nextDouble(random, 0.1, 0.9),
                        Mth.nextDouble(random, 0.25, 1.25),
                        Mth.nextDouble(random, 0.1, 0.9));
    }

    public float getSpin(float partialTick) {
        return Mth.rotLerp(partialTick, this.previousSpin, this.currentSpin);
    }

    public boolean isBaited() {
        return this.getItem(0).is(ModRegistry.FISHING_BAIT_ITEM_TAG);
    }

    public ItemStack getDisplayItem() {
        if (this.isBaited()) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemStack = this.getItem(0);
            return itemStack.isEmpty() ? this.displayItem : itemStack;
        }
    }

    @Override
    protected void loadAdditional(CompoundTag valueInput, HolderLookup.Provider registries) {
        super.loadAdditional(valueInput, registries);
        this.items.clear();
        ContainerSerializationHelper.loadAllItems(valueInput, this.items, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag valueOutput, HolderLookup.Provider registries) {
        super.saveAdditional(valueOutput, registries);
        ContainerSerializationHelper.saveAllItems(valueOutput, this.items, registries);
    }

    @Override
    public NonNullList<ItemStack> getContainerItems() {
        return this.items;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition,
                    this.getBlockState(),
                    this.getBlockState(),
                    Block.UPDATE_ALL);
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentGetter) {
        super.applyImplicitComponents(componentGetter);
        componentGetter.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                .copyInto(this.getContainerItems());
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getContainerItems()));
    }

    @Override
    public void removeComponentsFromTag(CompoundTag valueOutput) {
        valueOutput.remove("Items");
    }
}
