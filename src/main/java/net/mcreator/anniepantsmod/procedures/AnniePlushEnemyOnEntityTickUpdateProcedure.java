package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class AnniePlushEnemyOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double aggro = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getDouble("aggrocounter") > 54) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:annieattack")), SoundSource.HOSTILE, (float) 0.5, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:annieattack")), SoundSource.HOSTILE, (float) 0.5, 1, false);
					}
				}
				entity.getPersistentData().putDouble("aggrocounter", 0);
			} else {
				entity.getPersistentData().putDouble("aggrocounter", (entity.getPersistentData().getDouble("aggrocounter") + 1));
			}
		}
	}
}
