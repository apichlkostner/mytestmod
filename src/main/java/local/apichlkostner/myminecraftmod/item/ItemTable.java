package local.apichlkostner.myminecraftmod.item;

import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTable extends MyModItem {
	public ItemTable() {
		
	}
	
	@Override
	public void init() {
		this.setUnlocalizedName(Constants.ItemTableName);
		this.setTextureName(Constants.ItemTableTexture);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
	}

	@Override
	public void registerReceipe() {
		// no receipe		
	}
	
	
}
