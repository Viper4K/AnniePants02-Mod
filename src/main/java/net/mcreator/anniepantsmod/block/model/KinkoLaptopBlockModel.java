package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.entity.KinkoLaptopTileEntity;

public class KinkoLaptopBlockModel extends GeoModel<KinkoLaptopTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(KinkoLaptopTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/kinko_laptop_open.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KinkoLaptopTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/kinko_laptop_open.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KinkoLaptopTileEntity animatable) {
		return ResourceLocation.parse("anniepantsmod:textures/block/laptop_block.png");
	}
}
