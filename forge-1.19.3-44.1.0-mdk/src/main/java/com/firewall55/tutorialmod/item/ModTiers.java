package com.firewall55.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier POWERFUL = new ForgeTier(2, 1400, 1.5f, 500f,
            22, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.BLACK_OPAL.get()));
}
