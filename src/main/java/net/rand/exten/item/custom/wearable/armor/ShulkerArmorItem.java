package net.rand.exten.item.custom.wearable.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.rand.exten.item.custom.materials.ArmorMaterials_RaEx;
import net.rand.exten.item.custom.wearable.ArmorItem_RaEx;

import java.util.Map;

public class ShulkerArmorItem extends ArmorItem_RaEx {
    public ShulkerArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    // Todo add https://fabricmc.net/wiki/tutorial:colorprovider
    /**
     * Shulker
     */
    private static final Map<ArmorMaterial, StatusEffectInstance> SHULKER_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ArmorMaterials_RaEx.SHULKER,
                            new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 0, false, false, true))
                    .build();

    @Override
    public void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : SHULKER_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }
}
