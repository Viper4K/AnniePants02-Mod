
package net.mcreator.anniepantsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AnnieCupEmptyItem extends Item {
	public AnnieCupEmptyItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
