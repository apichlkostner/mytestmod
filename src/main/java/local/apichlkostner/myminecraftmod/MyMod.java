package local.apichlkostner.myminecraftmod;

import block.BlockTable;
import block.MyModBlock;
import config.Constants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import item.MyModItem;
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

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)
public class MyMod {
	@SidedProxy(clientSide = Constants.CLIENTSIDE, serverSide = Constants.SERVERSIDE)
	private static IProxy proxy;
	
	@Instance(Constants.MODNAME)
	public static MyMod instance;
	
	private static Baguette baguette;
	private static BaguetteRaw baguetteRaw;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// shapeless craftin
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
		
		for (MyModItem item : ItemRegistry.items) {
			item.init();
			GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		}
		
		for (MyModBlock block : BlockRegistry.blocks) {
			block.init();
			GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		}
		
		baguetteRaw = new BaguetteRaw();
		baguette = new Baguette();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		baguetteRaw.registerReceipe();
		baguette.registerReceipe(baguetteRaw);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
