package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.display.AnniePlushBlockDisplayItem;

public class AnniePlushBlockDisplayModel extends GeoModel<AnniePlushBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AnniePlushBlockDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/anniepants02.plush.block.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnniePlushBlockDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/anniepants02.plush.block.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnniePlushBlockDisplayItem entity) {
		return ResourceLocation.parse("anniepantsmod:textures/block/anniepants2.plush.png");
	}
}
