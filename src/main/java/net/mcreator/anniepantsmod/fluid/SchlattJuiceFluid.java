
package net.mcreator.anniepantsmod.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.anniepantsmod.init.AnniepantsmodModParticleTypes;
import net.mcreator.anniepantsmod.init.AnniepantsmodModItems;
import net.mcreator.anniepantsmod.init.AnniepantsmodModFluids;
import net.mcreator.anniepantsmod.init.AnniepantsmodModFluidTypes;
import net.mcreator.anniepantsmod.init.AnniepantsmodModBlocks;

public abstract class SchlattJuiceFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> AnniepantsmodModFluidTypes.SCHLATT_JUICE_TYPE.get(), () -> AnniepantsmodModFluids.SCHLATT_JUICE.get(),
			() -> AnniepantsmodModFluids.FLOWING_SCHLATT_JUICE.get()).explosionResistance(100f).bucket(() -> AnniepantsmodModItems.SCHLATT_JUICE_BUCKET.get()).block(() -> (LiquidBlock) AnniepantsmodModBlocks.SCHLATT_JUICE.get());

	private SchlattJuiceFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (AnniepantsmodModParticleTypes.SCHLATT_PARTICLE.get());
	}

	public static class Source extends SchlattJuiceFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SchlattJuiceFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
