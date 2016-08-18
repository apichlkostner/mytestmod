package local.apichlkostner.myminecraftmod.registry;

import java.util.ArrayList;

import local.apichlkostner.myminecraftmod.MyMod;
import local.apichlkostner.myminecraftmod.block.BlockTable;
import local.apichlkostner.myminecraftmod.block.MyModBlock;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.item.ItemTable;
import local.apichlkostner.myminecraftmod.item.MyModItem;
import net.minecraft.item.Item;

public class ItemRegistry {
public static ItemRegistry instance;
	
	public MyModItem itemTable = new ItemTable();
	
	public ArrayList<MyModItem> items;
	
	public static ItemRegistry getInstance() {
		if (instance == null) {
			instance = new ItemRegistry();
		}
		
		return instance;
	}
	
	public void register(MyModItem modTem) {
		items.add(modTem);
	}
	
	
	private ItemRegistry() {
		items = new ArrayList<MyModItem>();
		items.add(itemTable);
	}	
}
