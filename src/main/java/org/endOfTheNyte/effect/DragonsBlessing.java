package org.endOfTheNyte.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class DragonsBlessing extends StatusEffect {
    public DragonsBlessing() {
        super(
            StatusEffectCategory.BENEFICIAL,
            0xE7D8C1
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).getAbilities().allowFlying = true;
            ((PlayerEntity) entity).sendAbilitiesUpdate();
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity && !((PlayerEntity) entity).isCreative()) {
            ((PlayerEntity) entity).getAbilities().flying = false;
            ((PlayerEntity) entity).getAbilities().allowFlying = false;
            ((PlayerEntity) entity).sendAbilitiesUpdate();
        }
    }
}
