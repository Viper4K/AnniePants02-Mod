package net.mcreator.anniepantsmod.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.anniepantsmod.block.model.JaneDoeBodypillowBlockModel;
import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;

public class JaneDoeBodypillowTileRenderer extends GeoBlockRenderer<JaneDoeBodypillowTileEntity> {
	public JaneDoeBodypillowTileRenderer() {
		super(new JaneDoeBodypillowBlockModel());
	}

	@Override
	public RenderType getRenderType(JaneDoeBodypillowTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
	
	@Override
    public boolean shouldRenderOffScreen(JaneDoeBodypillowTileEntity blockEntity) {
        return true;
    }
	
	@Override
	public AABB getRenderBoundingBox(JaneDoeBodypillowTileEntity blockEntity) {
		BlockPos pos = blockEntity.getBlockPos();
		return new AABB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, 
						pos.getX() + 2, pos.getY() + 1, pos.getZ() + 2);
	}
}
