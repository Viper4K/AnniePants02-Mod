package net.mcreator.anniepantsmod.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;
import net.mcreator.anniepantsmod.init.AnniepantsmodModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VivifySchlattProcedure {
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
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_PLANKS) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_CUBE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_STAIRS) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_STAIRS.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()) && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_SLAB) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_SLAB.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_PRESSURE_PLATE) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_PRESSURE_PLATE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()) && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_DOOR) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_DOOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_TRAPDOOR) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_TRAP_DOOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_FENCE) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_FENCE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_FENCE_GATE) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_FENCE_GATE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()) && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_LOG) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_CUBE_2.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AnniepantsmodModItems.BROKEN_HEARTIFY.get())
				&& ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GLOWSTONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SEA_LANTERN)) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = AnniepantsmodModBlocks.JSCHLATT_LIGHT.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
