package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.AnniePlushBlockBlockModel;
import net.mcreator.anniepantsmod.block.entity.AnniePlushBlockTileEntity;

public class AnniePlushBlockTileRenderer extends GeoBlockRenderer<AnniePlushBlockTileEntity> {
	public AnniePlushBlockTileRenderer() {
		super(new AnniePlushBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(AnniePlushBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
