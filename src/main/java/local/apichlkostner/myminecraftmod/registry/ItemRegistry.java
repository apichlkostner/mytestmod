package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.MyMod;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.item.Baguette;
import local.apichlkostner.myminecraftmod.item.BaguetteRaw;
import local.apichlkostner.myminecraftmod.item.IItem;
import local.apichlkostner.myminecraftmod.item.ItemSteelArmor;
import local.apichlkostner.myminecraftmod.item.ItemSteelIngot;
import local.apichlkostner.myminecraftmod.item.ItemSteelPickaxe;
import local.apichlkostner.myminecraftmod.item.ItemTable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemRegistry {
	private static final Item.ToolMaterial steelMaterial =
			EnumHelper.addToolMaterial("steelMaterial", 3, 800, 7.0F, 3.0F, 10);
	private static final ItemArmor.ArmorMaterial steelArmorMaterial =
			EnumHelper.addArmorMaterial("steelArmorMaterial", Constants.ArmorMaterialDurability,
					Constants.ArmorMaterialReductionAmounts, Constants.ArmorMaterialEnchantability);
	
	public static final IItem itemTable = new ItemTable();
	public static final IItem itemSteelIngot = new ItemSteelIngot();
	public static final IItem itemSteelPickaxe = new ItemSteelPickaxe(steelMaterial);
	public static final IItem itemSteelHelmet = new ItemSteelArmor(steelArmorMaterial, 0, 0);
	public static final IItem itemSteelPlate = new ItemSteelArmor(steelArmorMaterial, 0, 1);
	public static final IItem itemSteelLeggings = new ItemSteelArmor(steelArmorMaterial, 0, 2);
	public static final IItem itemSteelBoots = new ItemSteelArmor(steelArmorMaterial, 0, 3);
	public static final IItem baguette = new Baguette();
	public static final IItem baguetteRaw = new BaguetteRaw();
	
	public static final IItem[] items = {
			itemTable,
			itemSteelIngot,
			itemSteelPickaxe,
			itemSteelHelmet,
			itemSteelPlate,
			itemSteelLeggings,
			itemSteelBoots,
			baguette,
			baguetteRaw
	};
	
}
