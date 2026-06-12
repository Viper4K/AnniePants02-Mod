
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.anniepantsmod.client.gui.GSGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnniepantsmodModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(AnniepantsmodModMenus.GS_GUI.get(), GSGuiScreen::new);
	}
}
