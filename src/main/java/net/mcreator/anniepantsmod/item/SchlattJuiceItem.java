
package net.mcreator.anniepantsmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.anniepantsmod.init.AnniepantsmodModFluids;

public class SchlattJuiceItem extends BucketItem {
	public SchlattJuiceItem() {
		super(AnniepantsmodModFluids.SCHLATT_JUICE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE));
	}
}
