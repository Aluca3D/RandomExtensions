package net.rand.exten.item.custom.wearable.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.rand.exten.item.custom.ArmorMaterials_RaEx;
import net.rand.exten.item.custom.wearable.ArmorItem_RaEx;

import java.util.Map;

public class RubyArmorItem extends ArmorItem_RaEx {
    public RubyArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    /**
     * Ruby
     */
    private static final Map<ArmorMaterial, StatusEffectInstance> D_RUBY_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.DIAMOND_RUBY,
                            new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0, false, false, true)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> N_RUBY_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.NETHERITE_RUBY,
                            new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1, false, false, true)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> N_RUBY_EFFECT_MAP_2 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.NETHERITE_RUBY,
                            new StatusEffectInstance(StatusEffects.SPEED, 400, 0, false, false, true)).
                    build();

    @Override
    public void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : D_RUBY_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_RUBY_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_RUBY_EFFECT_MAP_2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }
}
