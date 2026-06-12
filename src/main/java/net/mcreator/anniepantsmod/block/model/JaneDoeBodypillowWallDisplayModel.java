package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.display.JaneDoeBodypillowWallDisplayItem;

public class JaneDoeBodypillowWallDisplayModel extends GeoModel<JaneDoeBodypillowWallDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(JaneDoeBodypillowWallDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/jane_doe_pillow_wall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JaneDoeBodypillowWallDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/jane_doe_pillow_wall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JaneDoeBodypillowWallDisplayItem entity) {
		return ResourceLocation.parse("anniepantsmod:textures/block/jane_doe_pillow.png");
	}
}
