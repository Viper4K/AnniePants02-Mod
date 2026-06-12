
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.anniepantsmod.block.entity.KinkoLaptopTileEntity;
import net.mcreator.anniepantsmod.block.entity.KinkoLaptopClosedTileEntity;
import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowWallTileEntity;
import net.mcreator.anniepantsmod.block.entity.JaneDoeBodypillowTileEntity;
import net.mcreator.anniepantsmod.block.entity.AnniePlushBlockTileEntity;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AnniepantsmodMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ANNIE_PLUSH_BLOCK = register("annie_plush_block", AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK, AnniePlushBlockTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> JANE_DOE_BODYPILLOW = register("jane_doe_bodypillow", AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW, JaneDoeBodypillowTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> JANE_DOE_BODYPILLOW_WALL = register("jane_doe_bodypillow_wall", AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW_WALL, JaneDoeBodypillowWallTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> KINKO_LAPTOP = register("kinko_laptop", AnniepantsmodModBlocks.KINKO_LAPTOP, KinkoLaptopTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> KINKO_LAPTOP_CLOSED = register("kinko_laptop_closed", AnniepantsmodModBlocks.KINKO_LAPTOP_CLOSED, KinkoLaptopClosedTileEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
