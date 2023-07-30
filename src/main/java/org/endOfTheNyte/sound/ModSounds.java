package org.endOfTheNyte.sound;

import org.endOfTheNyte.EndOfTheNyte;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent ENDENYTE_BLOCK_ACTIVATED = registerSoundEvent("endenyte_block_activated");
    public static SoundEvent ENDENYTE_BLOCK_DEACTIVATED = registerSoundEvent("endenyte_block_deactivated");
    public static SoundEvent ENDENYTE_BLOCK_FALL = registerSoundEvent("endenyte_block_fall");
    public static SoundEvent ENDENYTE_BLOCK_HIT = registerSoundEvent("endenyte_block_hit");
    public static SoundEvent ENDENYTE_BLOCK_DIG = registerSoundEvent("endenyte_block_dig");
    public static SoundEvent ENDENYTE_BLOCK_PLACE = registerSoundEvent("endenyte_block_placed");

    public static SoundEvent THE_NYTE = registerSoundEvent("the_nyte");

    public static final BlockSoundGroup ENDENYTE_BLOCK_SOUND_GROUP = new BlockSoundGroup(1f, 1f, ENDENYTE_BLOCK_DIG, ENDENYTE_BLOCK_FALL, ENDENYTE_BLOCK_PLACE, ENDENYTE_BLOCK_HIT, ENDENYTE_BLOCK_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(EndOfTheNyte.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        EndOfTheNyte.LOGGER.info("Registerting mod sounds for " + EndOfTheNyte.MOD_ID);
    }

}