package org.endOfTheNyte.util;

import org.endOfTheNyte.item.ModItems;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier ENDERMITE_ID
        = new Identifier("minecraft", "entities/endermite");

    private static final Identifier END_CITY_TREASURE_CHEST_ID
        = new Identifier("minecraft", "chests/end_city_treasure");
    
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ENDERMITE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceWithLootingLootCondition.builder(0.2f, 0.05f))
                    .with(ItemEntry.builder(ModItems.ENDERMITE_BALL))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (END_CITY_TREASURE_CHEST_ID.equals(id)) {
                LootPool.Builder pooBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.1f))
                    .with(ItemEntry.builder(ModItems.THE_NYTE_MUSIC_DISC))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(pooBuilder.build());
            }
        });
    }
}