package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.anniepantsmod.init.AnniepantsmodModBlocks;

import java.util.Set;

public class AnniePlushBlockBlockIsPlacedByProcedure {

	private static final Set<Block> JSCHLATT_BLOCKS = Set.of(
			AnniepantsmodModBlocks.JSCHLATT_CUBE.get(),
			AnniepantsmodModBlocks.JSCHLATT_STAIRS.get(),
			AnniepantsmodModBlocks.JSCHLATT_SLAB.get(),
			AnniepantsmodModBlocks.JSCHLATT_PRESSURE_PLATE.get(),
			AnniepantsmodModBlocks.JSCHLATT_DOOR.get(),
			AnniepantsmodModBlocks.JSCHLATT_TRAP_DOOR.get(),
			AnniepantsmodModBlocks.JSCHLATT_FENCE.get(),
			AnniepantsmodModBlocks.JSCHLATT_FENCE_GATE.get(),
			AnniepantsmodModBlocks.SCHLATT_JUICE.get(),
			AnniepantsmodModBlocks.JSCHLATT_CUBE_2.get(),
			AnniepantsmodModBlocks.JSCHLATT_LIGHT.get()
	);

	private static final BlockPos[] OFFSETS = buildOffsets(3);

	private static BlockPos[] buildOffsets(int maxRadius) {
		java.util.List<BlockPos> list = new java.util.ArrayList<>();
		for (int dx = -maxRadius; dx <= maxRadius; dx++) {
			for (int dy = -maxRadius; dy <= maxRadius; dy++) {
				for (int dz = -maxRadius; dz <= maxRadius; dz++) {
					if (dx == 0 && dy == 0 && dz == 0) continue;
					list.add(new BlockPos(dx, dy, dz));
				}
			}
		}
		return list.toArray(new BlockPos[0]);
	}

	private static boolean isNearJschlatt(LevelAccessor world, BlockPos center) {
		for (BlockPos off : OFFSETS) {
			Block b = world.getBlockState(center.offset(off)).getBlock();
			if (JSCHLATT_BLOCKS.contains(b)) return true;
		}
		return false;
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockPos center = BlockPos.containing(x, y, z);
		if (isNearJschlatt(world, center)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, center, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:hi-schlatt")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:hi-schlatt")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}