package org.endOfTheNyte.item;

import org.endOfTheNyte.EndOfTheNyte;
import org.endOfTheNyte.armor.EndenyteArmorMaterial;
import org.endOfTheNyte.block.ModBlocks;
import org.endOfTheNyte.item.custom.EndenyteArmorItem;
import org.endOfTheNyte.sound.ModSounds;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item ENDENYTE = registerItem("endenyte", new Item(new FabricItemSettings()));
    public static final Item ENDENYTE_DUST = registerItem("endenyte_dust", new Item(new FabricItemSettings()));
    public static final Item ENDERMITE_BALL = registerItem("endermite_ball", new Item(new FabricItemSettings().food(ModFoodComponents.ENDERMITE_BALL)));
    public static final Item DRAGON_EGG_SHELL = registerItem("dragon_egg_shell", new Item(new FabricItemSettings()));

    public static final Item ENDENYTE_HELMET = registerItem("netherite_helmet_with_endenyte_coating", new EndenyteArmorItem(EndenyteArmorMaterial.ENDENYTE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ENDENYTE_CHESTPLATE = registerItem("netherite_chestplate_with_endenyte_coating", new EndenyteArmorItem(EndenyteArmorMaterial.ENDENYTE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ENDENYTE_LEGGINGS = registerItem("netherite_leggings_with_endenyte_coating", new EndenyteArmorItem(EndenyteArmorMaterial.ENDENYTE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ENDENYTE_BOOTS = registerItem("netherite_boots_with_endenyte_coating", new EndenyteArmorItem(EndenyteArmorMaterial.ENDENYTE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item THE_NYTE_MUSIC_DISC = registerItem("the_nyte_music_disc", new MusicDiscItem(6, ModSounds.THE_NYTE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 95));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDENYTE);
        entries.add(ENDENYTE_DUST);
        entries.add(DRAGON_EGG_SHELL);
        entries.add(ENDERMITE_BALL);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDENYTE_HELMET);
        entries.add(ENDENYTE_CHESTPLATE);
        entries.add(ENDENYTE_LEGGINGS);
        entries.add(ENDENYTE_BOOTS);
    }

    private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ENDENYTE_BLOCK);
    }

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ENDENYTE_ORE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EndOfTheNyte.MOD_ID, name), item);
    }
    
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.THE_NYTE_MUSIC_DISC);
    }

    public static void registerModItems() {
        EndOfTheNyte.LOGGER.info("Registering mod items for: " + EndOfTheNyte.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}