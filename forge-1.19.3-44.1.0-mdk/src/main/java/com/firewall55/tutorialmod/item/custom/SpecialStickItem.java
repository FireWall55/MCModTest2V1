package com.firewall55.tutorialmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SpecialStickItem extends Item {

    public SpecialStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getLevel().isClientSide()){
           BlockPos positionClicked = context.getClickedPos();
           Player player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i<=positionClicked.getY() + 64; i++){
                Block blockBelow = context.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)){
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }
                if(!foundBlock){
                    player.sendSystemMessage(Component.translatable("item.tutorialmod.special_stick.no_valuables"));
                }
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),        //damages item
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(context);
    }


    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow){
        player.sendSystemMessage(Component.literal("Found " + blockBelow.toString() + "at (" +
                blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(Block block){
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
    }



}
