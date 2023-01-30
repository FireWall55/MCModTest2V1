package com.firewall55.tutorialmod.item;

import com.firewall55.tutorialmod.TutorialMod;
import com.firewall55.tutorialmod.item.custom.EightBallItem;
import com.firewall55.tutorialmod.item.custom.SpecialStickItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}