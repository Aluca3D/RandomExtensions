package net.rand.exten.effects.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rand.exten.util.tools.Math_RaEx;

public class LightningAttraction extends StatusEffect {
    public LightningAttraction(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        lightningAttraction(entity.getWorld(), entity);
        super.applyUpdateEffect(entity, amplifier);
    }

    private void lightningAttraction(World world, LivingEntity entity) {
        BlockPos blockPos;
        Math_RaEx m = new Math_RaEx();
        int r = m.randomInt(250);
        if (world.isThundering() && world.isSkyVisible(blockPos = (entity.getBlockPos())) && r == 1) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
            if (lightningEntity != null) {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos.down()));
                world.spawnEntity(lightningEntity);
            }
            world.playSound(null, blockPos, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 5.0f, 1.0f);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
