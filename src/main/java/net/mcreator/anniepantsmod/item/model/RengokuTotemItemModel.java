package net.mcreator.anniepantsmod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.item.RengokuTotemItem;

public class RengokuTotemItemModel extends GeoModel<RengokuTotemItem> {
	@Override
	public ResourceLocation getAnimationResource(RengokuTotemItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/totem_of_rengoku.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RengokuTotemItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/totem_of_rengoku.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RengokuTotemItem animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/item/rengoku.png");
	}
}
