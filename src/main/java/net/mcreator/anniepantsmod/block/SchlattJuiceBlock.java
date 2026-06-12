
package net.mcreator.anniepantsmod.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.anniepantsmod.init.AnniepantsmodModFluids;

public class SchlattJuiceBlock extends LiquidBlock {
	public SchlattJuiceBlock() {
		super(AnniepantsmodModFluids.SCHLATT_JUICE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
