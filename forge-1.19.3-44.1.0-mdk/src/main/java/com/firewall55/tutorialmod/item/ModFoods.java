package com.firewall55.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {


    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties POWDER = (new FoodProperties.Builder()).nutrition(8).saturationMod(10F).
            effect(new MobEffectInstance(MobEffects.REGENERATION, 6000, 999), 1.0F). //effect, time,level(if applicable),?
            effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 999), 1.0F).
            effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 999), 1.0F).
            effect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 10), 1.0F).
            effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 999), 1.0f).
            effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 5), 1.0f).//lotsssss of hearts
            effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 3), 1.0f).
            effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, 999), 1.0f).
            effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 999), 1.0f).
            effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 999), 1.0f).
            effect(new MobEffectInstance(MobEffects.HEAL, 6000, 2), 1.0f).
            effect(new MobEffectInstance(MobEffects.JUMP, 6000, 5), 1.0f)

            .alwaysEat().build();
}
