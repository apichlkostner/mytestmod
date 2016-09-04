package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;

public class ItemBeamKey extends Item implements IItem {
	public static ChunkCoordinates beamCoordinates;
	
	@Override
	public void init() {
		setUnlocalizedName(Constants.ItemBeamKeyName);
		setTextureName(Constants.ItemBeamKeyTexture);
		setCreativeTab(CreativeTabs.tabAllSearch);
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	@Override
	public void registerReceipe() {
		ItemStack stackBeamKey = new ItemStack(this);
		
		GameRegistry.addRecipe(stackBeamKey, new Object[]{"iii", "  i", "   ",
				'i', Items.iron_ingot});
	}

	
}
