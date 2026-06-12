
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.anniepantsmod.potion.AnnieRefreshmentEffectWaterMobEffect;
import net.mcreator.anniepantsmod.potion.AnnieRefreshmentEffectGSMobEffect;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, AnniepantsmodMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ANNIE_REFRESHMENT_EFFECT_GS = REGISTRY.register("annie_refreshment_effect_gs", () -> new AnnieRefreshmentEffectGSMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ANNIE_REFRESHMENT_EFFECT_WATER = REGISTRY.register("annie_refreshment_effect_water", () -> new AnnieRefreshmentEffectWaterMobEffect());
}
