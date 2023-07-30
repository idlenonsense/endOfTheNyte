package org.endOfTheNyte.block;

import java.util.function.ToIntFunction;

import org.endOfTheNyte.EndOfTheNyte;
import org.endOfTheNyte.sound.ModSounds;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ENDENYTE_BLOCK = registerBlock("endenyte_block",
        new EndenyteBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).velocityMultiplier(0.6f).jumpVelocityMultiplier(0.7f).nonOpaque().sounds(ModSounds.ENDENYTE_BLOCK_SOUND_GROUP).luminance(state -> 12).strength(0.1f, 1200.0f)));

    public static final Block ENDENYTE_ORE = registerBlock("endenyte_ore", 
        new EndenyteOreBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(0.4f, 1200.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER).ticksRandomly().luminance(createLightLevelFromLit(9))));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EndOfTheNyte.MOD_ID, name), block);
    }

    private static ToIntFunction<BlockState> createLightLevelFromLit(int litLevel) {
        return state -> state.get(Properties.LIT) != false ? litLevel : 0;
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EndOfTheNyte.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        EndOfTheNyte.LOGGER.info("Regiserting mod blocks for " + EndOfTheNyte.MOD_ID);
    }
}
