package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowWallTileEntity;

public class JaneDoeBodypillowWallBlockModel extends GeoModel<JaneDoeBodypillowWallTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JaneDoeBodypillowWallTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/jane_doe_pillow_wall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JaneDoeBodypillowWallTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/jane_doe_pillow_wall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JaneDoeBodypillowWallTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/block/jane_doe_pillow.png");
	}
}
