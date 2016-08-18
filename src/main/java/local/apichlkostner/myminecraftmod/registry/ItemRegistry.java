package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.MyMod;
import local.apichlkostner.myminecraftmod.item.IItem;
import local.apichlkostner.myminecraftmod.item.ItemSteelIngot;
import local.apichlkostner.myminecraftmod.item.ItemSteelPickaxe;
import local.apichlkostner.myminecraftmod.item.ItemTable;
import local.apichlkostner.myminecraftmod.item.MyModItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRegistry {
	private static final Item.ToolMaterial steelMaterial = EnumHelper.addToolMaterial("steelMaterial", 3, 800, 7.0F, 3.0F, 10);
	
	public static final MyModItem itemTable = new ItemTable();
	public static final MyModItem itemSteelIngot = new ItemSteelIngot();
	public static final ItemSteelPickaxe itemSteelPickaxe = new ItemSteelPickaxe(steelMaterial);
	
	public static final MyModItem[] items = {
			itemTable,
			itemSteelIngot
	};
	
}
