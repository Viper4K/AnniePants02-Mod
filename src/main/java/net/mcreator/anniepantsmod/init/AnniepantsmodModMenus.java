
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.anniepantsmod.world.inventory.GSGuiMenu;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, AnniepantsmodMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<GSGuiMenu>> GS_GUI = REGISTRY.register("gs_gui", () -> IMenuTypeExtension.create(GSGuiMenu::new));
}
