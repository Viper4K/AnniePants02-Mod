
package net.mcreator.anniepantsmod.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.anniepantsmod.AnniepantsmodMod;

import java.util.Set;

public class AnnieRefreshmentEffectWaterMobEffect extends InstantenousMobEffect {
	public AnnieRefreshmentEffectWaterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3813894);
		this.addAttributeModifier(Attributes.MAX_ABSORPTION, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_water_0"), 2, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}
}
