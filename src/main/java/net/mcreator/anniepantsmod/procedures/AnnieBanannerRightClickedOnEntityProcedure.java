package net.mcreator.anniepantsmod.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.anniepantsmod.entity.AnnieBanannerEntity;

public class AnnieBanannerRightClickedOnEntityProcedure {

    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;

        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS) {
            if (entity instanceof AnnieBanannerEntity bananner) {
                int current = bananner.getEntityData().get(AnnieBanannerEntity.DATA_eyes);
                int next = (current + 1) % 4;
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_eyes, next);
            }
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BRUSH) {
            if (entity instanceof AnnieBanannerEntity bananner) {
                int current = bananner.getEntityData().get(AnnieBanannerEntity.DATA_mouth);
                int next = (current + 1) % 5;
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_mouth, next);
            }
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.LIGHT_BLUE_DYE) {
            if (entity instanceof AnnieBanannerEntity bananner)
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_color, 1);
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GREEN_DYE) {
            if (entity instanceof AnnieBanannerEntity bananner)
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_color, 2);
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ORANGE_DYE) {
            if (entity instanceof AnnieBanannerEntity bananner)
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_color, 3);
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PINK_DYE) {
            if (entity instanceof AnnieBanannerEntity bananner)
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_color, 4);
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PURPLE_DYE) {
            if (entity instanceof AnnieBanannerEntity bananner)
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_color, 5);
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.POTION) {
            if (entity instanceof AnnieBanannerEntity bananner)
                bananner.getEntityData().set(AnnieBanannerEntity.DATA_color, 0);
        }
    }
}