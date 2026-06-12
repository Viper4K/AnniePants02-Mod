package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;

public class RengokuTotemItemInInventoryTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(AnniepantsmodModItems.RENGOKU_TOTEM.get())) : false) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1, 255));
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.FIRE_RESISTANCE);
		}
	}
}
