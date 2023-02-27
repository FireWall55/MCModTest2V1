package com.firewall55.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties Cocaine = (new FoodProperties.Builder()).nutrition(4).saturationMod(10F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F).effect(new MobEffectInstance(MobEffects.
                    DAMAGE_RESISTANCE, 10000, 0), 1.0F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0)
                    , 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F).
            effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0f).
            effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 1), 1.0f).alwaysEat().build();
}
