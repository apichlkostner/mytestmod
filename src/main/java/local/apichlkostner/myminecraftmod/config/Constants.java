package local.apichlkostner.myminecraftmod.config;

import net.minecraft.block.material.Material;

public class Constants {
	public static final String MODID = "mymod";
	public static final String MODNAME = "Test mod with steel items";
	public static final String VERSION = "1.0";
	
	public static final String MOD_PATH = "local.apichlkostner.myminecraftmod";
	public static final String CLIENTSIDE = MOD_PATH + ".proxy.ClientProxy";
	public static final String SERVERSIDE = MOD_PATH + ".proxy.ServerProxy";
	
	public static final String CHANNEL = MODID + "Channel";
	
	public static final int ArmorMaterialDurability = 35;
	public static final int[] ArmorMaterialReductionAmounts = {2, 7, 5, 2}; 
	public static final int ArmorMaterialEnchantability = 9;
	
	public static final String[] ItemSteelArmorModel = {
			MODID + ":" + "textures/models/armor/steel_layer_1.png",
			MODID + ":" + "textures/models/armor/steel_layer_2.png",
	};
	
	public static final String[] ItemSteelArmorName = {
			"SteelArmorHelmet",	"SteelArmorPlate", "SteelArmorLeggins", "SteelArmorBoots"
	};
	
	public static final String[] ItemSteelArmorTexture = {
			MODID + ":" + "itemsteelhelmet",
			MODID + ":" + "itemsteelplate",
			MODID + ":" + "itemsteelleggings",
			MODID + ":" + "itemsteelboots"
	};
	
	public static final String ItemTableName = "ItemTable";
	public static final String ItemTableTexture = MODID + ":" + "itemtable";
	
	public static final String ItemBeamKeyName = "ItemBeamKey";
	public static final String ItemBeamKeyTexture = MODID + ":" + "itembeamkey";
		
	public static final String ItemSteelIngotName = "SteelIngot";
	public static final String ItemSteelIngotTexture = MODID + ":" + "itemsteelingot";
	
	public static final String ItemSteelPickaxeName = "SteelPickaxe";
	public static final String ItemSteelPickaxeTexture = MODID + ":" + "itemsteelpickaxe";
	
	public static final String BaguetteName = "Baguette";
	public static final String BaguetteTexture = MODID + ":" + "baguette";
	
	public static final String BaguetteRawName = "BaguetteRaw";
	public static final String BaguetteRawTexture = MODID + ":" + "baguetteraw";
	
	public static final String BlockTableName = "BlockTable";
	public static final String BlockTableTexture = MODID + ":" + "blocktable";
	public static final Material BlockTableMaterial = Material.wood;
	
	public static final String BlockBeamerName = "BlockBeamer";
	public static final String BlockBeamerTexture = MODID + ":" + "blockbeamer";
	public static final Material BlockBeamerMaterial = Material.glass;
}
