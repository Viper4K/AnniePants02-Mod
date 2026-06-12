package net.mcreator.anniepantsmod.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.entity.TechnopigEntity;

public class TechnopigModel extends GeoModel<TechnopigEntity> {
	@Override
	public ResourceLocation getAnimationResource(TechnopigEntity entity) {
		return ResourceLocation.parse("anniepantsmod:animations/technopig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TechnopigEntity entity) {
		return ResourceLocation.parse("anniepantsmod:geo/technopig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TechnopigEntity entity) {
		return ResourceLocation.parse("anniepantsmod:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(TechnopigEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
