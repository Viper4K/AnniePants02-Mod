package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.KinkoLaptopDisplayModel;
import net.mcreator.anniepantsmod.block.display.KinkoLaptopDisplayItem;

public class KinkoLaptopDisplayItemRenderer extends GeoItemRenderer<KinkoLaptopDisplayItem> {
	public KinkoLaptopDisplayItemRenderer() {
		super(new KinkoLaptopDisplayModel());
	}

	@Override
	public RenderType getRenderType(KinkoLaptopDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
