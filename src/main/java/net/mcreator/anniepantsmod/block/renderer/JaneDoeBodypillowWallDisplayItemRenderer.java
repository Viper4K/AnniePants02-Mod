package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.JaneDoeBodypillowWallDisplayModel;
import net.mcreator.anniepantsmod.block.display.JaneDoeBodypillowWallDisplayItem;

public class JaneDoeBodypillowWallDisplayItemRenderer extends GeoItemRenderer<JaneDoeBodypillowWallDisplayItem> {
	public JaneDoeBodypillowWallDisplayItemRenderer() {
		super(new JaneDoeBodypillowWallDisplayModel());
	}

	@Override
	public RenderType getRenderType(JaneDoeBodypillowWallDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
