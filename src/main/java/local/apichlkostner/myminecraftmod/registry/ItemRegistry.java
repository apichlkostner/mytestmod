package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.Baguette;
import local.apichlkostner.myminecraftmod.BaguetteRaw;
import local.apichlkostner.myminecraftmod.MyMod;
import local.apichlkostner.myminecraftmod.item.IItem;
import local.apichlkostner.myminecraftmod.item.ItemSteelIngot;
import local.apichlkostner.myminecraftmod.item.ItemSteelPickaxe;
import local.apichlkostner.myminecraftmod.item.ItemTable;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRegistry {
	private static final Item.ToolMaterial steelMaterial = EnumHelper.addToolMaterial("steelMaterial", 3, 800, 7.0F, 3.0F, 10);
	
	public static final IItem itemTable = new ItemTable();
	public static final IItem itemSteelIngot = new ItemSteelIngot();
	public static final IItem itemSteelPickaxe = new ItemSteelPickaxe(steelMaterial);
	public static final IItem baguette = new Baguette();
	public static final IItem baguetteRaw = new BaguetteRaw();
	
	public static final IItem[] items = {
			itemTable,
			itemSteelIngot,
			itemSteelPickaxe,
			baguette,
			baguetteRaw
	};
	
}
