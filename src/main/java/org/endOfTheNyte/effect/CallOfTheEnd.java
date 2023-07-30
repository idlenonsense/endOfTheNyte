package org.endOfTheNyte.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class CallOfTheEnd extends StatusEffect {
    public CallOfTheEnd() {
        super(
            StatusEffectCategory.BENEFICIAL,
            0xA373C9
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if (entity.isTouchingWaterOrRain()) {
                entity.damage(entity.getDamageSources().magic(), 2.0F);
            }
            ((PlayerEntity) entity).getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(40);
        }
    }
    
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity) {
            if (((PlayerEntity) entity).getHealth() > 20) {
                ((PlayerEntity) entity).damage(entity.getDamageSources().magic(), ((PlayerEntity) entity).getHealth() - 20);
            }
            ((PlayerEntity) entity).getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20);
        }
    }
}
