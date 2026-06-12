package net.mcreator.anniepantsmod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.item.ChosoTotemItem;

public class ChosoTotemItemModel extends GeoModel<ChosoTotemItem> {
	@Override
	public ResourceLocation getAnimationResource(ChosoTotemItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/totem_of_choso.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChosoTotemItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/totem_of_choso.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChosoTotemItem animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/item/choso.png");
	}
}
