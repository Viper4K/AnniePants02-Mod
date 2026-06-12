package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.JaneDoeBodypillowWallBlockModel;
import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowWallTileEntity;

public class JaneDoeBodypillowWallTileRenderer extends GeoBlockRenderer<JaneDoeBodypillowWallTileEntity> {
	public JaneDoeBodypillowWallTileRenderer() {
		super(new JaneDoeBodypillowWallBlockModel());
	}

	@Override
	public RenderType getRenderType(JaneDoeBodypillowWallTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
