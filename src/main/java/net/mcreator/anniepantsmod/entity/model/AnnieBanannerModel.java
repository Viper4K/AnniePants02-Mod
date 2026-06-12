package net.mcreator.anniepantsmod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import software.bernie.geckolib.animation.AnimationState;


import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.entity.AnnieBanannerEntity;

public class AnnieBanannerModel extends GeoModel<AnnieBanannerEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnnieBanannerEntity entity) {
		return ResourceLocation.parse("anniepantsmod:animations/bananner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnnieBanannerEntity entity) {
		return ResourceLocation.parse("anniepantsmod:geo/bananner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnnieBanannerEntity entity) {
		String texture = switch (entity.getEntityData().get(AnnieBanannerEntity.DATA_color)) {
			case 1 -> "banannerblue";
			case 2 -> "banannergreen";
			case 3 -> "banannerorange";
			case 4 -> "banannerpink";
			case 5 -> "banannerpurple";
			default -> "banannergolden";
		};
		return ResourceLocation.parse("anniepantsmod:textures/entities/" + texture + ".png");
	}

	@Override
	public void setCustomAnimations(AnnieBanannerEntity entity, long instanceId, AnimationState<AnnieBanannerEntity> animationState) {
		super.setCustomAnimations(entity, instanceId, animationState);

		var p = getAnimationProcessor();

		int m = entity.getEntityData().get(AnnieBanannerEntity.DATA_mouth);
		int e = entity.getEntityData().get(AnnieBanannerEntity.DATA_eyes);

		var mouth1 = p.getBone("mouth1");
		var mouth2 = p.getBone("mouth2");
		var mouth3 = p.getBone("mouth3");
		var mouth4 = p.getBone("mouth4");
		var mouth5 = p.getBone("mouth5");

		var eyes1 = p.getBone("eyes1");
		var eyes2 = p.getBone("eyes2");
		var eyes3 = p.getBone("eyes3");
		var eyes4 = p.getBone("eyes4");

		if (mouth1 != null) mouth1.setHidden(m != 0);
		if (mouth2 != null) mouth2.setHidden(m != 1);
		if (mouth3 != null) mouth3.setHidden(m != 2);
		if (mouth4 != null) mouth4.setHidden(m != 3);
		if (mouth5 != null) mouth5.setHidden(m != 4);

		if (eyes1 != null) eyes1.setHidden(e != 0);
		if (eyes2 != null) eyes2.setHidden(e != 1);
		if (eyes3 != null) eyes3.setHidden(e != 2);
		if (eyes4 != null) eyes4.setHidden(e != 3);
	}
}