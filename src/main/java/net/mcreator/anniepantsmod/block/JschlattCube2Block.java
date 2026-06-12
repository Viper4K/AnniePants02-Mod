
package net.mcreator.anniepantsmod.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class JschlattCube2Block extends Block {
	public JschlattCube2Block() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattbreak")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattwalk")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattplace")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlatthit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:schlattbreak"))))
				.strength(1.5f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
