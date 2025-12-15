package fuzs.sealife.client.particle;

import fuzs.puzzleslib.api.client.util.v1.ClientParticleHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class CustomBubbleParticle extends BubbleParticle {

    public CustomBubbleParticle(ClientLevel clientLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, TextureAtlasSprite sprite) {
        super(clientLevel, x, y, z, xSpeed, ySpeed, zSpeed, sprite);
    }

    @Override
    public void remove() {
        super.remove();
        Particle particle = ClientParticleHelper.addParticle(this.level,
                ParticleTypes.BUBBLE_POP,
                this.x,
                this.y,
                this.z,
                0.0,
                0.0,
                0.0);
        if (particle instanceof BubblePopParticle bubblePopParticle) {
            bubblePopParticle.quadSize = this.quadSize;
        }
    }

    /**
     * @see BubbleParticle.Provider
     */
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource randomSource) {
            return new CustomBubbleParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites.get(randomSource));
        }
    }
}
