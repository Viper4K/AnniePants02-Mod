
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.anniepantsmod.block.SchlattJuiceBlock;
import net.mcreator.anniepantsmod.block.KinkoLaptopClosedBlock;
import net.mcreator.anniepantsmod.block.KinkoLaptopBlock;
import net.mcreator.anniepantsmod.block.JschlattTrapDoorBlock;
import net.mcreator.anniepantsmod.block.JschlattStairsBlock;
import net.mcreator.anniepantsmod.block.JschlattSlabBlock;
import net.mcreator.anniepantsmod.block.JschlattPressurePlateBlock;
import net.mcreator.anniepantsmod.block.JschlattLightBlock;
import net.mcreator.anniepantsmod.block.JschlattFenceGateBlock;
import net.mcreator.anniepantsmod.block.JschlattFenceBlock;
import net.mcreator.anniepantsmod.block.JschlattDoorBlock;
import net.mcreator.anniepantsmod.block.JschlattCubeBlock;
import net.mcreator.anniepantsmod.block.JschlattCube2Block;
import net.mcreator.anniepantsmod.block.JaneDoeBodypillowWallBlock;
import net.mcreator.anniepantsmod.block.JaneDoeBodypillowBlock;
import net.mcreator.anniepantsmod.block.AnniePlushBlockBlock;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

public class AnniepantsmodModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(AnniepantsmodMod.MODID);
	public static final DeferredBlock<Block> ANNIE_PLUSH_BLOCK = REGISTRY.register("annie_plush_block", AnniePlushBlockBlock::new);
	public static final DeferredBlock<Block> JANE_DOE_BODYPILLOW = REGISTRY.register("jane_doe_bodypillow", JaneDoeBodypillowBlock::new);
	public static final DeferredBlock<Block> JANE_DOE_BODYPILLOW_WALL = REGISTRY.register("jane_doe_bodypillow_wall", JaneDoeBodypillowWallBlock::new);
	public static final DeferredBlock<Block> KINKO_LAPTOP = REGISTRY.register("kinko_laptop", KinkoLaptopBlock::new);
	public static final DeferredBlock<Block> KINKO_LAPTOP_CLOSED = REGISTRY.register("kinko_laptop_closed", KinkoLaptopClosedBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_CUBE = REGISTRY.register("jschlatt_cube", JschlattCubeBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_STAIRS = REGISTRY.register("jschlatt_stairs", JschlattStairsBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_SLAB = REGISTRY.register("jschlatt_slab", JschlattSlabBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_PRESSURE_PLATE = REGISTRY.register("jschlatt_pressure_plate", JschlattPressurePlateBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_DOOR = REGISTRY.register("jschlatt_door", JschlattDoorBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_TRAP_DOOR = REGISTRY.register("jschlatt_trap_door", JschlattTrapDoorBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_FENCE = REGISTRY.register("jschlatt_fence", JschlattFenceBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_FENCE_GATE = REGISTRY.register("jschlatt_fence_gate", JschlattFenceGateBlock::new);
	public static final DeferredBlock<Block> SCHLATT_JUICE = REGISTRY.register("schlatt_juice", SchlattJuiceBlock::new);
	public static final DeferredBlock<Block> JSCHLATT_CUBE_2 = REGISTRY.register("jschlatt_cube_2", JschlattCube2Block::new);
	public static final DeferredBlock<Block> JSCHLATT_LIGHT = REGISTRY.register("jschlatt_light", JschlattLightBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
