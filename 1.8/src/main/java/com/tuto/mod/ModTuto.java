package com.tuto.mod;

import com.tuto.mod.Entity.EntityTuto;
import com.tuto.mod.Entity.EntityTutoP;
import com.tuto.mod.Handlers.EntityHandler;
import com.tuto.mod.World.WorldRegisterTuto;
import com.tuto.mod.init.BlockMod;
import com.tuto.mod.init.EventsMod;
import com.tuto.mod.init.ItemMod;
import com.tuto.mod.init.RemoveRecipe;
import com.tuto.mod.init.StructureMod;
import com.tuto.mod.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class ModTuto
{
     @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
     public static CommonProxy proxy;
     
     @Instance(Reference.MOD_ID)
     public static ModTuto instance;
     
     public static CreativeTabs tabTuto = new CreativeTabs("tabTuto")
     {
         @SideOnly(Side.CLIENT)
         public Item getTabIconItem()
         {
             return ItemMod.itemModBasic;
         }
     };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockMod.init();
        BlockMod.register();
        ItemMod.init();
        ItemMod.register();
        WorldRegisterTuto.MainRegistry();
        StructureMod.init();
        RemoveRecipe.init();
        EventsMod.init();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //Entity Mob
        EntityHandler.RegisterMonster(EntityTuto.class, "Tuto");
        EntityHandler.RegisterMonster(EntityTutoP.class, "TutoP");
        proxy.registerRenders();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}