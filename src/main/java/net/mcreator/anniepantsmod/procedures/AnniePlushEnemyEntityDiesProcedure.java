package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class AnniePlushEnemyEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		PlayerKillsAnniePlushEnemyProcedure.execute(world, x, y, z, entity, sourceentity);
	}
}
