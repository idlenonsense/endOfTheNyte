package org.endOfTheNyte.item;

import org.endOfTheNyte.EndOfTheNyte;
import org.endOfTheNyte.block.ModBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup EOTN_GROUP = Registry.register(Registries.ITEM_GROUP, 
        new Identifier(EndOfTheNyte.MOD_ID, "eotn"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eotn"))
        .icon(() -> new ItemStack(ModItems.ENDENYTE)).entries((displayContext, entries) -> {
            entries.add(ModItems.ENDENYTE);
            entries.add(ModItems.ENDENYTE_DUST);
            entries.add(ModItems.DRAGON_EGG_SHELL);
            entries.add(ModItems.ENDERMITE_BALL);
            entries.add(ModBlocks.ENDENYTE_BLOCK);
            entries.add(ModBlocks.ENDENYTE_ORE);
            entries.add(ModItems.ENDENYTE_HELMET);
            entries.add(ModItems.ENDENYTE_CHESTPLATE);
            entries.add(ModItems.ENDENYTE_LEGGINGS);
            entries.add(ModItems.ENDENYTE_BOOTS);
            entries.add(ModItems.THE_NYTE_MUSIC_DISC);
        }).build());

    public static void registerItemGroups() {
        EndOfTheNyte.LOGGER.info("Registering item groups for " + EndOfTheNyte.MOD_ID);
    }
}
