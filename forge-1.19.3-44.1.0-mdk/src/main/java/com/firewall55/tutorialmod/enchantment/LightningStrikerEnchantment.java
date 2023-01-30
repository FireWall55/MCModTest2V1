package com.firewall55.tutorialmod.enchantment;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningStrikerEnchantment extends Enchantment {
    protected LightningStrikerEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... equipmentSlots) {
        super(rarity, category, equipmentSlots);
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) { //level is level of enchantment
        if(!attacker.level.isClientSide()){
            ServerLevel world = ((ServerLevel) attacker.level);
            BlockPos position = target.blockPosition();

            if(level == 1){
                EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, position, MobSpawnType.TRIGGERED,
                        true,true);
            }
            if(level == 2){
                EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, position, MobSpawnType.TRIGGERED,
                        true,true);
                EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, position, MobSpawnType.TRIGGERED,
                        true,true);
            }

        }

        super.doPostAttack(attacker, target, level);
    }

    @Override
    public int getMaxLevel(){
        return 2;
    }
}