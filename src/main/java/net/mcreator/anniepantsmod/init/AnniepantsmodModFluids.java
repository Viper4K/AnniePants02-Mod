
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.anniepantsmod.fluid.SchlattJuiceFluid;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, AnniepantsmodMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> SCHLATT_JUICE = REGISTRY.register("schlatt_juice", () -> new SchlattJuiceFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_SCHLATT_JUICE = REGISTRY.register("flowing_schlatt_juice", () -> new SchlattJuiceFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(SCHLATT_JUICE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SCHLATT_JUICE.get(), RenderType.translucent());
		}
	}
}
