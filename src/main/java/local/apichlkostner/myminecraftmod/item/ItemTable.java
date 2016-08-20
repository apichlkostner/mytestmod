package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTable extends Item implements IItem {
	public ItemTable() {
		
	}
	
	@Override
	public void init() {
		setUnlocalizedName(Constants.ItemTableName);
		setTextureName(Constants.ItemTableTexture);
		setCreativeTab(CreativeTabs.tabAllSearch);
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	@Override
	public void registerReceipe() {
		// no receipe		
	}
	
	
}
