package com.firewall55.tutorialmod.enchantment;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Regen extends Enchantment{
    protected Regen(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category, slots);
    }
    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
                float healthAdd = attacker.getHealth() + 2;
                attacker.setHealth(healthAdd);
            // attacker.sendSystemMessage(Component.literal(attacker.getOffhandItem().toString()));
            // if (attacker.getOffhandItem().toString().equals("1 stick")) { execution }
            super.doPostAttack(attacker, target, level);
        }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
