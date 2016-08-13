package local.apichlkostner.myminecraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTable extends Item {
	public ItemTable() {
		this.setUnlocalizedName(Constants.ItemTableName);
		this.setTextureName(Constants.ItemTableTexture);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
	}
	
	
}
