package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemSteelIngot extends MyModItem {

	public ItemSteelIngot() {
		
	}
	
	@Override
	public void init() {
		this.setUnlocalizedName(Constants.ItemSteelIngotName);
		this.setTextureName(Constants.ItemSteelIngotTexture);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
	}

	@Override
	public void registerReceipe() {
		ItemStack stackSteelIngot = new ItemStack(this);
		GameRegistry.addRecipe(stackSteelIngot, new Object[]{"iii", " g ", "iii",
				'i', Items.iron_ingot, 'g', Items.gold_ingot});
		
	}
}
