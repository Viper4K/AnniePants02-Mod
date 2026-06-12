package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.anniepantsmod.init.AnniepantsmodModMobEffects;

public class AnnieCupFullEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(AnniepantsmodModMobEffects.ANNIE_REFRESHMENT_EFFECT_WATER)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(AnniepantsmodModMobEffects.ANNIE_REFRESHMENT_EFFECT_WATER);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(AnniepantsmodModMobEffects.ANNIE_REFRESHMENT_EFFECT_GS, 800, 1, false, false));
	}
}
