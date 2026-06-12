
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnniepantsmodMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ANNIE_CREATIVE_TAB = REGISTRY.register("annie_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.anniepantsmod.annie_creative_tab")).icon(() -> new ItemStack(AnniepantsmodModItems.ANNIE_PANTS_ICON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK.get().asItem());
				tabData.accept(AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_HELMET.get());
				tabData.accept(AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_CHESTPLATE.get());
				tabData.accept(AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_LEGGINGS.get());
				tabData.accept(AnniepantsmodModItems.SHADOW_THE_HEDGEHOG_ARMOR_BOOTS.get());
				tabData.accept(AnniepantsmodModItems.CHOSO_TOTEM.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_MUSIC.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_MUSIC_2.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_ASMR.get());
				tabData.accept(AnniepantsmodModItems.RENGOKU_TOTEM.get());
				tabData.accept(AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW.get().asItem());
				tabData.accept(AnniepantsmodModBlocks.KINKO_LAPTOP.get().asItem());
				tabData.accept(AnniepantsmodModItems.ANNIE_CUSTOM_PAINTING_ITEM.get());
				tabData.accept(AnniepantsmodModItems.HEARTIFY.get());
				tabData.accept(AnniepantsmodModItems.BROKEN_HEARTIFY.get());
				tabData.accept(AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_HELMET.get());
				tabData.accept(AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_CHESTPLATE.get());
				tabData.accept(AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_LEGGINGS.get());
				tabData.accept(AnniepantsmodModItems.SCOURGE_THE_HEDGEHOG_ARMOR_BOOTS.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_GG_FLAVOR.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_CUP_EMPTY.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_CUP_FULL.get());
				tabData.accept(AnniepantsmodModItems.ANNIE_CUP_WATER.get());
			}).build());
}
