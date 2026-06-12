package net.mcreator.anniepantsmod.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.entity.JaneDoeEntity;

public class JaneDoeModel extends GeoModel<JaneDoeEntity> {
	@Override
	public ResourceLocation getAnimationResource(JaneDoeEntity entity) {
		return ResourceLocation.parse("anniepantsmod:animations/janedoecrumbs.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JaneDoeEntity entity) {
		return ResourceLocation.parse("anniepantsmod:geo/janedoecrumbs.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JaneDoeEntity entity) {
		return ResourceLocation.parse("anniepantsmod:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(JaneDoeEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
