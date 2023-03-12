package com.firewall55.tutorialmod.item.custom;

import com.firewall55.tutorialmod.enchantment.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class RegenSwordItem extends SwordItem {


    public RegenSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        float healthAdd = player.getHealth() + 6;
        player.setHealth(healthAdd);
        player.setOnGround(true);
        //player.setInvisible(!player.isInvisible());
        player.setNoGravity(false);
        player.setInvulnerable(false);
        //player.getEnderChestInventory
        player.getCooldowns().addCooldown(this, 40);//2 seconds

        return super.useOn(context);

    }

    @Override
    public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
        itemStack.enchant(ModEnchantments.REGEN.get(), 2);
        itemStack.enchant(Enchantments.SHARPNESS, 5);
        super.onCraftedBy(itemStack, level, player);
    }

}

