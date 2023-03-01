package com.firewall55.tutorialmod.block;

import com.firewall55.tutorialmod.TutorialMod;
import com.firewall55.tutorialmod.block.custom.BlueberryCropBlock;
import com.firewall55.tutorialmod.block.custom.JumpyBlock;
import com.firewall55.tutorialmod.block.custom.ZirconLampBlock;
import com.firewall55.tutorialmod.item.ModCreativeModeTabs;
import com.firewall55.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);
    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE) //gives it property of stone
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTabs.TUTORIAL_TAB);
    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                            .strength(6f).requiresCorrectToolForDrops(),
                            UniformInt.of(3,7)), ModCreativeModeTabs.TUTORIAL_TAB);
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTabs.TUTORIAL_TAB);
    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTabs.TUTORIAL_TAB);
    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTabs.TUTORIAL_TAB);




    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE) //gives it property of stone
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTabs.TUTORIAL_TAB);
    public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock("zircon_lamp",
            () -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE) //gives it property of stone
                    .strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(ZirconLampBlock.LIT ) ? 15 : 0)), ModCreativeModeTabs.TUTORIAL_TAB);
    public static final RegistryObject<Block> BLUEBERRY_CROP = Blocks.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT)));









        private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
            RegistryObject<T> toReturn = Blocks.register(name, block);
            registerBlockItem(name, toReturn, tab);
            return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
     Blocks.register(eventBus);

    }
}
