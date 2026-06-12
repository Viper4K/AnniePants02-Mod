package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowTileEntity;

public class JaneDoeBodypillowBlockModel extends GeoModel<JaneDoeBodypillowTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(JaneDoeBodypillowTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/jane_doe_pillow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JaneDoeBodypillowTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/jane_doe_pillow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JaneDoeBodypillowTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/block/jane_doe_pillow.png");
	}
}
