package org.endOfTheNyte.effect;

import org.endOfTheNyte.EndOfTheNyte;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect CALL_OF_THE_END = registerEffect("call_of_the_end", new CallOfTheEnd());
    public static final StatusEffect DRAGONS_BLESSING = registerEffect("dragons_blessing", new DragonsBlessing());
    public static final StatusEffect SOFT_TREAD = registerEffect("soft_tread", new SoftTread());

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EndOfTheNyte.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        EndOfTheNyte.LOGGER.info("Registering mod effects for: " + EndOfTheNyte.MOD_ID);

    }
}
