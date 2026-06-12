package net.mcreator.anniepantsmod.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.entity.JaneDoe2Entity;

public class JaneDoe2Model extends GeoModel<JaneDoe2Entity> {
	@Override
	public ResourceLocation getAnimationResource(JaneDoe2Entity entity) {
		return ResourceLocation.parse("anniepantsmod:animations/janedoecrumbs2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JaneDoe2Entity entity) {
		return ResourceLocation.parse("anniepantsmod:geo/janedoecrumbs2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JaneDoe2Entity entity) {
		return ResourceLocation.parse("anniepantsmod:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(JaneDoe2Entity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
