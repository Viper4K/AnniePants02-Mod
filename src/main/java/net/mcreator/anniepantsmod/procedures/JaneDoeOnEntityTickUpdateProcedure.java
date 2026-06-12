package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.anniepantsmod.entity.JaneDoeEntity;

public class JaneDoeOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
            
		if (entity instanceof TamableAnimal _tamIsTamedBy && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			Entity owner = (Entity) ((TamableAnimal) entity).getOwner();
			
			// Handle Sneaking States
			if (owner.isShiftKeyDown()) {
				entity.setShiftKeyDown(true);
				if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.SNEAKING_SPEED))
					_livingEntity5.getAttribute(Attributes.SNEAKING_SPEED).setBaseValue(0.1);
			} else {
				entity.setShiftKeyDown(false);
			}
			
			// Handle Sprinting States
			if (owner.isSprinting()) {
				entity.setSprinting(true);
				if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity17.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.6);
			} else {
				entity.setSprinting(false);
				if (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity19.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4); // Reset to base attribute default speed
			}
		}
	}
}
