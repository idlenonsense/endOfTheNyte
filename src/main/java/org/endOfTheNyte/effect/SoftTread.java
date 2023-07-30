package org.endOfTheNyte.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class SoftTread extends StatusEffect {
    public SoftTread() {
        super(
            StatusEffectCategory.BENEFICIAL,
            0x484B89
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity && !((PlayerEntity) entity).isCreative()) {
            entity.fallDistance = 0;
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity && !((PlayerEntity) entity).isCreative()) {
            ((PlayerEntity) entity).fallDistance = 1.0F;
        }
    }
}