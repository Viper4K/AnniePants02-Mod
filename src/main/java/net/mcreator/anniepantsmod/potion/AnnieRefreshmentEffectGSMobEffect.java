
package net.mcreator.anniepantsmod.potion;

import net.neoforged.neoforge.common.NeoForgeMod;
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

public class AnnieRefreshmentEffectGSMobEffect extends InstantenousMobEffect {
	public AnnieRefreshmentEffectGSMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -342563);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_gs_0"), 0.01, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_gs_1"), 0.01, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MAX_ABSORPTION, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_gs_2"), 16, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_gs_3"), 0.02, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_gs_4"), 0.01, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MINING_EFFICIENCY, ResourceLocation.fromNamespaceAndPath(AnniepantsmodMod.MODID, "effect.annie_refreshment_effect_gs_5"), 0.01, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}
}
