
package net.mcreator.anniepantsmod.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class JschlattStairsBlock extends StairBlock {
	public JschlattStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattbreak")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattwalk")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattplace")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlatthit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattbreak"))))
				.strength(1.5f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}
}
