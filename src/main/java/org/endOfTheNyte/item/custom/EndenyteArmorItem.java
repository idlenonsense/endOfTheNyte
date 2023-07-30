package org.endOfTheNyte.item.custom;

import org.endOfTheNyte.effect.ModEffects;
import org.endOfTheNyte.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EndenyteArmorItem extends ArmorItem {
    public EndenyteArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
	public void inventoryTick(ItemStack itemStack, World world, Entity entity, int slot, boolean selected) {
		if (((PlayerEntity) entity).getInventory().getArmorStack(0) != null) {
			if (((PlayerEntity) entity).getInventory().getArmorStack(0).getItem() == ModItems.ENDENYTE_BOOTS) {
				((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(ModEffects.SOFT_TREAD, 220));
			}
		}
		if (((PlayerEntity) entity).getInventory().getArmorStack(1) != null) {
			if (((PlayerEntity) entity).getInventory().getArmorStack(1).getItem() == ModItems.ENDENYTE_LEGGINGS) {
				((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 220));
			}
		}
		if (((PlayerEntity) entity).getInventory().getArmorStack(2) != null) {
			if (((PlayerEntity) entity).getInventory().getArmorStack(2).getItem() == ModItems.ENDENYTE_CHESTPLATE) {
				((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 220));
			}
		}
		if (((PlayerEntity) entity).getInventory().getArmorStack(3) != null) {
			if (((PlayerEntity) entity).getInventory().getArmorStack(3).getItem() == ModItems.ENDENYTE_HELMET) {
				((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220));
			}
		}

		super.inventoryTick(itemStack, world, entity, slot, selected);
	}
}