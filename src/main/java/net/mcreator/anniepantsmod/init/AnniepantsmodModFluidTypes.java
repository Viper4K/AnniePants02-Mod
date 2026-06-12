
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.anniepantsmod.fluid.types.SchlattJuiceFluidType;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, AnniepantsmodMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> SCHLATT_JUICE_TYPE = REGISTRY.register("schlatt_juice", () -> new SchlattJuiceFluidType());
}
