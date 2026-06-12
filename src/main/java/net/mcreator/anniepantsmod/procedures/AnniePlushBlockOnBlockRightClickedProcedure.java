package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.anniepantsmod.init.AnniepantsmodModEntities;

public class AnniePlushBlockOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BRICK) {
			world.addParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, 0, 1, 0);
			world.addParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, 0, 1, 0);
			world.addParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, 0, 1, 0);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AnniepantsmodModEntities.ANNIE_PLUSH_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.NETHER_BRICK) {
			world.addParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, 0, 1, 0);
			world.addParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, 0, 1, 0);
			world.addParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, 0, 1, 0);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AnniepantsmodModEntities.ANNIE_PLUSH_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
