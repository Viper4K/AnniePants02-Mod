package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.KinkoLaptopClosedDisplayModel;
import net.mcreator.anniepantsmod.block.display.KinkoLaptopClosedDisplayItem;

public class KinkoLaptopClosedDisplayItemRenderer extends GeoItemRenderer<KinkoLaptopClosedDisplayItem> {
	public KinkoLaptopClosedDisplayItemRenderer() {
		super(new KinkoLaptopClosedDisplayModel());
	}

	@Override
	public RenderType getRenderType(KinkoLaptopClosedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
