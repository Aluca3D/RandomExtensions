package net.rand.exten.item.custom.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
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
        int i = m.randomInt(3)+1;
        target.setVelocity(target.getVelocity().x * i, target.getVelocity().y * i,target.getVelocity().z * i);
        return true;
    }
}
