package net.rand.exten.item.custom.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.rand.exten.item.custom.ArmorMaterials_RaEx;

import java.util.Map;

public class AquamarinArmorItem extends MainArmorItem {
    public AquamarinArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    /**
     * Aquamarin
     */
    private static final Map<ArmorMaterial, StatusEffectInstance> D_AQUAMARIN_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.DIAMOND_AQUAMARIN,
                            new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false, true)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> N_AQUAMARIN_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN,
                            new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 400, 0, false, false, true)).build();
    private static final Map<ArmorMaterial, StatusEffectInstance> N_AQUAMARIN_EFFECT_MAP_2 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.NETHERITE_AQUAMARIN,
                            new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 0, false, false, true))
                    .build();


    @Override
    public void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : D_AQUAMARIN_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_AQUAMARIN_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_AQUAMARIN_EFFECT_MAP_2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }
}
