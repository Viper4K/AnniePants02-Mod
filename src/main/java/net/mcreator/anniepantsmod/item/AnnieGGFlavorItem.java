
package net.mcreator.anniepantsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class AnnieGGFlavorItem extends Item {
	public AnnieGGFlavorItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.3f).build()));
	}
}
