
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.anniepantsmod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.anniepantsmod.entity.TechnopigEntity;
import net.mcreator.anniepantsmod.entity.JaneDoeEntity;
import net.mcreator.anniepantsmod.entity.JaneDoe2Entity;
import net.mcreator.anniepantsmod.entity.AnniePlushEnemyEntity;
import net.mcreator.anniepantsmod.entity.AnnieBanannerEntity;
import net.mcreator.anniepantsmod.AnniepantsmodMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AnniepantsmodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, AnniepantsmodMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<AnniePlushEnemyEntity>> ANNIE_PLUSH_ENEMY = register("annie_plush_enemy",
			EntityType.Builder.<AnniePlushEnemyEntity>of(AnniePlushEnemyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<JaneDoeEntity>> JANE_DOE = register("jane_doe",
			EntityType.Builder.<JaneDoeEntity>of(JaneDoeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<JaneDoe2Entity>> JANE_DOE_2 = register("jane_doe_2",
			EntityType.Builder.<JaneDoe2Entity>of(JaneDoe2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AnnieBanannerEntity>> ANNIE_BANANNER = register("annie_bananner",
			EntityType.Builder.<AnnieBanannerEntity>of(AnnieBanannerEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TechnopigEntity>> TECHNOPIG = register("technopig",
			EntityType.Builder.<TechnopigEntity>of(TechnopigEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		AnniePlushEnemyEntity.init(event);
		JaneDoeEntity.init(event);
		JaneDoe2Entity.init(event);
		AnnieBanannerEntity.init(event);
		TechnopigEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ANNIE_PLUSH_ENEMY.get(), AnniePlushEnemyEntity.createAttributes().build());
		event.put(JANE_DOE.get(), JaneDoeEntity.createAttributes().build());
		event.put(JANE_DOE_2.get(), JaneDoe2Entity.createAttributes().build());
		event.put(ANNIE_BANANNER.get(), AnnieBanannerEntity.createAttributes().build());
		event.put(TECHNOPIG.get(), TechnopigEntity.createAttributes().build());
	}
}
