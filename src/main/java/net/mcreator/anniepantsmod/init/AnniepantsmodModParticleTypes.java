
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, AnniepantsmodMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SCHLATT_PARTICLE = REGISTRY.register("schlatt_particle", () -> new SimpleParticleType(false));
}
