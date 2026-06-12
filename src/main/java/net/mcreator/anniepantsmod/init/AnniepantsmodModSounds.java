
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, AnniepantsmodMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEATTACK = REGISTRY.register("annieattack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "annieattack")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEMUSIC = REGISTRY.register("anniemusic", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "anniemusic")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEMUSIC2 = REGISTRY.register("anniemusic2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "anniemusic2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEDEATH = REGISTRY.register("anniedeath", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "anniedeath")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LAPTOPSTEP = REGISTRY.register("laptopstep", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "laptopstep")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LAPTOPSMASH = REGISTRY.register("laptopsmash", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "laptopsmash")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LAPTOPFALL = REGISTRY.register("laptopfall", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "laptopfall")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LAPTOPPLACE = REGISTRY.register("laptopplace", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "laptopplace")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEASMRLIST = REGISTRY.register("annieasmrlist", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "annieasmrlist")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEHURT = REGISTRY.register("anniehurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "anniehurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANNIEIDLE = REGISTRY.register("annieidle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "annieidle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCHLATTWALK = REGISTRY.register("schlattwalk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "schlattwalk")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCHLATTPLACE = REGISTRY.register("schlattplace", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "schlattplace")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCHLATTHIT = REGISTRY.register("schlatthit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "schlatthit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCHLATTBREAK = REGISTRY.register("schlattbreak", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "schlattbreak")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCHLATTBUCKET = REGISTRY.register("schlattbucket", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "schlattbucket")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BANANNERANGRY = REGISTRY.register("banannerangry", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "banannerangry")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BANANNERDEATH = REGISTRY.register("banannerdeath", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "banannerdeath")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BANANNERHURT = REGISTRY.register("banannerhurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "banannerhurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BANANNERIDLE = REGISTRY.register("bananneridle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "bananneridle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> JD_IDLE = REGISTRY.register("jd_idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "jd_idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> JD_HURT = REGISTRY.register("jd_hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "jd_hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> JD_DEATH = REGISTRY.register("jd_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "jd_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_HIT = REGISTRY.register("pig-hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "pig-hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_IDLE = REGISTRY.register("pig-idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "pig-idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PIG_STEPPING = REGISTRY.register("pig-stepping", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "pig-stepping")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HI_SCHLATT = REGISTRY.register("hi-schlatt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "hi-schlatt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BANANNERIDLE2 = REGISTRY.register("bananneridle2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("anniepantsmod", "bananneridle2")));
}
