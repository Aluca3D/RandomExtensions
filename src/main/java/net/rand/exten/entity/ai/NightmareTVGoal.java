package net.rand.exten.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.rand.exten.entity.mobs.custom.NightmareTVEntity;

import java.util.EnumSet;

//ToDo Better AttackGoal (optional)
public class NightmareTVGoal extends MeleeAttackGoal {

    private final NightmareTVEntity mob;
    private LivingEntity target;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 0;
    private boolean shouldCountTillNextAttack = false;

    public NightmareTVGoal(PathAwareEntity mob) {
        super(mob, 1D, true);
        this.mob = ((NightmareTVEntity) mob);
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public void start() {
        if (this.shouldContinue()) {
            super.start();
            attackDelay = 20;
            ticksUntilNextAttack = 0;
        }
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null) {
            return false;
        } else {
            this.target = livingEntity;
            return true;
        }
    }

    public boolean shouldContinue() {
        if (!this.target.isAlive()) {
            return false;
        } else if (this.mob.squaredDistanceTo(this.target) > 225.0) {
            return false;
        } else {
            return !this.mob.getNavigation().isIdle() || this.canStart();
        }
    }

    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()) {
                mob.setAttacking(true);
            }

            if (isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            mob.setAttacking(false);
            mob.attackingAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.mob.distanceTo(pEnemy) <= 3f; // TODO
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
        this.mob.getLookControl().lookAt(this.target, 30.0F, 30.0F);
        double d = this.mob.getWidth() * 2.0F * this.mob.getWidth() * 2.0F;
        double e = this.mob.squaredDistanceTo(this.target.getX(), this.target.getY(), this.target.getZ());
        double f = 0.8;
        if (e > d && e < 16.0) {
            f = 1.33;
        } else if (e < 225.0) {
            f = 0.6;
        }

        this.mob.getNavigation().startMovingTo(this.target, f);
    }

    @Override
    public void stop() {
        super.stop();
        mob.setAttacking(false);
        this.target = null;
        this.mob.getNavigation().stop();
    }
}
