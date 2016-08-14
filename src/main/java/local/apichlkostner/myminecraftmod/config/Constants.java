package local.apichlkostner.myminecraftmod.config;

import net.minecraft.block.material.Material;

public class Constants {
	public static final String MODID = "mymod";
	public static final String MODNAME = "My own test mod";
	public static final String VERSION = "1.0";
	
	public static final String MOD_PATH = "local.apichlkostner.myminecraftmod";
	public static final String CLIENTSIDE = MOD_PATH + ".proxy.ClientProxy";
	public static final String SERVERSIDE = MOD_PATH + ".proxy.ServerProxy";
	
	public static final String ItemTableName = "ItemTable";
	public static final String ItemTableTexture = "mymod:itemtable";
	
	public static final String BlockTableName = "BlockTable";
	public static final String BlockTableTexture = "mymod:blocktable";
	public static final Material BlockTableMaterial = Material.wood;
}
