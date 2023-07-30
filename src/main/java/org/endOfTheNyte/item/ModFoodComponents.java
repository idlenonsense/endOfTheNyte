package org.endOfTheNyte.item;

import org.endOfTheNyte.effect.ModEffects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static FoodComponent ENDERMITE_BALL = new FoodComponent.Builder().hunger(5)
    .saturationModifier(0.3f).statusEffect(new StatusEffectInstance(ModEffects.CALL_OF_THE_END, 1800), 1.0f).build();
}
