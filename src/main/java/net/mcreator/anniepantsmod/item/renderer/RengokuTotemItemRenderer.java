package net.mcreator.anniepantsmod.item.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.item.model.RengokuTotemItemModel;
import net.mcreator.anniepantsmod.item.RengokuTotemItem;

import java.util.Set;
import java.util.HashSet;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class RengokuTotemItemRenderer extends GeoItemRenderer<RengokuTotemItem> {
	public RengokuTotemItemRenderer() {
		super(new RengokuTotemItemModel());
	}

	@Override
	public RenderType getRenderType(RengokuTotemItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	private static final float SCALE_RECIPROCAL = 1.0f / 16.0f;
	protected boolean renderArms = false;
	protected MultiBufferSource currentBuffer;
	protected RenderType renderType;
	public ItemDisplayContext transformType;
	protected RengokuTotemItem animatable;
	private final Set<String> hiddenBones = new HashSet<>();
	private final Set<String> suppressedBones = new HashSet<>();

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int p_239207_6_) {
		this.transformType = transformType;
		if (transformType == ItemDisplayContext.FIXED) {
			matrixStack.pushPose();
			matrixStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180));
			matrixStack.translate(-1, -0.1, -1.05);
			super.renderByItem(stack, transformType, matrixStack, bufferIn, combinedLightIn, p_239207_6_);
			matrixStack.popPose();
		} else {
			super.renderByItem(stack, transformType, matrixStack, bufferIn, combinedLightIn, p_239207_6_);
		}
	}

	@Override
	public void actuallyRender(PoseStack matrixStackIn, RengokuTotemItem animatable, BakedGeoModel model, RenderType type, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, boolean isRenderer, float partialTicks, int packedLightIn,
			int packedOverlayIn, int color) {
		this.currentBuffer = renderTypeBuffer;
		this.renderType = type;
		this.animatable = animatable;
		super.actuallyRender(matrixStackIn, animatable, model, type, renderTypeBuffer, vertexBuilder, isRenderer, partialTicks, packedLightIn, packedOverlayIn, color);
		if (this.renderArms) {
			this.renderArms = false;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(RengokuTotemItem instance) {
		return super.getTextureLocation(instance);
	}
}
