package org.endOfTheNyte;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import org.endOfTheNyte.block.ModBlocks;
import org.endOfTheNyte.effect.ModEffects;
import org.endOfTheNyte.item.ModItemGroups;
import org.endOfTheNyte.item.ModItems;
import org.endOfTheNyte.sound.ModSounds;
import org.endOfTheNyte.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndOfTheNyte implements ModInitializer {
	public static final String MOD_ID = "endofthenyte";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<PlacedFeature> ENDENYTE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("endofthenyte", "ore_endenyte"));

	@Override
	public void onInitialize() {
		ModSounds.registerModSounds();
		ModEffects.registerModEffects();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ENDENYTE_ORE_PLACED_KEY);
	}
}