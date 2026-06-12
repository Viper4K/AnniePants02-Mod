
package net.mcreator.anniepantsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnnieASMRItem extends Item {
	public AnnieASMRItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "annie_asmr"))));
	}
}
