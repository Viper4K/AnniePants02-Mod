package net.mcreator.anniepantsmod.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;
import net.mcreator.anniepantsmod.init.AnniepantsmodModEntities;
import net.mcreator.anniepantsmod.init.AnniepantsmodModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VivifyAnnieProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AnniepantsmodModEntities.ANNIE_BANANNER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (!(entity instanceof ServerPlayer _plr8 && _plr8.level() instanceof ServerLevel
					&& _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().get(ResourceLocation.parse("anniepantsmod:annie_bananner_vivify"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("anniepantsmod:annie_bananner_vivify"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AnniepantsmodModEntities.ANNIE_PLUSH_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.HEARTIFY.get())
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW.get()
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW_WALL.get())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AnniepantsmodModEntities.JANE_DOE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (!(entity instanceof ServerPlayer _plr28 && _plr28.level() instanceof ServerLevel
					&& _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().get(ResourceLocation.parse("anniepantsmod:annie_advancement_jane_doe"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("anniepantsmod:annie_advancement_jane_doe"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW.get()
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW_WALL.get())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AnniepantsmodModEntities.JANE_DOE_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (!(entity instanceof ServerPlayer _plr40 && _plr40.level() instanceof ServerLevel
					&& _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().get(ResourceLocation.parse("anniepantsmod:annie_advancement_jane_doe_2"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("anniepantsmod:annie_advancement_jane_doe_2"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
	}
}
