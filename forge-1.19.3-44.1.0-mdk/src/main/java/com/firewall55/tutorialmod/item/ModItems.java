package com.firewall55.tutorialmod.item;

import com.firewall55.tutorialmod.TutorialMod;
import com.firewall55.tutorialmod.block.ModBlocks;
import com.firewall55.tutorialmod.item.custom.EightBallItem;
import com.firewall55.tutorialmod.item.custom.RegenSwordItem;
import com.firewall55.tutorialmod.item.custom.SpecialStickItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =       //allows us to use items (registers items altogether)
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);


    public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal",  //makes the item with properties
            () -> new Item(new Item.Properties().stacksTo(25).fireResistant()));
    public static final RegistryObject<Item> RAW_BLACK_OPAL = ITEMS.register("raw_black_opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties()));

    public static final RegistryObject<Item> SPECIAL_STICK = ITEMS.register("special_stick",
            () -> new SpecialStickItem(new Item.Properties().durability(16)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> REGEN_SWORD = ITEMS.register("regen_sword",
            () -> new RegenSwordItem(ModTiers.POWERFUL, 2, 3f, new Item.Properties()));

    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),new Item.Properties()));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2)
                    .saturationMod(2f).build())));
    public static final RegistryObject<Item> POWDER = ITEMS.register("powder",
            () -> new Item(new Item.Properties().food(ModFoods.POWDER)));

    public static final RegistryObject<Item> POWDER_SEEDS = ITEMS.register("powder_seeds",
            () -> new ItemNameBlockItem(ModBlocks.POWDER_CROP.get(),new Item.Properties()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}