package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.KinkoLaptopBlockModel;
import net.mcreator.anniepantsmod.block.entity.KinkoLaptopTileEntity;

public class KinkoLaptopTileRenderer extends GeoBlockRenderer<KinkoLaptopTileEntity> {
	public KinkoLaptopTileRenderer() {
		super(new KinkoLaptopBlockModel());
	}

	@Override
	public RenderType getRenderType(KinkoLaptopTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
