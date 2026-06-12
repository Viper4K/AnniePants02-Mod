
package net.mcreator.anniepantsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AnnieAdvancementIconItem extends Item {
	public AnnieAdvancementIconItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}
}
