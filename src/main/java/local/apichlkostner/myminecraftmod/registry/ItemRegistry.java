package local.apichlkostner.myminecraftmod.registry;

import item.ItemTable;
import item.MyModItem;
import local.apichlkostner.myminecraftmod.MyMod;
import net.minecraft.item.Item;

public class ItemRegistry {
	public static final MyModItem itemTable = new ItemTable();
	public static final MyModItem[] items = {
			itemTable
	};
	
}
