package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSteelIngot extends Item implements IItem {

	public ItemSteelIngot() {
		
	}
	
	@Override
	public void init() {
		setUnlocalizedName(Constants.ItemSteelIngotName);
		setTextureName(Constants.ItemSteelIngotTexture);
		setCreativeTab(CreativeTabs.tabAllSearch);
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	@Override
	public void registerReceipe() {
		ItemStack stackSteelIngot = new ItemStack(this);
		GameRegistry.addRecipe(stackSteelIngot, new Object[]{"iii", "rgr", "iii",
				'i', Items.iron_ingot, 'g', Items.gold_ingot, 'r', Items.redstone});
		
	}
}
