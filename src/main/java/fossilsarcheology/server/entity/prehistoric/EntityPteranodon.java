package fossilsarcheology.server.entity.prehistoric;

import com.google.common.base.Predicate;
import fossilsarcheology.client.sound.FASoundRegistry;
import fossilsarcheology.server.entity.ai.*;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class EntityPteranodon extends EntityPrehistoricFlying {

    public EntityPteranodon(World world) {
        super(world, PrehistoricEntityType.PTEROSAUR, 2, 4, 6, 30, 0.15, 0.2, 0, 0);
        TAKEOFF_ANIMATION = Animation.create(30);
        this.setActualSize(1.1F, 1.1F);
        minSize = 0.3F;
        maxSize = 1.1F;
        teenAge = 4;
        pediaScale = 45;
    }

    public void initEntityAI() {
        this.tasks.addTask(1, new DinoMeleeAttackAI(this, 1.5D, false));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit = new EntityAISit(this));
        this.tasks.addTask(3, new DinoAIFindAirTarget(this));
        this.tasks.addTask(3, new DinoAIEatFeedersAndBlocks(this));
        this.targetTasks.addTask(0, new DinoAIEatItems(this));
        this.tasks.addTask(5, new DinoAILeapAtTarget(this));
        this.tasks.addTask(6, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new DinoAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new DinoAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new DinoAIHurtByTarget(this));
        this.targetTasks.addTask(4, new DinoAIHunt(this, EntityLivingBase.class, true, (Predicate<Entity>) entity -> entity instanceof EntityLivingBase));

    }

    public int getAttackLength() {
        return 25;
    }

    @Override
    public int getAdultAge() {
        return 9;
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
        return PrehistoricEntityTypeAI.Attacking.BASIC;
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
        return PrehistoricEntityTypeAI.Response.TERITORIAL;
    }

    @Override
    public PrehistoricEntityTypeAI.Stalking aiStalkType() {
        return PrehistoricEntityTypeAI.Stalking.NONE;
    }

    @Override
    public PrehistoricEntityTypeAI.Taming aiTameType() {
        return PrehistoricEntityTypeAI.Taming.FEEDING;
    }

    @Override
    public PrehistoricEntityTypeAI.Untaming aiUntameType() {
        return PrehistoricEntityTypeAI.Untaming.ATTACK;
    }

    @Override
    public PrehistoricEntityTypeAI.Moving aiMovingType() {
        return PrehistoricEntityTypeAI.Moving.FLIGHT;
    }

    @Override
    public PrehistoricEntityTypeAI.WaterAbility aiWaterAbilityType() {
        return PrehistoricEntityTypeAI.WaterAbility.IGNOREANDFISH;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
            doAttack();
        }
        if (this.isInWater() && !this.isFlying()) {
            this.startFlying();
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
    public boolean doesFlock() {
        return false;
    }

    @Override
    public Item getOrderItem() {
        return Items.ARROW;
    }

    @Override
    protected double getFlySpeed() {
        return 1;
    }

    @Override
    public float getMaleSize() {
        return 1.3F;
    }

    @Override
    public int getMaxHunger() {
        return 50;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return FASoundRegistry.PTEROSAUR_LIVING;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return FASoundRegistry.PTEROSAUR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FASoundRegistry.PTEROSAUR_DEATH;
    }

    @Nullable
    @Override
    public BlockPos generateAirTarget() {
        if (this.isHungry()) {
            BlockPos groundPos = new BlockPos(this);
            while (groundPos.getY() > 3 && world.isAirBlock(groundPos)) {
                groundPos = groundPos.down();
            }
            for (int i = 0; i < 10; i++) {
                BlockPos checkForWaterPos = groundPos.add(getRNG().nextInt(16) - 8, 0, getRNG().nextInt(16) - 8);
                if (world.getBlockState(checkForWaterPos).getMaterial() == Material.WATER) {
                    return checkForWaterPos.up();
                }
            }
        }
        return super.generateAirTarget();
    }

    protected void onReachAirTarget(BlockPos target) {
        if (world.getBlockState(target.down()).getMaterial() == Material.WATER && this.isHungry()) {
            ItemStack stack2 = new ItemStack(Items.FISH, 1, this.getRNG().nextInt(2));
            this.entityDropItem(stack2, 1);
            this.playSound(SoundEvents.ENTITY_GENERIC_SWIM, 0.7F, 1.0F + world.rand.nextFloat() * 0.4F);
            this.playSound(SoundEvents.ENTITY_HOSTILE_SWIM, 0.4F, 1.0F + world.rand.nextFloat() * 0.4F);
            if (this.world.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    double d0 = this.rand.nextGaussian() * 0.02D;
                    double d1 = this.rand.nextGaussian() * 0.02D;
                    double d2 = this.rand.nextGaussian() * 0.02D;
                    double d3 = 10.0D;
                    this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, (target.down().getX() + 0.5D + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width - d0 * 10.0D), target.down().getY() + 1.0D + (double) (this.rand.nextFloat() * this.height) - d1 * 10.0D, target.down().getZ() + 0.5D + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width - d2 * 10.0D, d0, d1, d2);
                }
            }
        }
    }

    public int getTakeoffTick() {
        return 6;
    }

    public boolean hasTakeoffAnimation(){
        return true;
    }
}
