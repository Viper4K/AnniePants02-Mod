
package net.mcreator.anniepantsmod.block;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class JschlattLightBlock extends Block {
	public JschlattLightBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattbreak")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattwalk")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattplace")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlatthit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattbreak"))))
				.strength(1f, 10f).lightLevel(s -> 15).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
