package net.rand.exten.item.custom.wearable.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.world.World;
import net.rand.exten.effects.Effects_RaEx;
import net.rand.exten.item.custom.ArmorMaterials_RaEx;
import net.rand.exten.item.custom.wearable.ArmorItem_RaEx;

import java.util.Map;

public class CopperArmorItem extends ArmorItem_RaEx {
    public CopperArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    /**
     * Copper
     */
    private static final Map<ArmorMaterial, StatusEffectInstance> COPPER_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ArmorMaterials_RaEx.COPPER,
                            new StatusEffectInstance(Effects_RaEx.LIGHTNING_ATTRACTION, 200, 0, false, false, true))
                    .build();

    @Override
    public void evaluateArmorEffects(PlayerEntity player) {
        World world = player.getWorld();
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : COPPER_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player) && world.isThundering()) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }
}
