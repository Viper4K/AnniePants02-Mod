package net.mcreator.anniepantsmod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;

public class GsGuiBuyCupProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double diamonds = 0;
		double emeralds1 = 0;
		emeralds1 = 0;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (Items.EMERALD == itemstackiterator.getItem()) {
					emeralds1 = emeralds1 + itemstackiterator.getCount();
				}
			}
		}
		if (emeralds1 >= 8) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(AnniepantsmodModItems.ANNIE_CUP_EMPTY.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.EMERALD);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 8, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You have purchased AnniePants02 cup!"), false);
		}
	}
}
