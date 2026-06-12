
package net.mcreator.anniepantsmod.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;

import net.mcreator.anniepantsmod.procedures.JaneDoeStayConditionProcedure;
import net.mcreator.anniepantsmod.procedures.JaneDoeOnEntityTickUpdateProcedure;
import net.mcreator.anniepantsmod.procedures.JaneDoeFollowConditionProcedure;
import net.mcreator.anniepantsmod.init.AnniepantsmodModEntities;
import net.mcreator.anniepantsmod.init.AnniepantsmodModBlocks;

import java.util.List;

public class JaneDoe2Entity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(JaneDoe2Entity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(JaneDoe2Entity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(JaneDoe2Entity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public JaneDoe2Entity(EntityType<JaneDoe2Entity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SHOOT, false);
		builder.define(ANIMATION, "undefined");
		builder.define(TEXTURE, "jane");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 0.75, (float) 3, (float) 5) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeStayConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeStayConditionProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Monster.class, true, true));
		this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(7, new OwnerHurtTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(10, new OpenDoorGoal(this, true) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(11, new OpenDoorGoal(this, true) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeStayConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeStayConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(12, new OpenDoorGoal(this, false) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeFollowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(13, new OpenDoorGoal(this, false) {
			@Override
			public boolean canUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canUse() && JaneDoeStayConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JaneDoe2Entity.this.getX();
				double y = JaneDoe2Entity.this.getY();
				double z = JaneDoe2Entity.this.getZ();
				Entity entity = JaneDoe2Entity.this;
				Level world = JaneDoe2Entity.this.level();
				return super.canContinueToUse() && JaneDoeStayConditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(AnniepantsmodModBlocks.JANE_DOE_BODYPILLOW.get()));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:jd_idle"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:jd_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:jd_death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypes.FALL))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		
		if (!this.level().isClientSide() && hand == InteractionHand.MAIN_HAND) {
			if (this.isTame() && this.isOwnedBy(sourceentity) && itemstack.isEmpty()) {
				this.setOrderedToSit(!this.isOrderedToSit());
				return InteractionResult.sidedSuccess(false);
			}
		}
		
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						FoodProperties foodproperties = itemstack.getFoodProperties(this);
						float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
						this.heal(nutrition);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		JaneDoeOnEntityTickUpdateProcedure.execute(this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(1f);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		JaneDoe2Entity retval = AnniepantsmodModEntities.JANE_DOE_2.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Blocks.DANDELION.asItem(), Blocks.POPPY.asItem(), Blocks.BLUE_ORCHID.asItem(), Blocks.ALLIUM.asItem(), Blocks.AZURE_BLUET.asItem(), Blocks.RED_TULIP.asItem(), Blocks.ORANGE_TULIP.asItem(), Blocks.WHITE_TULIP.asItem(),
				Blocks.PINK_TULIP.asItem(), Blocks.OXEYE_DAISY.asItem(), Blocks.CORNFLOWER.asItem(), Blocks.LILY_OF_THE_VALLEY.asItem(), Blocks.TORCHFLOWER.asItem(), Blocks.PINK_PETALS.asItem(), Blocks.SUNFLOWER.asItem(), Blocks.LILAC.asItem(),
				Blocks.ROSE_BUSH.asItem(), Blocks.PEONY.asItem(), Blocks.PITCHER_PLANT.asItem(), Blocks.FLOWERING_AZALEA.asItem()).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.7);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			// 1. Prioritize Death
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
			}
			// 2. Prioritize Water
			if (this.isInWaterOrBubble()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim_stand"));
			}
			// 3. Handle Crouching / Sneaking states smoothly
			if (this.isShiftKeyDown()) {
				if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
					return event.setAndContinue(RawAnimation.begin().thenLoop("sneak")); // Your moving sneak animation
				}
				return event.setAndContinue(RawAnimation.begin().thenLoop("sneakidle"));
			}
			// 4. Regular Movement States
			if (this.isSprinting()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("run"));
			}
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && this.onGround() && !this.isVehicle()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("walk3"));
			}
			if (!this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("fly"));
			}
			if (this.isVehicle() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("boat"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	private PlayState attackingPredicate(AnimationState event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level().getGameTime();
		}
		if (this.swinging && this.lastSwing + 7L <= level().getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().forceAnimationReset();
			return event.setAndContinue(RawAnimation.begin().thenPlay("swing_hand"));
		}
		return PlayState.CONTINUE;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(JaneDoe2Entity.RemovalReason.KILLED);
			this.dropExperience(this);
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
