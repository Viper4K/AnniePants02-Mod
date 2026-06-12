package net.mcreator.anniepantsmod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.entity.AnniePlushEnemyEntity;

public class AnniePlushEnemyModel extends GeoModel<AnniePlushEnemyEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnniePlushEnemyEntity entity) {
		return ResourceLocation.parse("anniepantsmod:animations/anniepants02.alive.plush.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnniePlushEnemyEntity entity) {
		return ResourceLocation.parse("anniepantsmod:geo/anniepants02.alive.plush.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnniePlushEnemyEntity entity) {
		return ResourceLocation.parse("anniepantsmod:textures/entities/" + entity.getTexture() + ".png");
	}

}
