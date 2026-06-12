
package net.mcreator.anniepantsmod.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.entity.model.AnnieBanannerModel;
import net.mcreator.anniepantsmod.entity.AnnieBanannerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AnnieBanannerRenderer extends GeoEntityRenderer<AnnieBanannerEntity> {
	public AnnieBanannerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AnnieBanannerModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(AnnieBanannerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AnnieBanannerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 0.6f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(AnnieBanannerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
