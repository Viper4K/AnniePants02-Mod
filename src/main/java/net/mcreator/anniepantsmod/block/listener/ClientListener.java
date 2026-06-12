package net.mcreator.anniepantsmod.block.listener;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.mcreator.anniepantsmod.init.AnniepantsmodModBlockEntities;
import net.mcreator.anniepantsmod.block.renderer.KinkoLaptopTileRenderer;
import net.mcreator.anniepantsmod.block.renderer.KinkoLaptopClosedTileRenderer;
import net.mcreator.anniepantsmod.block.renderer.JaneDoeBodypillowWallTileRenderer;
import net.mcreator.anniepantsmod.block.renderer.JaneDoeBodypillowTileRenderer;
import net.mcreator.anniepantsmod.block.renderer.AnniePlushBlockTileRenderer;
import net.mcreator.anniepantsmod.block.entity.KinkoLaptopTileEntity;
import net.mcreator.anniepantsmod.block.entity.KinkoLaptopClosedTileEntity;
import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowWallTileEntity;
import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowTileEntity;
import net.mcreator.anniepantsmod.block.entity.AnniePlushBlockTileEntity;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

@EventBusSubscriber(modid = AnniepantsmodMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<AnniePlushBlockTileEntity>) AnniepantsmodModBlockEntities.ANNIE_PLUSH_BLOCK.get(), context -> new AnniePlushBlockTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<JaneDoeBodypillowTileEntity>) AnniepantsmodModBlockEntities.JANE_DOE_BODYPILLOW.get(), context -> new JaneDoeBodypillowTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<JaneDoeBodypillowWallTileEntity>) AnniepantsmodModBlockEntities.JANE_DOE_BODYPILLOW_WALL.get(), context -> new JaneDoeBodypillowWallTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<KinkoLaptopTileEntity>) AnniepantsmodModBlockEntities.KINKO_LAPTOP.get(), context -> new KinkoLaptopTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<KinkoLaptopClosedTileEntity>) AnniepantsmodModBlockEntities.KINKO_LAPTOP_CLOSED.get(), context -> new KinkoLaptopClosedTileRenderer());
	}
}
