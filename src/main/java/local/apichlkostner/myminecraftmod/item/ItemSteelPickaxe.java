package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.registry.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemSteelPickaxe extends ItemPickaxe implements IItem {

	public ItemSteelPickaxe(ToolMaterial material) {
		super(material);
	}

	@Override
	public void init() {
		this.setUnlocalizedName(Constants.ItemSteelPickaxeName);
		this.setTextureName(Constants.ItemSteelPickaxeTexture);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
	}

	@Override
	public void registerReceipe() {
		ItemStack itemSteelPickaxeIngot = new ItemStack(this);
		GameRegistry.addRecipe(itemSteelPickaxeIngot, new Object[]{"sss", " t ", " t ",
				's', ItemRegistry.itemSteelIngot, 't', Items.stick});
	}

}
