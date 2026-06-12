package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.KinkoLaptopClosedBlockModel;
import net.mcreator.anniepantsmod.block.entity.KinkoLaptopClosedTileEntity;

public class KinkoLaptopClosedTileRenderer extends GeoBlockRenderer<KinkoLaptopClosedTileEntity> {
	public KinkoLaptopClosedTileRenderer() {
		super(new KinkoLaptopClosedBlockModel());
	}

	@Override
	public RenderType getRenderType(KinkoLaptopClosedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
