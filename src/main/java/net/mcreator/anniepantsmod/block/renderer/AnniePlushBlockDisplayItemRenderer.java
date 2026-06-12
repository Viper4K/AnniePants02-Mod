package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.AnniePlushBlockDisplayModel;
import net.mcreator.anniepantsmod.block.display.AnniePlushBlockDisplayItem;

public class AnniePlushBlockDisplayItemRenderer extends GeoItemRenderer<AnniePlushBlockDisplayItem> {
	public AnniePlushBlockDisplayItemRenderer() {
		super(new AnniePlushBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(AnniePlushBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
