package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.display.JaneDoeBodypillowDisplayItem;

public class JaneDoeBodypillowDisplayModel extends GeoModel<JaneDoeBodypillowDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JaneDoeBodypillowDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/jane_doe_pillow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JaneDoeBodypillowDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/jane_doe_pillow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JaneDoeBodypillowDisplayItem entity) {
		return ResourceLocation.parse("anniepantsmod:textures/block/jane_doe_pillow.png");
	}
}
