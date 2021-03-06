package fossilsarcheology.server.entity.prehistoric;

import com.google.common.base.Predicate;
import fossilsarcheology.client.sound.FASoundRegistry;
import fossilsarcheology.server.entity.ai.*;
import fossilsarcheology.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityPrehistoric implements IScaryDinosaur {

    public static final Animation ROAR_ANIMATION = Animation.create(100);

    public EntityTyrannosaurus(World world) {
        super(world, PrehistoricEntityType.TYRANNOSAURUS, 2, 14, 15, 82, 0.2, 0.3, 0, 7);
        this.setActualSize(1.3F, 1.25F);
        this.pediaScale = 40F;
        minSize = 0.2F;
        maxSize = 2.8F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        this.nearByMobsAllowed = 2;
        this.ridingY = 1.625F;
        this.ridingXZ = -0.05F;
        this.stepHeight = 1;
    }

    public void initEntityAI() {
        this.tasks.addTask(1, new DinoMeleeAttackAI(this, 1.5D, false));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit = new EntityAISit(this));
        this.tasks.addTask(3, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(3, new DinoAIEatFeedersAndBlocks(this));
        this.targetTasks.addTask(0, new DinoAIEatItems(this));
        this.tasks.addTask(4, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new DinoAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new DinoAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new DinoAIHurtByTarget(this));
        this.targetTasks.addTask(4, new DinoAIHunt(this, EntityLivingBase.class, true, (Predicate<Entity>) entity -> entity instanceof EntityLivingBase));
    }

    public float getTargetScale() {
        return 2.0F;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public int getSpeakLength() {
        return 40;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAnimation() == ATTACK_ANIMATION && this.canReachPrey() && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
            doAttack();
            doAttackKnockback(1F);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getAnimation() != ATTACK_ANIMATION) {
            this.setAnimation(ATTACK_ANIMATION);
        }
        return false;
    }


    @Override
    public void setSpawnValues() {
    }

    @Override
    public PrehistoricEntityTypeAI.Activity aiActivityType() {

        return PrehistoricEntityTypeAI.Activity.DIURINAL;
    }

    @Override
    public PrehistoricEntityTypeAI.Attacking aiAttackType() {

        return PrehistoricEntityTypeAI.Attacking.DROP;
    }

    @Override
    public PrehistoricEntityTypeAI.Climbing aiClimbType() {

        return PrehistoricEntityTypeAI.Climbing.NONE;
    }

    @Override
    public PrehistoricEntityTypeAI.Following aiFollowType() {

        return PrehistoricEntityTypeAI.Following.AGRESSIVE;
    }

    @Override
    public PrehistoricEntityTypeAI.Jumping aiJumpType() {

        return PrehistoricEntityTypeAI.Jumping.BASIC;
    }

    @Override
    public PrehistoricEntityTypeAI.Response aiResponseType() {

        return isChild() ? PrehistoricEntityTypeAI.Response.SCARED : PrehistoricEntityTypeAI.Response.AGRESSIVE;
    }

    @Override
    public PrehistoricEntityTypeAI.Stalking aiStalkType() {

        return PrehistoricEntityTypeAI.Stalking.STEALTH;
    }

    @Override
    public PrehistoricEntityTypeAI.Taming aiTameType() {

        return PrehistoricEntityTypeAI.Taming.GEM;
    }

    @Override
    public PrehistoricEntityTypeAI.Untaming aiUntameType() {

        return PrehistoricEntityTypeAI.Untaming.NONE;
    }

    @Override
    public PrehistoricEntityTypeAI.Moving aiMovingType() {

        return PrehistoricEntityTypeAI.Moving.WALK;
    }

    @Override
    public PrehistoricEntityTypeAI.WaterAbility aiWaterAbilityType() {

        return PrehistoricEntityTypeAI.WaterAbility.NONE;
    }

    @Override
    public boolean doesFlock() {

        return false;
    }

    @Override
    public Item getOrderItem() {

        return FAItemRegistry.SKULL_STICK;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.isSleeping() && this.rand.nextInt(1500) == 0 && !world.isRemote && !this.isSkeleton() && !this.isActuallyWeak() && !this.isSitting() && this.getAttackTarget() == null) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ROAR_ANIMATION);
            }
        }
        if (getAnimation() == EntityTyrannosaurus.ROAR_ANIMATION && getAnimationTick() == 10) {
            this.playSound(FASoundRegistry.TYRANNOSAURUS_ROAR, this.getSoundPitch(), this.getSoundVolume());
        }
    }

    private void triggerTamingAcheivement(EntityPlayer player) {
        // player.addStat(FossilAchievements.THE_KING);

    }

    public AxisAlignedBB getAttackBounds() {
        float size = this.getRenderSizeModifier() * 0.25F;
        return this.getEntityBoundingBox().grow(4.0F + size, 2.0F + size, 4.0F + size);
    }


    @Override
    public int getAdultAge() {
        return 12;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{SPEAK_ANIMATION, ATTACK_ANIMATION, ROAR_ANIMATION};
    }

    @Override
    public int getTailSegments() {
        return 3;
    }

    @Override
    public int getMaxHunger() {
        return 150;
    }

    @Override
    public void onDeath(DamageSource source) {
        if (source.getTrueSource() != null && source.getTrueSource() instanceof EntityPlayer) {
            //((EntityPlayer) source.getTrueSource()).addStat(FossilAchievements.TREX_KILL);
        }
        super.onDeath(source);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isWeak() ? FASoundRegistry.TYRANNOSAURUS_WEAK : FASoundRegistry.TYRANNOSAURUS_LIVING;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return FASoundRegistry.TYRANNOSAURUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FASoundRegistry.TYRANNOSAURUS_DEATH;
    }

    @Override
    public boolean canBeRidden() {
        return true;
    }

    public float getProximityToNextPathSkip() {
        return (float) this.getEntityBoundingBox().getAverageEdgeLength() * 0.8F;
    }
}
