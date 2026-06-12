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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
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

import net.mcreator.anniepantsmod.procedures.AnnieBanannerRightClickedOnEntityProcedure;
import net.mcreator.anniepantsmod.init.AnniepantsmodModEntities;
import net.mcreator.anniepantsmod.init.AnniepantsmodModBlocks;

import java.util.List;

public class AnnieBanannerEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(AnnieBanannerEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(AnnieBanannerEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(AnnieBanannerEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_eyes = SynchedEntityData.defineId(AnnieBanannerEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_mouth = SynchedEntityData.defineId(AnnieBanannerEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_color = SynchedEntityData.defineId(AnnieBanannerEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	private long lastAngrySound = 0;
	public String animationprocedure = "empty";

	public AnnieBanannerEntity(EntityType<AnnieBanannerEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	// --- Nested goal: defend owner when a mob attacks them ---
	static class DefendOwnerGoal extends TargetGoal {
		private final AnnieBanannerEntity pet;
		private LivingEntity attacker;

		public DefendOwnerGoal(AnnieBanannerEntity pet) {
			super(pet, false);
			this.pet = pet;
		}

		@Override
		public boolean canUse() {
			if (!pet.isTame() || pet.isOrderedToSit()) return false;
			LivingEntity owner = pet.getOwner();
			if (owner == null) return false;
			attacker = owner.getLastHurtByMob();
			if (attacker == null) return false;
			// Don't target the owner themselves or the pet itself
			return attacker != pet && attacker != owner;
		}

		@Override
		public void start() {
			pet.setTarget(attacker);
			super.start();
		}
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SHOOT, false);
		builder.define(ANIMATION, "undefined");
		builder.define(TEXTURE, "banannergolden");
		builder.define(DATA_eyes, 0);
		builder.define(DATA_mouth, 0);
		builder.define(DATA_color, 0);
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
		// --- Goal selector (what the entity DOES) ---
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.3, Ingredient.of(AnniepantsmodModBlocks.ANNIE_PLUSH_BLOCK.get().asItem()), false));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1, (float) 2, (float) 10));
		this.goalSelector.addGoal(5, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(6, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(7, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(9, new PanicGoal(this, 1.6));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

		// --- Target selector (WHO the entity fights) ---
		this.targetSelector.addGoal(1, new DefendOwnerGoal(this));       // something attacked the owner
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));   // owner was hurt by something
		this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this)); // owner attacked something
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:bananneridle2"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:banannerhurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:banannerdeath"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("Dataeyes", this.entityData.get(DATA_eyes));
		compound.putInt("Datamouth", this.entityData.get(DATA_mouth));
		compound.putInt("Datacolor", this.entityData.get(DATA_color));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Dataeyes"))
			this.entityData.set(DATA_eyes, compound.getInt("Dataeyes"));
		if (compound.contains("Datamouth"))
			this.entityData.set(DATA_mouth, compound.getInt("Datamouth"));
		if (compound.contains("Datacolor"))
			this.entityData.set(DATA_color, compound.getInt("Datacolor"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();

		if (!this.level().isClientSide() && hand == InteractionHand.MAIN_HAND) {
			Entity entity = this;
			// Toggle sit/follow when owner right clicks with empty hand
			if (this.isTame() && this.isOwnedBy(sourceentity) && itemstack.isEmpty()) {
				this.setOrderedToSit(!this.isOrderedToSit());
				return InteractionResult.sidedSuccess(false);
			}
			AnnieBanannerRightClickedOnEntityProcedure.execute(entity, sourceentity);
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
	public boolean doHurtTarget(Entity target) {
		boolean result = super.doHurtTarget(target);
		if (result) {
			// Brief invulnerability after we land a hit so retaliation doesn't land same tick
			this.invulnerableTime = 10;
		}
		return result;
	}

	@Override
	public boolean isAlliedTo(Entity other) {
		if (this.isTame()) {
			LivingEntity owner = this.getOwner();
			if (other == owner) return true;
			if (owner != null && other instanceof TamableAnimal otherTamable) {
				return otherTamable.isOwnedBy(owner);
			}
		}
		return super.isAlliedTo(other);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
		// Play angry sound every ~5 seconds while attacking
		if (this.isAggressive() && this.getTarget() != null && !this.level().isClientSide()) {
			long currentTime = this.level().getGameTime();
			if (currentTime - lastAngrySound > 100) { // 100 ticks = 5 seconds
				lastAngrySound = currentTime;
				SoundEvent angrySound = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("anniepantsmod:banannerangry"));
				if (angrySound != null)
					this.playSound(angrySound, 1.0f, 1.0f);
			}
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(1f);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		AnnieBanannerEntity retval = AnniepantsmodModEntities.ANNIE_BANANNER.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Blocks.POPPY.asItem()).contains(stack.getItem());
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && this.onGround() && !this.isAggressive() && !this.isSprinting()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
			}
			if (this.isInWaterOrBubble()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
			}
			if (this.isShiftKeyDown()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("sneak_idle"));
			}
			if (this.isSprinting()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
			}
			if (!this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("flight"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stanced_up"));
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
			return event.setAndContinue(RawAnimation.begin().thenPlay("attack1, attack2"));
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
			this.remove(AnnieBanannerEntity.RemovalReason.KILLED);
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