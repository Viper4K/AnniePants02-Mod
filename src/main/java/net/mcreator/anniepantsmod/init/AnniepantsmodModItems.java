
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.anniepantsmod.item.ShadowTheHedgehogArmorItem;
import net.mcreator.anniepantsmod.item.ScourgeTheHedgehogArmorItem;
import net.mcreator.anniepantsmod.item.SchlattJuiceItem;
import net.mcreator.anniepantsmod.item.RengokuTotemItem;
import net.mcreator.anniepantsmod.item.KinkoLaptopIconItem;
import net.mcreator.anniepantsmod.item.JaneDoeBodypillowIconItem;
import net.mcreator.anniepantsmod.item.Jane2Item;
import net.mcreator.anniepantsmod.item.Jane1Item;
import net.mcreator.anniepantsmod.item.HeartifyItem;
import net.mcreator.anniepantsmod.item.ChosoTotemItem;
import net.mcreator.anniepantsmod.item.BrokenHeartifyItem;
import net.mcreator.anniepantsmod.item.AnniePantsIconItem;
import net.mcreator.anniepantsmod.item.AnnieMusicItem;
import net.mcreator.anniepantsmod.item.AnnieMusic2Item;
import net.mcreator.anniepantsmod.item.AnnieGGFlavorItem;
import net.mcreator.anniepantsmod.item.AnnieCustomPaintingItemItem;
import net.mcreator.anniepantsmod.item.AnnieCupWaterItem;
import net.mcreator.anniepantsmod.item.AnnieCupFullItem;
import net.mcreator.anniepantsmod.item.AnnieCupEmptyItem;
import net.mcreator.anniepantsmod.item.AnnieAdvancementIconPosessionItem;
import net.mcreator.anniepantsmod.item.AnnieAdvancementIconPlushieItem;
import net.mcreator.anniepantsmod.item.AnnieAdvancementIconItem;
import net.mcreator.anniepantsmod.item.AnnieAdvancementIconBanannersItem;
import net.mcreator.anniepantsmod.item.AnnieASMRItem;
import net.mcreator.anniepantsmod.block.display.KinkoLaptopDisplayItem;
import net.mcreator.anniepantsmod.block.display.KinkoLaptopClosedDisplayItem;
import net.mcreator.anniepantsmod.block.display.JaneDoeBodypillowWallDisplayItem;
import net.mcreator.anniepantsmod.block.display.JaneDoeBodypillowDisplayItem;
import net.mcreator.anniepantsmod.block.display.AnniePlushBlockDisplayItem;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(AnniepantsmodMod.MODID);
	public static final DeferredItem<Item> ANNIE_PLUSH_ENEMY_SPAWN_EGG = REGISTRY.register("annie_plush_enemy_spawn_egg", () -> new DeferredSpawnEggItem(AnniepantsmodModEntities.ANNIE_PLUSH_ENEMY, -44553, -20485, new Item.Properties()));
	public static final DeferredItem<Item> ANNIE_PLUSH_BLOCK = REGISTRY.register(AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK.getId().getPath(), () -> new AnniePlushBlockDisplayItem(AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK.get(), new Item.Properties()));
	public static final DeferredItem<Item> ANNIE_PANTS_ICON = REGISTRY.register("annie_pants_icon", AnniePantsIconItem::new);
	public static final DeferredItem<Item> SHADOW_THE_HEDGEHOG_ARMOR_HELMET = REGISTRY.register("shadow_the_hedgehog_armor_helmet", ShadowTheHedgehogArmorItem.Helmet::new);
	public static final DeferredItem<Item> SHADOW_THE_HEDGEHOG_ARMOR_CHESTPLATE = REGISTRY.register("shadow_the_hedgehog_armor_chestplate", ShadowTheHedgehogArmorItem.Chestplate::new);
	public static final DeferredItem<Item> SHADOW_THE_HEDGEHOG_ARMOR_LEGGINGS = REGISTRY.register("shadow_the_hedgehog_armor_leggings", ShadowTheHedgehogArmorItem.Leggings::new);
	public static final DeferredItem<Item> SHADOW_THE_HEDGEHOG_ARMOR_BOOTS = REGISTRY.register("shadow_the_hedgehog_armor_boots", ShadowTheHedgehogArmorItem.Boots::new);
	public static final DeferredItem<Item> CHOSO_TOTEM = REGISTRY.register("choso_totem", ChosoTotemItem::new);
	public static final DeferredItem<Item> ANNIE_MUSIC = REGISTRY.register("annie_music", AnnieMusicItem::new);
	public static final DeferredItem<Item> ANNIE_MUSIC_2 = REGISTRY.register("annie_music_2", AnnieMusic2Item::new);
	public static final DeferredItem<Item> ANNIE_ASMR = REGISTRY.register("annie_asmr", AnnieASMRItem::new);
	public static final DeferredItem<Item> RENGOKU_TOTEM = REGISTRY.register("rengoku_totem", RengokuTotemItem::new);
	public static final DeferredItem<Item> JANE_DOE_BODYPILLOW = REGISTRY.register(AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW.getId().getPath(),
			() -> new JaneDoeBodypillowDisplayItem(AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW.get(), new Item.Properties()));
	public static final DeferredItem<Item> JANE_DOE_BODYPILLOW_WALL = REGISTRY.register(AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW_WALL.getId().getPath(),
			() -> new JaneDoeBodypillowWallDisplayItem(AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW_WALL.get(), new Item.Properties()));
	public static final DeferredItem<Item> KINKO_LAPTOP = REGISTRY.register(AnniepantsmodModBlocks.KINKO_LAPTOP.getId().getPath(), () -> new KinkoLaptopDisplayItem(AnniepantsmodModBlocks.KINKO_LAPTOP.get(), new Item.Properties()));
	public static final DeferredItem<Item> KINKO_LAPTOP_ICON = REGISTRY.register("kinko_laptop_icon", KinkoLaptopIconItem::new);
	public static final DeferredItem<Item> JANE_DOE_BODYPILLOW_ICON = REGISTRY.register("jane_doe_bodypillow_icon", JaneDoeBodypillowIconItem::new);
	public static final DeferredItem<Item> KINKO_LAPTOP_CLOSED = REGISTRY.register(AnniepantsmodModBlocks.KINKO_LAPTOP_CLOSED.getId().getPath(),
			() -> new KinkoLaptopClosedDisplayItem(AnniepantsmodModBlocks.KINKO_LAPTOP_CLOSED.get(), new Item.Properties()));
	public static final DeferredItem<Item> ANNIE_ADVANCEMENT_ICON = REGISTRY.register("annie_advancement_icon", AnnieAdvancementIconItem::new);
	public static final DeferredItem<Item> ANNIE_ADVANCEMENT_ICON_PLUSHIE = REGISTRY.register("annie_advancement_icon_plushie", AnnieAdvancementIconPlushieItem::new);
	public static final DeferredItem<Item> JSCHLATT_CUBE = block(AnniepantsmodModBlocks.JSCHLATT_CUBE);
	public static final DeferredItem<Item> JSCHLATT_STAIRS = block(AnniepantsmodModBlocks.JSCHLATT_STAIRS);
	public static final DeferredItem<Item> JSCHLATT_SLAB = block(AnniepantsmodModBlocks.JSCHLATT_SLAB);
	public static final DeferredItem<Item> JSCHLATT_PRESSURE_PLATE = block(AnniepantsmodModBlocks.JSCHLATT_PRESSURE_PLATE);
	public static final DeferredItem<Item> JSCHLATT_DOOR = doubleBlock(AnniepantsmodModBlocks.JSCHLATT_DOOR);
	public static final DeferredItem<Item> JSCHLATT_TRAP_DOOR = block(AnniepantsmodModBlocks.JSCHLATT_TRAP_DOOR);
	public static final DeferredItem<Item> ANNIE_CUSTOM_PAINTING_ITEM = REGISTRY.register("annie_custom_painting_item", AnnieCustomPaintingItemItem::new);
	public static final DeferredItem<Item> JANE_DOE_SPAWN_EGG = REGISTRY.register("jane_doe_spawn_egg", () -> new DeferredSpawnEggItem(AnniepantsmodModEntities.JANE_DOE, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> HEARTIFY = REGISTRY.register("heartify", HeartifyItem::new);
	public static final DeferredItem<Item> BROKEN_HEARTIFY = REGISTRY.register("broken_heartify", BrokenHeartifyItem::new);
	public static final DeferredItem<Item> JSCHLATT_FENCE = block(AnniepantsmodModBlocks.JSCHLATT_FENCE);
	public static final DeferredItem<Item> JSCHLATT_FENCE_GATE = block(AnniepantsmodModBlocks.JSCHLATT_FENCE_GATE);
	public static final DeferredItem<Item> SCHLATT_JUICE_BUCKET = REGISTRY.register("schlatt_juice_bucket", SchlattJuiceItem::new);
	public static final DeferredItem<Item> JSCHLATT_CUBE_2 = block(AnniepantsmodModBlocks.JSCHLATT_CUBE_2);
	public static final DeferredItem<Item> JSCHLATT_LIGHT = block(AnniepantsmodModBlocks.JSCHLATT_LIGHT);
	public static final DeferredItem<Item> JANE_DOE_2_SPAWN_EGG = REGISTRY.register("jane_doe_2_spawn_egg", () -> new DeferredSpawnEggItem(AnniepantsmodModEntities.JANE_DOE_2, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> SCOURGE_THE_HEDGEHOG_ARMOR_HELMET = REGISTRY.register("scourge_the_hedgehog_armor_helmet", ScourgeTheHedgehogArmorItem.Helmet::new);
	public static final DeferredItem<Item> SCOURGE_THE_HEDGEHOG_ARMOR_CHESTPLATE = REGISTRY.register("scourge_the_hedgehog_armor_chestplate", ScourgeTheHedgehogArmorItem.Chestplate::new);
	public static final DeferredItem<Item> SCOURGE_THE_HEDGEHOG_ARMOR_LEGGINGS = REGISTRY.register("scourge_the_hedgehog_armor_leggings", ScourgeTheHedgehogArmorItem.Leggings::new);
	public static final DeferredItem<Item> SCOURGE_THE_HEDGEHOG_ARMOR_BOOTS = REGISTRY.register("scourge_the_hedgehog_armor_boots", ScourgeTheHedgehogArmorItem.Boots::new);
	public static final DeferredItem<Item> JANE_1 = REGISTRY.register("jane_1", Jane1Item::new);
	public static final DeferredItem<Item> JANE_2 = REGISTRY.register("jane_2", Jane2Item::new);
	public static final DeferredItem<Item> ANNIE_ADVANCEMENT_ICON_POSESSION = REGISTRY.register("annie_advancement_icon_posession", AnnieAdvancementIconPosessionItem::new);
	public static final DeferredItem<Item> ANNIE_ADVANCEMENT_ICON_BANANNERS = REGISTRY.register("annie_advancement_icon_bananners", AnnieAdvancementIconBanannersItem::new);
	public static final DeferredItem<Item> ANNIE_GG_FLAVOR = REGISTRY.register("annie_gg_flavor", AnnieGGFlavorItem::new);
	public static final DeferredItem<Item> ANNIE_CUP_EMPTY = REGISTRY.register("annie_cup_empty", AnnieCupEmptyItem::new);
	public static final DeferredItem<Item> ANNIE_CUP_FULL = REGISTRY.register("annie_cup_full", AnnieCupFullItem::new);
	public static final DeferredItem<Item> ANNIE_CUP_WATER = REGISTRY.register("annie_cup_water", AnnieCupWaterItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
