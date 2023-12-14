package net.rand.exten.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class ArmorItem_RaEx extends ArmorItem {
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

    /**
     * Topas
     */
    private static final Map<ArmorMaterial, StatusEffectInstance> D_TOPAS_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.DIAMOND_TOPAS,
                            new StatusEffectInstance(StatusEffects.HASTE, 200, 0, false, false, true)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> N_TOPAS_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.NETHERITE_TOPAS,
                            new StatusEffectInstance(StatusEffects.HASTE, 400, 2, false, false, true)).build();
    private static final Map<ArmorMaterial, StatusEffectInstance> N_TOPAS_EFFECT_MAP_2 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ArmorMaterials_RaEx.NETHERITE_TOPAS,
                            new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false, true))
                    .build();

    public ArmorItem_RaEx(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        //Aquamarin
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : D_AQUAMARIN_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }

        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_AQUAMARIN_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_AQUAMARIN_EFFECT_MAP_2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
        //Ruby
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : D_RUBY_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }

        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_RUBY_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_RUBY_EFFECT_MAP_2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
        //Topas
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : D_TOPAS_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }

        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_TOPAS_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : N_TOPAS_EFFECT_MAP_2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

}
