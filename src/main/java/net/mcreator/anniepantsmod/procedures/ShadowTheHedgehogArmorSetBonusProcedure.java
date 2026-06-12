package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;

public class ShadowTheHedgehogArmorSetBonusProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double sonichelmetpresent = 0;
		double sonicchestpresent = 0;
		double sonicpantspresent = 0;
		double sonicbootspresent = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_HELMET.get()) {
			sonichelmetpresent = 1;
		} else {
			sonichelmetpresent = 0;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_CHESTPLATE.get()) {
			sonicchestpresent = 1;
		} else {
			sonicchestpresent = 0;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_LEGGINGS.get()) {
			sonicpantspresent = 1;
		} else {
			sonicpantspresent = 0;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_BOOTS.get()) {
			sonicbootspresent = 1;
		} else {
			sonicbootspresent = 0;
		}
		if (sonichelmetpresent + sonicchestpresent + sonicbootspresent + sonicpantspresent == 4) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 5, false, false));
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
		}
	}
}
