package fossilsarcheology.client.model;

import fossilsarcheology.server.entity.prehistoric.EntityDryosaurus;
import fossilsarcheology.server.entity.prehistoric.EntityPrehistoric;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCitipati extends ModelPrehistoric {
    public AdvancedModelRenderer lowerBody;
    public AdvancedModelRenderer leftThigh;
    public AdvancedModelRenderer rightThigh;
    public AdvancedModelRenderer upperBody;
    public AdvancedModelRenderer tail1;
    public AdvancedModelRenderer neck;
    public AdvancedModelRenderer rightUpperArm;
    public AdvancedModelRenderer leftUpperArm;
    public AdvancedModelRenderer neck_1;
    public AdvancedModelRenderer head;
    public AdvancedModelRenderer headPivot;
    public AdvancedModelRenderer upperJaw;
    public AdvancedModelRenderer lowerJaw;
    public AdvancedModelRenderer upperCrest;
    public AdvancedModelRenderer rightLowerArm;
    public AdvancedModelRenderer rightLowerArmWing;
    public AdvancedModelRenderer rightLowerArmWing2;
    public AdvancedModelRenderer leftLowerArm;
    public AdvancedModelRenderer leftLowerArmWing;
    public AdvancedModelRenderer leftLowerArmWing2;
    public AdvancedModelRenderer tail2;
    public AdvancedModelRenderer tail3;
    public AdvancedModelRenderer rightToeClaw2;
    public AdvancedModelRenderer tailFeather1;
    public AdvancedModelRenderer tailFeather2;
    public AdvancedModelRenderer leftLeg;
    public AdvancedModelRenderer leftFoot;
    public AdvancedModelRenderer rightLeg;
    public AdvancedModelRenderer rightFoot;
    private final ModelAnimator animator;

    public ModelCitipati() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.leftLowerArmWing2 = new AdvancedModelRenderer(this, 30, 18);
        this.leftLowerArmWing2.mirror = true;
        this.leftLowerArmWing2.setRotationPoint(-0.5F, 2.9F, -7.1F);
        this.leftLowerArmWing2.addBox(-0.45F, -0.5F, -1.0F, 1, 7, 6, 0.0F);
        this.setRotateAngle(leftLowerArmWing2, -0.10471975511965977F, -0.0F, 0.0F);
        this.leftLowerArmWing = new AdvancedModelRenderer(this, 37, 4);
        this.leftLowerArmWing.mirror = true;
        this.leftLowerArmWing.setRotationPoint(-0.5F, -0.3F, 0.5F);
        this.leftLowerArmWing.addBox(-0.5F, 0.0F, -8.0F, 1, 5, 7, 0.0F);
        this.setRotateAngle(leftLowerArmWing, 0.31869712141416456F, -0.0F, 0.0F);
        this.neck_1 = new AdvancedModelRenderer(this, 36, 30);
        this.neck_1.setRotationPoint(0.0F, -1.3F, -6.9F);
        this.neck_1.addBox(-1.5F, -2.0F, -8.7F, 3, 4, 10, 0.0F);
        this.setRotateAngle(neck_1, -1.0471975511965976F, 0.0F, 0.0F);
        this.lowerJaw = new AdvancedModelRenderer(this, 49, 0);
        this.lowerJaw.setRotationPoint(0.0F, 2.1F, -2.03F);
        this.lowerJaw.addBox(-2.0F, -0.1F, -4.4F, 3, 1, 4, 0.0F);
        this.setRotateAngle(lowerJaw, -0.014486232791552934F, 0.0F, 0.0F);
        this.rightLeg = new AdvancedModelRenderer(this, 2, 27);
        this.rightLeg.setRotationPoint(-1.2F, 2.8F, 2.2F);
        this.rightLeg.addBox(-1.0F, 0.4F, -10.7F, 2, 2, 11, 0.0F);
        this.setRotateAngle(rightLeg, 1.4311699866353502F, -0.0F, 0.0F);
        this.rightFoot = new AdvancedModelRenderer(this, 0, 40);
        this.rightFoot.setRotationPoint(-0.2F, 0.9F, -9.3F);
        this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(rightFoot, -1.2217304763960306F, -0.0F, 0.0F);
        this.head = new AdvancedModelRenderer(this, 1, 1);
        this.head.addBox(-3.0F, -2.0F, -4.4F, 5, 5, 5, 0.0F);
        this.headPivot = new AdvancedModelRenderer(this, 1, 1);
        this.headPivot.setRotationPoint(0.5F, -0.6F, -8.53F);
        this.setRotateAngle(headPivot, 1.593485607070823F, 0.0F, 0.0F);
        this.tail3 = new AdvancedModelRenderer(this, 60, 16);
        this.tail3.setRotationPoint(0.0F, 0.0F, 5.2F);
        this.tail3.addBox(-1.0F, -0.6F, -1.0F, 2, 2, 10, 0.0F);
        this.setRotateAngle(tail3, -0.05253441048502932F, -0.0F, 0.0F);
        this.rightLowerArm = new AdvancedModelRenderer(this, 20, 8);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(1.1F, 0.6F, 2.8F);
        this.rightLowerArm.addBox(-1.2F, 0.5F, -8.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(rightLowerArm, 0.091106186954104F, -0.0F, 0.0F);
        this.leftFoot = new AdvancedModelRenderer(this, 0, 40);
        this.leftFoot.setRotationPoint(0.2F, 0.9F, -9.3F);
        this.leftFoot.addBox(-1.5F, 0.0F, -3.1F, 3, 2, 4, 0.0F);
        this.setRotateAngle(leftFoot, -1.2217304763960306F, -0.0F, 0.0F);
        this.upperBody = new AdvancedModelRenderer(this, 67, 0);
        this.upperBody.setRotationPoint(0.0F, 1.2F, -1.2F);
        this.upperBody.addBox(-3.0F, -2.0F, -5.0F, 6, 7, 7, 0.0F);
        this.setRotateAngle(upperBody, 0.1609193570338772F, -0.0F, 0.0F);
        this.upperJaw = new AdvancedModelRenderer(this, 28, 0);
        this.upperJaw.setRotationPoint(0.0F, 1.3F, -3.53F);
        this.upperJaw.addBox(-2.5F, -2.7F, -3.2F, 4, 4, 3, 0.0F);
        this.setRotateAngle(upperJaw, 0.091106186954104F, -0.0F, 0.0F);
        this.tail1 = new AdvancedModelRenderer(this, 96, 0);
        this.tail1.setRotationPoint(0.0F, 2.4F, 8.5F);
        this.tail1.addBox(-2.5F, -3.0F, 0.0F, 5, 7, 4, 0.0F);
        this.setRotateAngle(tail1, 0.11903145498601327F, -0.0F, -0.045553093477052F);
        this.leftLowerArm = new AdvancedModelRenderer(this, 20, 8);
        this.leftLowerArm.setRotationPoint(-1.1F, 0.6F, 2.8F);
        this.leftLowerArm.addBox(-0.8F, 0.5F, -8.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(leftLowerArm, 0.091106186954104F, -0.0F, 0.0F);
        this.leftUpperArm = new AdvancedModelRenderer(this, 19, 17);
        this.leftUpperArm.setRotationPoint(-2.0F, 2.3F, -3.0F);
        this.leftUpperArm.addBox(-2.0F, -1.0F, -1.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(leftUpperArm, 0.8939576428714956F, -0.18203784098300857F, 0.22759093446006054F);
        this.upperCrest = new AdvancedModelRenderer(this, 1, 18);
        this.upperCrest.setRotationPoint(-0.51F, 0.9F, -1.15F);
        this.upperCrest.addBox(-0.5F, -3.1F, -5.4F, 1, 5, 5, 0.0F);
        this.setRotateAngle(upperCrest, -0.5045746867515607F, 0.0F, 0.0F);
        this.rightLowerArmWing = new AdvancedModelRenderer(this, 37, 4);
        this.rightLowerArmWing.setRotationPoint(0.5F, -0.3F, 0.5F);
        this.rightLowerArmWing.addBox(-0.5F, 0.0F, -8.0F, 1, 5, 7, 0.0F);
        this.setRotateAngle(rightLowerArmWing, 0.31869712141416456F, -0.0F, 0.0F);
        this.rightUpperArm = new AdvancedModelRenderer(this, 19, 17);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(2.0F, 2.3F, -3.0F);
        this.rightUpperArm.addBox(0.0F, -1.0F, -1.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(rightUpperArm, 0.8939576428714956F, 0.18203784098300857F, -0.22759093446006054F);
        this.tail2 = new AdvancedModelRenderer(this, 90, 13);
        this.tail2.setRotationPoint(0.0F, -0.7F, 4.1F);
        this.tail2.addBox(-1.5F, -1.6F, -1.0F, 3, 4, 6, 0.0F);
        this.setRotateAngle(tail2, 0.0645771823237902F, 0.0F, 0.0F);
        this.rightThigh = new AdvancedModelRenderer(this, 14, 43);
        this.rightThigh.setRotationPoint(-3.0F, 9.6F, 4.0F);
        this.rightThigh.addBox(-3.0F, -2.5F, -2.0F, 3, 8, 5, 0.0F);
        this.setRotateAngle(rightThigh, -0.20943951023931953F, -0.0F, 0.0F);
        this.tailFeather2 = new AdvancedModelRenderer(this, 67, 51);
        this.tailFeather2.setRotationPoint(0.0F, -0.7F, 0.3F);
        this.tailFeather2.addBox(-3.0F, 0.5F, 1.1F, 6, 1, 7, 0.0F);
        this.setRotateAngle(tailFeather2, -0.004886921905584123F, -0.0F, 0.0F);
        this.leftThigh = new AdvancedModelRenderer(this, 14, 43);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(3.0F, 9.6F, 4.0F);
        this.leftThigh.addBox(0.0F, -2.5F, -2.0F, 3, 8, 5, 0.0F);
        this.setRotateAngle(leftThigh, -0.20943951023931953F, -0.0F, 0.0F);
        this.leftLeg = new AdvancedModelRenderer(this, 2, 27);
        this.leftLeg.mirror = true;
        this.leftLeg.setRotationPoint(1.2F, 2.8F, 2.2F);
        this.leftLeg.addBox(-1.0F, 0.4F, -10.7F, 2, 2, 11, 0.0F);
        this.setRotateAngle(leftLeg, 1.4311699866353502F, -0.0F, 0.0F);
        this.lowerBody = new AdvancedModelRenderer(this, 90, 24);
        this.lowerBody.setRotationPoint(0.0F, 4.8F, -1.8F);
        this.lowerBody.addBox(-4.0F, -1.0F, 0.0F, 8, 9, 10, 0.0F);
        this.setRotateAngle(lowerBody, -0.16458454846306528F, 0.0F, 0.0F);
        this.tailFeather1 = new AdvancedModelRenderer(this, 83, 48);
        this.tailFeather1.setRotationPoint(0.0F, -0.7F, -2.5F);
        this.tailFeather1.addBox(-3.5F, 0.5F, 10.1F, 7, 1, 14, 0.0F);
        this.setRotateAngle(tailFeather1, -0.004886921905584123F, -0.0F, 0.0F);
        this.rightToeClaw2 = new AdvancedModelRenderer(this, 0, 40);
        this.rightToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
        this.rightToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rightToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
        this.neck = new AdvancedModelRenderer(this, 36, 51);
        this.neck.setRotationPoint(0.0F, 2.3F, -3.2F);
        this.neck.addBox(-2.0F, -3.6F, -7.6F, 4, 5, 8, 0.0F);
        this.setRotateAngle(neck, -0.22759093446006054F, -0.0F, 0.0F);
        this.rightLowerArmWing2 = new AdvancedModelRenderer(this, 30, 18);
        this.rightLowerArmWing2.setRotationPoint(0.5F, 2.9F, -7.1F);
        this.rightLowerArmWing2.addBox(-0.55F, -0.5F, -1.0F, 1, 7, 6, 0.0F);
        this.setRotateAngle(rightLowerArmWing2, -0.10471975511965977F, -0.0F, 0.0F);
        this.leftLowerArm.addChild(this.leftLowerArmWing2);
        this.leftLowerArm.addChild(this.leftLowerArmWing);
        this.neck.addChild(this.neck_1);
        this.head.addChild(this.lowerJaw);
        this.rightThigh.addChild(this.rightLeg);
        this.rightLeg.addChild(this.rightFoot);
        this.neck_1.addChild(this.headPivot);
        this.headPivot.addChild(this.head);
        this.tail2.addChild(this.tail3);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.leftLeg.addChild(this.leftFoot);
        this.lowerBody.addChild(this.upperBody);
        this.head.addChild(this.upperJaw);
        this.lowerBody.addChild(this.tail1);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.upperBody.addChild(this.leftUpperArm);
        this.head.addChild(this.upperCrest);
        this.rightLowerArm.addChild(this.rightLowerArmWing);
        this.upperBody.addChild(this.rightUpperArm);
        this.tail1.addChild(this.tail2);
        this.tail3.addChild(this.tailFeather2);
        this.leftThigh.addChild(this.leftLeg);
        this.tail3.addChild(this.tailFeather1);
        this.tail2.addChild(this.rightToeClaw2);
        this.upperBody.addChild(this.neck);
        this.rightLowerArm.addChild(this.rightLowerArmWing2);
        this.updateDefaultPose();
        animator = ModelAnimator.create();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.rightThigh.render(f5);
        this.leftThigh.render(f5);
        this.lowerBody.render(f5);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityPrehistoric prehistoric = (EntityPrehistoric) entity;
        animator.update(entity);
        blockMovement(f, f1, f2, f3, f4, f5, (Entity) entity);
        this.resetToDefaultPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        animator.setAnimation(prehistoric.SPEAK_ANIMATION);
        animator.startKeyframe(10);
        ModelUtils.rotate(animator, lowerJaw, 29, 0, 0);
        animator.endKeyframe();
        animator.resetKeyframe(10);
        animator.setAnimation(prehistoric.ATTACK_ANIMATION);
        animator.startKeyframe(10);
        ModelUtils.rotate(animator, neck, -20, 0, 0);
        ModelUtils.rotate(animator, neck_1, -10, 0, 0);
        ModelUtils.rotate(animator, head, 20, 0, 0);
        ModelUtils.rotate(animator, lowerJaw, 35, 0, 0);
        animator.move(head, 0, 0, -1);
        animator.endKeyframe();
        animator.startKeyframe(5);
        ModelUtils.rotate(animator, neck, 15, 0, 0);
        ModelUtils.rotate(animator, neck_1, 35, 0, 0);
        ModelUtils.rotate(animator, head, -30, 0, 0);
        ModelUtils.rotate(animator, lowerJaw, -5, 0, 0);
        animator.endKeyframe();
        animator.resetKeyframe(10);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        AdvancedModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
        AdvancedModelRenderer[] neckParts = {this.neck, this.neck_1, this.head};
        AdvancedModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
        AdvancedModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};
        if (((EntityPrehistoric) entity).isSkeleton() || ((EntityPrehistoric) entity).isAIDisabled()) {
            return;
        }
        EntityPrehistoric dino = (EntityPrehistoric) entity;
        ModelUtils.faceTargetMod(head, f3, f4, 0.5F);
        ModelUtils.faceTargetMod(neck, f3, f4, 0.5F);
        float speed = dino.isSleeping() ? 0.05F : 0.1F;
        float speed2 = 0.5F;
        float degree = dino.isSleeping() ? 0.2F :0.5F;
        {
            float sitProgress = dino.sitProgress;
            sitAnimationRotationPrev(leftLeg, sitProgress, (float) Math.toRadians(30.0D), 0, 0);
            sitAnimationRotationPrev(leftThigh, sitProgress, -((float) Math.toRadians(25.0D)), 0, 0);
            sitAnimationRotationPrev(leftFoot, sitProgress, -((float) Math.toRadians(5.0D)), 0, 0);
            sitAnimationRotationPrev(tail3, sitProgress, (float) Math.toRadians(10.43D), 0, 0);
            sitAnimationRotationPrev(rightFoot, sitProgress, -((float) Math.toRadians(5.0D)), 0, 0);
            sitAnimationRotationPrev(tail1, sitProgress, -((float) Math.toRadians(10.43D)), 0, 0);
            sitAnimationRotationPrev(tail2, sitProgress, (float) Math.toRadians(2.61D), 0, 0);
            sitAnimationRotationPrev(lowerBody, sitProgress, -((float) Math.toRadians(7.83D)), 0, 0);
            sitAnimationRotationPrev(rightThigh, sitProgress, -((float) Math.toRadians(25.0D)), 0, 0);
            sitAnimationRotationPrev(upperBody, sitProgress, (float) Math.toRadians(10.43D), 0, 0);
            sitAnimationRotationPrev(rightLeg, sitProgress, (float) Math.toRadians(30.0D), 0, 0);
            sitAnimationRotationPrev(leftUpperArm, sitProgress, ((float) Math.toRadians(40)), ((float) Math.toRadians(-15)), ((float) Math.toRadians(45)));
            sitAnimationRotationPrev(rightUpperArm, sitProgress, ((float) Math.toRadians(40)), ((float) Math.toRadians(-15)), ((float) Math.toRadians(-45)));
            sitAnimationPos(lowerBody, sitProgress, 0F, 9F, 0F);
            sitAnimationPos(leftThigh, sitProgress, 0F, 7F, 0F);
            sitAnimationPos(rightThigh, sitProgress, 0F, 7F, 0F);

        }
        {
            float sitProgress = dino.sleepProgress;
            sitAnimationRotationPrev(upperJaw, sitProgress, (float) Math.toRadians(2.61D), 0, 0);
            sitAnimationRotationPrev(upperBody, sitProgress, (float) Math.toRadians(13.04D), (float) Math.toRadians(15.65D), -((float) Math.toRadians(2.61D)));
            sitAnimationRotationPrev(leftLeg, sitProgress, (float) Math.toRadians(30.0D), 0, 0);
            sitAnimationRotationPrev(leftFoot, sitProgress, -((float) Math.toRadians(5.0D)), 0, 0);
            sitAnimationRotationPrev(lowerBody, sitProgress, -((float) Math.toRadians(2.61D)), 0, (float) Math.toRadians(10.43D));
            sitAnimationRotationPrev(headPivot, sitProgress, -((float) Math.toRadians(23.48D)), (float) Math.toRadians(20D), -((float) Math.toRadians(7.83D)));
            sitAnimationRotationPrev(lowerJaw, sitProgress, (float) Math.toRadians(2.61D), 0, 0);
            sitAnimationRotationPrev(rightLeg, sitProgress, (float) Math.toRadians(30.0D), 0, 0);
            sitAnimationRotationPrev(leftThigh, sitProgress, -((float) Math.toRadians(25.0D)), 0, 0);
            sitAnimationRotationPrev(tail2, sitProgress, (float) Math.toRadians(2.61D), -((float) Math.toRadians(31.3D)), -((float) Math.toRadians(7.83D)));
            sitAnimationRotationPrev(tail1, sitProgress, -((float) Math.toRadians(28.7D)), -((float) Math.toRadians(10.43D)), -((float) Math.toRadians(15.65D)));
            sitAnimationRotationPrev(neck, sitProgress, (float) Math.toRadians(20.48D), ((float) Math.toRadians(20D)), -((float) Math.toRadians(5.22D)));
            sitAnimationRotationPrev(neck_1, sitProgress, (float) Math.toRadians(-10D), ((float) Math.toRadians(20D)), -((float) Math.toRadians(5D)));
            sitAnimationRotationPrev(rightThigh, sitProgress, -((float) Math.toRadians(25.0D)), (float) Math.toRadians(15.65D), (float) Math.toRadians(2.61D));
            sitAnimationRotationPrev(tail3, sitProgress, (float) Math.toRadians(26.09D), -((float) Math.toRadians(20.87D)), -((float) Math.toRadians(26.09D)));
            sitAnimationRotationPrev(leftUpperArm, sitProgress, ((float) Math.toRadians(40)), ((float) Math.toRadians(-15)), ((float) Math.toRadians(45)));
            sitAnimationRotationPrev(rightUpperArm, sitProgress, ((float) Math.toRadians(40)), ((float) Math.toRadians(-15)), ((float) Math.toRadians(-45)));
            sitAnimationRotationPrev(rightFoot, sitProgress, -((float) Math.toRadians(5.0D)), 0, 0);
            sitAnimationPos(lowerBody, sitProgress, 0F, 9F, 0F);
            sitAnimationPos(leftThigh, sitProgress, 0F, 7F, 0F);
            sitAnimationPos(rightThigh, sitProgress, 0F, 7F, 0F);
        }
        this.bob(lowerBody, speed, degree * 0.7F, false, entity.ticksExisted, 1);
        this.walk(upperBody, speed, degree * 0.1F, false, 0, 0, entity.ticksExisted, 1);
        this.chainWave(tailParts, speed, degree * 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(leftArmParts, speed, degree * 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(rightArmParts, speed, degree * 0.05F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed, degree * 0.15F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed2, degree * 0.25F, -3, f, f1);
        this.chainWave(neckParts, speed, degree * 0.15F, 3, entity.ticksExisted, 1);
        this.chainWave(leftArmParts, speed2, degree * 0.25F, -3, f, f1);
        this.chainWave(rightArmParts, speed2, degree * 0.25F, -3, f, f1);
        this.walk(leftThigh, speed2, 0.6F, false, 0F, 0.4F, f, f1);
        this.walk(leftLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
        this.walk(leftFoot, speed2, -0.6F, true, 2.5F, -0.4F, f, f1);
        this.walk(rightThigh, speed2, 0.6F, true, 0F, -0.4F, f, f1);
        this.walk(rightLeg, speed2, 0.2F, true, 0F, 0.6F, f, f1);
        this.walk(rightFoot, speed2, -0.6F, false, 2.5F, 0.4F, f, f1);
        this.chainWave(neckParts, speed2, degree * 0.35F, 5, f, f1);
        this.chainSwing(tailParts, speed2, degree * 0.1F, 0, f, f1);
        ((EntityPrehistoric) entity).chainBuffer.applyChainSwingBuffer((ModelRenderer[]) tailParts);

    }
}
