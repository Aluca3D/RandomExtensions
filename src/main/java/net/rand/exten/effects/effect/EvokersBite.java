package net.rand.exten.effects.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EvokersBite extends StatusEffect {
    private int timer;
    public EvokersBite(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            spawnEvokersBite(entity.getWorld(), entity.getPos(), entity);
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    private void spawnEvokersBite(World world, Vec3d position, LivingEntity entity) {
        if (timer == 5) {
            world.spawnEntity(new EvokerFangsEntity(world, position.getX(), position.getY(), position.getZ(), entity.getYaw(), 5, entity.getAttacker()));
            timer = 0;
        } else {
            timer++;
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
