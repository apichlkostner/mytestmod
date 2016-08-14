package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.MyMod;
import local.apichlkostner.myminecraftmod.item.ItemTable;
import local.apichlkostner.myminecraftmod.item.MyModItem;
import net.minecraft.item.Item;

public class ItemRegistry {
	public static final MyModItem itemTable = new ItemTable();
	public static final MyModItem[] items = {
			itemTable
	};
	
}
