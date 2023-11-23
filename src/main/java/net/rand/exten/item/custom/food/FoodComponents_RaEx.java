package net.rand.exten.item.custom.food;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents_RaEx {

    public static final FoodComponent SANDWICH = new FoodComponent.Builder().hunger(5).saturationModifier(1.0f).meat().build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build();
    public static final FoodComponent END_BARRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).alwaysEdible().meat().build();
    public static final FoodComponent PIZZA = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).build();

    public static final FoodComponent POPCORN = new FoodComponent.Builder().hunger(2).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100), 0.0125f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 100), 0.125f)
            .alwaysEdible().build();

    public static final FoodComponent DOUGH = new FoodComponent.Builder().hunger(2).saturationModifier(0.125f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100), 0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 0.75f)
            .build();

    public static final FoodComponent RAW_PIZZA = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100), 0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 0.75f)
            .build();

    public static final FoodComponent SODA = new FoodComponent.Builder().hunger(1).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100), 0.125f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100), 0.125f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100), 0.125f)
            .alwaysEdible().build();
}