package org.endOfTheNyte.util;

import org.endOfTheNyte.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDENYTE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDENYTE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDENYTE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDENYTE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.THE_NYTE_MUSIC_DISC, Models.GENERATED);
    }
    
}