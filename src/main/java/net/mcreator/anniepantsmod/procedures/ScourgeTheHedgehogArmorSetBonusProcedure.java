package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;

public class ScourgeTheHedgehogArmorSetBonusProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double sonichelmetpresent = 0;
		double sonicchestpresent = 0;
		double sonicpantspresent = 0;
		double sonicbootspresent = 0;
		double sonic2helmetpresent = 0;
		double sonic2chestplatepresent = 0;
		double sonic2pantspresent = 0;
		double sonic2bootspresent = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_HELMET.get()) {
			sonic2helmetpresent = 1;
		} else {
			sonic2helmetpresent = 0;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_CHESTPLATE.get()) {
			sonic2chestplatepresent = 1;
		} else {
			sonic2chestplatepresent = 0;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_LEGGINGS.get()) {
			sonic2pantspresent = 1;
		} else {
			sonic2pantspresent = 0;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_BOOTS.get()) {
			sonic2bootspresent = 1;
		} else {
			sonic2bootspresent = 0;
		}
		if (sonic2helmetpresent + sonic2chestplatepresent + sonic2pantspresent + sonic2bootspresent == 4) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 4, false, false));
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
		}
	}
}
