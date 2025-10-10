package fuzs.sealife.client.particle;

import fuzs.puzzleslib.api.client.util.v1.ClientParticleHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;

public class CustomBubbleParticle extends BubbleParticle {

    public CustomBubbleParticle(ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
        super(clientLevel, d, e, f, g, h, i);
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
        private final SpriteSet sprite;

        public Provider(SpriteSet sprites) {
            this.sprite = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            BubbleParticle bubbleParticle = new CustomBubbleParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            bubbleParticle.pickSprite(this.sprite);
            return bubbleParticle;
        }
    }
}
