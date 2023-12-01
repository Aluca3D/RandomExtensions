package net.rand.exten.item.custom.legendary;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
        Math_RaEx m = new Math_RaEx();
        int i = m.randomInt(3) + 1;

        float yaw = attacker.getYaw();
        float pitch = attacker.getPitch();
        float roll = attacker.getRoll();

        float f = -MathHelper.sin(yaw * ((float) Math.PI / 180)) * MathHelper.cos(pitch * ((float) Math.PI / 180));
        float g = -MathHelper.sin((pitch + roll) * ((float) Math.PI / 180));
        float h = MathHelper.cos(yaw * ((float) Math.PI / 180)) * MathHelper.cos(pitch * ((float) Math.PI / 180));

        if (target instanceof PlayerEntity player) {
            player.playSound(Sounds_RaEx.BOING, 2, 1);
            player.setVelocity(f * i, g * i, h * i);

        } else {
            target.playSound(Sounds_RaEx.BOING, 2, 1);
            target.setVelocity(f * i, g * i, h * i);
        }

        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }
}
