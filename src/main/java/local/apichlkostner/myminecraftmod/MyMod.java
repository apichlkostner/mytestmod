package local.apichlkostner.myminecraftmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.block.BlockBeamer;
import local.apichlkostner.myminecraftmod.block.IBlock;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.entity.TileEntityBeamer;
import local.apichlkostner.myminecraftmod.item.IItem;
import local.apichlkostner.myminecraftmod.item.ItemSteelPickaxe;
import local.apichlkostner.myminecraftmod.network.NetworkHandler;
import local.apichlkostner.myminecraftmod.network.TileEntityDescriptionHandler;
import local.apichlkostner.myminecraftmod.proxy.IProxy;
import local.apichlkostner.myminecraftmod.registry.BlockRegistry;
import local.apichlkostner.myminecraftmod.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)
public class MyMod {
	@SidedProxy(clientSide = Constants.CLIENTSIDE, serverSide = Constants.SERVERSIDE)
	private static IProxy proxy;
	
	@Instance(Constants.MODNAME)
	public static MyMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkHandler.init();
		TileEntityDescriptionHandler.init();
		
		// shapeless crafting
		ItemStack stackWool = new ItemStack(Blocks.wool);
		ItemStack stackWeb = new ItemStack(Blocks.web, 5);
		
		GameRegistry.addShapelessRecipe(stackWeb, stackWool);
		
		ItemStack stackDirt = new ItemStack(Blocks.dirt);
		ItemStack stackDiamond = new ItemStack(Blocks.diamond_block);
		GameRegistry.addShapelessRecipe(stackDirt, stackDiamond);
		
		// crafting
		ItemStack stackStone = new ItemStack(Blocks.stone);
		ItemStack stackCobble = new ItemStack(Blocks.cobblestone);
		ItemStack stackDispenser = new ItemStack(Blocks.dispenser);
		GameRegistry.addRecipe(stackDispenser, "ccc", "c c", "sss", 'c', stackCobble, 's', stackStone);
		
		// smelting
		ItemStack stackDiamonds = new ItemStack(Items.diamond);
		ItemStack stackCoalBlock = new ItemStack(Blocks.coal_block);
		GameRegistry.addSmelting(stackDiamonds, stackCoalBlock, 1000);
		
		for (IItem item : ItemRegistry.items) {
			item.init();
		}
		
		for (IBlock block : BlockRegistry.blocks) {
			block.init();
		}
		
		GameRegistry.registerTileEntity(TileEntityBeamer.class, "MyMod_Beamer");
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {		
		for (IItem item : ItemRegistry.items) {
			item.registerReceipe();
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
