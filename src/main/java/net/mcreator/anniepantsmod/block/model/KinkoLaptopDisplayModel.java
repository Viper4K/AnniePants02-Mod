package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.display.KinkoLaptopDisplayItem;

public class KinkoLaptopDisplayModel extends GeoModel<KinkoLaptopDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(KinkoLaptopDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/kinko_laptop_open.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KinkoLaptopDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/kinko_laptop_open.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KinkoLaptopDisplayItem entity) {
		return ResourceLocation.parse("anniepantsmod:textures/block/laptop_block.png");
	}
}
