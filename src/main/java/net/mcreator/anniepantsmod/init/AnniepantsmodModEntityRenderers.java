
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.anniepantsmod.client.renderer.TechnopigRenderer;
import net.mcreator.anniepantsmod.client.renderer.JaneDoeRenderer;
import net.mcreator.anniepantsmod.client.renderer.JaneDoe2Renderer;
import net.mcreator.anniepantsmod.client.renderer.AnniePlushEnemyRenderer;
import net.mcreator.anniepantsmod.client.renderer.AnnieBanannerRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnniepantsmodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AnniepantsmodModEntities.ANNIE_PLUSH_ENEMY.get(), AnniePlushEnemyRenderer::new);
		event.registerEntityRenderer(AnniepantsmodModEntities.JANE_DOE.get(), JaneDoeRenderer::new);
		event.registerEntityRenderer(AnniepantsmodModEntities.JANE_DOE_2.get(), JaneDoe2Renderer::new);
		event.registerEntityRenderer(AnniepantsmodModEntities.ANNIE_BANANNER.get(), AnnieBanannerRenderer::new);
		event.registerEntityRenderer(AnniepantsmodModEntities.TECHNOPIG.get(), TechnopigRenderer::new);
	}
}
