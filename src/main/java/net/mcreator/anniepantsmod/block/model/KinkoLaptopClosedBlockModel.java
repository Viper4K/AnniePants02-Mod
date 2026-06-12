package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.entity.KinkoLaptopClosedTileEntity;

public class KinkoLaptopClosedBlockModel extends GeoModel<KinkoLaptopClosedTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(KinkoLaptopClosedTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/kinko_laptop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KinkoLaptopClosedTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/kinko_laptop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KinkoLaptopClosedTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/block/laptop_block.png");
	}
}
