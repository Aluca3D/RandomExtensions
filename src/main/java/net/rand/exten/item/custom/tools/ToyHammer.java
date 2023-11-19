package net.rand.exten.item.custom.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rand.exten.sound.Sounds_RaEx;
import net.rand.exten.util.tools.Math_RaEx;

public class ToyHammer extends ToolItem {
    public ToyHammer(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.SLIME_BALL);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        target.playSound(Sounds_RaEx.BOING, 1,1);
        Math_RaEx m = new Math_RaEx();
        int i = m.randomInt(3)+1;
        target.setVelocity(target.getVelocity().x * i, target.getVelocity().y * i,target.getVelocity().z * i);
        return true;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }
}
