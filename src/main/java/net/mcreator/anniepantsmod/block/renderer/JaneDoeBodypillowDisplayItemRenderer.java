package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.JaneDoeBodypillowDisplayModel;
import net.mcreator.anniepantsmod.block.display.JaneDoeBodypillowDisplayItem;

public class JaneDoeBodypillowDisplayItemRenderer extends GeoItemRenderer<JaneDoeBodypillowDisplayItem> {
	public JaneDoeBodypillowDisplayItemRenderer() {
		super(new JaneDoeBodypillowDisplayModel());
	}

	@Override
	public RenderType getRenderType(JaneDoeBodypillowDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
