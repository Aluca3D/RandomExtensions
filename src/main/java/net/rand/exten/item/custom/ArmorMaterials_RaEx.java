package net.rand.exten.item.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.rand.exten.RandomExtensions;

import java.util.function.Supplier;

public enum ArmorMaterials_RaEx implements ArmorMaterial {
    /**Aquamarin*/
    DIAMOND_AQUAMARIN("d_aquamarin", 33, new int[]{3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_AQUAMARIN("n_aquamarin", 37, new int[]{3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, 0.1f, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
/**Ruby*/
    DIAMOND_RUBY("d_ruby", 33, new int[]{3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_RUBY("n_ruby", 37, new int[]{3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, 0.1f, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
 /**Topas*/
    DIAMOND_TOPAS("d_topas", 33, new int[]{3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_TOPAS("n_topas", 37, new int[]{3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, 0.1f, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ArmorMaterials_RaEx(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness,
                        float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return RandomExtensions.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
