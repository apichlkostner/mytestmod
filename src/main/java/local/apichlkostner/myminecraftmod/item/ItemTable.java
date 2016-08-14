package local.apichlkostner.myminecraftmod.item;

import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTable extends MyModItem {
	public ItemTable() {
		
	}
	
	public void init() {
		this.setUnlocalizedName(Constants.ItemTableName);
		this.setTextureName(Constants.ItemTableTexture);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
	}
	
	
}
