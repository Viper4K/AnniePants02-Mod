package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.entity.AnniePlushBlockTileEntity;

public class AnniePlushBlockBlockModel extends GeoModel<AnniePlushBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnniePlushBlockTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/anniepants02.plush.block.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnniePlushBlockTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/anniepants02.plush.block.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnniePlushBlockTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/block/anniepants2.plush.png");
	}
}
