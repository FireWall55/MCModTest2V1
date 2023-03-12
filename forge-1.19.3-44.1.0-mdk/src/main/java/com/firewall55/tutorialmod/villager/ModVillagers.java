package com.firewall55.tutorialmod.villager;

import com.firewall55.tutorialmod.TutorialMod;
import com.firewall55.tutorialmod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);

                    // a villager will be able to see the block from

    public static final RegistryObject<PoiType> JUMPY_BLOCK_POI = POI_TYPES.register("jumpy_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.JUMPY_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));//maxTickets = amount of villagers that can have profession from block, Range = range
    public static final RegistryObject<PoiType> MAGMA_BLOCK_POI = POI_TYPES.register("magma_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ZIRCON_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));


    public static final RegistryObject<VillagerProfession> JUMP_MASTER = VILLAGER_PROFESSIONS.register("jumpy_master",
                            () -> new VillagerProfession("jumpy_master", x -> x.get() == JUMPY_BLOCK_POI.get(),
                                    x -> x.get() == JUMPY_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> DRUG_DEALER = VILLAGER_PROFESSIONS.register("drug_dealer",
            () -> new VillagerProfession("drug_dealer", x -> x.get() == MAGMA_BLOCK_POI.get(),
                    x -> x.get() == MAGMA_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_TOOLSMITH));


    public static void registerPOIs() {
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, JUMPY_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, MAGMA_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }



    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
