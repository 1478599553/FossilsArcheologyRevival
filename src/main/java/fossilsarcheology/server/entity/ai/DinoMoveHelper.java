package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.prehistoric.EntityPrehistoric;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.pathfinding.NodeProcessor;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.MathHelper;

public class DinoMoveHelper extends EntityMoveHelper {

    public DinoMoveHelper(EntityLiving entitylivingIn) {
        super(entitylivingIn);
    }

    public void onUpdateMoveHelper() {
        if (this.action == EntityMoveHelper.Action.STRAFE) {
            float f = (float) this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
            float f1 = (float) this.speed * f;
            float f2 = this.moveForward;
            float f3 = this.moveStrafe;
            float f4 = MathHelper.sqrt(f2 * f2 + f3 * f3);

            if (f4 < 1.0F) {
                f4 = 1.0F;
            }

            f4 = f1 / f4;
            f2 = f2 * f4;
            f3 = f3 * f4;
            float f5 = MathHelper.sin(this.entity.rotationYaw * 0.017453292F);
            float f6 = MathHelper.cos(this.entity.rotationYaw * 0.017453292F);
            float f7 = f2 * f6 - f3 * f5;
            float f8 = f3 * f6 + f2 * f5;
            PathNavigate pathnavigate = this.entity.getNavigator();

            if (pathnavigate != null) {
                NodeProcessor nodeprocessor = pathnavigate.getNodeProcessor();

                if (nodeprocessor != null && nodeprocessor.getPathNodeType(this.entity.world, MathHelper.floor(this.entity.posX + (double) f7), MathHelper.floor(this.entity.posY), MathHelper.floor(this.entity.posZ + (double) f8)) != PathNodeType.WALKABLE) {
                    this.moveForward = 1.0F;
                    this.moveStrafe = 0.0F;
                    f1 = f;
                }
            }

            this.entity.setAIMoveSpeed(f1);
            this.entity.setMoveForward(this.moveForward);
            this.entity.setMoveStrafing(this.moveStrafe);
            this.action = EntityMoveHelper.Action.WAIT;
        } else if (this.action == EntityMoveHelper.Action.MOVE_TO) {
            this.action = EntityMoveHelper.Action.WAIT;
            double d0 = this.posX - this.entity.posX;
            double d1 = this.posZ - this.entity.posZ;
            double d2 = this.posY - this.entity.posY;
            double d3 = d0 * d0 + d2 * d2 + d1 * d1;

            if (d3 < 2.500000277905201E-7D) {
                this.entity.setMoveForward(0.0F);
                return;
            }

            float turn = ((EntityPrehistoric) entity).getMaxTurnDistancePerTick();
            float f9 = (float) (MathHelper.atan2(d1, d0) * (180D / Math.PI)) - 90;
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, f9, turn);
            this.entity.setAIMoveSpeed((float) (this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

            if (d2 > (double) this.entity.stepHeight && d0 * d0 + d1 * d1 < (double) Math.max(1.0F, this.entity.width)) {
                this.entity.getJumpHelper().setJumping();
                this.action = EntityMoveHelper.Action.JUMPING;
            }
        } else if (this.action == EntityMoveHelper.Action.JUMPING) {
            this.entity.setAIMoveSpeed((float) (this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

            if (this.entity.onGround) {
                this.action = EntityMoveHelper.Action.WAIT;
            }
        } else {
            this.entity.setMoveForward(0.0F);
        }
    }
}
