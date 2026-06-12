package net.mcreator.anniepantsmod.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.block.display.KinkoLaptopClosedDisplayItem;

public class KinkoLaptopClosedDisplayModel extends GeoModel<KinkoLaptopClosedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(KinkoLaptopClosedDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:animations/kinko_laptop.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KinkoLaptopClosedDisplayItem animatable) {
		return ResourceLocation.parse("anniepantsmod:geo/kinko_laptop.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KinkoLaptopClosedDisplayItem entity) {
		return ResourceLocation.parse("anniepantsmod:textures/block/laptop_block.png");
	}
}
