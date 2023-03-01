package com.firewall55.tutorialmod;

import com.firewall55.tutorialmod.block.ModBlocks;
import com.firewall55.tutorialmod.enchantment.ModEnchantments;
import com.firewall55.tutorialmod.item.ModCreativeModeTabs;
import com.firewall55.tutorialmod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.function.Supplier;

//alt shift . to increase font size
//20 ticks = 1 second
// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod"; //the mod id
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEnchantments.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){         //adds item/block to Ingredients Tab
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);
        }
        if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB) {    //adds item/block to Tutorial Tab (custom tab)
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);
            event.accept(ModItems.EIGHT_BALL);
            event.accept(ModItems.SPECIAL_STICK);
            event.accept(ModItems.CUCUMBER);
            event.accept(ModItems.REGEN_SWORD);
            event.accept(ModBlocks.ZIRCON_BLOCK);
            event.accept(ModBlocks.ZIRCON_ORE);
            event.accept(ModBlocks.DEEPSLATE_ZIRCON_ORE);
            event.accept(ModBlocks.ENDSTONE_ZIRCON_ORE);
            event.accept(ModBlocks.NETHERRACK_ZIRCON_ORE);
            event.accept(ModBlocks.JUMPY_BLOCK);
            event.accept(ModBlocks.ZIRCON_LAMP);
            event.accept(ModBlocks.BLUEBERRY_CROP);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUEBERRY_CROP.get(), RenderType.cutout());

        }
    }
}
